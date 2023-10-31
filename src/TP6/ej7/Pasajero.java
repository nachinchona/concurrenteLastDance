package TP6.ej7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Pasajero extends Thread{
    private Ferry ferry;
        
    public Pasajero(String name, Ferry ferry){
        this.ferry = ferry;
        this.setName(name);
    }
    
    public void run(){
        try {
            ferry.subirPasajero();
            //System.out.println("Pasajero "+this.getName()+" se subió al ferry. ");
            //ferry.bajarPasajero();
            //System.out.println("Pasajero "+this.getName()+" se bajó del ferry. ");
        } catch (InterruptedException ex) {
        }
    }
}
