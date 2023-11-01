package TP7.ej1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Medidor extends Thread{
    private Sala sala;
    private Random r;
    
    public Medidor(Sala sala){
        this.sala = sala;
        r = new Random();
    }
    
    public void run(){
        while(true){
            sala.notificarTemperatura(r.nextInt(25, 35));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
