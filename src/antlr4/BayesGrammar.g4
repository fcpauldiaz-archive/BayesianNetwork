/*
 * Universidad del Valle de Guatemala
 * 01/03/2017
 * Simle grammar for bayesian expressions
 */

grammar BayesGrammar;


fragment LETTER : ('a'..'z'|'A'..'Z') ;
fragment DIGIT :'0'..'9' ;

NEGATION: '!';
TOKEN:   LETTER  (',')?;
NUM : DIGIT ('.'? DIGIT* )?
;
EQUALS: '=';

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
	: 'P' '(' op (condition  op)?  ')' EQUALS NUM
	;

condition: ('|'); 
negation: NEGATION;
operator: negation? TOKEN ;
op: operator* ;



