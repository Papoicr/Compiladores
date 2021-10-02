package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[1-9]
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
int |
if |
else |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

{D}{2} {lexeme=yytext(); return BolaDetenida;}
"K" {lexeme=yytext(); return Ponchada;}
"L"{D} {lexeme=yytext(); return OutAtrapada;}
"DP" {lexeme=yytext(); return JugadaDoble;}
"FC" {lexeme=yytext(); return OutBateadorPrimera;}
"E"{D} {lexeme=yytext(); return BateadorPrimeraPorError;}
"HP" {lexeme=yytext(); return GolpeadoPorBola;}
"BB" {lexeme=yytext(); return BasePorBola;}
"W" {lexeme=yytext(); return BasePorBola;}
"SAC" {lexeme=yytext(); return Sacrificio;}
"1B" {lexeme=yytext(); return Hit;}
"2B" {lexeme=yytext(); return Doble;}
"3B" {lexeme=yytext(); return Triple;}
"4B" {lexeme=yytext(); return Cuadrangular;}
"HR" {lexeme=yytext(); return Homerun;}
 . {return ERROR;}
