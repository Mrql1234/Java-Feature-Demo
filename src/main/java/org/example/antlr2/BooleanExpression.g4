grammar BooleanExpression;

// 解析规则
program: expression EOF;

expression
    : '(' expression ')'                                 # parenExpr
    | '!' expression                                     # notExpr
    | expression ('*'|'/'|'%') expression               # mulDivModExpr
    | expression ('+'|'-') expression                   # addSubExpr
    | expression ('<'|'<='|'>'|'>='|'=='|'!=') expression # compareExpr
    | expression '&&' expression                         # andExpr
    | expression '||' expression                         # orExpr
    | expression IN setExpression                     # inExpr
    | functionCall                                      # funcCallExpr
    | ID                                                # idExpr
    | literal                                           # literalExpr
    ;

setExpression
    : '{' expression (',' expression)* '}'              # explicitSet
    | ID                                                # setVariable
    ;

functionCall
    : ID '(' (expression (',' expression)*)? ')'
    ;

literal
    : NUMBER                                            # numberLiteral
    | STRING                                            # stringLiteral
    | BOOLEAN                                           # booleanLiteral
    ;

// 词法规则
BOOLEAN: 'true' | 'false';
NUMBER: [0-9]+ ('.' [0-9]+)?;
STRING: '"' (~["\\] | '\\' .)* '"';

ID: [a-zA-Z_][a-zA-Z_0-9]*;

// 运算符
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';
NOT: '!';
AND: '&&';
OR: '||';
LT: '<';
LE: '<=';
GT: '>';
GE: '>=';
EQ: '==';
NE: '!=';
IN: 'in';

LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
COMMA: ',';

WS: [ \t\r\n]+ -> skip;