/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class Game implements IGame {
    //atributos
    private Integer num_jugadores;
    private ArrayList<Jugador>jugadores;
    protected Cardset mazo;
    protected Areajuego area;
    private String estado;
    protected String modo;
    private String resultado;


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
            for(Integer i = 0; i < jugadores.size(); i++){
                if(jugadores.get(i).equals(j)){
                    jugadores = null;
                }
            }
            jugadores.add(j);
            num_jugadores = num_jugadores -1;
        }
    }
    
    public void iniciarjuego(){
        area.getArea().add(mazo.nthcard(0));
        area.getArea().add(mazo.nthcard(1));
        mazo.borrar_carta(mazo.nthcard(0));
        mazo.borrar_carta(mazo.nthcard(0));
    }
    
    

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
        return "GANADOR: " + ganadores.get(0).getNombre();
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
