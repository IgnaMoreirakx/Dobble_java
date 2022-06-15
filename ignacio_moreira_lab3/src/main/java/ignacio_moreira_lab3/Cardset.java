/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;
import java.util.Collections;

public class Cardset implements ICardset  {
    private int E;
    public ArrayList<String> simbolos;
    private ArrayList <Carta> cartas = new ArrayList<>();
    public Cardset(int E, int C, ArrayList<String> simbolos) {
        this.E = E;
        Integer n = E-1;
        this.simbolos = simbolos;
        ArrayList<Integer> c1aux = new ArrayList<>();
        Carta primeracarta = new Carta();
        int i, j, k;
        for (i = 1; i<= n+1; i++) {
            String aux = simbolos.get(i);
            primeracarta.getcarta().add(aux);

        }
        cartas.add(primeracarta);

        
        for (j=1; j<=n; j++) {
            Carta ncartas = new Carta();
            ncartas.getcarta().add(simbolos.get(1));
    
            for (k=1; k<=n; k++) {
                String aux2 = simbolos.get(n * j + (k+1));
                ncartas.getcarta().add(aux2);
            }
            cartas.add(ncartas);

            //ncartas.getcarta().clear();
        }
        for (i= 1; i<=n; i++) {
            for (j=1; j<=n; j++){
                Carta nncartas = new Carta();
                nncartas.getcarta().add(simbolos.get(i+1));
                for (k=1; k<= n; k++) {
                    nncartas.getcarta().add(simbolos.get(n+2+n*(k-1)+(((i-1)*(k-1)+j-1)%n)));
                }
                cartas.add(nncartas);

                //nncartas.getcarta().clear();
            }
        }
        ArrayList<Carta> cartas_finales_aux = new ArrayList<>();
        cartas_finales_aux = cartas;
        ArrayList<Carta> cartas_finales= new ArrayList<>();
        for (i= 0; i<C; i++){
            cartas_finales.add(cartas.get(i));
        }
        cartas = cartas_finales;
        Collections.shuffle(cartas);
           
    }
    
    public ArrayList<Carta> getcartas(){
        return this.cartas;
    }
    
    public ArrayList<String> getsimbolos(){
        return this.simbolos;
    }
    
    public Carta nthcard(Integer n){
        return this.cartas.get(n);
    }
    
    public Integer numcard(){
        return this.cartas.size();
    }
    
    protected void borrar_carta(Carta n){
        this.cartas.remove(n);
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
     
     
     public boolean isdobble(){
         Integer n = E-1;
       ArrayList<String> aux = new ArrayList<>();
         for(Integer i = 0; i < cartas.size(); i++){
             for(Integer j = i +1; j < cartas.size(); j++){
                 aux = cartas.get(i).encomun(cartas.get(j));
                 if(aux.size() > 1){
                     return true;
                 }
                 else{
                     aux.clear();
                 }
             }
         }
         boolean serepite = !(aux.isEmpty());
         if(n ==2) return true;
        if (n%2==0) return false;
        
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        boolean primo = true;
        return primo & !serepite();
     }


     
     public boolean serepite(){
         ArrayList<String> aux = new ArrayList<>();
         for(Integer i = 0; i < cartas.size(); i++){
             for(Integer j = i +1; j < cartas.size(); j++){
                 aux = cartas.get(i).encomun(cartas.get(j));
                 if(aux.size() > 1){
                     return true;
                 }
                 else{
                     aux.clear();
                 }
             }
         }
         return !(aux.isEmpty());
     }
     
    boolean isPrime(int n) {
        if(n ==2) return true;
        if (n%2==0) return false;
        
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}