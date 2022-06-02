package ignacio_moreira_lab3;

import java.util.ArrayList;


public class Carta {
     ArrayList<Integer> carta = new ArrayList<>();
    
    //constructor
    public Carta() {
       
    }
    
    public ArrayList<Integer> getcarta(){
        return this.carta;
    }
    public String tostring(){
        ArrayList<String> carta_string = new ArrayList<>();         //se crea arreglo vacio
        for(Integer i =0; i<this.carta.size(); i++){
            carta_string.add(this.carta.get(i).toString());         //se  transforman los atributos en string y se agregan al carta_string
        }
        String cartaa = String.join("-", carta_string);             // junta los string y despues los separa con un "-"
        return cartaa;
    }
}
