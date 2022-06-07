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
public class Areajuego {
    // atributo
    ArrayList<Carta> area = new ArrayList<>();

    public Areajuego() {
        
    }
    public ArrayList<Carta> agregarcartas(Cardset cs){
        area.add(cs.nthcard(0));
        area.add(cs.nthcard(1));
        cs.borrar_carta(cs.nthcard(0));
        cs.borrar_carta(cs.nthcard(1));
        return area;
    }
    
    public ArrayList<Carta> eliminarcartas(){
        this.area.clear();
        return area;
    }
    
    public String areat_string(){
        ArrayList<String> area_string = new ArrayList<>();
        for(Integer i =0; i<this.area.size(); i++){
            Carta carta1 = this.area.get(i);
            area_string.add(carta1.cartatostring()); 
            }
        String areaa = String.join("  ", area_string); 
        return areaa;
    }
}
