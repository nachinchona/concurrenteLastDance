package Parcial2021.ej1N;

import java.time.Duration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaestroPizzero extends Thread {

    private boolean tipo;
    private Mostrador mostrador;
    private int nombre;
    private Random r = new Random();

    public MaestroPizzero(int nombre, boolean tipo, Mostrador mostrador) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.mostrador = mostrador;
    }

    public void run() {
        while (true) {
            try {
                mostrador.tomarPedido(tipo);
                System.out.println("Pizzero "+nombre + " preparando pedido " + (tipo ? "vegano" : "napolitano"));
                Thread.sleep(r.nextInt(500, 1000));
                System.out.println("Pizzero "+nombre + " completó pedido " + (tipo ? "vegano" : "napolitano"));
                mostrador.completarPedido();
            } catch (InterruptedException ex) {
            }
        }
    }
}
