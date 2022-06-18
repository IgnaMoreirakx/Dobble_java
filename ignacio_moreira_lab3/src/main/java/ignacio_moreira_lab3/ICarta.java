/*
 * Interfaz que representa a un carta del juego.
 * 
 * @Author Ignacio Moreira.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;


public interface ICarta {
    /**
     * Determina apartir de la misma carta el total de cartas necesarios
     * para formar un mazo completo donde esta misma carta pertenezca.
     * @return Entero.
     */
    public Integer findtotalcards();
    
    /**
     * Determina apartir de la misma carta el total de simbolos necesarios
     * para formar un mazo completo donde esta misma carta pertenezca.
     * @return Entero
     */
    public Integer requiredelements();
    
    /**
     * Permite saber los elementos que tienen en común 2  cartas.
     * @param c carta con la que hacer la comparación
     * @return Arraylist de strings.
     */
    public ArrayList<String> encomun(Carta c);
    
     /**
     * Entrega la cantidad de elementos que tiene una carta.
     * @return Entero
     */
    public Integer largo();
    
    /**
    * Transforma los elementos de la carta en un string para poder mostrarselo al usuario.
    * @return String.
    */
    public String cartatostring();
    
    /**
     * Permite saber si 2 cartas son iguales.
     * @param c1 carta con la que hacer la comparación.
     * @return booleano
     */
    public Boolean equals(Carta c1);
}

