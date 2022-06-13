package ignacio_moreira_lab3;

import java.util.ArrayList;


public class Carta {
    ArrayList<String> carta = new ArrayList<>();
    //constructor
    public Carta() {
       
    }
    
    public ArrayList<String> getcarta(){
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
    
    public ArrayList<String> transformar(ArrayList<String> simbolos, ArrayList<Integer> numeros){
        ArrayList aux = new ArrayList<> ();
        for(Integer i =0; i<this.carta.size(); i++){
            Integer cambio = numeros.get(i);
            aux.add(simbolos.get(cambio));
        }
        return aux;
    }
    
    public String cartatostring(){
        ArrayList<String> carta_string = new ArrayList<>();         //se crea arreglo vacio
        for(Integer i =0; i<this.carta.size(); i++){
            carta_string.add(this.carta.get(i));         //se  transforman los atributos en string y se agregan al carta_string
        }
        String cartaa = String.join("-", carta_string);             // junta los string y despues los separa con un "-"
        return cartaa;
    }
    
    

    public Boolean equals(Carta c1){
       return carta.equals(c1.getcarta());
    }
    
    public ArrayList<String> encomun(Carta c){
        ArrayList<String> resultado = new ArrayList<>();
        for(Integer i = 0; i< carta.size(); i++){
            if(carta.contains(c.getcarta().get(i))){
               resultado.add((c.getcarta().get(i)));
            }
        }
        return resultado;
    }
           
}
