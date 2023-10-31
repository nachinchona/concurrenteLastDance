package TP6.ej1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Auto extends Thread{
    private boolean paso;
    private GestorTrafico puente;
    
    public Auto(String name, boolean paso, GestorTrafico puente){
        this.paso = paso;
        this.setName(name);
        this.puente = puente;
    }
    
    public void run(){
        if (paso) {
            puente.entrarNorte(getName());
        }else{
            puente.entrarSur(getName());
        }
        
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
        }
        puente.salir(getName());
        
    }
}
