package TP8.ej3;

import java.util.concurrent.Semaphore;

public class Caja {

    private final int pesoMaximo = 1000;
    private int pesoActual = 0;
    private boolean hayCaja = true;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore mutex2 = new Semaphore(1);
    private Semaphore brazo = new Semaphore(0);
    private Semaphore empaquetadora = new Semaphore(0);

    public void soltarPastel(int unPeso) throws InterruptedException {
        pesoActual = pesoActual + unPeso;
        System.out.println("Empaquetadora "+Thread.currentThread().getName()+" soltó un pastel en la caja. Peso caja: "+pesoActual);
        mutex.release();
    }

    public void retirarCaja() throws InterruptedException {
        brazo.acquire();
        mutex2.acquire();
        hayCaja = false;
        System.out.println("Brazo quitó la caja. Peso caja: " + pesoActual);
        mutex2.release();
        brazo.release();
    }

    public void reponerCaja() throws InterruptedException {
        brazo.acquire();
        mutex2.acquire();
        pesoActual = 0;
        hayCaja = true;
        System.out.println("Brazo repuso la caja.");
        empaquetadora.release();
        mutex2.release();
    }

    public void avisarBrazo() {
        System.out.println("Brazo fue avisado para retirar la caja.");
        brazo.release();
    }

    public void adquirirMutex() throws InterruptedException {
        mutex.acquire();
    }

    public void liberarMutex() {
        mutex.release();
    }

    public boolean sePuedeAgregar(int unPeso) {
        return ((pesoActual + unPeso) < pesoMaximo);
    }

    public void esperarAviso() throws InterruptedException {
        this.empaquetadora.acquire();
        System.out.println("Empaquetadora recibió el aviso CAJA REPUESTA");
    }

    public void avisarEmpaquetadora() {
        this.empaquetadora.release();
    }
}
