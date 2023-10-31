package TP6.ej3;

import java.util.concurrent.Semaphore;

public class Sala {
    private int cantMesas = 8;
    private Semaphore semMesas = new Semaphore(cantMesas);
    
    public void ocuparMesa() throws InterruptedException{
        semMesas.acquire();
    }
    
    public void dejarMesa(){
        semMesas.release();
    }
}
