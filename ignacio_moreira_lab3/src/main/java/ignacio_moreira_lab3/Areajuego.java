/**
 * Representa el area de juedo de una partida con sus funciones elementales
 *
 * @author Ignacio Moreira
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;

public class Areajuego {
    /**
     * representa las cartas que estarán sobre el area de juego.
     */
    ArrayList<Carta> area = new ArrayList<>();

    
    
    /**
     * crea una instancia de la clase area de juego
     */
    public Areajuego() {
        
    }
    
    /**
     * Agrega cartas del mazo al area de juego y elimina esas cartas del mazo
     * @param cs Mazo correspondiente al juego creado
     * @return 2 cartas sobre el area de juego
     */
    protected ArrayList agregarcartas(Cardset cs){
        if(cs.getcartas().size()>=2){
             
            this.area.add(cs.nthcard(0));
            this.area.add(cs.nthcard(1));
            cs.borrar_carta(cs.nthcard(0));
            cs.borrar_carta(cs.nthcard(0));
            
            return this.area;
        }
        return this.area;
    }
    
    
    /**
     * Elimina las cartas ya usadas del área de juego
     * @return el área d ejuego vacía
     */
    protected ArrayList<Carta> eliminarcartas(){
        this.area.clear();
        return area;
    }
    
    /**
     * Transforma la información de la clase en un string para poder entregaeselo al usuraio
     * @return String
     */
    protected String areat_string(){
        ArrayList<String> area_string = new ArrayList<>();
        for(Integer i =0; i<this.area.size(); i++){
            Carta carta1 = this.area.get(i);
            area_string.add(carta1.cartatostring()); 
            }
        String areaa = String.join("\r\n", area_string); 
        return areaa;
    }

    
    /**
     * Obtiene el área de juego para operar sobre esta en otra clase.
     * @return Área de juego
     */
    protected ArrayList<Carta> getArea() {
        return area;
    }
    
    /**
     * Obtener una carta especifica del área de juego
     * @param i entero referente a la poscición de la carta en el arraylist
     * @return Una carta
     */
    protected Carta obtenercarta(int i){
        return area.get(i);
    }
    
}

