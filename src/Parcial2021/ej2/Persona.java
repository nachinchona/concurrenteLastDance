package Parcial2021.ej2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona extends Thread {
    private Random r = new Random();
    private Entrada entrada;
    private int pos;
    
    public Persona(int i, Entrada entrada) {
        this.setName("Persona "+i);
        this.entrada = entrada;
    }
    
    public void run(){
        try {
            Thread.sleep(r.nextInt(200, 20000));
            boolean aux = r.nextBoolean();
            pos = entrada.getPos(aux);
            if (aux) {
                entrada.entrarFila1(pos);
            }else{
                entrada.entrarFila2(pos);
            }
        } catch (InterruptedException ex) {
        }
    }
}
