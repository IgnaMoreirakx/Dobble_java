
package ignacio_moreira_lab3;

import java.util.ArrayList;



public class Main {

 
    public static void main(String[] args) {
       /*
        
       Ejemplos de la clase Cardset
        
       ArrayList<String> simbolos = new ArrayList<>();
       simbolos.add("");
       simbolos.add("perro");
       simbolos.add("gato");
       simbolos.add("carpincho");
       simbolos.add("rana");
       simbolos.add("leopardo");
       simbolos.add("tortuga");
       simbolos.add("elefante");
       
       simbolos.add("cocodrilo");
       
       simbolos.add("murcielago");
       simbolos.add("hamster");
       simbolos.add("caballo");
       simbolos.add("minotauro");
       simbolos.add("koala");
       simbolos.add("cqqq");
       
       Cardset cs1 = new Cardset(2, 4, simbolos);
       Cardset cs2 = new Cardset(2, 3, simbolos);
        Ejemplo tostring
       System.out.println(cs1.cardset_string());
        
        Ejemplo nthcard y carta to string
       System.out.println(cs2.nthcard(0).cartatostring() + "\n");
        
        Ejemplo de isdobble
       System.out.println(cs1.isdobble());
       
        EJEMPLO de equals
       //System.out.println(cs1.equals(cs2).toString());
       

             
      
       Areajuego a1 = new Areajuego();
       
       Jugador j1 = new Jugador("ignacio");
       Jugador j2 = new Jugador("tomas");
       Jugador j3 = new Jugador("esperanza");
       
       Game g1 = new Game(3, cs1, a1, "iniciado", " ");
       Game g2 = new Game(3, cs1, a1, "iniciado", " ");
       
        ejemplo de register
       g1.register(j1);
       g1.register(j3);
        
        ejemplo de register game2
       g2.register(j1);
       g2.register(j3);
       
        ejemplo de equals de game
       System.out.println(g1.Equals(g2));
        
        ejemplo de tostring de game
       //System.out.println(g1.toString() + "\n");
       //g1.register(j3);
       
       
       EJEMPLO DE UNA PARTIDA 
        
       g1.iniciarjuego();
       System.out.println(g1.toString() + "\n");
       g1.spotit("carpincho");
       System.out.println(g1.toString() + "\n");
       g1.pass();
       System.out.println(g1.toString() + "\n");
       
        g1.finish();
        System.out.println(g1.toString() + "\n");
        
        EJEMPLO DE DEQUIENESELTURNO
        System.out.println(g2.dequieneselturno() + "\n");
        
        
  
       */
        Menu m1 = new Menu();
        m1.run();

    }
}

