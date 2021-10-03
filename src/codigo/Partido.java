/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

/**
 *
 * @author Asus VivoBook
 */
public class Partido {
    private int outs;
    private boolean[] bases;
    private int entrada;
    private int[] marcador;
    private int equipoBateando;
    
    public Partido(){
        outs = 0;
        bases = new boolean[3];
        entrada = 1;
        marcador = new int[2];
        equipoBateando = 0;
    }
    
    public void AvanzaBase(int avance, int base){
        if(base < bases.length){
            if(bases[base]){
                AvanzaRecursivo(base+1);
            }
            --avance;
            if(avance != 0){
                bases[base] = false;
                AvanzaBase(avance, base+1);
            }
            else{
                bases[base] = true;
            }
        }
        else{
            ++marcador[equipoBateando];
        }
    }
    
    private void AvanzaRecursivo(int base){
        if(base < bases.length){
            if(bases[base]){
                AvanzaRecursivo(base+1);
            }
            else{
                bases[base] = true;
            }
        }
        else{
           ++marcador[equipoBateando];
        }
    }
    
    public void Out(int cantidadOuts){
        for(int i = 0; i < cantidadOuts; ++i)
            ++outs;
        if(outs >= 3){
           outs = 0;
           if(equipoBateando == 1)
               ++entrada;
           equipoBateando = (equipoBateando+1)%2;
           for(int i = 0; i < bases.length; ++i)
               bases[i] = false;
        }
    }
    
    public void Sacrificio(){
        for(int i = bases.length; i > 0; --i){
            System.out.print(i-1);
            System.out.print("\n");
            if(bases[i-1]){
                AvanzaBase(1, i-1);
                bases[i-1] = false;
            }
        }
        AvanzaBase(1,0);
        Out(1);
    }
    
    public String toString(){
        return  "Entrada: " + String.valueOf(entrada) + "\n\nMarcador\nEquipo 1: " 
                + String.valueOf(marcador[0])
                + "\nEquipo 2: " +  String.valueOf(marcador[1])
                + "\n\nBase 1: " + String.valueOf(bases[0]) + "\nBase 2: " + 
                String.valueOf(bases[1]) + "\nBase 3: " + String.valueOf(bases[2])
                + "\nOuts: " + String.valueOf(outs) + "\nEquipo bateando: " +
                String.valueOf(equipoBateando+1) + "\n--------------------\n";
    }
}
