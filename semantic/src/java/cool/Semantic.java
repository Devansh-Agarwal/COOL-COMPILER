package cool;

import java.util.*;

import cool.AST.formal;

class ClassNode {
    public String name;
    public String parent;
    public int height;
    public HashMap<String, AST.attr> attributes ;
    public HashMap<String, AST.method> methods ;

    ClassNode(String class_name,  String  class_parent, int  class_height, HashMap<String, AST.attr> class_atributes ,  HashMap<String,  AST.method> class_methods) {
        attributes = new HashMap<String, AST.attr>();
        methods = new HashMap<String, AST.method> ();
        name  = class_name;
        parent  = class_parent;
        height  = class_height;

        attributes.putAll(class_atributes);
        methods.putAll(class_methods);
    }
}

public class Semantic {
    private Boolean errorFlag = false;
    public void reportError(String filename, int lineNo, String error) {
        errorFlag = true;
        System.err.println(filename + ":" + lineNo + ": " + error);
    }

    public Boolean getErrorFlag() {
        return errorFlag;
    }

    /*
        Don't change code above this line
    */

    
    int condiii = 0;
    
    // used for managing scope
    private ScopeTable<AST.attr> scope = new ScopeTable<AST.attr>();
    // contains all the classes
    public HashMap<String, ClassNode> classList = new HashMap<String, ClassNode>();
    private String filename;

    public Semantic(AST.program program) {

        //Write Semantic analyzer code here
        // adds basic classes to the class list
        addBuiltInClasses();
        // process the entire program and fills classList with the help of few functions
        GraphHandler(program.classes);
        int i = 0 ;
        while (i < (program.classes).size()) {
	    
            filename = ((program.classes).get(i)).filename; // each class has a file name

            scope.enterScope(); // entering new scope
            
            String name = ((program.classes).get(i)).name;
            AST.no_expr b = new AST.no_expr(((program.classes).get(i)).lineNo); 
            int lNo = ((program.classes).get(i)).lineNo;
            AST.attr a = new AST.attr("self", name , b , lNo );
            scope.insert("self", a );     //in the class self is availaible as an attribuite

            String Name = ((program.classes).get(i)).name;
            scope.insertAll(classList.get(Name).attributes);

            visit_class((program.classes).get(i));

            scope.exitScope(); // exiting scope after class is processed
            i++;
        }

        

	// Check is there a Main class
        if (classList.containsKey("Main") == false) {
            reportError(filename, 1, "Program does not contain class 'Main'");
        } 
	
	//Check is there a main method in Main class
        else if (classList.get("Main").methods.containsKey("main") == false ) {    
            reportError(filename, 1, "'Main' class does not contain 'main' method");
        }
    }

    // adds all the built in classes as mentione on page 13 and 14 of cool manual
    private void addBuiltInClasses() {
        // contains Object, String, Io
        List<HashMap<String,AST.method>> basicClassMethods = new ArrayList<HashMap<String,AST.method> >(); 
        basicClassMethods.add(new HashMap<String, AST.method>());
        basicClassMethods.add(new HashMap<String, AST.method>());
        basicClassMethods.add(new HashMap<String, AST.method>());
        List<AST.formal> substr_formal = new ArrayList<AST.formal>();
        substr_formal.add(new AST.formal("i", "Int", 0));
        substr_formal.add(new AST.formal("l", "Int", 0));
        // fills basicClassMethods with respective classes
        helperAddObjectIOString(basicClassMethods, substr_formal);
        // adds the built in classes to the class list
        helperAddBuiltInClassToClassList(basicClassMethods);
     }
// helper function to fill basicClassMethods with respective classes
private void helperAddObjectIOString(List<HashMap<String,AST.method>> basicClassMethods,  List<AST.formal> substr_formal)
    {
        AST.no_expr[] nox  =  new AST.no_expr[10];
           
        for(int i = 0; i < 10; i++)
        {
            nox[i] = new AST.no_expr(0);
        }
        // adding Object
        basicClassMethods.get(0).put("abort", new AST.method("abort", new ArrayList<AST.formal>(), "Object",nox[0] , 0));
        basicClassMethods.get(0).put("type_name", new AST.method("type_name", new ArrayList<AST.formal>(), "String",nox[1], 0));
        basicClassMethods.get(0).put("copy", new AST.method("copy", new ArrayList<AST.formal>(), "Object", nox[2], 0));

        // adding IO    
        basicClassMethods.get(1).put("out_string", new AST.method("out_string", Arrays.asList(new AST.formal("x", "String", 0)), "IO", nox[3], 0));
        basicClassMethods.get(1).put("out_int", new AST.method("out_int", Arrays.asList(new AST.formal("x", "Int", 0)), "IO", nox[4], 0));
        basicClassMethods.get(1).put("in_string", new AST.method("in_string", new ArrayList<AST.formal>(), "String", nox[5], 0));
        basicClassMethods.get(1).put("in_int", new AST.method("in_int", new ArrayList<AST.formal>(), "Int", nox[6], 0));
        basicClassMethods.get(1).putAll(basicClassMethods.get(0));      //inheriting all object methods
        
        // adding String
        basicClassMethods.get(2).put("length", new AST.method("length", new ArrayList<AST.formal>(), "Int", nox[7], 0));
        basicClassMethods.get(2).put("concat", new AST.method("concat", Arrays.asList(new AST.formal("s", "String", 0)), "String", nox[8], 0));
        basicClassMethods.get(2).put("substr", new AST.method("substr", substr_formal, "String",nox[9], 0));
        basicClassMethods.get(2).putAll(basicClassMethods.get(0));      //inheriting all object methods
        
        return ;
    }

