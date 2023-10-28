package TP6.ej4;

import java.util.LinkedList;
import java.util.Queue;

public class Almacen {

    private int cantProductos = 0;
    private int MAX = 5;
    private Queue<Integer> buffer = new LinkedList<>();

    public Almacen() {

    }

    public synchronized void poner(Integer num) {
        while (cantProductos == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        cantProductos++;
        buffer.add(num);
        this.notify();
    }

    public synchronized Integer sacar() {
        int producto;
        while (cantProductos == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        cantProductos--;
        producto = buffer.remove();
        this.notify();
        return producto;
    }
}
