package TP6.ej7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Auto extends Thread{
    private Ferry ferry;
        
    public Auto(String name, Ferry ferry){
        this.ferry = ferry;
        this.setName(name);
    }
    
    public void run(){
        try {
            ferry.subirAuto();
            //System.out.println("Auto "+this.getName()+" se subió al ferry. ");
            //ferry.bajarAuto();
            //System.out.println("Auto "+this.getName()+" se bajó del ferry. ");
        } catch (InterruptedException ex) {
        }
    }
}
