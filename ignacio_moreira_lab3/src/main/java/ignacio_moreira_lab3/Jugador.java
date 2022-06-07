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

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.score = 0;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", score=" + score + '}';
    }
}
