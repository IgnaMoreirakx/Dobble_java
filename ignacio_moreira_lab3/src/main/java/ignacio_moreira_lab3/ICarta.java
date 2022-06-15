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
public interface ICarta {
    public Integer findtotalcards();
    public Integer requiredelements();
    public ArrayList<String> encomun(Carta c);
    public Integer largo();
    public String cartatostring();
    public Boolean equals(Carta c1);
}
