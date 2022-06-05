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
       Cardset cs1 = new Cardset(3);
       Carta c1 = new Carta();
       c1.getcarta().add(2);
       c1.getcarta().add(33);
       c1.getcarta().add(545);
       
       System.out.println(c1.cartatostring());
       System.out.println(cs1.cardset_string());
    }
    
}
