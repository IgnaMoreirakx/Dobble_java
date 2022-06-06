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
    
    public Integer findtotalcards(){
        Integer n = this.carta.size() - 1;
        return n*n + n + 1;
    }
    
    public Integer requiredelements(){
        Integer n = this.carta.size() - 1;
        return n*n + n + 1;
    }
    
    public Integer largo(){
        return this.carta.size();
    }
    
    public ArrayList transformar(ArrayList<String> e){
        ArrayList aux = new ArrayList<> ();
        for(Integer i =0; i<this.carta.size(); i++){
            Integer cambio = this.carta.get(i);
            aux.add(e.get(cambio));
        }
        return aux;
    }
    
    
    public String cartatostring(){
        ArrayList<String> carta_string = new ArrayList<>();         //se crea arreglo vacio
        for(Integer i =0; i<this.carta.size(); i++){
            carta_string.add(this.carta.get(i).toString());         //se  transforman los atributos en string y se agregan al carta_string
        }
        String cartaa = String.join("-", carta_string);             // junta los string y despues los separa con un "-"
        return cartaa;
    }
           
}
