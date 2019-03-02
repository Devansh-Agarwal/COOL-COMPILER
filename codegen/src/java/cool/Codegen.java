package cool;
import java.io.PrintWriter;
import java.util.*;
class ClassNode {
  public String name;
  public String parent;
  public List<AST.attr> attributes = new ArrayList<AST.attr>();
  public List<AST.method> methods = new ArrayList<AST.method>();
  ClassNode(String className, String class_parent, List<AST.attr> class_attributes, List<AST.method> class_methods) {
    name = className;
    parent = class_parent;
    attributes = class_attributes;
    methods = class_methods;
  }
}
class Logger {
  public int register;
  String lastBB;
  Logger() {
    register = 0;
    lastBB = "";
  }
  Logger(int reg, String lb) {
    register = reg;
    lastBB = lb;
  }
}
public class Codegen {
  PrintWriter out;
  String filename;
  HashMap<String, ClassNode> classList = new HashMap<String, ClassNode>();
  HashMap<String, String> typeConv = new HashMap<String, String>();
  HashMap<String, Integer> string_table = new HashMap<String, Integer>();
  ArrayList<String> strArray = new ArrayList<String>();
  Integer string_counter = 0;
  Integer loopBBcount = 0;
  Integer ifBBcount = 0;
  String clsName = null;
  String methodReturn;
  List<String> functionFormalArguments;   //for storing formal parameters of method
  public Codegen(AST.program program, PrintWriter output) {  
    // Write Code generator code here
    out = output;
    out.print("; I am a comment in LLVM-IR. Feel free to remove me.\n");
    typeConv.put("void","void");
    typeConv.put("Int","i32");
    typeConv.put("Bool","i1");
    typeConv.put("String","i8*");
    filename = program.classes.get(0).filename;
    out.println("source_filename = \"" + filename + "\"");
    out.println("target triple = \"x86_64-unknown-linux-gnu\"\n");// assumptions
    //Using C language functions
    out.println("declare i8* @strcat( i8*, i8* )\n");
    out.println("declare i8* @strcpy( i8*, i8* )\n");
    out.println("declare i32 @strcmp( i8*, i8* )\n");
    out.println("declare i8* @strncpy( i8*, i8*, i32 )\n");
    out.println("declare i32 @strlen( i8*)\n");
    out.println("declare i32 @printf( i8*, ... )\n");
    out.println("declare i32 @scanf( i8*, ... )\n");
    out.println("declare i8* @malloc( i32 )\n");
    out.println("declare void @exit( i32 )\n");
    // C Format specifiers 
    out.println("@stringFormatSpecifier = private unnamed_addr constant [3 x i8] c\"%s\\00\"");
    out.println("@intFormatSpecifier = private unnamed_addr constant [3 x i8] c\"%d\\00\"");
    out.println("@nullString = private unnamed_addr constant [1 x i8] c\"\\00\"");
    out.println("@zeroDivError = private unnamed_addr constant [41 x i8] c\"Runtime Error: Zero cannot be a divisor\\0A\\00\"");
    out.println("@vStaticDispatchError = private unnamed_addr constant [55 x i8] c\"Runtime Error: Cannot perform static dispatch on void\\0A\\00\"");
    appendBuiltClasses(program);// adding to the ast
    filename = program.classes.get(0).filename;
    
    for (AST.class_ cl : program.classes) {
      insertClass(cl);
    }
    //main() function is printed here
    out.println("define i32 @main(  ) {");
    out.println("entry:"); 
    out.println(" %this = alloca %class.Main");
    out.println(" %this_ret = call %class.Main* @MainConstructorMain( %class.Main* %this )");
    out.println(" call void @Main_main( %class.Main* %this_ret )");
    out.println(" ret i32 0");
    out.println("}");
    //default functions for object is printed here
    
    out.println("define void @Object_abort(  ) {");
    out.println("entry:");
    out.println(" call void (i32) @exit(i32 0)");
    out.println(" ret void");
    out.println("}");
    out.println("%class.Object = type {  }");
    constructorConstructor("Object", new Logger()); 
    //default functions for IO are printed here
    out.println("define i32 @IO_in_int(  ) {");
    out.println("entry:");
    out.println(" %0 = bitcast [3 x i8]* @intFormatSpecifier to i8*");
    out.println(" %1 = call i8* @malloc( i32 4 )");
    out.println(" %2 = bitcast i8* %1 to i32*");
    out.println(" %3 = call i32 (i8*, ...)  @scanf( i8* %0, i32* %2 )");
    out.println(" %retval = load i32, i32* %2");
    out.println(" ret i32 %retval");
    out.println("}");
    out.println("define i8* @IO_in_string(  ) {");
    out.println("entry:");
    out.println(" %0 = bitcast [3 x i8]* @stringFormatSpecifier to i8*");
    out.println(" %retval = call i8* @malloc( i32 1024 )");
    out.println(" %1 = call i32 (i8*, ...)  @scanf( i8* %0, i8* %retval )");
    out.println(" ret i8* %retval");
    out.println("}");
    out.println("define void @IO_out_int( i32 %given ) {");
    out.println("entry:");
    out.println(" %0 = getelementptr inbounds [3 x i8], [3 x i8]* @intFormatSpecifier, i32 0, i32 0");
    out.println("%call = call i32 ( i8*, ... ) @printf(i8* %0, i32 %given)");
    out.println("ret void");
    out.println("}");
    out.println("define void @IO_out_string( i8* %given ) {");
    out.println("entry:");
    out.println(" %0 = getelementptr inbounds [3 x i8], [3 x i8]* @stringFormatSpecifier, i32 0, i32 0");
    out.println("%call = call i32 ( i8*, ... ) @printf(i8* %0, i8* %given)");
    out.println("ret void");
    out.println("}");
    out.println("%class.IO = type {  }");
    constructorConstructor("IO", new Logger());
    // default functions for strings are printed here
    out.println("define i32 @String_length( i8* %this ) {");
    out.println("entry:");
    out.println(" %retval = call i32 @strlen( i8* %this )");
    out.println(" ret i32 %retval");
    out.println("}");
    out.println("define i8* @String_concat( i8* %this, i8* %that ) {");
    out.println("entry:");
    out.println(" %newitem = call i8* @malloc( i32 1024 )");
    out.println(" %stringduplicate = call i8* @strcpy( i8* %newitem, i8* %this )");
    out.println(" %retval = call i8* @strcat( i8* %stringduplicate, i8* %that )");
    out.println(" ret i8* %retval");
    out.println("}");
    out.println("define i8* @String_substr( i8* %this, i32 %start, i32 %len ) {");
    out.println("entry:");
    out.println(" %0 = call i8* @malloc( i32 1024 )");
    out.println(" %1 = getelementptr inbounds i8, i8* %this, i32 %start");
    out.println(" %2 = call i8* @strncpy( i8* %0, i8* %1, i32 %len )");
    out.println(" %3 = getelementptr inbounds [1 x i8], [1 x i8]* @nullString, i32 0, i32 0");
    out.println(" %retval = call i8* @strcat( i8* %2, i8* %3 )");
    out.println(" ret i8* %retval");
    out.println("}");
    out.println("define i1 @String_strcmp( i8* %this, i8* %start ) {");
    out.println("entry:");
    out.println(" %0 = call i32 @strcmp( i8* %this, i8* %start )");
    out.println(" %1 = icmp eq i32 %0, 0");
    out.println(" ret i1 %1");
    out.println("}");
    
    for (AST.class_ cl : program.classes) {
      // skip built in classes
      if (cl.name.equals("Int") || cl.name.equals("String") || cl.name.equals("Bool") || cl.name.equals("Object") || cl.name.equals("IO")) {
        continue;
      }
      // generating code for class atrribuites 
      int attr_i = 0;
      while(attr_i < classList.get(cl.name).attributes.size()){
        if (classList.get(cl.name).attributes.get(attr_i).typeid.equals("String") && classList.get(cl.name).attributes.get(attr_i).value.getClass().getSimpleName().equals("string_const")) { // Getting existing string constants
          catchString(classList.get(cl.name).attributes.get(attr_i).value);
        }
        attr_i++;
      }
      attr_i = 1;
      out.print("%class." + cl.name + " = type {" );
      if(!typeConv.containsKey(classList.get(cl.name).attributes.get(0).typeid)) {
        out.print("%" + "class." + classList.get(cl.name).attributes.get(0).typeid + "*");
      }
      else {
        out.print(typeConv.get(classList.get(cl.name).attributes.get(0).typeid));
      }
      while(attr_i < classList.get(cl.name).attributes.size()){
        if(!typeConv.containsKey(classList.get(cl.name).attributes.get(attr_i).typeid)) {
          out.print("," + "%" + "class." + classList.get(cl.name).attributes.get(attr_i).typeid + "*");
        }
        else {
          out.print("," + typeConv.get(classList.get(cl.name).attributes.get(attr_i).typeid));
        }
        attr_i++;
      }
      out.print("}\n");
      constructorConstructor(cl.name, new Logger()); // constructing class constructor
      Logger counter = new Logger();
      // generating code for methods
      for (AST.method mtd : classList.get(cl.name).methods) {
        catchString(mtd.body);
        List<String> typeFormList = new ArrayList<String>();
        List<String> nameFormList = new ArrayList<String>();
        typeFormList.add(printType(cl.name, 1));
        nameFormList.add("%this");
        functionFormalArguments = new ArrayList<String>();
        for (AST.formal f : mtd.formals) {
          typeFormList.add(printType(f.typeid, 1));
          nameFormList.add("%" + f.name);
          functionFormalArguments.add(f.name);
        }
        out.print("define " + (mtd.typeid.equals("Object")?"void":printType(mtd.typeid,0)) + " @" + cl.name + "_" + mtd.name + "(" );
        for(int argI=0;argI<typeFormList.size();argI++){
          out.print(typeFormList.get(argI)+" "+nameFormList.get(argI)+(argI == typeFormList.size()-1 ? "" : ", "));
        }
        out.print(")\n{\nentry:\n");
        methodReturn = printType(mtd.typeid, 0);
        if (!mtd.typeid.equals("Object")) {
          out.println("%retval = alloca " + printType(mtd.typeid, 1));          
        }
        out.println("%this.addr = alloca " + typeFormList.get(0));
        for (int i = 1; i < typeFormList.size(); i++) {
          out.println("%this.addr = alloca " + typeFormList.get(i));
        }
        int argI = 1;
        while (argI < typeFormList.size()) {
          out.print("store " + typeFormList.get(argI) + " " + nameFormList.get(argI) + ", " + typeFormList.get(argI) + "* " + nameFormList.get(argI) + ".addr");
          argI++;
        }
        getClassAttributes(cl.name);
        loopBBcount = 0;
        ifBBcount = 0;
        counter.register = 0;
        counter.lastBB = "%entry";
        clsName = cl.name;
        counter = visitExpr(mtd.body, counter);
        if (! ((mtd.body instanceof AST.block) || (mtd.body instanceof AST.loop) || (mtd.body instanceof AST.cond))) {
          assignRetvalIfSame((mtd.body).type, counter.register - 1);
        }
        out.println("br label %funcReturnBB");
        out.println("vStaticDispErrBB:");
        out.println("\t%errMsgVSDE = alloca i8*");
        out.println("\tstore i8* getelementptr inbounds ([55 x i8], [55 x i8]* @vStaticDispatchError, i32 0, i32 0), i8** %errMsgVSDE");
        out.println("\t%errMsgVSDEprint = load i8*, i8** %errMsgVSDE");
        out.println("\tcall void @IO_out_string( i8* %errMsgVSDEprint )");
        out.println("\tcall void @Object_abort(  )");
        out.println("\tbr label %funcReturnBB");
        out.println("zeroDivisorErrorBB:");
        out.println("\t%errMsgZDE = alloca i8*");
        out.println("\tstore i8* getelementptr inbounds ([41 x i8], [41 x i8]* @zeroDivError, i32 0, i32 0), i8** %errMsgZDE");
        out.println("\t%errMsgZDEprint = load i8*, i8** %errMsgZDE");
        out.println("\tcall void @IO_out_string( i8* %errMsgZDEprint )");
        out.println("\tcall void @Object_abort(  )");
        out.println("\tbr label %funcReturnBB");
        out.println("funcReturnBB:");
        if (mtd.typeid.equals("Object")) {
          out.println("\tret void");
          out.println("} ");
        } else {
          out.println("%" + String.valueOf(counter.register) + " = load " + printType(methodReturn,1) + ", " + printType(methodReturn,1) + "* %retval");          
          out.println("\tret " + (printType(methodReturn, 1).equals("void")?"void":printType(methodReturn, 1) + " %" + String.valueOf(counter.register)) + "\n}\n");
          counter.register++;
        }
      }
    }
  }
  public void appendBuiltClasses(AST.program program) { 
    AST.no_expr[] nox  =  new AST.no_expr[9];
    
    for(int i = 0; i < 9; i++)
    {
      nox[i] = new AST.no_expr(0);
    }
    // object class
    ArrayList<ArrayList<AST.feature > >basicClassFeatures = new ArrayList<ArrayList<AST.feature>>();
    ArrayList<ArrayList<AST.formal > >basicClassFormals = new ArrayList<ArrayList<AST.formal>>();
    
    basicClassFeatures.add(new ArrayList <AST.feature>());
    
    (basicClassFeatures.get(0)).add(new AST.method("abort", new ArrayList<AST.formal>(), "Object", nox[0], 0));  
    (basicClassFeatures.get(0)).add(new AST.method("type_name", new ArrayList<AST.formal>(), "String", nox[1], 0));
    program.classes.add(new AST.class_("Object", filename, null, basicClassFeatures.get(0), 0));
    
    // IO Class
    basicClassFeatures.add(new ArrayList <AST.feature>(basicClassFeatures.get(0)));
    basicClassFormals.add(new ArrayList<AST.formal>());
    basicClassFormals.add(new ArrayList<AST.formal>());
    (basicClassFormals.get(0)).add(new AST.formal("out_string", "String", 0));
    (basicClassFormals.get(1)).add(new AST.formal("out_int", "Int", 0));
    (basicClassFeatures.get(1)).add(new AST.method("out_string",basicClassFormals.get(0) , "Object", nox[2], 0));
    (basicClassFeatures.get(1)).add(new AST.method("out_int", basicClassFormals.get(1), "Object", nox[3], 0));
    (basicClassFeatures.get(1)).add(new AST.method("in_string", new ArrayList<AST.formal>(), "String", nox[4], 0));
    (basicClassFeatures.get(1)).add(new AST.method("in_int", new ArrayList<AST.formal>(), "Int", nox[5], 0));
    program.classes.add(new AST.class_("IO", filename, "Object", basicClassFeatures.get(1), 0));
    // Int class
    program.classes.add(new AST.class_("Int", filename, "Object", basicClassFeatures.get(0), 0));
    
    // Bool class
    program.classes.add(new AST.class_("Bool", filename, "Object", basicClassFeatures.get(0), 0));
    // String Class
    basicClassFeatures.add(new ArrayList <AST.feature>(basicClassFeatures.get(0)));//2
    basicClassFormals.add(new ArrayList<AST.formal>());//2
    basicClassFormals.add(new ArrayList<AST.formal>());//3
    (basicClassFormals.get(2)).add(new AST.formal("s", "String", 0));
    (basicClassFormals.get(3)).add(new AST.formal("i", "Int", 0));
    (basicClassFormals.get(3)).add(new AST.formal("l", "Int", 0));
    (basicClassFeatures.get(2)).add(new AST.method("length", new ArrayList<AST.formal>(), "Int", nox[6], 0));
    (basicClassFeatures.get(2)).add(new AST.method("concat", basicClassFormals.get(2), "String", nox[7], 0));
    (basicClassFeatures.get(2)).add(new AST.method("substr", basicClassFormals.get(3), "String", nox[8], 0));
    program.classes.add(new AST.class_("String", filename, "Object", basicClassFeatures.get(2), 0));
    
  }
  public void insertClass(AST.class_ currentClass) {  
    List<AST.attr> currentClassAttributes = new ArrayList<AST.attr>();
    List<AST.method> currentClassMethods = new ArrayList<AST.method>();
    int tempitr = 0;
    while(tempitr < (currentClass.features).size())
    {
      if (((currentClass.features).get(tempitr)) instanceof AST.method) {
        AST.method cur_method = (AST.method)((currentClass.features).get(tempitr));
        currentClassMethods.add(cur_method);
      }
      else
        if (((currentClass.features).get(tempitr)) instanceof AST.attr) {
          AST.attr curAttr = (AST.attr)((currentClass.features).get(tempitr));
          currentClassAttributes.add(curAttr);
        } 
        tempitr++;
      }
      if (currentClass.parent == null) {
        classList.put(currentClass.name, new ClassNode(currentClass.name, currentClass.name, currentClassAttributes, currentClassMethods));
      } else {
        classList.put(currentClass.name, new ClassNode(currentClass.name, currentClass.parent, currentClassAttributes, currentClassMethods));
      }
    }
    public String printType(String typeid, int depth) {
      if(!typeConv.containsKey(typeid)) {
        String typeCode = "%" + "class." + typeid;
        if(depth == 0){
          return typeCode;
        }
        else if (depth == 1){
          return typeCode + "*";
        }
        else if (depth == 2){
          return typeCode + "**";
        }
      }
      else {
        String typeCode = typeConv.get(typeid);
        return typeCode;
      }
      return "";
    }
    public void constructorConstructor(String className, Logger counter) {
      out.print("define " + (printType(className, 1).equals("Object")?"void":printType(className, 1)) + " @" + className + "Constructor" + className + "(" + (printType(className, 1)) + " %this");;
      out.print(")\n{\nentry:\n");
      out.println("%this.addr = alloca " + printType(className, 1));
      newCopy(className, "this");
      
      List<AST.attr> currentClassAttrList = classList.get(className).attributes;
      int i = 0;
      while(i <  currentClassAttrList.size())
      {
        AST.attr curAttr = currentClassAttrList.get(i);        
        if (curAttr.typeid.equals("Int")) {
          out.println("%" + curAttr.name + " = getelementptr inbounds" + printType(className,0) + ", " + printType(className,1) + " %this1, i32 0, i32 " + String.valueOf(i));
          if (!(curAttr.value instanceof AST.no_expr)  && !( curAttr.value instanceof AST.new_)) {
            counter = visitExpr(curAttr.value, counter);
            out.println("store " + printType(curAttr.value.type,1) + " %" + String.valueOf(counter.register - 1) + ", " + printType(curAttr.value.type,1) + "* %" + curAttr.name);        
          } else {
            out.println("store i32 0, i32* %" + curAttr.name);
          }
        }
      // String attribute 
        else if (curAttr.typeid.equals("String")) {
          out.println("%" + curAttr.name + " = getelementptr inbounds " + printType(className,0) + ", " + printType(className,1) + " %this1, i32 0, i32 " + String.valueOf(i));        String length_string = null;
          if (!(curAttr.value instanceof AST.no_expr) && !(curAttr.value instanceof AST.new_)) {
            counter = visitExpr(curAttr.value, counter);
            out.println("store " + printType(curAttr.value.type,1) + " %" +  String.valueOf(counter.register - 1) + ", " + printType(curAttr.value.type,1) + "* %" + curAttr.name);        
          } else {
            length_string = "[" + 1 + " x i8]";
            out.println("\tstore i8* getelementptr inbounds (" + length_string + ", " + length_string + "* @nullString , i32 0, i32 0), i8** %" + curAttr.name);
          }
        }
      // Bool attribute 
        else if (curAttr.typeid.equals("Bool")) {
          out.println("%" + curAttr.name + " = getelementptr inbounds " + printType(className,0) + ", " + printType(className,1) + " %this1, i32 0, i32 " + String.valueOf(i));
          if (curAttr.value instanceof AST.no_expr || curAttr.value instanceof AST.new_) {
            out.println("store i1 false, " + printType(curAttr.value.type,1) + "* %" + curAttr.name);        } else {
              counter = visitExpr(curAttr.value, counter);
              out.println("store " + printType(curAttr.value.type,1) + " %" +  String.valueOf(counter.register - 1) + ", " + printType(curAttr.value.type,1) + "* %" + curAttr.name);        
            }
          }
          else {
            out.println("%" + curAttr.name + " = getelementptr inbounds " + printType(className,0) + ", " + printType(className,1) + " %this1, i32 0, i32 " + String.valueOf(i));
            if (!(curAttr.value instanceof AST.no_expr)) {
              counter = visitExpr(curAttr.value, counter);
              out.println("store " + printType(curAttr.value.type,1) + " %" +  String.valueOf(counter.register - 1) + ", " + printType(curAttr.value.type,1) + "* %" + curAttr.name);
              
            } else {
              String null_type = printType(curAttr.typeid, 1);
              out.println("\tstore " + null_type + " null , " + null_type + "* %" + (curAttr.name));
            }
          }
          i++ ;
        }
        out.println("\tret " + (printType(className, 1).equals("void")?"void":printType(className, 1) + "%this1") + "\n}\n");
      }
      public void getClassAttributes(String className) {
        ClassNode currentClass = classList.get(className);
        newCopy(className, "this");
        for (int i = 0; i < currentClass.attributes.size(); i++) {
          if (isClashMethodFormal(currentClass.attributes.get(i).name))   
            continue;
          out.println("%" + currentClass.attributes.get(i).name + " = getelementptr inbounds" + printType(className,0) + ", " + printType(className,1) + " %this1, i32 0, i32 " + String.valueOf(i));
        }
      }
      public boolean isClashMethodFormal(String variable_name) {
        int tempitr = 0, flag = 0;
        while(tempitr < (functionFormalArguments).size())
        {
          if ((functionFormalArguments.get(tempitr)).equals(variable_name) )
          {
            flag = 1;
            break;
          }
          tempitr++;
        }
        if(flag == 1)
          return true;
        else if( flag == 0)
          return false;
        return false;
      }
      public String getAttributeAddress(String objname) {
        int tempitr = 0, flag = 0;
        if (!isClashMethodFormal(objname)) {    
          
          while(tempitr < (classList.get(clsName).attributes).size())
          {
            if (objname.equals(((classList.get(clsName).attributes).get(tempitr)).name)) {
              flag = 1;
              break;
            }
            tempitr++;
          }
        }
        if(flag == 0)
        {
          return (objname + ".addr");
        }
        else if(flag == 1)
          return objname;
        return objname;
      }
      public void newCopy(String type_name, String obj_name) {
        out.println("store " + printType(type_name,1) + "%" + obj_name + ", " + printType(type_name,1) + "* %" + obj_name + ".addr");
        out.println("%this1 = load " + printType(type_name,1) + ", " + printType(type_name,1) + "* %" + obj_name + ".addr");  }
        
