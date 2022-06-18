/*
 * Representación de una carta del juego, muchas de ellas dan a lugar a un mazo de cartas.
 * 
 * @author Ignacio Moreira.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;


public class Carta implements ICarta {
    /**
     * Representa a una carta, que inicialmente es una carta sin elementos.
     */
    ArrayList<String> carta = new ArrayList<>();
    
    
    /**
     * Constructor: Inicializa una carta como un arraylist de string vacío.
     */
    public Carta() {
       
    }
    
    /**
     * se obtiene los elementos de la carta para poder operar sobre estos.
     * @return Arraylsit de strings
     */
    public ArrayList<String> getcarta(){
        return this.carta;
    }
    
    /**
     * Determina apartir de la misma carta el total de cartas necesarios
     * para formar un mazo completo donde esta misma carta pertenezca.
     * @return Entero.
     */
    public Integer findtotalcards(){
        Integer n = this.carta.size() - 1;
        return n*n + n + 1;
    }
    
    /**
     * Determina apartir de la misma carta el total de simbolos necesarios
     * para formar un mazo completo donde esta misma carta pertenezca.
     * @return Entero
     */
    public Integer requiredelements(){
        Integer n = this.carta.size() - 1;
        return n*n + n + 1;
    }
    
    /**
     * Entrega la cantidad de elementos que tiene una carta.
     * @return Entero
     */
    public Integer largo(){
        return this.carta.size();
    }
   
   /**
    * Transforma los elementos de la carta en un string para poder mostrarselo al usuario.
    * @return String.
    */ 
    public String cartatostring(){
        ArrayList<String> carta_string = new ArrayList<>();         //se crea arreglo vacio
        for(Integer i =0; i<this.carta.size(); i++){
            carta_string.add(this.carta.get(i));         //se  transforman los atributos en string y se agregan al carta_string
        }
        String cartaa = String.join("-", carta_string);             // junta los string y despues los separa con un "-"
        return cartaa;
    }
    
    /**
     * Permite saber si 2 cartas son iguales.
     * @param c1 carta con la que hacer la comparación.
     * @return booleano
     */

    public Boolean equals(Carta c1){
       return carta.equals(c1.getcarta());
    }
    
    /**
     * Permite saber los elementos que tienen en común 2  cartas.
     * @param c carta con la que hacer la comparación
     * @return Arraylist de strings.
     */
    public ArrayList<String> encomun(Carta c){
        ArrayList<String> resultado = new ArrayList<>();
        for(Integer i = 0; i< carta.size(); i++){
            if(carta.contains(c.getcarta().get(i))){
               resultado.add((c.getcarta().get(i)));
            }
        }
        return resultado;
    }
    
    
           
}
