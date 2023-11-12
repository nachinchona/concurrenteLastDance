package TP8.ej2;

import java.util.Random;

public class Investigador extends Thread{
    private Observatorio obs;
    private Random r = new Random();
    
    public Investigador(int i, Observatorio o){
        this.setName(Integer.toString(i));
        this.obs = o;
    }
    
    public void run(){
        try{
            obs.investigar();
            Thread.sleep(r.nextInt(2000, 6000));
            obs.salirInvestigador();
        }catch(InterruptedException e){
            
        }
    }
}
