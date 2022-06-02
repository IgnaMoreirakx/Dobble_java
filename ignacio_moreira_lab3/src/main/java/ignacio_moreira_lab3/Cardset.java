/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;


public class Cardset {
    int E;
    ArrayList <Carta> cartas = new ArrayList<>();
    
    public Cardset(int E) {
        ArrayList <Carta> Cartas= new ArrayList<>();
        Carta primeracarta = new Carta();
        int i, j, k;
        for (i = 1; i<= E+1; i++) {
            primeracarta.getcarta().add(i);
        }
        Cartas.add(primeracarta);
        
        for (j=1; j<=E; j++) {
            Carta ncartas = new Carta();
            ncartas.getcarta().add(1);
    
            for (k=1; k<=E; k++) {
                ncartas.getcarta().add(E * j + (k+1));
            }
            Cartas.add(ncartas);
            ncartas.getcarta().clear();
        }
        for (i= 1; i<=E; i++) {
            for (j=1; j<=E; j++){
                Carta nncartas = new Carta();
                nncartas.getcarta().add(i+1);
        
                for (k=1; k<= E; k++) {
                    nncartas.getcarta().add(E+2+E*(k-1)+(((i-1)*(k-1)+j-1)%E));
                }
                Cartas.add(nncartas);
                nncartas.getcarta().clear();
            }
        }
    }
    
    public ArrayList<Carta> getcartas(){
        return this.cartas;
    }
    

     public String tostring(){
        ArrayList<String> cartas_string = new ArrayList<>();         //se crea arreglo vacio
        for(Integer i =0; i<this.cartas.size(); i++){
            cartas_string.add(this.cartas.get(i).toString());         //se  transforman los atributos en string y se agregan al carta_string
        }
        String cartaa = String.join("-", cartas_string);             // junta los string y despues los separa con un "-"
        return cartaa;
    } 
}
