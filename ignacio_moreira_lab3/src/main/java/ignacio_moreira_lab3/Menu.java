/*
 * Clase encargada de establecer la conexión entre los usuarios y el programa.
 * 
 * @Author Ignacio Moreira.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;
import java.util.Scanner;



public class Menu {
    /**
     * Representa el mazo que construirá el usuario que utilice el programa.
     */
    Cardset cs;
    
    /**
     * Representa el juego que tendrá los atributos que el usuario desee.
     */
    Game game;
    
    /**
     * Permite obtener las respuestas del usuario.
     */
    Scanner s = new Scanner(System.in);
    
    /**
     * Permite saber cuando el usuario quiera salir del programa.
     */
    private boolean salir = false;

    
    /**
     * Encargadada de mostrar las opciones principales al usuario
     */
    private void mostraropciones(){
        System.out.println("Bienvenido a Dobblegame\n");
        System.out.println("Elija una opcion: \n");
        System.out.println("1. crear mazo");
        System.out.println("2. salir\n");
    }
    
    /**
     * Método para que el menú sea mostrado al usuario.
     */
    public void run(){
        while(!salir){
            mostraropciones();
            leeropciones();
        }
    }
    
    /**
     * Recoge las opciones que entrega el usuario
     * Consta de sub-menús, donde el primero
     * le permite al usuario construir su mazo, luego el usuario decide los parametros del juego,
     * o bien puede elegir jugar contra la cpu.
     */
    private void leeropciones(){
        System.out.println("Elija una opcion: \n");
        int opcion = s.nextInt();
        
        switch(opcion){
            case 1:
                cs = crearmazo();
                
                System.out.println("Elija una opcion: \n");
                System.out.println("1. Partida entre amigos");
                System.out.println("2. Partida contra la cpu");
                System.out.println("3. Salir\n");
                int opcionaux = s.nextInt();
                switch(opcionaux){
                    case 1:
                        game = crearpartida();
                        game.iniciarjuego();
                        System.out.println("\nEl juego actual es: "+ game.toString());
                        menujugar();
                        salir = true;
                        break;
                    case 2:
                        game = modocpu();
                        game.iniciarjuego();
                        System.out.println("\nEl juego actual es: "+ game.toString());
                        menucpu();
                        salir = true;
                        break;
                    case 3:
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
    
    /**
     * Se encarga guardar los parametros escogidos por el usuario y 
     * asi poder crear el mazo para la partida.
     * @return Mazo con el que se jugará, tipo de dato Cardset.
     */
    private Cardset crearmazo(){
        Scanner sn = new Scanner(System.in);
        ArrayList<String> simbolos = new ArrayList<>();
        simbolos.add("");
        System.out.println("cuantos simbolos por elementos quiere en cada carta: ");
        Integer nume = sn.nextInt();
        Integer numero_orden = nume-1;
        System.out.println("cuantas cartas quiere del mazo, no pueden ser mas de "+ (numero_orden*numero_orden + numero_orden +1) + " : ");
        Integer numc = sn.nextInt();
        Integer maxsimbolos = (nume-1)*(nume-1) + nume-1 + 1;

        for(Integer i = 0; i< maxsimbolos; i++){
            System.out.println("ingrese el" + " " + (Integer.toString(i+1))+ " " + "simbolo que quiere en su mazo: ");
            String simb= sn.next();
            simbolos.add(simb);
        }

        Cardset cs1 = new Cardset(nume, numc, simbolos);
        System.out.println("EL MAZO PARA ESTA PARTIDA ES: " + cs1.cardset_string());
        return cs1;

    }
    
    /**
     * Se encarga de recibir los parametros del usuario para crear la partida a su gusto.
     * @return estructura de la partida de juego, tipo de dato Game.
     */
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
    
    /**
     * Corresponde a las opciones de jugadas principalmente,
     * con esto el usuario podrá siempre que jugada hacer 
     * cada vez después de una jugada se muestra el game actual.
     */
    private void menujugar(){
        boolean sal = false;
    do{
        System.out.println("\nEl turno es de: " + game.dequieneselturno() + "\n");
        System.out.println("Elije una opción: ");
        System.out.println("1. Hacer una jugada: ");
        System.out.println("2. salir");
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
                       System.out.println("Cual es el simbolo en comun: " + "\n");
                       String elemento = sn.next();
                       game.spotit(elemento);
                       System.out.println(game.toString());
                       if(game.area.getArea().isEmpty()){
                           game.finish();
                           sal = true;
                       }
                       
                       break;
                    case 2: 
                        System.out.println(game.area.areat_string());
                        game.pass();
                        System.out.println(game.toString());
                        //sal = true;
                        break;
                    case 3:
                        System.out.println(game.area.areat_string());
                        game.finish();
                        System.out.println(game.toString());
                        sal=true;

                        break;
                    case 4:
                        sal=true;
                        break;
                }
                
                break;
            case 2:
                sal=true;
                break;
        }
        
    }while(!sal);
    }
    
    /**
     * Corresponde a asociar al usuario al juego y a la cpu a la misma partida
     * e inicar la partida automaticamente.
     * @return Game.
     */
    private Game modocpu(){
        Scanner sn = new Scanner(System.in);
        Areajuego a1 = new Areajuego();
        Game g = new Game(2, cs, a1, "iniciado", "");
        System.out.println("Cual es tu nombre: ");
        String nombrej= sn.next();
        Jugador j = new Jugador(nombrej);
        Jugador cpu = new Jugador("cpu");
        g.register(j);
        g.register(cpu);
        return g;
    }
    /**
     * Corresponde A las opciones que se tiene al eligir el modo contra la cpu,
     * este menú siempre le pregunta al usuario que jugada quiere hacer,
     * por otro lada siempre muestra la opción escogida por la cpu.
     */
    private void menucpu(){
        boolean sal = false;
    do{
        if(game.area.getArea().isEmpty()){
            sal = true;
            break;
        }
        System.out.println("Que jugada quieres hacer: ");
        System.out.println("\n 1. Spoit ");
        System.out.println("\n 2. pass ");
        System.out.println("\n 3. finish ");
        System.out.println("\n 4. salir ");
        int opcionaux = s.nextInt();
        switch(opcionaux){
            case 1:
                System.out.println("LAS CARTAS EN EL AREA SON: " + game.area.areat_string());;
                Scanner sn = new Scanner(System.in);
                System.out.println("Cual es el simbolo en comun: " + "\n");
                String elemento = sn.next();
                game.spotit(elemento);
                System.out.println(game.toString()+ "\n");
                if(game.area.getArea().isEmpty()){
                    game.finish();
                    //System.out.println(game.toString());
                    sal = true;
                }
                else{
                    System.out.println("La cpu eligio: ");
                    game.contracpu();
                System.out.println(game.toString());
                }
                       
                break;
            case 2: 
                System.out.println(game.area.areat_string());
                game.pass();
                System.out.println(game.toString()+ "\n");
                System.out.println("La cpu eligio: ");
                game.contracpu();
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
               break;
        }        
    }while(!sal);
    }
        
    
    
}