/*
 * Representa a la estructura de un jugador, es decir, 
 * su nombre y su score el cual siempre será 0 al iniciar un juego.
 * 
 * @Author Ignacio Moreira.
 */
package ignacio_moreira_lab3;

public class Jugador implements IJugador {
    //atributos
    /**
     * Nombre del jugador, debe ser único.
     */
    private String nombre;
    
    /**
     * Representa el puntaje del jugador, que 
     * dependiendo de las jugadas irá cmabiando.
     */
    private Integer score;

    public Jugador(String nombre) {
        /**
         * Constructor: ArrayList que contien el nombre y el score del jugador.
         */
        this.nombre = nombre;
        this.score = 0;
    }

    /**
     * Permite obtener el nombre de un jugador para poder operar con él.
     * @return El nombre del jugador en forma de string.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Permite obtener el score de un jugador, se usa principalmente
     * para obtener el ganador de una partida.
     * @return Score del jugador en forma de entero.
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Permite sumarle 1 al score del jugador, 
     * se usa en la jugada "Spotit" cuando en necesario.
     */
    public void setScore() {
        this.score = this.score + 1;
    }

    
    /**
     * Entrega la información del jugador en forma de string 
     * para poder mostrarselo al usuario.
     * @return String. 
     */
    @Override
    public String toString() {
        return nombre + "\r con "+ " " + score + " " + "puntos";
    }
    
    /**
     * Se compara jugadores y se verifica o no si son iguales.
     * Un jugador será igual al otro si estos 2 tienen el mismo nombre.
     * @param j jugador con el que se hace la comparación.
     * @return booleano
     */
    public Boolean equals(Jugador j){
        return nombre.equals(j.getNombre());
    }
    
}