    // adding all the classes to the class list
    private void helperAddBuiltInClassToClassList(List<HashMap<String,AST.method>> basicClassMethods)
    {
        classList.put("Object", new ClassNode("Object", null, 0, new HashMap <String, AST.attr>(), basicClassMethods.get(0)));
        classList.put("IO", new ClassNode("IO", "Object", 1, new HashMap <String, AST.attr>(), basicClassMethods.get(1)));
        classList.put("String", new ClassNode("String", "Object", 1, new HashMap <String, AST.attr>(), basicClassMethods.get(2)));
        classList.put("Int", new ClassNode("Int", "Object", 1, new HashMap <String, AST.attr>(), new HashMap <String, AST.method>(basicClassMethods.get(0))));
        classList.put("Bool", new ClassNode("Bool", "Object", 1, new HashMap <String, AST.attr>(), new HashMap <String, AST.method>(basicClassMethods.get(0))));
        return;
    }

        // returns the number equivalent to a class in the adjacenccy graph
    private int ClassNameEquivalentNumber(ArrayList<AST.class_> class_node,String name )
    {
        for (int i = 0 ; i < class_node.size(); i++ )
        {
            if( class_node.get(i) != null &&((class_node.get(i)).name).equals(name))
                return i; 
        }
        return -1;
    }

    // checks if the class is a basic class
    private boolean isBasicClass(String cl)
    {
        return (cl.equals("Object") || cl.equals("IO") || cl.equals("Int") || cl.equals("String") || cl.equals("Bool"));
    }

    // checks if a class is inheritable
    private boolean isBasicClassNotInheritable(String cl)
    {
        return (cl.equals("Int") || cl.equals("String") || cl.equals("Bool"));
    }


    // makes a graph detects cycles checks for inheritance related stuff
    // if everything is fine adds class to the class list using some functions
    private void GraphHandler(List<AST.class_> classes) {

        // contains all the classes
        ArrayList<AST.class_> class_node = new ArrayList<AST.class_>();          
        // contains inheritance graph all the classes
        ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<ArrayList<Integer>>();
       
        // adds the built in classes to the inheritance graph
        helperUpdateClassNodeAndGraph(class_node, adjacency_list);

        boolean flag = true;

        // checks for proper class redefination and inheritance from legal class and then adds to the graph
        int k = 0;
        while ( k < classes.size()) {
            if (isBasicClassNotInheritable(classes.get(k).parent)) {
                reportError(classes.get(k).filename, classes.get(k).lineNo, "Class '" + classes.get(k).name + "' cannot inherit basic class '" + classes.get(k).parent + "'.");
                flag = false;
            }
            if (isBasicClass(classes.get(k).name)) {
                reportError(classes.get(k).filename, classes.get(k).lineNo, "here basic class is redefined  '" + classes.get(k).name + "'.");
                flag = false ;
            }
            if (!isBasicClass(classes.get(k).name) &&  (ClassNameEquivalentNumber(class_node, classes.get(k).name)!= -1)) {
                reportError(classes.get(k).filename, classes.get(k).lineNo, "Class '" + classes.get(k).name + "' was previously defined.");
                flag = false;
            } else {
                class_node.add(classes.get(k));
                adjacency_list.add(new ArrayList<Integer>()); 
            }
            k++;
        }

        // adds the edges between the nodes in the adjaceny list
       int j = 0;
        while ( j< classes.size()) {
            String paren = classes.get(j).parent;
            if (!paren.equals("Object") &&!paren.equals("IO") &&!paren.equals("String") &&!paren.equals("Int") &&!paren.equals("Bool") && ClassNameEquivalentNumber(class_node, paren) == -1) {
                reportError(classes.get(j).filename, classes.get(j).lineNo, "Class '" + classes.get(j).name + "' inherits from an undefined class '" + paren + "'.");
                flag = false;
            }

            if (flag) {
                if(paren.equals("Object"))
                {
                    (adjacency_list.get(0)).add(ClassNameEquivalentNumber(class_node, classes.get(j).name));
                }
                else if(paren.equals("IO"))
                {
                    (adjacency_list.get(1)).add(ClassNameEquivalentNumber(class_node, classes.get(j).name));
                }                    
                else
                (adjacency_list.get(ClassNameEquivalentNumber(class_node, paren) )).add(ClassNameEquivalentNumber(class_node, classes.get(j).name));     //adding the inheritance edge
            }
            j++;
        }
        // checks if there are any cylces in the graph or any of the above condition is wrong
        if (flag == false || isCyclic(adjacency_list, class_node)) {
            System.exit(0);
        }
        // adds the classes to classlist
        makeClassList(adjacency_list,class_node);
    }

