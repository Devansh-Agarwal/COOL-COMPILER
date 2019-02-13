parser grammar CoolParser;

options {
    tokenVocab = CoolLexer;
}

@header{
    import java.util.List;
}

@members{
    String filename;
    public void setFilename(String f){
        filename = f;
    }

/*
    DO NOT EDIT THE FILE ABOVE THIS LINE
    Add member functions, variables below.
*/

}

/*
    Add appropriate actions to grammar rules for building AST below.
*/

//Node returned is of type AST.program (it's also a public class)(basically a "node" of type "program")
//value is the node returned. cl is the token being parsed.

//program := class_list  (which is [[class;]]+)
program returns [AST.program value]
    : cl=class_list EOF{
        $value = new AST.program($(class_list).ast_class_list, $cl.ast_class_list.get(0).lineNo);
        //cl.value is the String list containing the names of the classes and the second parameter is the no. of classes.
    };


//Returns a list for above rule. Returns a list so in @init a list is created then value of the token is added.
//cl is the token being parsed.

//class_list := [[class]]+
class_list returns [List<AST.class_> ast_class_list] 
    @init { $ast_class_list = new ArrayList<>(); }      //Create a new empty list.
    : (cl=class_ SEMICOLON{ $ast_class_list.add($cl.ast_class);})*;
    //Since the regular expression is followed by a *, it will keep matching and populating the list.
    //cl is being assigned the token matching with thge regular expression, which is then added to list?

//Returns a single class.

//class := class TYPE [inherits TYPE] { [[feature_list]] } (feature_list:= [[feature;]]*)
class_ returns [AST.class_ ast_class]
    : CLASS type = TYPEID LBRACE t_feat_list = feature_list RBRACE {
        $ast_class = new AST.class_($type.getText(), filename, "Object", $t_feat_list.ast_feat_list, $type.getLine());
    }
    | CLASS type = TYPEID INHERITS in_type = TYPEID LBRACE t_feat_list = feature_list RBRACE {
        $ast_class = new AST.class_($type.getText(), filename, $in_type.getText(), $t_feat_list.ast_feat_list, $type.getLine());
    };

//(feature_list := [[feature;]]*)
feature_list returns [List<AST.feature> ast_feat_list]
    @init { $ast_feat_list = new ArrayList<>(); }
    : (feat=feature SEMICOLON{ $ast_feat_list.add($feat.value); })*;

//feature ::= ID([formal [[,formal]]∗ ]) : TYPE { expr }  (Function and variable declaration)
feature returns [AST.feature value]
    //ID : TYPE () : (expr)
    : obj =  OBJECTID LPAREN RPAREN COLON type = TYPEID LBRACE e = expr RBRACE{
        $value = new AST.method($obj.getText(),new ArrayList<AST.formal>(), $type.getText(), $e.value, $obj.getLine());
    }//Add formal list
    | obj =  OBJECTID LPAREN f_list = form_list RPAREN COLON type = TYPEID LBRACE e = expr RBRACE{
        $value = new AST.method($obj.getText(),$f_list.value, $type.getText(), $e.value, $obj.getLine());
    } //Without list and expression but no ()
    | obj = OBJECTID COLON type = TYPEID {
        $value = new AST.attr($obj.getText(), $type.getText(), new AST.no_expr($obj.getLine()), $obj.getLine());
    }//With expression but no ()
    | obj = OBJECTID COLON type = TYPEID ASSIGN e = expr {
        $value = new AST.attr($obj.getText(), $type.getText(), $e.value, $obj.getLine());
    };

//form_list := formal*
form_list returns [List<AST.formal> value]
    @init{ $value = new ArrayList<>(); }
    : form = formal { $value.add($form.value); }(COMMA form_extra=formal { $value.add($form_extra.value); })*;

//formal := ID : TYPE  (Parameters)
formal returns [AST.formal value] 
    : obj=OBJECTID COLON type=TYPEID {
        $value = new AST.formal($obj.getText(), $type.getText(), $obj.getLine());
    };

//case_list := case_single+    (ID : TYPE => expr;)+
case_list returns [List<AST.branch> value]
    @init{ $value = new ArrayList<>(); }
    : (c = case_single {$value.add($c.value); })+;

//case_single := ID : TYPE => expr;
case_single returns [AST.branch value]
    : obj = OBJECTID COLON type = TYPEID DARROW e = expr SEMICOLON {
        $value = new AST.branch($obj.getText(), $type.getText(), $e.value, $obj.getLine());
    };

//expr_block := (expr;)+ 
expr_block returns [List<AST.expression> value]
    @init{ $value = new ArrayList<>(); }
    : (e = expr SEMICOLON {$value.add($e.value);})+;

//expr_comma_expr := (expr (,expr)* )
expr_comma_expr returns [List<AST.expression> value]
    @init{ $value = new ArrayList<>(); }
    : ( e1st = expr {$value.add($e1st.value);}
        (COMMA e2nd = expr {$value.add($e2nd.value);})*)?;

