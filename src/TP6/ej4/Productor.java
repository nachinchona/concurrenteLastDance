package TP6.ej4;

import java.util.Random;

public class Productor extends Thread {

    private Random r = new Random();
    private Almacen almacen;
    private final int TIEMPO = 500;

    public Productor(String nombre, Almacen almacen) {
        this.setName(nombre);
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            int producto = r.nextInt(300);
            almacen.poner(producto);
            System.out.println("El productor " + this.getName() + " agregó el producto: " + producto);
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {
            }
        }
    }
}
