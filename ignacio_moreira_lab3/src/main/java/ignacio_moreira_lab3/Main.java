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
public class Main {

    
    public static void main(String[] args) {
             ArrayList<String> simbolos = new ArrayList<>();
       simbolos.add("perro");
       simbolos.add("gato");
       simbolos.add("carpincho");
       simbolos.add("rana");
       simbolos.add("leopardo");
       simbolos.add("tortuga");
       simbolos.add("elefante");
       simbolos.add("cocodrilo");
       simbolos.add("hipopotamo");
       simbolos.add("orritonrico");
       simbolos.add("pato");
       simbolos.add("pincuino");
       
       Cardset cs1 = new Cardset(2 , 7, simbolos);
       Carta c1 = new Carta();
       c1.getcarta().add("hola");
       c1.getcarta().add("chao");
       
       Areajuego a1 = new Areajuego();
       
       Jugador j1 = new Jugador("ignacio");
       Jugador j2 = new Jugador("fenia");
       Jugador j3 = new Jugador("esperanza");
       
       Game g1 = new Game(3, cs1, a1, "iniciado", "bb");
       g1.register(j1);
       g1.register(j2);
       g1.register(j3);
       
       g1.iniciarjuego();
       g1.spotit("gato");
       g1.pass();
       
       System.out.println(cs1.cardset_string());
       System.out.println(c1.cartatostring());
       System.out.println(g1.toString());
    }
}

