package TP6.ej2;

public class Sala {
    private int cantMesas = 8;
    
    public synchronized void ocuparMesa() throws InterruptedException{
        while(cantMesas == 0){
            this.wait();
        }
        cantMesas--;
    }
    
    public synchronized void dejarMesa(){
        cantMesas++;
        this.notify();
    }
}
