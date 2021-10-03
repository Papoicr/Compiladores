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
            Partido partido = new Partido();
            String resultado = "";
            while(true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    resultado += "\nFIN\n";
                    break;
                }
                switch (tokens) {
                    case ERROR:
                        resultado += "Simbolo no definido";
                        break;
                    case BolaDetenida:
                        partido.Out(1);
                        System.out.print(partido.toString());
                        break;
                    case Ponchada:
                        partido.Out(1);
                        System.out.print(partido.toString());
                        break;
                    case OutAtrapada:
                        partido.Out(1);
                        System.out.print(partido.toString());
                        break;
                    case JugadaDoble:
                        partido.Out(2);
                        System.out.print(partido.toString());
                        break;
                    case OutBateadorPrimera:
                        partido.Out(1);
                        partido.AvanzaBase(1, 0);
                        System.out.print(partido.toString());
                        break;
                    case BateadorPrimeraPorError:
                        partido.AvanzaBase(1,0);  
                        System.out.print(partido.toString());
                        break;
                    case GolpeadoPorBola:
                        partido.AvanzaBase(1,0);
                        System.out.print(partido.toString());
                        break;
                    case BasePorBola:
                        partido.AvanzaBase(1,0);
                        System.out.print(partido.toString());
                        break;
                    case Sacrificio:
                        partido.Sacrificio();
                        System.out.print(partido.toString());
                        break;
                    case Homerun:
                        partido.AvanzaBase(4, 0);
                        System.out.print(partido.toString());
                        break;
                    case Avanza:
                        partido.AvanzaBase(Character.getNumericValue(lexer.lexeme.charAt(0)), 0);
                        System.out.print(partido.toString());
                    break;
                    default:
                        resultado += "Token: " + tokens;
                        break;
                }
            }
            System.out.print(resultado);
        } catch (FileNotFoundException ex) {
            System.out.print("Error\n");
        } catch (IOException ex) {
            System.out.print("Error\n");
        }
    }
}
