package TP7.ej1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sala {

    //datos
    private final int capacidadMax = 5;
    private final int capacidadMin = 3;
    private int capacidadActual;
    private int cantPersonas = 0;
    private final int tUmbral = 30;
    private int jubiladosEsperando = 0;
    //solo coloco esta cantidad para saber si termino fiumba
    private int cantPersonasAEntrar;
    
    public Sala(int cantPersonasAEntrar){
        this.cantPersonasAEntrar = cantPersonasAEntrar;
    }
    
    //locks
    private Lock lock = new ReentrantLock();
    private Condition hayLugar = lock.newCondition();

    public void entrarSala() {
        lock.lock();
        try {
            while (cantPersonas >= capacidadActual || (jubiladosEsperando > 0 && cantPersonas > 0)) {
                try {
                    hayLugar.await();
                } catch (InterruptedException ex) {
                }
            }
            cantPersonas++;
            System.out.println("Persona con ID: " + Thread.currentThread().getName() + " entró a la sala. Cant. actual: " + cantPersonas);
        } finally {
            lock.unlock();
        }
    }

    public void entrarSalaJubilado() {
        lock.lock();
        try {
            jubiladosEsperando++;
            while (cantPersonas >= capacidadActual) {
                try {
                    hayLugar.await();
                } catch (InterruptedException ex) {
                }
            }
            jubiladosEsperando--;
            cantPersonas++;
            System.out.println("Persona jub. con ID: " + Thread.currentThread().getName() + " entró a la sala. Cant. actual: " + cantPersonas);
        } finally {
            lock.unlock();
        }
    }

    public void salirSala() {
        lock.lock();
        try {
            cantPersonas--;
            cantPersonasAEntrar--;
            System.out.println("Persona con ID: " + Thread.currentThread().getName() + " salió de la sala. Cant. actual: " + cantPersonas);
            hayLugar.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void notificarTemperatura(int temperatura) {
        lock.lock();
        try {
            if (cantPersonasAEntrar == 0) {
                System.out.println("NO QUEDAN MÁS PERSONAS A ENTRAR");
            }
            boolean cambiarCapacidad = temperatura >= tUmbral;
            System.out.println("Aviso: la temperatura de la sala cambió a " + temperatura+". Capacidad máxima: "+(cambiarCapacidad ? capacidadMin : capacidadMax));
            if (cambiarCapacidad) {
                capacidadActual = capacidadMin;
            } else {
                capacidadActual = capacidadMax;
            }
        } finally {
            lock.unlock();
        }
    }
}
