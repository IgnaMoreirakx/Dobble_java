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
public class Jugador {
    //atributos
    String nombre;
    Integer score;
    Boolean turno;

    public Jugador(String nombre, Boolean turno) {
        this.nombre = nombre;
        this.score = 0;
        this.turno = turno;
    }
    public String getnombre(Jugador j1){
        return j1.nombre;
    }
    
    public Integer getscore(Jugador j1){
        return j1.score;
    }
    
    // se le suma un punto al jugador cuando corresponde
    public Integer setscore(Jugador j1){
        return j1.getscore(j1) + 1;
    }
}