    //adds the built in classes to the inheritance graph
    private void helperUpdateClassNodeAndGraph(ArrayList<AST.class_> class_node, ArrayList<ArrayList<Integer>> adjacency_list)
    {

        class_node.add(null);
        class_node.add(null);
        class_node.add(null);
        class_node.add(null);
        class_node.add(null);

        adjacency_list.add(new ArrayList<Integer>(Arrays.asList(1)));   //adding Object to graph
        adjacency_list.add(new ArrayList<Integer>());   //adding IO to graph
        adjacency_list.add(new ArrayList<Integer>());   //adding Int to graph
        adjacency_list.add(new ArrayList<Integer>());   //adding String to graph
        adjacency_list.add(new ArrayList<Integer>());   //adding Bool to graph
        return;
    }

     // Nodes are added in a BFS style to classList so that the derived class can easily inherit features from the parent class   
    private void makeClassList(ArrayList<ArrayList<Integer>> adjacency_list,ArrayList<AST.class_> class_node)
    {
        ArrayList<Integer> q = new ArrayList<Integer>();
        boolean[] visited = new boolean[class_node.size()];       
        Arrays.fill(visited, Boolean.FALSE);
        Integer node = 0;
        int size = 0, i =0, nodeInList;
        ArrayList<Integer> nodeList ;
        q.add(0);   //Object class
        visited[0] = true;
        size =  q.size();
        while (size > 0) {
            node = q.get(--size);
            q.remove(size);
            i= 0;
            nodeList = adjacency_list.get(node);
            while ((nodeList!= null) && (i < nodeList.size())) {
                nodeInList = nodeList.get(i);
                if (visited[nodeInList] == false) {
                    visited[nodeInList]= true;
                    q.add(0, nodeInList);
                    size++;
                    // checking for Object & IO class
                    if (nodeInList > 1) {
                        
                        insert_class(class_node.get(nodeInList));
                    }
                }
            i++;
            }
        }
    }
    /*
     detecting cycles using dfs;
    */
    private boolean isCyclic(ArrayList<ArrayList<Integer>> adjacency_list, ArrayList<AST.class_> class_node) {
    
        boolean[] visited = new boolean[class_node.size()];
        Arrays.fill(visited, Boolean.FALSE);
        ArrayList<Integer> dfsStack = new ArrayList<Integer>();        //recursion stack
        ArrayList<Integer> nodeList ;
        boolean isCyclic = false;

        int i = 0, k = 0, size;
        while (i < class_node.size()) {

            if (visited[i] == false) {

                dfsStack.add(i);
                size = dfsStack.size();
                while (size > 0) {

                    Integer node = dfsStack.get(size-1);
                    dfsStack.remove(--size);

                    visited[node] = true; // node visited marked   
                    k = 0;
                    nodeList = adjacency_list.get(node);
                    while ((nodeList!= null) && (k < nodeList.size())) {

                        int nodeInList = nodeList.get(k);
                        if (visited[nodeInList] == false) 
                            dfsStack.add(nodeInList);
                        else
                        {       
                            printCycle(adjacency_list, class_node, nodeInList);  // prints the detected cycle
                            isCyclic = true;
                            dfsStack.clear();
                            size  = 0;
                            break;
                        }
                        k++;
                    }
                }   
            }
            i++;
        }
        return isCyclic;
    }

    
     //   every class which is reachable from the node part of a cycle is flagged
    //    all the nodes are printed using bfs
    void printHelperFunc(AST.class_ Node)
    {
        reportError(Node.filename, Node.lineNo, " Class " + Node.name + ", or an ancestor of " + Node.name + ", is involved in an inheritance cycle.");
    }
    private void printCycle(ArrayList<ArrayList<Integer>> adjacency_list, ArrayList<AST.class_> class_node, Integer node) {

        ArrayList<Integer> q = new ArrayList<Integer>();
        Boolean[] visited = new Boolean[class_node.size()];
        Arrays.fill(visited, Boolean.FALSE);
        ArrayList<Integer> nodeList;
        int size = 0, i = 0;

        q.add(node);
        visited[node] = true;
        printHelperFunc(class_node.get(node));        
        size = q.size();
        while (size > 0) {
            node = q.get(--size);
            q.remove(size);
            nodeList = adjacency_list.get(node);
            i = 0;
            while((nodeList!= null) && (i < nodeList.size())) {
                int tempNode = nodeList.get(i);
                if (visited[tempNode] == false ) {
                    q.add(0,tempNode);
                    size++;
                    visited[tempNode] =  true;
                    printHelperFunc(class_node.get(tempNode));
                }
                i++;
            }
        }
    }

    // intitialising the attribuites
    private void add_default_value(AST.attr atr) {
        switch(atr.typeid){
            case "Int":{
                atr.value = new AST.int_const(0, atr.lineNo);
                break;
            }
            case "String":{
                atr.value = new AST.string_const("", atr.lineNo);
                break;
            }
            case "Bool":{
                atr.value = new AST.bool_const(false, atr.lineNo);
                break;
            }
            
        }
    }

