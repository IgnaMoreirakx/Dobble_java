/**
 * Representación de un mazo de cartas para el juego
 * @Author Ignacio Moreira
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;
import java.util.Collections;

public class Cardset implements ICardset  {
    /**
     * Representación del orden finito del plano proyectivo para la construcción del mazo
     */
    private int E;
    
    /**
     * Representa la cantidad de cartas que quiera un jugador para una partida de juego
     */
    private int C;
    
    /**
     * representa los simbolos que tendrán las cartas
     */
    public ArrayList<String> simbolos;
    
    /**
     * Representa el mazo final que se le entregará al usuario y al juego
     */
    private ArrayList <Carta> cartas = new ArrayList<>();
    
    /**
     * Representa un mazo auxiliar para realizar distintas funcionalidades obligatorias, ejemplo Missingcard
     */
    private ArrayList <Carta> cartas_aux = new ArrayList<>();
    
    public Cardset(int E, int C, ArrayList<String> simbolos) {
        /**
         * Crea una nueva instacia de mazo dando los parametros requeridos
         */
        this.C = C;
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
        cartas_aux = cartas;
        ArrayList<Carta> cartas_finales_aux = new ArrayList<>();
        cartas_finales_aux = cartas;
        ArrayList<Carta> cartas_finales= new ArrayList<>();
        for (i= 0; i<C; i++){
            cartas_finales.add(cartas.get(i));
        }
        cartas = cartas_finales;
        Collections.shuffle(cartas);
           
    }
    
    /**
     * Obtener las cartas para poder realizar operaciones sobre ellas
     * @return arraylist de cartas
     */
    public ArrayList<Carta> getcartas(){
        return this.cartas;
    }
    
    /**
     * Obtener los simbolos para poder realizar operaciones sobre estos
     * @return arraylist de strings
     */
    public ArrayList<String> getsimbolos(){
        return this.simbolos;
    }
    
    /**
     * Obtiene una carta del mazo referente a su posicion en el mazo
     * @param n entero que significa la posicion de la carta, puede ser desde 0 hasta el largo del mazo -1
     * @return Una carta
     */
    public Carta nthcard(Integer n){
        return this.cartas.get(n);
    }
    
    /**
     * Obtiene la cantidad de cartas que hay en el mazo
     * @return Un entero
     */
    public Integer numcard(){
        return this.cartas.size();
    }
    
    /**
     * Perimite borrar alguna carta del mazo
     * @param n representa la carta que se quiere eliminar del mazo
     */
    protected void borrar_carta(Carta n){
        this.cartas.remove(n);
    }
    
    
    /**
     * Permite conocer las cartas que hacen falta para tener el mazo completo
     * @return Un mazo
     */
    public Cardset missingcards(){
        Cardset cs1 = new Cardset(0,0, simbolos);
        for(Integer i =0; i<cartas.size();i++){
            if(cartas_aux.contains(cartas.get(i))){
                cartas_aux.remove(cartas.get(i));
            }
        }
        for(Integer i = 0; i<cartas_aux.size();i++){
            cs1.getcartas().add(cartas_aux.get(i));
        }
        return cs1;
    }
    
    /**
     * Transforma la información del mazo a un string para posteriormente mostrarselo al usuario
     * @return string
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
     
     
     /**
      * Permite saber si dos mazos son iguales
      * @param cs1 mazo con el que se quiere saber la igualdad
      * @return booleano
      */
     public boolean equals(Cardset cs1){
         for(Integer i = 0; i<cartas.size();i++){
             if(!cs1.contains(cartas.get(i))){
                 return false;
             }
         }
         Boolean resultado = simbolos.equals(cs1.getsimbolos()) && cartas.size() == cs1.getcartas().size();
        return resultado; 
     }
    
     /**
      * Permite saber si una carta está presente en el mazo
      * @param c1 carta que se quiere saber si está o no en el mazo
      * @return booleano
      */
    public Boolean contains(Carta c1){
        for(Integer i = 0; i< cartas.size(); i++){
            if(cartas.get(i).equals(c1)){
                return true;
            }
        }
        return false;
    } 

     /**
      * Permite saber si un mazo es válido según las reglas matemáticas que existen dentro del juego.
      * @return boolean 
      */
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
        return primo & !serepite;
     }
}