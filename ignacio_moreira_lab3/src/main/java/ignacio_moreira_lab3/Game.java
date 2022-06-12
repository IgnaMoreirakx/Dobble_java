/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;
import java.util.Collections;



public class Game {
    //atributos
    Integer num_jugadores;
    ArrayList<Jugador>jugadores;
    Cardset mazo;
    Areajuego area;
    String estado;
    String modo;
    String resultado;


    public Game(Integer num_jugadores, Cardset mazo, Areajuego area, String estado, String modo) {
        this.jugadores = new ArrayList<>();
        this.mazo = mazo;
        this.num_jugadores = num_jugadores;
        this.area = area;
        this.estado = estado;
        this.modo = "stackmode";
        this.resultado = "no terminado";
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
                Jugador j1= jugadores.get(0);
                j1.setScore();
                cambiarturno();
                area.agregarcartas(mazo);
                if(area.getArea().size()< 2){
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
    
    public void pass(){
        cambiarturno();
    }
    
    public void finish(){
        this.estado = "finalizado";
        this.resultado = ganador();
    }
    
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
        return "ganador: " + ganadores.get(0).getNombre();
    }
    
    
    public void cambiarturno(){
        Jugador j1= jugadores.get(0);
        jugadores.remove(0);
        Integer largo = jugadores.size();
        jugadores.add(largo, j1);
    }
    
    public String dequieneselturno(){
        return jugadores.get(0).getNombre();
    }

    
    
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
    
}
