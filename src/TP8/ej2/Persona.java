package TP8.ej2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona extends Thread{
    private boolean esDiscapacitado;
    private Observatorio obs;
    private Random r = new Random();
    
    public Persona(int i, boolean v, Observatorio o){
        this.setName(Integer.toString(i));
        this.esDiscapacitado = v;
        this.obs = o;
    }
    
    public void run(){
        if (!esDiscapacitado) {
            try {
                obs.entrar();
                Thread.sleep(r.nextInt(1000, 5000));
                obs.salir();
            } catch (InterruptedException ex) {
            }
        }else{
            try {
                obs.entrarDiscapacitado();
                Thread.sleep(r.nextInt(1000, 5000));
                obs.salirDiscapacitado();
            } catch (InterruptedException ex) {
            }
        }
    }
}
