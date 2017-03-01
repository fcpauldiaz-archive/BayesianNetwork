/*
 * Universidad del Valle de Guatemala
 * 01/03/2017
 * Simle grammar for bayesian expressions
 */

grammar BayesGrammar;


fragment LETTER : ('a'..'z'|'A'..'Z') ;

NEGATION: '!';
TOKEN:   LETTER  (',')?;

WS : 
    [\t\r\n\f ]+ -> skip
    ;

COMMENT
    :   ( '//' ~[\r\n]* '\r'? '\n'	
        | '/*' .*? '*/'	
        ) -> skip
    ;								

//PARSER
program
	: 'P' '(' op (condition  op)?  ')'
	;

condition: ('|'); 
negation: NEGATION;
operator: negation? TOKEN ;
op: operator* ;