        public void catchString(AST.expression expr) {  
          String type = expr.getClass().getSimpleName();
          switch (type){ 
            case "string_const": {
              String cap_string = ((AST.string_const)expr).value;
              if(indexOfStringInArray(cap_string) == -1){
                strArray.add(cap_string);
                out.print("@.str." + indexOfStringInArray(cap_string) + " = private unnamed_addr constant [" + String.valueOf(cap_string.length() + 1) + " x i8] c\"");
                for(int i = 0; i < cap_string.length(); i++) {
                  switch(cap_string.charAt(i)){
                    case '\\':{
                      out.print("\\5C");
                      break;
                    }
                    case '\"':{
                      out.print("\\22");
                      break;
                    }
                    case '\n':{
                      out.print("\\0A");
                      break;
                    } 
                    case '\t': {
                      out.print("\\09");
                      break;
                    } 
                    default: {
                      out.print(cap_string.charAt(i));
                      break;
                    }
                  }
                }
                out.println("\\00\"");
              }
              break;
            } case "eq": {
              catchString(((AST.eq)expr).e1);
              catchString(((AST.eq)expr).e2);
              break;
            } case "assign": {
              catchString(((AST.assign)expr).e1);
              break;
            } case "block": {
              for (AST.expression e : ((AST.block)expr).l1) {
                catchString(e);
              }
              break;
            } case "loop": {
              catchString(((AST.loop)expr).predicate);
              catchString(((AST.loop)expr).body);
              break;
            } case "cond": {
              catchString(((AST.cond)expr).predicate);
              catchString(((AST.cond)expr).ifbody);
              catchString(((AST.cond)expr).elsebody);
              break;
            } case "static_dispatch": {
              catchString(((AST.static_dispatch)expr).caller);
              for (AST.expression e : ((AST.static_dispatch)expr).actuals) {
                catchString(e);
              }
              break;
            }
          }
          return ;
        }
        public void assignRetvalIfSame(String type_name, int register) {
          if (register >= 0 && methodReturn.equals(type_name) && (!(methodReturn.equals("void")) || (methodReturn.equals("IO"))) ) {
            out.println("store = " + printType(type_name,1) + "%" + String.valueOf(register) + ", " + printType(type_name,1) + "* %retval");
          }
        }
        public Logger visitExpr(AST.expression expr, Logger counter) {
          if (expr instanceof AST.bool_const) {
            out.println("\t%" + String.valueOf(counter.register) + " = alloca i1");
            out.println("\tstore i1 " + Boolean.toString(((AST.bool_const)expr).value) + ", i1* %" + String.valueOf(counter.register));
            out.println("\t%" + String.valueOf(counter.register + 1) + " = load i1, i1* %" + String.valueOf(counter.register));
            return new Logger(counter.register + 2, counter.lastBB);
          }
          else if (expr instanceof AST.string_const) {
            String cur_assign_string = ((AST.string_const)expr).value;
            out.println("\t%" + String.valueOf(counter.register) + " = alloca i8*");
            String length_string = "[" + String.valueOf(cur_assign_string.length() + 1) + " x i8]";
            out.print("\tstore i8* getelementptr inbounds (" + length_string + ", " + length_string + "* @.str." + indexOfStringInArray(cur_assign_string));
            out.println(", i32 0, i32 0), i8** %" + String.valueOf(counter.register));
            out.println("\t%" + String.valueOf(counter.register + 1) + " = load i8*, i8** %" + String.valueOf(counter.register));
            return new Logger(counter.register + 2, counter.lastBB);
          }
          else if (expr instanceof AST.int_const) {
            out.println("\t%" + String.valueOf(counter.register) + " = alloca i32");
            out.println("\tstore i32 " + String.valueOf(((AST.int_const)expr).value) + ", i32* %" + String.valueOf(counter.register));
            out.println("\t%" + String.valueOf(counter.register + 1) + " = load i32, i32* %" + String.valueOf(counter.register));
            return new Logger(counter.register + 2, counter.lastBB);
          }
          else if (expr instanceof AST.object) {  
            String typeCode;
            if(!typeConv.containsKey((((AST.object)expr).type))) {
              typeCode = "%" + "class." + ((AST.object)expr).type + "*";
            }
            else {
              typeCode = typeConv.get(((AST.object)expr).type);
            }
            
            if ((((AST.object)expr).name).equals("self")) {
              out.println("\t%" + String.valueOf(counter.register) + " = load " + typeCode + ", " + typeCode + "* %" + "this1");
            } else {
              out.println("\t%" + String.valueOf(counter.register) + " = load " + typeCode + ", " + typeCode + "* %" + getAttributeAddress(((AST.object)expr).name));
            }
            return new Logger(counter.register + 1, counter.lastBB);
          }
          else if (expr instanceof AST.mul || expr instanceof AST.divide || expr instanceof AST.plus || expr instanceof AST.sub ||
            expr instanceof AST.leq || expr instanceof AST.lt || expr instanceof AST.eq || expr instanceof AST.comp || expr instanceof AST.neg) {
            return catchArith(expr, counter);
        }
        else if (expr instanceof AST.block) {
          AST.block the_block = (AST.block)expr;
          String last_type_name = "";
          for (AST.expression cur_expr : the_block.l1) {
            counter = visitExpr(cur_expr, counter);
            last_type_name = (cur_expr).type;
          }
          assignRetvalIfSame(last_type_name, counter.register - 1);
          return counter;
        }
        else if (expr instanceof AST.cond) {
          return catchIf(counter.register, (AST.cond)expr, counter.lastBB);
        }
        else if (expr instanceof AST.loop) {
          return catchLoop((AST.loop)expr, counter);
        }
        else if (expr instanceof AST.assign) {
          counter = visitExpr(((AST.assign)expr).e1, counter);
          String typeCode;
          if(!typeConv.containsKey((((AST.assign)expr).type))) {
            typeCode = "%" + "class." + ((AST.assign)expr).type + "*";
          }
          else {
            typeCode = typeConv.get(((AST.assign)expr).type);
          }
          out.println("\tstore " + typeCode + " %" + String.valueOf(counter.register - 1) + ", " + typeCode +"* %" + getAttributeAddress(((AST.assign)expr).name));
          return counter;
        }
        else if (expr instanceof AST.new_) {
          AST.new_ cur_expr = (AST.new_)expr;
          if (cur_expr.typeid.equals("Int")) {
            out.println("\t%" + String.valueOf(counter.register) + " = alloca i32");
            out.println("\tstore i32 " + String.valueOf(0) + ", i32* %" + String.valueOf(counter.register));
            out.println("\t%" + String.valueOf(counter.register + 1) + " = load i32, i32* %" + String.valueOf(counter.register));
            return new Logger(counter.register + 2, counter.lastBB);
          }
          else if (cur_expr.typeid.equals("Bool")) {
            out.println("\t%" + String.valueOf(counter.register) + " = alloca i1");
            out.println("\tstore i1 " + Boolean.toString(false) + ", i1* %" + String.valueOf(counter.register));
            out.println("\t%" + String.valueOf(counter.register + 1) + " = load i1, i1* %" + String.valueOf(counter.register));
            return new Logger(counter.register + 2, counter.lastBB);
          }
          else if (cur_expr.typeid.equals("String")) {
            String length_string = "[" + 1 + " x i8]";
            out.println("\t%" + String.valueOf(counter.register) + " = alloca i8*");
            out.println("store i8* getelementptr inbounds (" + length_string + ", " + length_string + "* @nullString , i32 0, i32 0), i8** %" + String.valueOf(counter.register));
            out.println("\t%" + String.valueOf(counter.register + 1) + " = load i8*, i8** %" + String.valueOf(counter.register));
            return new Logger(counter.register + 2, counter.lastBB);
          }
          String typeCode;
          if(!typeConv.containsKey((((AST.new_)expr).typeid))) {
            typeCode = "%" + "class." + (((AST.new_)expr).typeid);
          }
          else {
            typeCode = typeConv.get(((AST.new_)expr).typeid);
          }
          out.println("\t%" + String.valueOf(counter.register) + " = alloca " + typeCode);
          out.println("\t%" + String.valueOf(counter.register + 1) + " = call " + typeCode + "* @" + (((AST.new_)expr).typeid) + "Constructor" + (((AST.new_)expr).typeid) + " (" + typeCode + "* %" + String.valueOf(counter.register) + ")");
          return new Logger(counter.register + 2, counter.lastBB);
        }
        else if (expr instanceof AST.static_dispatch) {
          AST.static_dispatch currFuntcion = (AST.static_dispatch)expr;
          if ((!currFuntcion.typeid.equals("Int"))) {
            if(!currFuntcion.typeid.equals("Bool")) {
              if(!currFuntcion.typeid.equals("String")) {
                counter = visitExpr(currFuntcion.caller, counter);
                String callee_type = printType((currFuntcion.caller).type,1);
                out.println("\t%" + counter.register + " = icmp eq " + callee_type + " null , %" + (counter.register - 1) + "\t\t\t\t\t\t\t\t;checking the voidness of the callee");
                out.println("br i1 %" + String.valueOf(counter.register) + ", label %vStaticDispErrBB, label %goAhead" + counter.register);
                out.println("goAhead" + counter.register + ":");
                counter.register++;
                counter.lastBB = "goAhead" + counter.register + ":";
              }
            }
          }
          
          List<Integer> regList = new ArrayList<Integer>();
          String function_being_called = currFuntcion.typeid + "_" + currFuntcion.name;
          String typeCode;
          String retTypeCode;
          if(!typeConv.containsKey(currFuntcion.type)) {
            retTypeCode = "%" + "class." + currFuntcion.type + "*";
          }
          else {
            retTypeCode = typeConv.get(currFuntcion.type);
          }
          int expr_i = 0;
          
          while(expr_i < currFuntcion.actuals.size()){  
            counter = visitExpr(currFuntcion.actuals.get(expr_i),counter);
            
            regList.add(counter.register - 1);
            expr_i++;
          }
          counter = visitExpr(currFuntcion.caller, counter);
          regList.add(0,counter.register);
          regList.add(1,counter.register - 1);
          expr_i = 0;
          if(retTypeCode != "void" && !retTypeCode.equals("%class.IO*")){
            out.print("\t%" + regList.get(0) + " = call " + retTypeCode + " @" + function_being_called + "(");
          }
          else {
            out.print("\tcall void @" + function_being_called + "(");
          }if (! (currFuntcion.typeid.equals("IO"))) {
            if(!typeConv.containsKey((currFuntcion.caller).type)) {
              typeCode = "%" + "class." + ((currFuntcion.caller).type) + "*";
            }
            else {
              typeCode = typeConv.get((currFuntcion.caller).type);
            }
            out.print(typeCode + " %" + String.valueOf(regList.get(1)) + ",");
          }
          while(expr_i < currFuntcion.actuals.size()){
            if(!typeConv.containsKey(currFuntcion.actuals.get(expr_i).type)) {
              typeCode = "%" + "class." + (currFuntcion.actuals.get(expr_i)).type + "*";
            }
            else {
              typeCode = typeConv.get(currFuntcion.actuals.get(expr_i).type);
            }
            out.print(typeCode + " %" + String.valueOf(regList.get(expr_i+2)));
            if(expr_i == (currFuntcion.actuals.size() - 1)){
              expr_i++;
              continue;
            }
            else{
              out.print(",");
            }
            expr_i++;
          }
          out.print(")\n");
          if (retTypeCode.equals("void") || retTypeCode.equals("%class.IO*") )
            return new Logger(counter.register, counter.lastBB);
          else {
            return new Logger(counter.register + 1, counter.lastBB);
          }
        }
        return counter;
      }
      public Logger catchIf(int register, AST.cond expr, String lastBB) {  
        int currIfBbCounter = ifBBcount;
        Logger predicateBlock;
        ifBBcount++;
        Logger tempLogger;
        tempLogger = new Logger();
        tempLogger.register = register;
        tempLogger.lastBB = lastBB;
        predicateBlock = visitExpr(expr.predicate, tempLogger);
        out.println("br i1 %" + String.valueOf(predicateBlock.register - 1) + ", label %if.then" + String.valueOf(currIfBbCounter) + ", label %if.else" + String.valueOf(currIfBbCounter));
        out.println("if.then" + String.valueOf(currIfBbCounter) + ":");
        Logger thenBlock;
        tempLogger.register = predicateBlock.register;
        tempLogger.lastBB = "%if.then" + String.valueOf(currIfBbCounter);
        thenBlock = visitExpr(expr.ifbody, tempLogger);
        out.println("br label %if.end" + String.valueOf(currIfBbCounter) + "\n");
        out.println("if.else" + String.valueOf(currIfBbCounter) + ":");
        Logger elseBlock;
        tempLogger.register = thenBlock.register;
        tempLogger.lastBB = "%if.else" + String.valueOf(currIfBbCounter);
        elseBlock = visitExpr(expr.elsebody, tempLogger);
        out.println("br label %if.end" + String.valueOf(currIfBbCounter) + "\n");
        out.println("\nif.end" + String.valueOf(currIfBbCounter) + ":");
        if ((expr.elsebody.type).equals("void") || (expr.elsebody.type).equals("IO")) {
          return new Logger(elseBlock.register, "%if.end" + String.valueOf(currIfBbCounter));
        } 
        out.println("  %" + elseBlock.register + " = phi " + expr.elsebody.type + " [ %" + (thenBlock.register - 1) + " , " + thenBlock.lastBB + " ]" + " , " + " [ %" + (elseBlock.register - 1) + " , " + elseBlock.lastBB + " ]");
        assignRetvalIfSame((expr.elsebody.type), elseBlock.register);
        return new Logger(elseBlock.register + 1, "%if.end" + String.valueOf(currIfBbCounter));
      }
      public Logger catchLoop(AST.loop expr, Logger counter) {
        int currLoopCounter = loopBBcount;
        loopBBcount++;
        out.println("br label %for.cond" + String.valueOf(currLoopCounter) + "\n");
        out.println("\nfor.cond" + String.valueOf(currLoopCounter) + ":");
        Logger tempLogger;
        tempLogger = new Logger();
        tempLogger.register = counter.register;
        tempLogger.lastBB = "%for.cond" + String.valueOf(currLoopCounter);
        tempLogger = visitExpr(expr.predicate, tempLogger);
        out.println("br i1 %" + String.valueOf(tempLogger.register - 1) + ", label %for.body" + String.valueOf(currLoopCounter) + ", label %for.end" + String.valueOf(currLoopCounter));
        out.println("\nfor.body" + String.valueOf(currLoopCounter) + ":");
        tempLogger.lastBB = "%for.body" + String.valueOf(currLoopCounter);
        tempLogger = visitExpr(expr.body, tempLogger);
        out.println("br label %for.cond" + String.valueOf(currLoopCounter) + "\n");
        out.println("\nfor.end" + String.valueOf(currLoopCounter) + ":");
        return new Logger(tempLogger.register, "%for.end" + String.valueOf(currLoopCounter));
      }
      public Logger catchArith(AST.expression expr, Logger counter) {
        if (expr instanceof AST.mul) {
          Logger ops1 = visitExpr(((AST.mul)expr).e1, counter);
          Logger ops2 = visitExpr(((AST.mul)expr).e2, ops1);
          out.println("%"+String.valueOf(ops2.register) + " = mul i32 %" + String.valueOf((ops1.register - 1)) + ", %" + String.valueOf((ops2.register - 1)));
          return new Logger(ops2.register + 1, ops2.lastBB);
        } else if (expr instanceof AST.divide) {
          Logger ops1 = visitExpr(((AST.divide)expr).e1, counter);
          Logger ops2 = visitExpr(((AST.divide)expr).e2, ops1);
          String ops2_regis = String.valueOf(ops2.register - 1);
          out.println("%comp_" + String.valueOf(ops2.register - 1) + "_0" + " = icmp eq i32 %" + String.valueOf(ops2_regis) + ", 0");
          out.println("br i1 %" + "comp_" + ops2_regis + "_0" + ", label %zeroDivisorErrorBB" + ", label %goAhead" + ops2_regis + "_0");
          out.println("goAhead" + ops2_regis + "_0:");
          out.println("%"+String.valueOf(ops2.register) + " = udiv i32 %" + String.valueOf((ops1.register - 1)) + ", %" + String.valueOf((ops2.register - 1)));
          return new Logger(ops2.register + 1, "goAhead" + ops2_regis + "_0:");
        } else if (expr instanceof AST.plus) {
          Logger ops1 = visitExpr(((AST.plus)expr).e1, counter);
          Logger ops2 = visitExpr(((AST.plus)expr).e2, ops1);
          out.println("%"+String.valueOf(ops2.register) + " = add i32 %" + String.valueOf((ops1.register - 1)) + ", %" + String.valueOf((ops2.register - 1)));
          return new Logger(ops2.register + 1, ops2.lastBB);
        } else if (expr instanceof AST.sub) {
          Logger ops1 = visitExpr(((AST.sub)expr).e1, counter);
          Logger ops2 = visitExpr(((AST.sub)expr).e2, ops1);
          out.println("%"+String.valueOf(ops2.register) + " = sub i32 %" + String.valueOf((ops1.register - 1)) + ", %" + String.valueOf((ops2.register - 1)));
          return new Logger(ops2.register + 1, ops2.lastBB);
        } else if (expr instanceof AST.leq) {
          Logger ops1 = visitExpr(((AST.leq)expr).e1, counter);
          Logger ops2 = visitExpr(((AST.leq)expr).e2, ops1);
          out.println("%"+String.valueOf(ops2.register) + " = icmp sle i32 %" + String.valueOf((ops1.register - 1)) + ", %" + String.valueOf((ops2.register - 1)));
          return new Logger(ops2.register + 1, ops2.lastBB);
        } else if (expr instanceof AST.lt) {
          Logger ops1 = visitExpr(((AST.lt)expr).e1, counter);
          Logger ops2 = visitExpr(((AST.lt)expr).e2, ops1);
          out.println("%"+String.valueOf(ops2.register) + " = icmp slt i32 %" + String.valueOf((ops1.register - 1)) + ", %" + String.valueOf((ops2.register - 1)));
          return new Logger(ops2.register + 1, ops2.lastBB);
        } else if (expr instanceof AST.eq) {
          Logger ops1 = visitExpr(((AST.eq)expr).e1, counter);
          Logger ops2 = visitExpr(((AST.eq)expr).e2, ops1);
          if (((AST.eq)expr).e1.type.equals("Int")){
            out.println("%"+String.valueOf(ops2.register) + " = icmp eq i32 %" + String.valueOf((ops1.register - 1)) + ", %" + String.valueOf((ops2.register - 1)));
          }
          else if (((AST.eq)expr).e1.type.equals("Bool")) {
            out.println("%"+String.valueOf(ops2.register) + " = icmp eq i1 %" + String.valueOf((ops1.register - 1)) + ", %" + String.valueOf((ops2.register - 1)));
          }
          else if (((AST.eq)expr).e1.type.equals("String")) {
            out.println("%" + String.valueOf(ops2.register) + " = call i1 @String_strcmp (i8* %" + String.valueOf(ops1.register - 1) + ",i8* %" + String.valueOf(ops2.register - 1) + ")") ;
          }
          return new Logger(ops2.register + 1, ops2.lastBB);
        } else if (expr instanceof AST.comp) {
          Logger ops1 = visitExpr(((AST.comp)expr).e1, counter);
          out.println("%"+String.valueOf(ops1.register) + " = xor i1 %" + String.valueOf((ops1.register - 1)) + ", true");
          return new Logger(ops1.register + 1, ops1.lastBB);
        }
        else if (expr instanceof AST.neg) {
          Logger ops1 = visitExpr(((AST.neg)expr).e1, counter);
          out.println("%"+String.valueOf(ops1.register) + " = mul i32 %" + String.valueOf((ops1.register - 1)) + ", -1");
          return new Logger(ops1.register + 1, ops1.lastBB);
        }
        return counter;
      }
      
      private int indexOfStringInArray(String name)
      {
        for (int i = 0 ; i < strArray.size(); i++ )
        {
          if((strArray.get(i)).equals(name))
            return i; 
        }
        return -1;
      }
    }
