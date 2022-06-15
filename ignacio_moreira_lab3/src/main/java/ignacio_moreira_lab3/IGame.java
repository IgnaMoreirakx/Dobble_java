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
public interface IGame {
    public void register(Jugador j);
    public void iniciarjuego();
    public void spotit(String elemento);
    public void finish();
    public String ganador();
    public void cambiarturno();
    public String dequieneselturno();
    public void contracpu();
    @Override
    public String toString();
}
