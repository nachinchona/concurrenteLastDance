package TP8.ej3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Mostrador {

    private Queue<Pastel> buffer = new LinkedList<>();
    private Semaphore mutex = new Semaphore(1);
    private Semaphore pasteles = new Semaphore(0);

    public void poner(Pastel pastel) throws InterruptedException {
        mutex.acquire();
        buffer.add(pastel);
        pasteles.release();
        mutex.release();
    }

    public Pastel tomarPastel() throws InterruptedException {
        pasteles.acquire();
        mutex.acquire();
        Pastel aux = buffer.remove();
        System.out.println("Empaq "+Thread.currentThread().getName()+" agarró pastel de peso "+aux.getPeso());
        mutex.release();
        return aux;
    }
}
