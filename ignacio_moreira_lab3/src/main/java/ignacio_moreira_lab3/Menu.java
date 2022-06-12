/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
     Cardset cs;
    Game game;
    Scanner s = new Scanner(System.in);
    private boolean salir = false;

    private void mostraropciones(){
        System.out.println("Bienvenido a Dobblegame\n");
        System.out.println("Elija una opcion: \n");
        System.out.println("1. crear mazo");
        System.out.println("2. salir\n");
    }
    
    public void run(){
        while(!salir){
            mostraropciones();
            leeropciones();
        }
    }
    
    private void leeropciones(){
        System.out.println("Elija una opcion: \n");
        int opcion = s.nextInt();
        
        switch(opcion){
            case 1:
                cs = crearmazo();
                
                System.out.println("Elija una opcion: \n");
                System.out.println("1. registrar jugadores");
                System.out.println("2. salir\n");
                int opcionaux = s.nextInt();
                switch(opcionaux){
                    case 1:
                        game = crearpartida();
                        System.out.println("El juego actual es: "+ game.toString());
                        
                        System.out.println("Elija una opcion: \n");
                        System.out.println("1. iniciar partida");
                        System.out.println("\n 2. salir");
                        opcionaux = s.nextInt();
                        switch(opcionaux){
                            case 1:
                                game.iniciarjuego();
                                System.out.println(game.area.areat_string());
                                menujugar();
                                break;
                            case 2:
                                salir=true;      
                        }
                        salir = true;
                        break;
                    case 2:
                        salir = true;
                        break;
                }
                salir = true;
                break;
                
            case 2: 
                salir = true;
                break;
        }
    }
    
    private Cardset crearmazo(){
        Scanner sn = new Scanner(System.in);
        ArrayList<String> simbolos = new ArrayList<>();
        System.out.println("cuantos simbolos por elementos quiere en cada carta: ");
        Integer nume = sn.nextInt();
        Integer numero_orden = nume-1;
        System.out.println("cuantas cartas quiere del mazo, no pueden ser mas de "+ (numero_orden*numero_orden + numero_orden +1) + " : ");
        Integer numc = sn.nextInt();
        Integer maxsimbolos = (nume)*(nume) + nume + 1;

        for(Integer i = 0; i< maxsimbolos; i++){
            System.out.println("ingrese el" + " " + (Integer.toString(i+1))+ " " + "simbolo que quiere en su mazo: ");
            String simb= sn.next();
            simbolos.add(simb);
        }

        Cardset cs1 = new Cardset(nume-1, numc, simbolos);
        System.out.println("EL MAZO PARA ESTA PARTIDA ES: " + cs1.cardset_string());
        return cs1;

    }
    
    private Game crearpartida(){
        Areajuego a1 = new Areajuego();
        Scanner sn = new Scanner(System.in);
        System.out.println("cuantos jugadores son: ");
        Integer num_jugadores = sn.nextInt();
        Game g = new Game(num_jugadores, cs, a1, "iniciado", "");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for(Integer i = 0; i < num_jugadores; i++){
            System.out.println("ingrese el jugador numero" + " " + (Integer.toString(i+1))+ " : ");
            String nombrej= sn.next();
            Jugador j = new Jugador(nombrej);
            jugadores.add(j);
        }
        for(Integer i = 0; i<jugadores.size(); i++){
            g.register(jugadores.get(i));
        }
        return g;
    }
    
    private void menujugar(){
        boolean sal = false;
    do{
        System.out.println("Elije una opción: ");
        System.out.println("1. Hacer una jugada: ");
        System.out.println("\n 2. salir");
        int opcionaux = s.nextInt();
        switch(opcionaux){
            case 1:
                System.out.println("Que jugada quieres hacer: ");
                System.out.println("\n 1. Spoit ");
                System.out.println("\n 2. pass ");
                System.out.println("\n 3. finish ");
                System.out.println("\n 4. salir ");
                opcionaux = s.nextInt();
                switch(opcionaux){
                    case 1:
                       System.out.println("LAS CARTAS EN EL AREA SON: " + game.area.areat_string());;
                       Scanner sn = new Scanner(System.in);
                       System.out.println("Cual es el simbolo en comun: ");
                       String elemento = sn.next();
                       game.spotit(elemento);
                       System.out.println(game.toString());
                       
                       break;
                    case 2: 
                        System.out.println(game.area.areat_string());
                        game.pass();
                        System.out.println(game.toString());

                        break;
                    case 3:
                        System.out.println(game.area.areat_string());
                        game.finish();
                        System.out.println(game.toString());
                        sal=true;

                        break;
                    case 4:
                        sal=true;
                }
                
                break;
            case 2:
                sal=true;
                break;
        }
        
    }while(!sal);
    }
}
