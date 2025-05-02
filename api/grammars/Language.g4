grammar Language;

program: dcl*;

dcl: varDcl |funcDcl  |stmt;

varDcl: 'var' ID type '=' expr ';'?   
      | 'var' ID type  ';'?             
      | ID ':=' expr ';'?
      | ID  type ';'?;
      

funcDcl: 'func' ID '(' params? ')' type? '{' dcl* '}' ';'? ;



params: param (',' param)*;

param: ID type;

stmt:
    expr                                               # ExprStmt
    | '{' dcl* '}'                                     # BlockStmt
    | 'if'  expr  stmt ('else' stmt)?                  # IfStmt
    | 'switch' expr '{' cases*  defaultSwitch? '}'     # SwitchStmt
    | 'for'  forInit expr ';' expr  stmt               # ForStmt
    | 'for'  expr  stmt                                # ForCondStmt
    | 'for' ID ',' ID ':=' 'range' expr stmt           # ForRange
    | 'break'  ';'?                                         # BreakStmt
    | 'continue'  ';'?                                      # ContinueStmt
    | 'fmt.Println(' expr (',' expr)* ')' ';'?                    # Print
    | 'slice.Index' '(' expr ',' expr ')'	# SliceIndex
    | ID '[' expr ']' '=' expr ';'?			# SliceAsign
    | 'return' expr? ';'?                                   # ReturnStmt; 

cases: 'case' expr ':' stmt*; 
defaultSwitch: 'default' ':' stmt*;

forInit: varDcl ';' | expr ';';

expr:
    '-' expr                                    # Negate
    | expr call+                                # Callee
    | expr op = ('*' | '/' | '%') expr          # MulDivMod
    | expr op = ('+' | '-') expr                # AddSub
    | expr op = ('>' | '<' | '>=' | '<=') expr  # Relational
    | expr op = ('==' | '!=') expr              # Equality
    | expr op = ('&&' | '||' ) expr             # Logical
    | '!' expr                                  # Not
    | ID op = ('+=' | '-=') expr                # IncDecAssign
    | expr '=' expr ';'?                              # Assign
    | sliceDcl									# SliceDeclStmt
    | ID '[' expr ']' 							# AccesoSlice 
    | 'strconv.Atoi' '(' expr ')'              # AtoiCall
    | 'strconv.ParseFloat' '(' expr ')'              # ParseFloatCall
    | ID '++'                                   # Increment
    | ID '--'                                   # Decrement
    | BOOL                                      # Boolean
    | FLOAT                                     # Float
    | STRING                                    # String
    | INT                                       # Int
    | ID                                        # Identifier
    | Nil                                       # Nill
    | RUNE                                      # Rune
    | '(' expr ')'                              # Parens;


sliceDcl: ID ':=' '[' ']' type '{' expr (',' expr)* '}' ';'?;

call: '(' args? ')' #FuncCall | '.' ID #Get;

args: expr (',' expr)*;

props: ( ID ':' expr ',' ( ID ':' expr ',' )*); 


type: 'int' | 'float64' | 'string' | 'bool' | 'rune';

INT: [0-9]+;
BOOL: 'true' | 'false';
FLOAT: [0-9]+ '.' [0-9]+;
STRING: '"' ('\\"' | ~'"')* '"';
RUNE: '\'' ~["'\r\n] '\'';
Nil: 'nil';
ID: [a-zA-Z_][a-zA-Z0-9_]*;


// COMENTARIOS 
WS: [ \t\r\n]+ -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip; 
BLOCK_COMMENT: '/*' .*? '*/' -> skip;
