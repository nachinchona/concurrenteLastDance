package Parcial2021.ej1N;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneradorPedidos extends Thread {

    private Random r = new Random();
    private Mostrador mostrador;

    public GeneradorPedidos(Mostrador mostrador) {
        this.mostrador = mostrador;
    }

    public void run() {
        while (true) {
            try {
                mostrador.nuevoPedido(r.nextBoolean());
                Thread.sleep(r.nextInt(200, 1000));
            } catch (InterruptedException ex) {
            }
        }
    }
}
