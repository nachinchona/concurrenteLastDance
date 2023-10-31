package TP6.ej1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorTrafico {
    int cantAutosN;
    int cantAutosS;
    int cantActual;
    boolean paso; //true N false S
    
    public GestorTrafico(){
        cantActual = 0;
    }
    
    public void setCantidades(int cantAutosN, int cantAutosS){
        this.cantAutosN = cantAutosN;
        this.cantAutosS = cantAutosS;
    }
    
    public synchronized void entrarNorte(){
        while(!paso){
            try {
                if (cantActual == 0) {
                    System.out.println("Auto "+Thread.currentThread().getName()+" cambia dirección a "+(paso ? "sur" : "norte"));
                    paso = !paso;
                }else{
                    System.out.println("Auto "+Thread.currentThread().getName()+" espera a cambio de dirección. Dir. actual: "+(paso ? "norte" : "sur"));
                    this.wait();
                }
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("Auto "+Thread.currentThread().getName()+" entra a la dirección "+ (paso ? "norte" : "sur"));
        cantActual++;
    }
    
    public synchronized void salir(){
        cantActual--;
        System.out.println("Auto "+Thread.currentThread().getName()+" sale del puente");
        this.notify();
    }
    
    public synchronized void entrarSur(){
        while(paso){
            try {
                if (cantActual == 0) {
                    System.out.println("Auto "+Thread.currentThread().getName()+" cambia dirección a "+(paso ? "sur" : "norte"));
                    paso = !paso;
                }else{
                    System.out.println("Auto "+Thread.currentThread().getName()+" espera a cambio de dirección. Dir. actual: "+(paso ? "norte" : "sur"));
                    this.wait();
                }
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("Auto "+Thread.currentThread().getName()+" entra a la dirección "+ (paso ? "norte" : "sur"));
        cantActual++;
    }
    
}
