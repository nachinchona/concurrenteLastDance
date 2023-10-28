package TP6.ej4;

import java.util.Random;

public class Consumidor extends Thread {

    private Random r = new Random();
    private Almacen almacen;
    private final int TIEMPO = 500;

    public Consumidor(String nombre, Almacen almacen) {
        this.setName(nombre);
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("El consumidor " + this.getName() + " quitó el producto: " + almacen.sacar());
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {
            }
        }
    }
}
