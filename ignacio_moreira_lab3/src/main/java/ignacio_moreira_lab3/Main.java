/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignacio_moreira_lab3;

/**
 *
 * @author ignac
 */
public class Main {

    
    public static void main(String[] args) {
       Cardset cs1 = new Cardset(3, 8);
       Areajuego a1 = new Areajuego();
       Jugador j1 = new Jugador("ignacio");
       Jugador j2 = new Jugador("feniaa");
       Game g1 = new Game(2, cs1, a1, "iniciado", "bb");
       g1.register(j1);
       g1.register(j2);
       g1.iniciarjuego();
   
       //System.out.println(cs1.cardset_string());
       System.out.println(g1.toString());
       
       //System.out.println(c1.transformar(simbolos));
    }
    
}
