/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;

public class Cardset {
    int E;
    ArrayList<String> simbolos;
    ArrayList <Carta> cartas = new ArrayList<>();
    
    public Cardset(int E, int C, ArrayList<String> simbolos) {
        ArrayList<Integer> c1aux = new ArrayList<>();
        Carta primeracarta = new Carta();
        int i, j, k;
        for (i = 1; i<= E+1; i++) {
            String aux = simbolos.get(i);
            primeracarta.getcarta().add(aux);

        }
        cartas.add(primeracarta);

        
        for (j=1; j<=E; j++) {
            Carta ncartas = new Carta();
            ncartas.getcarta().add(simbolos.get(1));
    
            for (k=1; k<=E; k++) {
                String aux2 = simbolos.get(E * j + (k+1));
                ncartas.getcarta().add(aux2);
            }
            cartas.add(ncartas);

            //ncartas.getcarta().clear();
        }
        for (i= 1; i<=E; i++) {
            for (j=1; j<=E; j++){
                Carta nncartas = new Carta();
                nncartas.getcarta().add(simbolos.get(i+1));
                for (k=1; k<= E; k++) {
                    nncartas.getcarta().add(simbolos.get(E+2+E*(k-1)+(((i-1)*(k-1)+j-1)%E)));
                }
                cartas.add(nncartas);

                //nncartas.getcarta().clear();
            }
        }
        ArrayList<Carta> cartas_finales= new ArrayList<>();
        for (i= 0; i<C; i++){
            cartas_finales.add(cartas.get(i));
        }
        cartas = cartas_finales;
       
           
    }
    
    public ArrayList<Carta> getcartas(){
        return this.cartas;
    }
    public ArrayList<String> getsimbolos(){
        return this.simbolos;
    }
    
    /*
    public ArrayList<Carta> transformar_cartas(ArrayList<String> simbolos){
        ArrayList aux = new ArrayList<>();
        for(Integer i =0; i< cartas.size(); i++){
            aux.add(cartas.get(i).transformar(simbolos));
        }
        return aux;
    }
    */
    
    public Carta nthcard(Integer n){
        return this.cartas.get(n);
    }
    
    public Integer numcard(){
        return this.cartas.size();
    }
    
    public void borrar_carta(Carta n){
        this.cartas.remove(n);
    }
    
    /*
    public void missingcard(Cardset cs1){
        Carta c1 = cs1.nthcard(1);
        Integer largo = c1.largo() - 1;
        Cardset cs2 = new Cardset(largo, (largo-1 + largo-1 +largo-1 +1));
        for(Integer i = 0; i < cs2.numcard(); i++){
            cs2.borrar_carta(cs1.nthcard(i));
        }
    }
*/
    
     public String cardset_string(){
        ArrayList<String> carta_string = new ArrayList<>();
        for(Integer i =0; i<this.cartas.size(); i++){
            Carta carta1 = this.cartas.get(i);
            carta_string.add(carta1.cartatostring()); 
            }
        String cartaa = String.join(" / ", carta_string); 
        return cartaa;
    }
     
     public Boolean equals(Cardset cs1){
         for(Integer i = 0; i<cartas.size();i++){
             if(cartas.get(i).equals(cs1.getcartas().get(i)));
             else{
                 return false;
             }
         }
         Boolean resultado = simbolos.equals(cs1.getsimbolos()) & cartas.size() == cs1.getcartas().size();
        return resultado; 
     }
}