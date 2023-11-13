package Parcial2021.ej2;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Control extends Thread {
    private Entrada sala;
    
    public Control(Entrada sala){
        this.sala = sala;
    }
    
    public void run(){
        while(true){
            try {
                sala.controlar();
            } catch (InterruptedException ex) {
            }
        }
    }
}
