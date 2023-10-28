package TP5.ej7;

import java.util.Random;

public class Encargado extends Thread {

    private Parque parque;
    private Random r;

    public Encargado(String nombre, Parque parque) {
        r = new Random();
        this.parque = parque;
        this.setName(nombre);
    }

    @Override
    public void run() {
        while (true) {
            boolean tobAsignado = r.nextBoolean();
            parque.asignarTobogan(tobAsignado);
            System.out.println("Asigné tobogan " + (tobAsignado ? "1" : "2"));
            
        }
    }
}
