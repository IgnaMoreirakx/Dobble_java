/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;

/**
 *
 * @author ignac
 */
public class Game {
    //atributos
    Integer num_jugadores;
    ArrayList<Jugador>jugadores;
    Cardset mazo;
    Areajuego area;
    String estado;
    String modo;

    public Game(Integer num_jugadores, Cardset mazo, Areajuego area, String estado, String modo) {
        this.jugadores = new ArrayList<>();
        this.mazo = mazo;
        this.num_jugadores = num_jugadores;
        this.area = area;
        this.estado = estado;
        this.modo = "stackmode";
    }
    public void register(Jugador j){
        if(num_jugadores > 0){
            jugadores.add(j);
            num_jugadores = num_jugadores -1;
        }
    }
    
    public void iniciarjuego(){
        area.agregarcartas(mazo);
    }
    
/*    
    public String devolver(){
        String s = "";
        for(Integer i = 0; i < jugadores.size(); i++){
            s += jugadores.get(i).toString();
        }
        return s;
    }
*/
    @Override
    public String toString() {
        String si = mazo.cardset_string();
        String area2 = area.areat_string();
        return "Game{ jugadores=" + jugadores + ", mazo=" + si + ", area=" + area2 + ", estado=" + estado + ", modo=" + modo + '}';
    }
}
