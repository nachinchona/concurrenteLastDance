package TP8.ej3;

import java.util.Random;

public class Horno extends Thread {

    char tipo;
    Mostrador buffer;
    Random r = new Random();

    public Horno(char tipo, Mostrador buffer) {
        this.tipo = tipo;
        this.buffer = buffer;
    }

    public Pastel hornear() {
        return new Pastel(tipo);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(r.nextInt(1000, 2000));
                //System.out.println("Horno " + tipo + " colocó un pastel en el mostrador.");
                buffer.poner(hornear());
            } catch (InterruptedException e) {
            }
        }
    }
}
