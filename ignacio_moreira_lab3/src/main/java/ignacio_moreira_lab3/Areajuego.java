/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ignacio_moreira_lab3;

import java.util.ArrayList;

public class Areajuego {
    // atributo
    ArrayList<Carta> area = new ArrayList<>();

    public Areajuego() {
        
    }
    protected ArrayList agregarcartas(Cardset cs){
        if(cs.getcartas().size()>=2){
             
            this.area.add(cs.nthcard(0));
            this.area.add(cs.nthcard(1));
            cs.borrar_carta(cs.nthcard(0));
            cs.borrar_carta(cs.nthcard(0));
            
            return this.area;
        }
        return this.area;
    }
    
    protected ArrayList<Carta> eliminarcartas(){
        this.area.clear();
        return area;
    }
    
    protected String areat_string(){
        ArrayList<String> area_string = new ArrayList<>();
        for(Integer i =0; i<this.area.size(); i++){
            Carta carta1 = this.area.get(i);
            area_string.add(carta1.cartatostring()); 
            }
        String areaa = String.join("\r\n", area_string); 
        return areaa;
    }

    protected ArrayList<Carta> getArea() {
        return area;
    }
    
    protected Carta obtenercarta(int i){
        return area.get(i);
    }
    
}
