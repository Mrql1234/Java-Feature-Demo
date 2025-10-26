
grammar Calculator;

// 语法规则
expression
    : expression op=('*'|'/') expression # MulDiv
    | expression op=('+'|'-') expression # AddSub
    | '(' expression ')'                # Parentheses
    | NUMBER                            # Number
    ;

// 词法规则
NUMBER: [0-9]+('.'[0-9]+)?;
WS: [ \t\r\n]+ -> skip;