//let_base := let_stmt (,let_stmt)*     ( ID : TYPE [ <- expr ] [[, ID : TYPE [ <- expr ]]] )
let_base returns [ArrayList<AST.attr> value]
    @init { $value = new ArrayList<AST.attr>(); }
    :   let1st = let_stmt { $value.add($let1st.value); }
        (COMMA letExtra = let_stmt{ $value.add($letExtra.value); })*;

//let_stmt := ID : TYPE (<-expr)?
let_stmt returns [AST.attr value]
    //ID : TYPE
    : obj = OBJECTID COLON type = TYPEID { 
        $value = new AST.attr($obj.getText(), $type.getText(), new AST.no_expr($obj.getLine()), $obj.getLine());
    }// ID : TYPE (<-expr)
    | obj = OBJECTID COLON type = TYPEID ASSIGN e = expr { 
        $value = new AST.attr($obj.getText(), $type.getText(), $e.value, $obj.getLine());
    };

//All expressions are handled here (Leaves in AST)
expr returns [AST.expression value]
    : e = expr DOT obj = OBJECTID LPAREN e_opt = expr_comma_expr RPAREN {
        $value = new AST.dispatch($e.value, $obj.getText(), $e_opt.value, $e.value.lineNo);
    }
    | e = expr ATSYM type = TYPEID DOT obj = OBJECTID LPAREN e_opt = expr_comma_expr RPAREN {
        $value = new AST.static_dispatch($e.value, $type.getText(), $obj.getText(), $e_opt.value, $e.value.lineNo);
    }
    | obj = OBJECTID LPAREN e_opt = expr_comma_expr RPAREN {
        $value = new AST.dispatch(new AST.object("self", $obj.getLine()), $obj.getText(), $e_opt.value, $obj.getLine());
    }
    | i = IF e_if = expr THEN e_then = expr ELSE e_else = expr FI{
         $value = new AST.cond($e_if.value, $e_then.value, $e_else.value, $i.getLine());
    }
    | w = WHILE e_cond = expr LOOP e_loop = expr POOL{
        $value = new AST.loop ($e_cond.value, $e_loop.value, $w.getLine());
    }
    | l = LBRACE eb = expr_block RBRACE{
        $value = new AST.block($eb.value,$l.getLine());
    }
    | l = LET lb = let_base IN e = expr{
        $value = $e.value;
        AST.attr thia;
        for(int i = $lb.value.size() - 1; i>=0; --i){
            thia = $lb.value.get(i);
            $value = new AST.let(thia.name, thia.typeid, thia.value, $value, $l.getLine());
        }
    }
    | c_line = CASE e = expr OF c = case_list ESAC{
        $value = new AST.typcase($e.value, $c.value, $c_line.getLine());
    }
    | n = NEW type = TYPEID{
        $value = new AST.new_($type.getText(), $n.getLine());
    }
    | t = TILDE e = expr{
        $value = new AST.comp($e.value, $t.getLine());
    }
    | i = ISVOID e = expr{
        $value = new AST.isvoid($e.value, $i.getLine());
    }
    | e_l = expr STAR e_r = expr{
        $value = new AST.mul($e_l.value, $e_r.value, $e_l.value.lineNo);
    }
    | e_l = expr SLASH e_r = expr{
        $value = new AST.divide($e_l.value, $e_r.value, $e_l.value.lineNo);
    }
    | e_l = expr PLUS e_r = expr{
        $value = new AST.plus($e_l.value, $e_r.value, $e_l.value.lineNo);
    }
    | e_l = expr MINUS e_r = expr{
        $value = new AST.sub($e_l.value, $e_r.value, $e_l.value.lineNo);
    }
    | e_l = expr LT e_r = expr{
        $value = new AST.lt($e_l.value, $e_r.value, $e_l.value.lineNo);
    }
    | e_l = expr LE e_r = expr{
        $value = new AST.leq($e_l.value, $e_r.value, $e_l.value.lineNo);
    }
    | e_l = expr EQUALS e_r = expr{
        $value = new AST.eq($e_l.value, $e_r.value, $e_l.value.lineNo);
    }
    | n = NOT e = expr{
        $value = new AST.neg($e.value, $n.getLine());
    }
    | <assoc=right>obj = OBJECTID ASSIGN e = expr{
        $value = new AST.assign($obj.getText(), $e.value, $obj.getLine());
    }
    | LPAREN e = expr RPAREN{
        $value = $e.value;
    }
    | obj = OBJECTID{
        $value = new AST.object($obj.getText(), $obj.getLine());
    }
    | i = INT_CONST{
        $value = new AST.int_const(Integer.parseInt($i.getText()), $i.getLine());
    }
    | str = STR_CONST{
        $value = new AST.string_const($str.getText(), $str.getLine());
    }
    | b = BOOL_CONST{
        $value = new AST.bool_const($b.getText().charAt(0)=='t', $b.getLine());
    }
    ;