    // inserts classes to the classList in a BFS manner
    private void insert_class(AST.class_ cl) {
        String parent = cl.parent;
        ArrayList<HashMap<String, AST.attr>> attribuitess = new ArrayList<HashMap<String, AST.attr>>();
        ArrayList<HashMap<String, AST.method>> methodss = new ArrayList<HashMap<String, AST.method>>();
        attribuitess.add(new HashMap<String, AST.attr>());
        attribuitess.add(classList.get(parent).attributes);
        methodss.add(new HashMap<String, AST.method>());
        methodss.add(classList.get(parent).methods);
        int i =0;

        // parents attribute & method list are added here
        ClassNode clNode = new ClassNode(cl.name, parent, classList.get(parent).height + 1, attribuitess.get(1), methodss.get(1)); 

        boolean flag = true;
        
        while(i< (cl.features).size()) {

            // Going throug the attributes of class
            if (cl.features.get(i).getClass() == AST.attr.class) {
                AST.attr atr = (AST.attr)cl.features.get(i);
                flag = true;

                // are there duplicate attributes within the class attributes
                if (attribuitess.get(0).containsKey(atr.name)) {
                    reportError(cl.filename, atr.lineNo, "Attribute '" + atr.name + "' in class '" + cl.name + "' is defined multiple times in class '" + cl.name + "'.");
                    flag = false;
                }

                // Are inherited class attributes  duplicate? 
                if (attribuitess.get(1).containsKey(atr.name)) {
                    reportError(cl.filename, atr.lineNo, "Attribute '" + atr.name + "' in class '" + cl.name + "' is an attribute of an inherited class '" + parent + "'.");
                    flag = false;
                }

                if (flag) {
                    // Default values are added
                    if (atr.value.getClass() == AST.no_expr.class)
                       {
                            add_default_value(atr);
                       }
                    attribuitess.get(0).put(atr.name, atr);
                }
            }

            else if (cl.features.get(i).getClass() == AST.method.class) {
                AST.method me = (AST.method)cl.features.get(i);
                flag = true;

                if (methodss.get(0).containsKey(me.name)) {
                    reportError(cl.filename, me.lineNo, "Method '" + me.name + "' is defined multiple times in class '" + cl.name + "'.");
                    flag =  false;
                }
                if (methodss.get(1).containsKey(me.name)) {
                    AST.method pr_met = methodss.get(1).get(me.name);

                    // Checking number of formal parameters
                    if (pr_met.formals.size() != me.formals.size()) {
                        reportError(cl.filename, me.lineNo, "Incompatible number of formal parameters of redefined method '" + me.name + "' in class '" + cl.name + "'.");
                        flag = false;
                    } else {

                        for (int j = 0; j < me.formals.size(); j++) {
                            formal a = pr_met.formals.get(j); 
                            String str = a.typeid; 
                            formal b = me.formals.get(j);
                            String str2 = b.typeid;
                            if (str.equals(str2) == false) {
                                reportError(cl.filename, me.lineNo, "In redefined method '" + me.name + "' in class '" + cl.name + "', parameter type " + me.formals.get(j).typeid + " is different from original type " + pr_met.formals.get(j).typeid + ".");
                                flag = false;
                            }
                        }
                    }

                    
                    if (pr_met.typeid.equals(me.typeid) == false) {
                        reportError(cl.filename, me.lineNo, "In redefined method '" + me.name + "' in class '" + cl.name + "', return type '" + me.typeid + "' is different from original return type '" + pr_met.typeid + "'.");
                        flag = false;
                    }

                }

                if (flag) {
                    methodss.get(0).put(me.name, me);
                }
            }
            i++;
        }

        // if Main class does not have main method but it's inherited class has main method
        if (cl.name.equals("Main") && (methodss.get(0).containsKey("main") == false))  {
            condiii = 1;
            reportError(cl.filename, 1, "'Main' class does not contain 'main' method");
        }
        clNode.methods.putAll(methodss.get(0));
        clNode.attributes.putAll(attribuitess.get(0));

        classList.put(cl.name, clNode);
    }

    // Visit the class
    private void visit_class(AST.class_ cl) {
        Iterator<AST.feature> cl_f_Iter = cl.features.iterator(); //Inits at -1
        while(cl_f_Iter.hasNext()) {
        AST.feature temp = cl_f_Iter.next();
        if (temp.getClass() == AST.method.class) {
            visit_method((AST.method)temp);
            continue;
        }
        if (temp.getClass() == AST.attr.class) 
            visit_attr((AST.attr)temp);
        }
    }

    // Visit methods of a certain class
    private void visit_method(AST.method cl_m) {
        scope.enterScope();                                     //Entering a new scope
        Iterator<AST.formal> cl_m_for_Iter = cl_m.formals.iterator();
        while(cl_m_for_Iter.hasNext()) {
            AST.formal temp = cl_m_for_Iter.next();
            if (scope.lookUpLocal(temp.name) == null){
                scope.insert(temp.name, new AST.attr(temp.name, temp.typeid, new AST.no_expr(temp.lineNo), temp.lineNo));
                continue;
            }
            reportError(filename, temp.lineNo, "Duplicate declarations found for formal parameters");
        }
        visit_expr(cl_m.body);
        if (conform(cl_m.body.type, cl_m.typeid) != true)          // Refer to cool manual Sections 6 and 7.5 for conformance of types in methods
            reportError(filename, cl_m.lineNo, "Types \"" + cl_m.body.type + ", " + cl_m.typeid + "\" do not conform. Refer to cool manual for details.");
        scope.exitScope();
    }

