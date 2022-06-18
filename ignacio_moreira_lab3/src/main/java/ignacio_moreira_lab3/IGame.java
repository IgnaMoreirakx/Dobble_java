/*
 * Representación de la estructura que alberga una partida del juego.
 *
 * @author Ignacio Moreira.
 */
package ignacio_moreira_lab3;

public interface IGame {
    /**
     * Se encarga del proceso de agregar a un jugador a la partida, este jugador debe ser único.
     * @param j Jugador el cual se quiere agregar.
     */
    public void register(Jugador j);
    
    /**
     * Se encarga de inicar el juego, es decir 
     * agrega cartas del mazo al área de juego y cambia el estado del juego a "iniciado"
     */
    public void iniciarjuego();
    
    /**
     * Represente el proceso de la primera juega que un jugador puede realizar, 
     * compara el elemento del jugador con las de las 2 cartas del área y 
     * dependiendo del resultado de la comparación se suma o no puntaje al jugador y se cambian las cartas del área.
     * @param elemento Elmento que elije el usuario para comparar con las 2 cartas del área.
     */
    public void spotit(String elemento);
    
    /**
     * Última jugada displonible, cambia el estado del juego a "Finalizado" y entre el resutlado del juego.
     */
    public void finish();
    
    /**
     * Entrega el jugador ganador, en caso de no existir entrega "Empate".
     * @return String, puede ser le nombre del jugador ganador o "empate".
     */
    public String ganador();
    
    /**
     * Representa el cambio de turno entre los jugadores.
     */
    public void cambiarturno();
    
    /**
     * Entrega a quien le corresponde hacer alguna jugada.
     * @return Nombre del jugador.
     */
    public String dequieneselturno();
    
    /**
     * Corresponde al método para que un jugador pueda jugar contra la cpu 
     * la cpu siempre elige la jugada "Spotit" y dependiende del azar acertará o no.
     */
    public void contracpu();
    
    /**
     * Corresponde a transformar la información del juego en un string para mostrarselo al usuario.
     * @return String.
     */
    @Override
    public String toString();
}
