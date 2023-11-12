package TP8.ej3;

import java.util.Random;

public class Brazo extends Thread {

    private Caja caja;
    private Random r = new Random();
    
    public Brazo(Caja caja){
        this.caja = caja;
    }
    
    public void run() {
        while (true) {
            try {
                caja.retirarCaja();
                Thread.sleep(r.nextInt(100, 600));
                caja.reponerCaja();
            } catch (InterruptedException ex) {
            }
        }
    }
}
