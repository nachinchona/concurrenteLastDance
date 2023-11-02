package TP7.ej3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cocina {
    private int cantCarne;
    private int cantVeg;
    private int cantPasta;
    
    //locks
    private Lock lock = new ReentrantLock();
    private Condition hayCarne = lock.newCondition();
    private Condition hayVeg = lock.newCondition();
    private Condition hayPasta = lock.newCondition();
    
    public Cocina(int cantCarne, int cantVeg, int cantPasta){
        this.cantCarne = cantCarne;
        this.cantVeg = cantVeg;
        this.cantPasta = cantPasta;
    }
    
    public void obtenerCarne() throws InterruptedException{
        lock.lock();
        try {
            while(cantCarne == 0){
                System.out.println("Cocinero "+Thread.currentThread().getName()+" espera 1 de carne.");
                hayCarne.await();
            }
            cantCarne--;
            System.out.println("Cocinero "+Thread.currentThread().getName()+" retiró 1 de carne. Cant. actual: "+ cantCarne);
        } finally {
            lock.unlock();
        }
    }
    
    public void obtenerVeg() throws InterruptedException{
        lock.lock();
        try {
            while(cantVeg == 0){
                System.out.println("Cocinero "+Thread.currentThread().getName()+" espera 1 vegetal.");
                hayVeg.await();
            }
            cantVeg--;
            System.out.println("Cocinero "+Thread.currentThread().getName()+" retiró 1 vegetal. Cant. actual: "+ cantVeg);
        } finally {
            lock.unlock();
        }
    }
    
    public void obtenerPasta() throws InterruptedException{
        lock.lock();
        try {
            while(cantPasta == 0){
                System.out.println("Cocinero "+Thread.currentThread().getName()+" espera 1 pasta.");
                hayPasta.await();
            }
            cantPasta--;
            System.out.println("Cocinero "+Thread.currentThread().getName()+" retiró 1 pasta. Cant. actual: "+ cantPasta);
        } finally {
            lock.unlock();
        }
    }
    
    public void reponerCarne(){
        lock.lock();
        try {
            cantCarne++;
            System.out.println("Cocinero "+Thread.currentThread().getName()+" repuso 1 carne. Cant. actual: "+ cantPasta);
            hayCarne.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public void reponerVeg(){
        lock.lock();
        try {
            cantVeg++;
            System.out.println("Cocinero "+Thread.currentThread().getName()+" repuso 1 vegetal. Cant. actual: "+ cantPasta);
            hayVeg.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public void reponerPasta(){
        lock.lock();
        try {
            cantPasta++;
            System.out.println("Cocinero "+Thread.currentThread().getName()+" repuso 1 pasta. Cant. actual: "+ cantPasta);
            hayPasta.signal();
        } finally {
            lock.unlock();
        }
    }
}
