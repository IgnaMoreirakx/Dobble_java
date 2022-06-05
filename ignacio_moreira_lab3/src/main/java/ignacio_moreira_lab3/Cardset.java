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
        //ArrayList <Carta> cartas= new ArrayList<>();
        Carta primeracarta = new Carta();
        int i, j, k;
        for (i = 1; i<= E+1; i++) {
            primeracarta.getcarta().add(i);
        }
        cartas.add(primeracarta);
        
        for (j=1; j<=E; j++) {
            Carta ncartas = new Carta();
            ncartas.getcarta().add(1);
    
            for (k=1; k<=E; k++) {
                ncartas.getcarta().add(E * j + (k+1));
            }
            cartas.add(ncartas);
            //ncartas.getcarta().clear();
        }
        for (i= 1; i<=E; i++) {
            for (j=1; j<=E; j++){
                Carta nncartas = new Carta();
                nncartas.getcarta().add(i+1);
        
                for (k=1; k<= E; k++) {
                    nncartas.getcarta().add(E+2+E*(k-1)+(((i-1)*(k-1)+j-1)%E));
                }
                cartas.add(nncartas);
                //nncartas.getcarta().clear();
            }
        }
    }
    
    public ArrayList<Carta> getcartas(){
        return this.cartas;
    }
    
    public Carta nthcard(Integer n){
        return this.cartas.get(n);
    }
    
    public Integer numcard(){
        return this.cartas.size();
    }
    
    public void borrar_carta(Carta n){
        this.cartas.remove(n);
    }
    
    public void missingcard(Cardset cs1){
        Carta c1 = cs1.nthcard(1);
        Integer largo = c1.largo() - 1;
        Cardset cs2 = new Cardset(largo);
        for(Integer i = 0; i < cs2.numcard(); i++){
            cs2.borrar_carta(cs1.nthcard(i));
        }
    }

     public String cardset_string(){
        ArrayList<String> carta_string = new ArrayList<>();
        for(Integer i =0; i<this.cartas.size(); i++){
            Carta carta1 = this.cartas.get(i);
            carta_string.add(carta1.cartatostring()); 
            }
        String cartaa = String.join(" / ", carta_string); 
        return cartaa;
    } 
}