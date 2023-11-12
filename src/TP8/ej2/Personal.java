package TP8.ej2;

import java.util.Random;

public class Personal extends Thread{
    private Observatorio obs;
    private Random r = new Random();
    
    public Personal(int i, Observatorio o){
        this.setName(Integer.toString(i));
        this.obs = o;
    }
    
    public void run(){
        try{
            obs.mantener();
            Thread.sleep(r.nextInt(2000, 6000));
            obs.salirPersonal();
        }catch(InterruptedException e){
            
        }
    }
}