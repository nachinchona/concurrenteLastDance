package Parcial2021.ej2;

import java.time.Duration;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Entrada {

    private Lock lock = new ReentrantLock(true);
    private Condition fila1 = lock.newCondition();
    private Condition fila2 = lock.newCondition();
    private Condition esperaPareja1 = lock.newCondition();
    private Condition esperaPareja2 = lock.newCondition();
    private Condition control = lock.newCondition();
    private String p1 = null;
    private String p2 = null;
    private int cantFila1 = 0;
    private int cantFila2 = 0;
    private int posActual = 0;
    private int parejas = 0;

    public void entrarFila1(int pos) throws InterruptedException {
        lock.lock();
        try {
            while (pos != posActual) {
                System.out.println(Thread.currentThread().getName() + " en pos " + pos + " y fila 1 espera a llegar a la entrada. POS: " + pos);
                fila1.await();
            }
            p1 = Thread.currentThread().getName() + " F1--Pos: " + pos;
            System.out.println(p1 + " llego a la entrada");
            if (p2 == null) {
                System.out.println(Thread.currentThread().getName() + " espera una pareja en fila 1");
                esperaPareja1.await();
            }
            parejas++;
            control.signal();
            esperaPareja2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void entrarFila2(int pos) throws InterruptedException {
        lock.lock();
        try {
            while (pos != posActual) {
                System.out.println(Thread.currentThread().getName() + " en pos " + pos + " y fila 2 espera a llegar a la entrada. POS: " + pos);
                fila2.await();
            }
            p2 = Thread.currentThread().getName() + " F2--Pos: " + pos;
            System.out.println(p2 + " llego a la entrada");
            if (p1 == null) {
                System.out.println(Thread.currentThread().getName() + " espera una pareja en fila 2");
                esperaPareja2.await();
            }
            parejas++;
            control.signal();
            esperaPareja1.signal();
        } finally {
            lock.unlock();
        }
    }

    public void controlar() throws InterruptedException {
        lock.lock();
        try {
            while (parejas < 2) {
                control.await();
            }
            System.out.println(p1 + " y " + p2 + " entraron a bailar");
            p1 = null;
            p2 = null;
            parejas = 0;
            posActual++;
            System.out.println("================== SE AUMENTÓ LA POSICIÓN A " + posActual + " ===========================");
            fila1.signal();
            fila2.signal();
        } finally {
            lock.unlock();
        }
    }

    public int getPos(boolean fila) {
        lock.lock();
        try {
            if (fila) {
                cantFila1++;
                return (cantFila1 - 1);
            } else {
                cantFila2++;
                return (cantFila2 - 1);
            }
        } finally {
            lock.unlock();
        }
    }
}
