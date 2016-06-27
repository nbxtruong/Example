/**
 * Define a grammar called Exp
 */
 grammar Exp;

 @lexer::header {
	package exp.parser;
}

 @lexer::members {
@Override
public Token emit() {
    switch (getType()) {
    case ERROR_CHAR:
    	Token result = super.emit();
    	throw new ErrorToken(result.getText());	
    default:
        return super.emit();
    }
}
}

 @parser::header {
	package exp.parser;
}

 exps
 :
 	(
 		stm NL
 	)+
 ;

 stm
 :
 	'if' exp 'then' stm 'else' stm
 	| ID '=' exp ';'
 ;

 exp
 :
 	exp ADDOP exp1
 	| exp1
 ;

 exp1
 :
 	exp1 MULOP factor
 	| factor
 ;

 factor
 :
 	ID
 	| INT
 	| LP exp RP
 	| FLOAT
 ;

 INT
 :
 	[0-9]+
 ;

 FLOAT
 :
 	INT+ '.' INT*
 ;

 NL
 :
 	'\n'
 ;

 LP //left parenthesis

 :
 	'('
 ;

 RP //right parenthesis

 :
 	')'
 ;

 ADDOP
 :
 	(
 		'+'
 		| '-'
 	)
 ;

 MULOP
 :
 	'*'
 ;

 WS // Skip spaces, tabs, newlines, form feed	

 :
 	[\t\r ]+ -> skip
 ;

 ID
 :
 	[a-z]+
 ;

 ERROR_CHAR // Otherwise, thow error 

 :
 	.
 ;