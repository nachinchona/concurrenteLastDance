package Parcial2021.ej2;

import java.util.Random;

public class Pareja extends Thread{

    private Persona p1;
    private Persona p2;
    private Entrada entrada;
    private Random r = new Random();
    
    public Pareja(Persona p1, Persona p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public void run(){
        
    }
}
