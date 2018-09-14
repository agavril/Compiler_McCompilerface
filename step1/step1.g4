grammar step1;
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