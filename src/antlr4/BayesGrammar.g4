/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar BayesGrammar;


fragment LETTER : ('a'..'z'|'A'..'Z') ;

TOKEN: '!' LETTER ('!' LETTER)*;

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
	: '(' TOKEN '|' TOKEN* ')'
	;