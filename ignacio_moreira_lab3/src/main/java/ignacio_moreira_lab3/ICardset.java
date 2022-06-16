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
public interface ICardset {
    public Carta nthcard(Integer n);
    public Integer numcard();
    public boolean isdobble();
    public Cardset missingcards();
    public String cardset_string();
    public boolean equals(Cardset cs1);
}
