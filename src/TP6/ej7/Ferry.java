package TP6.ej7;

public class Ferry {
    private int cantEspacios = 40;
    private boolean enViaje = false;
    private int maxPasajeros;
    private int maxAutos;
    
    public Ferry(int maxPasajeros, int maxAutos){
        this.maxPasajeros = maxPasajeros;
        this.maxAutos = maxAutos;
    }
    
    public synchronized void subirPasajero() throws InterruptedException{
        while(cantEspacios <= 0){
            this.wait();
        }
        cantEspacios--;
        maxPasajeros--;
        System.out.println("Se subió un pasajero." +Thread.currentThread().getName()+" Cantidad de espacios disponibles: "+cantEspacios+" p: "+maxPasajeros +" a: "+ maxAutos);
        if (cantEspacios == 0 || (maxAutos == 0 && maxPasajeros == 0)) {
            enViaje = true;
            this.notifyAll();
        }
        this.wait();
    }
    
    public synchronized void subirAuto() throws InterruptedException{
        while(cantEspacios < 4){
            this.wait();
        }
        cantEspacios = cantEspacios - 4;
        maxAutos--;
        if (cantEspacios == 0 || (maxAutos == 0 && maxPasajeros == 0)) {
            enViaje = true;
            this.notifyAll();
        }
        System.out.println("Se subió un auto." +Thread.currentThread().getName()+" Cantidad de espacios disponibles: "+cantEspacios+" p: "+maxPasajeros +" a: "+ maxAutos);
        this.wait();
    }
    
    public synchronized void bajarPasajero() throws InterruptedException{
        cantEspacios++;
    }
    
    public synchronized void bajarAuto() throws InterruptedException{
        cantEspacios = cantEspacios + 4;
    }
    
    public synchronized boolean enViaje(){
        return enViaje;
    }
    
    public synchronized void chequeo() throws InterruptedException{
        while(!enViaje){
            this.wait();
        }
        System.out.println("Realizando viaje...");
        Thread.sleep(1000);
        System.out.println("Se terminó el viaje...");
        enViaje = false;
        cantEspacios = 40;
        this.notifyAll();
    }
    
}