    // Visit attributes of a certain class
    private void visit_attr(AST.attr attrib) {
        //Visit recursively if possible
        if ((attrib.value.getClass() == AST.no_expr.class) != true) {
            visit_expr(attrib.value);
            if (conform(attrib.value.type, attrib.typeid) != true) {  // Refer to cool manual Sections 6 and 7.5 for conformance of types in attributes
                reportError(filename, attrib.lineNo, "Types \"" + attrib.value.type + "\", \"" + attrib.typeid + "\" do not conform. Refer to cool manual for details.");
            }
        }
    }

    // Big bad function to take care of all the expressions tiny and large alike.
    //Refer to Section 12 of cool manual for info on type checking.
    private void visit_expr(AST.expression expr) {
        String type = expr.getClass().getSimpleName();  //get type of AST as string for case
        switch (type){                                  //Select action based on type of expression
            //Constants
            case "bool_const": {
                ((AST.bool_const)expr).type = "Bool";
                break;
            }

            case "string_const":{
                ((AST.string_const)expr).type = "String";
                break;
            }

            case "int_const":{
                ((AST.int_const)expr).type = "Int";
                break;
            }
            //~expr
            case "comp":{
                AST.comp the_complement = ((AST.comp)expr);
                visit_expr(((AST.comp)expr).e1);
                if ((((AST.comp)expr).e1).type.equals("Bool") == true) {
                    ((AST.comp)expr).type = "Bool";
                    break;
                }
                ((AST.comp)expr).type = "Bool";
                reportError(filename, (((AST.comp)expr).e1).lineNo, "Type \"" + (((AST.comp)expr).e1).type + "\" encountered for complement. Expected \"Bool\"");
                break;
            }
            //expr = expr.
            case "eq":{
                AST.eq the_equality = (AST.eq)expr;
                visit_expr(((AST.eq)expr).e1);
                visit_expr(((AST.eq)expr).e2);

                Boolean e1_Ok =  (((AST.eq)expr).e1).type.equals("Int");
                e1_Ok = e1_Ok || (((AST.eq)expr).e1).type.equals("String");
                e1_Ok = e1_Ok || (((AST.eq)expr).e1).type.equals("Bool");

                Boolean e2_Ok =  (((AST.eq)expr).e2).type.equals("Int");
                e2_Ok = e2_Ok || (((AST.eq)expr).e2).type.equals("String");
                e2_Ok = e2_Ok || (((AST.eq)expr).e2).type.equals("Bool");
                
                ((AST.eq)expr).type = "Bool";
                if ((e1_Ok || e2_Ok)) {
                    if ((((AST.eq)expr).e1).type.equals((((AST.eq)expr).e1).type) == false) {
                        reportError(filename, the_equality.lineNo, "Types \"" + (((AST.eq)expr).e1).type + "\", \"" + (((AST.eq)expr).e2).type + "\"encountered for equality testing. Expected \"Int\"");
                        break;
                    }
                }
                break;
            }
            //expr <- expr
            case "assign":{
                visit_expr(((AST.assign)expr).e1);

                if (scope.lookUpGlobal(((AST.assign)expr).name) == null) {
                    reportError(filename, ((AST.assign)expr).lineNo, "Variable being used without being declared");
                    ((AST.assign)expr).type = "Object";
                    break;
                } 
                if (conform((((AST.assign)expr).e1).type, scope.lookUpGlobal(((AST.assign)expr).name).typeid) == true) {
                    ((AST.assign)expr).type = ((AST.assign)expr).e1.type;
                } else {
                    reportError(filename, ((AST.assign)expr).lineNo, "Types \"" + (((AST.assign)expr).e1).type + "\", \"" + scope.lookUpGlobal(((AST.assign)expr).name).typeid + "\" do not conform. Refer to cool manual for details.");
                    ((AST.assign)expr).type = "Object";
                    ((AST.assign)expr).type = ((AST.assign)expr).e1.type;
                }
                ((AST.assign)expr).type = ((AST.assign)expr).e1.type;
                break;
            }
            //expr <= expr
            case "leq": {
                visit_expr(((AST.leq)expr).e1);
                if ((((AST.leq)expr).e1).type.equals("Int") == false){
                    ((AST.leq)expr).type = "Bool";
                    reportError(filename, ((AST.leq)expr).lineNo, "Incompatible type for operand 1 \"" + (((AST.leq)expr).e1).type + "\" & \"" + (((AST.leq)expr).e2).type + "\" for less than or equal to operator");
                }
                visit_expr(((AST.leq)expr).e2);
                if ((((AST.leq)expr).e2).type.equals("Int") == true) {
                    ((AST.leq)expr).type = "Bool";
                    reportError(filename, ((AST.leq)expr).lineNo, "Incompatible type for operand 2 \"" + (((AST.leq)expr).e1).type + "\" & \"" + (((AST.leq)expr).e2).type + "\" for less than or equal to operator");
                }
                ((AST.leq)expr).type = "Bool";
                break;
            }
            //expr < expr
            case "lt":{
                visit_expr(((AST.lt)expr).e1);
                visit_expr(((AST.lt)expr).e2);
                if ((((AST.lt)expr).e1).type.equals("Int") == false) {
                    ((AST.lt)expr).type = "Bool";
                    reportError(filename, ((AST.lt)expr).lineNo, "Incompatible type for operand 1 \"" + (((AST.lt)expr).e1).type + "\" & \"" + (((AST.lt)expr).e2).type + "\" for less than operator");
                }
                if ((((AST.lt)expr).e2).type.equals("Int") == false) {
                    ((AST.lt)expr).type = "Bool";
                    reportError(filename, ((AST.lt)expr).lineNo, "Incompatible type for operand 2 \"" + (((AST.lt)expr).e1).type + "\" & \"" + (((AST.lt)expr).e2).type + "\" for less than operator");
                }
                ((AST.lt)expr).type = "Bool";
                break;
            }
            //if expr then expr else expr fi
            case "cond":{
                visit_expr(((AST.cond)expr).predicate);
                visit_expr(((AST.cond)expr).ifbody);
                visit_expr(((AST.cond)expr).elsebody);
                if ((((AST.cond)expr).predicate).type.equals("Bool") == true) {
                    ((AST.cond)expr).type = lca((((AST.cond)expr).ifbody).type, (((AST.cond)expr).elsebody).type);
                    break;
                }
                ((AST.cond)expr).type = lca((((AST.cond)expr).ifbody).type, (((AST.cond)expr).elsebody).type);
                reportError(filename, (((AST.cond)expr).predicate).lineNo, "Conditional encountered has type \"" + (((AST.cond)expr).predicate).type + "\". Expected \"Bool\"");
                break;
            }
            //not expr
            case "neg":{
                visit_expr(((AST.neg)expr).e1);
                if (((((AST.neg)expr).e1).type.equals("Int")) == true) {
                    ((AST.neg)expr).type = "Int";
                    break;
                }
                ((AST.neg)expr).type = "Int";
                reportError(filename, ((AST.neg)expr).lineNo, "Type \"" + (((AST.neg)expr).e1).type + "\" encountered. Expected \"Int\" for negation");
                break;
            }
            //expr/expr
            case "divide":{
                visit_expr(((AST.divide)expr).e1);
                if ((((AST.divide)expr).e1).type.equals("Int") == false){
                    reportError(filename, ((AST.divide)expr).lineNo, "Incompatible type for operand 1 \"" + (((AST.divide)expr).e1).type + "\" & \"" + (((AST.divide)expr).e2).type + "\" for performing division");
                    ((AST.divide)expr).type = "Int";
                }
                visit_expr(((AST.divide)expr).e2);
                if ((((AST.divide)expr).e2).type.equals("Int") == false) {
                    reportError(filename, ((AST.divide)expr).lineNo, "Incompatible type for operand 2 \"" + (((AST.divide)expr).e1).type + "\" & \"" + (((AST.divide)expr).e2).type + "\" for performing division");
                    ((AST.divide)expr).type = "Int";
                }
                ((AST.divide)expr).type = "Int";
                break;
            }
            //expr*expr
            case "mul":{
                visit_expr(((AST.mul)expr).e1);
                if ((((AST.mul)expr).e1).type.equals("Int") == false){
                    ((AST.mul)expr).type = "Int";
                    reportError(filename, ((AST.mul)expr).lineNo, "Incompatible type for operand 1 \"" + (((AST.mul)expr).e1).type + "\" & \"" + (((AST.mul)expr).e2).type + "\" for performing multiplication");    
                }
                visit_expr(((AST.mul)expr).e2);
                if ((((AST.mul)expr).e2).type.equals("Int") == false) {
                    ((AST.mul)expr).type = "Int";
                    reportError(filename, ((AST.mul)expr).lineNo, "Incompatible type for operand 2 \"" + (((AST.mul)expr).e1).type + "\" & \"" + (((AST.mul)expr).e2).type + "\" for performing multiplication");
                }
                ((AST.mul)expr).type = "Int";
                break;
            }
            //expr+expr
            case "plus":{
                visit_expr(((AST.plus)expr).e1);
                visit_expr(((AST.plus)expr).e2);
                if ((((AST.plus)expr).e1).type.equals("Int") == false){
                    ((AST.plus)expr).type = "Int";
                    reportError(filename, ((AST.plus)expr).lineNo, "Incompatible type for operand 1 \"" + (((AST.plus)expr).e1).type + "\" & \"" + (((AST.plus)expr).e2).type + "\" for performing addition");
                }
                if ((((AST.plus)expr).e2).type.equals("Int") == false) {
                    ((AST.plus)expr).type = "Int";
                    reportError(filename, ((AST.plus)expr).lineNo, "Incompatible type for operand 2 \"" + (((AST.plus)expr).e1).type + "\" & \"" + (((AST.plus)expr).e2).type + "\" for performing addition");
                }
                ((AST.plus)expr).type = "Int";
                break;
            }
            //expr-expr
            case "sub":{
                visit_expr(((AST.sub)expr).e1);
                if ((((AST.sub)expr).e1).type.equals("Int") == false){
                    reportError(filename, ((AST.sub)expr).lineNo, "Incompatible type for operand 1 \"" + (((AST.sub)expr).e1).type + "\" & \"" + (((AST.sub)expr).e2).type + "\" for performing subtraction");
                    ((AST.sub)expr).type = "Int";
                } 
                visit_expr(((AST.sub)expr).e2);
                if ((((AST.sub)expr).e2).type.equals("Int") == false) {
                    reportError(filename, ((AST.sub)expr).lineNo, "Incompatible type for operand 2 \"" + (((AST.sub)expr).e1).type + "\" & \"" + (((AST.sub)expr).e2).type + "\" for performing subtraction");
                    ((AST.sub)expr).type = "Int";
                }
                ((AST.sub)expr).type = "Int";
                break;
            }
            //while expr loop expr pool
            case "loop":{
                visit_expr(((AST.loop)expr).predicate);
                visit_expr(((AST.loop)expr).body);
                if ((((AST.loop)expr).predicate).type.equals("Bool") == true) {
                    ((AST.loop)expr).type = "Object";
                    break;
                }
                ((AST.loop)expr).type = "Object";
                reportError(filename, (((AST.loop)expr).predicate).lineNo, "Type encountered for loop conditional is \"" + (((AST.loop)expr).predicate).type + "\". Expected \"Bool\"");
                break;
            }
            //isvoid expr
            case "isvoid":{
                ((AST.isvoid)expr).type = "Bool";
                break;
            }
            //{expr;+}
            case "block":{
                for (AST.expression c_expr : ((AST.block)expr).l1) {
                    visit_expr(c_expr);
                }
                ((AST.block)expr).type = ((AST.block)expr).l1.get(((AST.block)expr).l1.size() - 1).type;
                break;
            }
            //ID
            case "object":{
                if (scope.lookUpGlobal(((AST.object)expr).name) != null) {
                    ((AST.object)expr).type = scope.lookUpGlobal(((AST.object)expr).name).typeid;
                    break;
                }
                reportError(filename, ((AST.object)expr).lineNo, "Identifier \"" + ((AST.object)expr).name + "\" being used without being declared in the current scope.");
                ((AST.object)expr).type = "Object";
                break;
            }
            //let ID:TYPE <- expr* in expr
            case "let":{
                visit_expr((AST.let)expr);
                break;
            }
            //case expr of (ID:TYPE => expr)+ esac
            case "typcase":{
                visit_expr((AST.typcase)expr);
                break;
            }
            //class.method
            case "dispatch":{
                visit_expr((AST.dispatch)expr);
                break;
            }
            //class@class.method
            case "static_dispatch":{
                visit_expr((AST.static_dispatch)expr);
                break;
            }
            //Null expr non assignable only for internal workings of the COOL compiler
            case "no_expr":{
                ((AST.no_expr)expr).type = "No_type";
                break;
            }
        }
        //If condition to test whether the expr was new_.
        if (expr.getClass() == AST.new_.class) {
            if (classList.containsKey(((AST.new_)expr).typeid) == false) {
                reportError(filename, ((AST.new_)expr).lineNo, "Class type \"" + ((AST.new_)expr).typeid + "\" being used without being defined");
                ((AST.new_)expr).type = "Object";
            } else {
                ((AST.new_)expr).type = ((AST.new_)expr).typeid;
            }
        }
    }

