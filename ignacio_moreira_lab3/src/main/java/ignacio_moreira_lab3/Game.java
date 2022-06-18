/*
 * Representación de la estructura que alberga una partida del juego.
 *
 * @author Ignacio Moreira.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Game implements IGame {
    //atributos
    /**
     * Representa la cantidad de juagdores que participaran del juego.
     */
    private Integer num_jugadores;
    
    /**
     * Representa una lista con los jugadores que van a jugar.
     */
    private ArrayList<Jugador>jugadores;
    
    /**
     * Representa el mazo correspondiente a la partida de juego.
     */
    protected Cardset mazo;
    
    /**
     * Representa el área de juego una vez que se inicie la partida.
     */
    protected Areajuego area;
    
    /**
     * Da a conocer el estado del juego.
     */
    private String estado;
    
    /**
     * Da a conocer el modo del juego, para este efecto el modo siempre será "Stackmode".
     */
    protected String modo;
    
    /**
     * Corresponde a entregar al juagdor ganador o bien, decir cuando hay un empate.
     */
    private String resultado;

   
    public Game(Integer num_jugadores, Cardset mazo, Areajuego area, String estado, String modo) {
        /**
         * Instancia para crear una nueva partida de juego, indicando todos sus atributos necesarios.
         */
        this.jugadores = new ArrayList<>();
        this.mazo = mazo;
        this.num_jugadores = num_jugadores;
        this.area = area;
        this.estado = estado;
        this.modo = "stackmode";
        this.resultado = "no terminado";
    }
    
    /**
     * Se encarga del proceso de agregar a un jugador a la partida, este jugador debe ser único.
     * @param j Jugador el cual se quiere agregar.
     */
    public void register(Jugador j){
        if(num_jugadores > 0){
            for(Integer i = 0; i < jugadores.size(); i++){
                if(jugadores.get(i).equals(j)){
                    jugadores = null;
                }
            }
            jugadores.add(j);
            num_jugadores = num_jugadores -1;
        }
    }
    
    /**
     * Se encarga de inicar el juego, es decir 
     * agrega cartas del mazo al área de juego y cambia el estado del juego a "iniciado"
     */
    public void iniciarjuego(){
        area.getArea().add(mazo.nthcard(0));
        area.getArea().add(mazo.nthcard(1));
        mazo.borrar_carta(mazo.nthcard(0));
        mazo.borrar_carta(mazo.nthcard(0));
    }
    
    
    
    /**
     * Represente el proceso de la primera juega que un jugador puede realizar, 
     * compara el elemento del jugador con las de las 2 cartas del área y 
     * dependiendo del resultado de la comparación se suma o no puntaje al jugador y se cambian las cartas del área.
     * @param elemento Elmento que elije el usuario para comparar con las 2 cartas del área.
     */
    public void spotit(String elemento){
        if(area.obtenercarta(0).getcarta().contains(elemento)){
            if(area.obtenercarta(1).getcarta().contains(elemento)){
                area.eliminarcartas();
                System.out.println(area.areat_string());
                Jugador j1= jugadores.get(0);
                j1.setScore();
                cambiarturno();
                area.agregarcartas(mazo);
                
                if(area.getArea().size() < 2){
                    finish();
                }
             
                
                
            }
            else{
                cambiarturno();
            }
        }
        else{
            cambiarturno();
        }
    }
    
    /**
     * Se encarga de la 2da jugada que se puede realizar, esta solo se cambia el turno entre los juagdores.
     */
    public void pass(){
        cambiarturno();
    }
    
    /**
     * Última jugada displonible, cambia el estado del juego a "Finalizado" y entre el resutlado del juego.
     */
    public void finish(){
        this.estado = "finalizado";
        this.resultado = ganador();
    }
    
    /**
     * Entrega el jugador ganador, en caso de no existir entrega "Empate".
     * @return String, puede ser le nombre del jugador ganador o "empate".
     */
    public String ganador(){
        ArrayList<Integer> scores= new ArrayList<>();
        ArrayList<Jugador> ganadores= new ArrayList<>();
        for(Integer i = 0; i<jugadores.size(); i++){
            scores.add(jugadores.get(i).getScore());
        }
        Integer maxscores= Collections.max(scores);
        for(Integer i = 0; i < jugadores.size(); i++){
            Jugador j = jugadores.get(i);
            if(j.getScore().equals(maxscores)){
                ganadores.add(j);
                
            }
        }
        if(ganadores.size() >1){
            return "empate";
        }
        return "GANADOR: " + ganadores.get(0).getNombre();
    }
    
    /**
     * Representa el cambio de turno entre los jugadores.
     */
    public void cambiarturno(){
        Jugador j1= jugadores.get(0);
        jugadores.remove(0);
        Integer largo = jugadores.size();
        jugadores.add(largo, j1);
    }
    
    
    /**
     * Entrega a quien le corresponde hacer alguna jugada.
     * @return Nombre del jugador.
     */
    public String dequieneselturno(){
        return jugadores.get(0).getNombre();
    }
    
    /**
     * Corresponde al método para que un jugador pueda jugar contra la cpu 
     * la cpu siempre elige la jugada "Spotit" y dependiende del azar acertará o no.
     */
    public void contracpu(){
        Random posrandom = new Random();
        Integer pos= posrandom.nextInt(10);
        if(area.getArea().isEmpty()){
            finish();
        }
        if(pos%2 == 0){
            String simbolo = area.getArea().get(0).encomun(area.getArea().get(1)).get(0);
            System.out.println(simbolo);
            spotit(simbolo);
        }
        else{
            Random posrandom2 = new Random();
            Integer pos2= posrandom.nextInt(area.getArea().size());
            ArrayList<String> elementos = area.getArea().get(pos2).getcarta();
            String simbolo = elementos.get(pos2);
            System.out.println(simbolo);
            spotit(simbolo);
        }   
    }

    
    /**
     * Corresponde a transformar la información del juego en un string para mostrarselo al usuario.
     * @return String.
     */
    @Override
    public String toString() {
        Integer cantidad_cartas= mazo.getcartas().size();
        String mazo2 = mazo.cardset_string();
        String area2 = area.areat_string();
        ArrayList<String> nombrej= new ArrayList<>();
        for(Integer i = 0; i<jugadores.size();i++){
            nombrej.add(jugadores.get(i).toString());
            }
        String jugadoresstring = String.join("\r\n", nombrej);
        return jugadoresstring + "\r\nNUMERO DE CARTAS EN EL MAZO: " + cantidad_cartas + "\r\nCARTAS SOBRE EL AREA: " + area2 + "\r\nESTADO: " + estado + "\r\nMODO: " + modo + "\r\n" +resultado ;
    }
    
    /**
     * Permite saber si 2 juegos son iguales.
     * @param g Juego con el que se quiere comparar.
     * @return booleano
     */
    public boolean Equals(Game g){
        return num_jugadores.equals(g.num_jugadores) && mazo.equals(g.mazo) && jugadores.equals(g.jugadores) && estado.equals(g.estado);
    }
    
}
