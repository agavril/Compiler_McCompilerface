grammar Micro;

// Program 
@members {
	public Tree tree = new Tree();
	public int level = 0;
	public ACList ac = new ACList();
	public AbstractSyntaxTree ast;
	public int ASTregs = 0;
}
program           : 'PROGRAM' id 'BEGIN' pgm_body 'END' {tree.print();}; 
id                : IDENTIFIER;
pgm_body          : decl func_declarations;
decl		        : string_decl decl | var_decl decl | ;


// Global String Declaration
string_decl       : 'STRING' id ':=' str ';'{
	Symbol newSymbol = new Symbol($id.text, "STRING", $str.text);
	tree.scope.add(newSymbol);
};
str               : STRINGLITERAL;

// Variable Declaration
var_decl          : var_type id_list ';'{
	String[] strings = $id_list.text.split(",");
	for (String id : strings){
		Symbol newSymbol = new Symbol(id, $var_type.text, "0");
		ac.addLast(new ACNode("var", null, null, id));
		tree.scope.add(newSymbol);
	}
};
var_type	        : 'FLOAT' | 'INT';
any_type          : var_type | 'VOID';
id_list           : id id_tail;
id_tail           : ',' id id_tail | ;

// Function Parameter List
param_decl_list   : param_decl param_decl_tail | ;
param_decl        : var_type id{
	Symbol newSymbol = new Symbol($id.text, $var_type.text, "0");
	tree.scope.add(newSymbol);
};
param_decl_tail   : ',' param_decl param_decl_tail | ;

// Function Declarations
func_declarations : func_decl func_declarations | ;
func_decl	  : 'FUNCTION' any_type id
{tree.down($id.text, 0);}
'(' param_decl_list ')' 'BEGIN' func_body 'END'
{tree.up();};
func_body	  : decl stmt_list;

// Statement List
stmt_list	  : stmt stmt_list | ;
stmt   	 	  : base_stmt | if_stmt | loop_stmt;
base_stmt 	  : assign_stmt | read_stmt | write_stmt | control_stmt;

// Basic Statements
assign_stmt       : assign_expr ';';
assign_expr       : id {
  ast = new AbstractSyntaxTree(tree.scope.find($id.text), ASTregs, tree.scope);}
  ':=' expr {
  ast.expr_end();
  ac.addAll(ast.ac);
  ASTregs = ast.tmp_cnt; // add AST & set new ASTregs
};
read_stmt         : 'READ' '(' id_list ')' ';'{
  String[] idlist = $id_list.text.split(",");
  String op = null;
  for (String id : idlist) {
    Symbol sym = tree.scope.find(id);
    if (sym.type.equals("INT")) {
      op = "READI";
    }
    else if (sym.type.equals("FLOAT")) {
      op = "READF";
    }
    ACNode acnode = new ACNode(op, null, null, id);
    ac.addLast(acnode);
  }
};
write_stmt        : 'WRITE' '(' id_list ')' ';'{
  String[] idlist = $id_list.text.split(",");
  String op = null;
  for (String id : idlist) {
    Symbol sym = tree.scope.find(id);
    if (sym.type.equals("INT")) {
      op = "WRITEI";
    }
    else if (sym.type.equals("FLOAT")) {
      op = "WRITEF";
    }
    else if (sym.type.equals("STRING")) {
      op = "WRITES";
    }
    ACNode acnode = new ACNode(op, null, null, id);
    ac.addLast(acnode);
  }
};
return_stmt       : 'RETURN' expr ';';

// Expressions
expr              : expr_prefix factor;
expr_prefix       : expr_prefix factor addop | ;
factor            : factor_prefix postfix_expr;
factor_prefix     : factor_prefix postfix_expr mulop | ;
postfix_expr      : primary | call_expr;
call_expr         : id '(' expr_list ')';
expr_list         : expr expr_list_tail | ;
expr_list_tail    : ',' expr expr_list_tail | ;
primary           : '('          {ast.par_start();}
	            expr ')'     {ast.par_end();}|
	            id           {ast.addOperand($id.text);}|
		    INTLITERAL   {ast.addOperand($INTLITERAL.text);}|
		    FLOATLITERAL {ast.addOperand($FLOATLITERAL.text);};

addop             : '+' {ast.addOperator("+");} | '-' {ast.addOperator("-");};
mulop             : '*' {ast.addOperator("*");} | '/' {ast.addOperator("/");};

// Complex Statements and Condition
if_stmt           : 'IF'
{tree.down("BLOCK", ++level);} 
'(' cond ')' decl stmt_list else_part 'ENDIF'
{tree.up();};
else_part         : 'ELSE' 
{tree.down("BLOCK", ++level);} 
decl stmt_list
{tree.up();} | ;
cond              : expr compop expr | 'TRUE' | 'FALSE';
compop            : '<' | '>' | '=' | '!=' | '<=' | '>=';
while_stmt        : 'WHILE' 
{tree.down("BLOCK", ++level);} 
'(' cond ')' decl stmt_list 'ENDWHILE'
{tree.up();};


// ECE468 ONLY
control_stmt      : return_stmt;
loop_stmt         : while_stmt;

// lexer

keyword : KEYWORD;

INTLITERAL : [0-9]+;
FLOATLITERAL : [0-9]*'.'[0-9]+;
STRINGLITERAL : '"'~('"')+'"';
COMMENT : '--'~('\n')+ -> skip;

WS :	('\t' 
		| '\n' 
		| '\r' 
		| ' ')+ -> skip;
	
OPERATOR : 	':=' 
			| '+' 
			| '-' 
			| '*' 
			| '/' 
			| '=' 
			| '!=' 
			| '<'
			| '>'
			| '('
			| ')'
			| ';'
			| ','
			| '<='
			| '>=';
			
KEYWORD : 	'PROGRAM'
			| 'BEGIN'
			| 'END'
			| 'FUNCTION'
			| 'READ'
			| 'WRITE'
			| 'IF'
			| 'ELSE'
			| 'ENDIF'
			| 'WHILE'
			| 'ENDWHILE'
			| 'RETURN'
			| 'INT'
			| 'VOID'
			| 'STRING'
			| 'FLOAT'
			| 'TRUE'
			| 'FALSE'
			| 'FOR'
			| 'ENDFOR'
			| 'CONTINUE'
			| 'BREAK';
			
IDENTIFIER : [a-zA-Z]([a-zA-Z]|[0-9])*;