    // Let expressions
    private void visit_expr(AST.let l) {
        scope.enterScope();
        if (classList.containsKey(l.typeid) == false) { //Class for let body is undefined
            reportError(filename, l.lineNo, "Let has undefined class for In");
        }

        if (l.value.getClass()==AST.no_expr.class) {    //Trivial case. No body
            switch(l.typeid){
                case "String": {
                    l.value = new AST.string_const("", l.lineNo);
                    break;
                }
                case "Int": {
                    l.value = new AST.int_const(0, l.lineNo);
                    break;
                }
                case "Bool": {
                    l.value = new AST.bool_const(false, l.lineNo);
                    break;
                }
            }
        } else {
            visit_expr(l.value);
            if (conform(l.value.type, l.typeid) == false) {
                reportError(filename, l.lineNo, "Types \"" + l.value.type + "\" & \"" + l.typeid + "\" encountered do not conform. Refer to cool manusl for details.");
            }
        }

        scope.insert(l.name, new AST.attr(l.name, l.typeid, l.value, l.lineNo));
        visit_expr(l.body);                         //There is a body. Explore it.
        l.type = l.body.type;
        scope.exitScope();
    }
    //switch and dcase statements
    private void visit_expr(AST.typcase cases) {
        visit_expr(cases.predicate);
        for (AST.branch single_branch : cases.branches) {
            scope.enterScope();
            String in_type = new String("Object");
            if (classList.containsKey(single_branch.type) == true) {
                in_type = single_branch.type;
                scope.insert(single_branch.name, new AST.attr(single_branch.name, in_type, single_branch.value, single_branch.lineNo));
                visit_expr(single_branch.value);
                scope.exitScope();
                continue;
            }
            reportError(filename, single_branch.lineNo, "Class \"" + single_branch.type + "\" being used without being defined.");
            scope.insert(single_branch.name, new AST.attr(single_branch.name, in_type, single_branch.value, single_branch.lineNo));
            visit_expr(single_branch.value);
            scope.exitScope();            
        }
        //Find least common ancestor for type checking.
        String type = null;
        for (int i = 0; i < cases.branches.size(); i++) {
            for (int j = i + 1; j < cases.branches.size(); j++) {
                if (cases.branches.get(i).type.equals(cases.branches.get(j).type)) {
                    reportError(filename, cases.branches.get(j).lineNo, "Duplicate branch types \"" + cases.branches.get(i).type + "\"encountered in case expression.");
                }
            }
            cases.type = ((i!=0)?lca(type, cases.branches.get(i).value.type):cases.branches.get(i).value.type);
        }
    }
    //dispatch
    private void visit_expr(AST.dispatch disp) {
        visit_expr(disp.caller);
        for (int i = 0; i < disp.actuals.size(); i++) {
            visit_expr(disp.actuals.get(i));
        }
        if (classList.containsKey(disp.caller.type) == true) {  //Valid caller.
            if (classList.get(disp.caller.type).methods.containsKey(disp.name) == true) {
                disp.type = classList.get(disp.caller.type).methods.get(disp.name).typeid;  //Check no. of arguments
                if (classList.get(disp.caller.type).methods.get(disp.name).formals.size() == disp.actuals.size()) {
                    for (int i = 0; i < classList.get(disp.caller.type).methods.get(disp.name).formals.size(); i++) { //Check conformance
                        if (conform(disp.actuals.get(i).type, classList.get(disp.caller.type).methods.get(disp.name).formals.get(i).typeid) == false) {
                            reportError(filename, disp.lineNo,  "Argument no. \"" + i + 1 + "\" of type \"" + disp.actuals.get(i).type + "\" has no conformance \"" + classList.get(disp.caller.type).methods.get(disp.name).formals.get(i).typeid + "\" to dispatch of method \"" + disp.name + ".Refer to cool manual for details.");
                            disp.type = "Object";
                        }
                    }
                } else {
                    reportError(filename, disp.lineNo, "Method \"" + disp.name + " has " + disp.actuals.size() + " number of arguments; Expected no. was " + classList.get(disp.caller.type).methods.get(disp.name).formals.size());
                    disp.type = "Object";
                }
            } else {
                reportError(filename, disp.lineNo, "Method " + disp.name + " used without being defined.");
                disp.type = "Object";
            }
            return;
        }
        reportError(filename, disp.caller.lineNo, "Class \"" + disp.caller.type + "\" was not declared");
        disp.type = "Object";
    }
    //static dispatch
    private void visit_expr(AST.static_dispatch static_disp) {
        visit_expr(static_disp.caller);
        for (int i = 0; i < static_disp.actuals.size(); i++) {
            visit_expr(static_disp.actuals.get(i));
        }
        if (classList.containsKey(static_disp.typeid) == true) {    //Check whether the class being operated upon exists
            if (conform(static_disp.caller.type, static_disp.typeid) == false) {
                reportError(filename, static_disp.lineNo, "Types encountered \"" + static_disp.caller.type + "\", \"" + static_disp.typeid + "do not conform");
                static_disp.type = "Object";
            } else {
                if (classList.get(static_disp.caller.type).methods.containsKey(static_disp.name) == true) {
                    static_disp.type = classList.get(static_disp.caller.type).methods.get(static_disp.name).typeid;
                    if (classList.get(static_disp.caller.type).methods.get(static_disp.name).formals.size() == static_disp.actuals.size()) {
                        for (int i = 0; i < classList.get(static_disp.caller.type).methods.get(static_disp.name).formals.size(); i++) {
                            if (conform(static_disp.actuals.get(i).type, classList.get(static_disp.caller.type).methods.get(static_disp.name).formals.get(i).typeid) == false) {
                                reportError(filename, static_disp.lineNo,  "Argument no. \"" + i + 1 + "\" of type \"" + static_disp.actuals.get(i).type + "\" has no conformance \"" + classList.get(static_disp.caller.type).methods.get(static_disp.name).formals.get(i).typeid + "\" to dispatch of method \"" + static_disp.name + ".Refer to cool manual for details.");
                                static_disp.type = "Object";
                            }
                        }
                    } else {
                        reportError(filename, static_disp.lineNo, "Method \"" + static_disp.name + " has " + static_disp.actuals.size() + " number of arguments; Expected no. was " + classList.get(static_disp.caller.type).methods.get(static_disp.name).formals.size());
                        static_disp.type = "Object";
                    }
                } else {
                    reportError(filename, static_disp.lineNo, "Method " + static_disp.name + " used without being defined.");
                    static_disp.type = "Object";
                }
            }
            return;            
        }
        reportError(filename, static_disp.lineNo, "Class \"" + static_disp.typeid + "\" was not declared");  
        static_disp.type = "Object";
    }

    // Least common ancestor of two nodes in AST
    private String lca(String type_1, String type_2) {
        return (type_1.equals(type_2))?type_1:((classList.get(type_1).height)<(classList.get(type_2).height)?lca(type_2,type_1):lca(classList.get(type_1).parent, type_2));
    }
    //Check conformance
    private boolean conform(String inferred_type, String declared_type) {
        return (lca(inferred_type, declared_type).equals(declared_type)) && (classList.get(inferred_type).height >= classList.get(declared_type).height);
    }
}