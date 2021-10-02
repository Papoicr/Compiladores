/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import static codigo.Principal.generarLexer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus VivoBook
 */
public class Main {
    public static void main(String[] args) {
        try {
            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
            Scanner myReader = new Scanner(lector);
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            System.out.print("Debug1");
            while(true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    resultado += "FIN";
                    break;
                }
                switch (tokens) {
                    case ERROR:
                        resultado += "Simbolo no definido";
                        break;
                    case BolaDetenida:
                        resultado+= lexer.lexeme+": Bola Detenida por "
                                +lexer.lexeme.charAt(0)+", out producido por "
                                +lexer.lexeme.charAt(1);
                        break;
                    case Ponchada:
                        resultado+=lexer.lexeme+": Ponchada (1 out)";
                        break;
                    case OutAtrapada:
                        resultado+=lexer.lexeme+": Out por atrapada de "
                                +lexer.lexeme.charAt(1);
                        break;
                    case JugadaDoble:
                        resultado+=lexer.lexeme+": Jugada Doble ";
                        break;
                    case OutBateadorPrimera:
                        resultado+=lexer.lexeme+": Out pero bateador avanza a "
                                + "primera ";
                        break;
                    case BateadorPrimeraPorError:
                        resultado+=lexer.lexeme+": Bateador llega a primera por "
                                + "un error de " +lexer.lexeme.charAt(1);           
                        break;
                    case GolpeadoPorBola:
                        resultado+=lexer.lexeme+": Bateador golpeado por bola, "
                                + "avanza a primera ";
                        break;
                    case BasePorBola:
                        resultado+=lexer.lexeme+": Base por bolas ";
                        break;
                    case Sacrificio:
                        resultado+=lexer.lexeme+": Sacrificio, 1 out, los "
                                + "corredores avanzan una base ";
                        break;
                    case Hit:
                        resultado+=lexer.lexeme+": Bateador avanza a primera"
                                + " base (hit)";
                        break;
                    case Doble:
                        resultado+=lexer.lexeme+": Bateador avanza a segunda "
                                + "base (doble)";
                        break;
                    case Triple:
                        resultado+=lexer.lexeme+": Bateador avanza a tercera "
                                + "base (triple) ";
                        break;
                    case Cuadrangular:
                        resultado+=lexer.lexeme+": Cuadrangular (todos los "
                                + "corredores anotan)";
                        break;
                    case Homerun:
                        resultado+=lexer.lexeme+": Homerun";
                        break;
                    default:
                        resultado += "Token: " + tokens;
                        break;
                }
                resultado+="\n";
            }
            System.out.print(resultado);
        } catch (FileNotFoundException ex) {
            System.out.print("Error\n");
        } catch (IOException ex) {
            System.out.print("Error\n");
        }
    }
}
