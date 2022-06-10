/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;



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
    
    

    public void spotit(String elemento){
        if(area.obtenercarta(0).getcarta().contains(elemento)){
            if(area.obtenercarta(1).getcarta().contains(elemento)){
                area.eliminarcartas();
                area.agregarcartas(mazo);
                Jugador j1= jugadores.get(0);
                j1.setScore();
                cambiarturno();
             
                
                
            }
            else{
                cambiarturno();
            }
        }
        else{
            cambiarturno();
        }
    }
    
    public void pass(){
        cambiarturno();
    }
    
    
    public void cambiarturno(){
        Jugador j1= jugadores.get(0);
        jugadores.remove(0);
        Integer largo = jugadores.size();
        jugadores.add(largo, j1);
    }

    
    
    @Override
    public String toString() {
        Integer cantidad_cartas= mazo.getcartas().size();
        String mazo2 = mazo.cardset_string();
        String area2 = area.areat_string();
        return "Game{ jugadores=" + jugadores + ", numeros de cartas en el mazo=" + cantidad_cartas + ", area=" + area2 + ", estado=" + estado + ", modo=" + modo + '}';
    }
    
}
