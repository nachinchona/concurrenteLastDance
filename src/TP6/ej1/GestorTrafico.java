package TP6.ej1;

import java.util.LinkedList;
import java.util.Queue;

public class GestorTrafico {
    int cantAutosN;
    int cantAutosS;
    int cantActual;
    //cola para que salgan en orden
    Queue<Integer> colaIds = new LinkedList<>();
    boolean paso; //true N false S
    
    public GestorTrafico(){
        cantActual = 0;
    }
    
    public void setCantidades(int cantAutosN, int cantAutosS){
        this.cantAutosN = cantAutosN;
        this.cantAutosS = cantAutosS;
    }
    
    public synchronized void entrarNorte(String name){
        while(!paso){
            try {
                if (cantActual == 0 || cantAutosS == 0) {
                    System.out.println("Auto "+name+" cambia dirección a "+(paso ? "sur" : "norte"));
                    paso = !paso;
                }else{
                    //System.out.println("Auto "+name+" espera a cambio de dirección. Dir. actual: "+(paso ? "norte" : "sur"));
                    this.wait();
                }
            } catch (InterruptedException ex) {
            }
        }
        colaIds.add(Integer.valueOf(name));
        System.out.println("Auto "+Thread.currentThread().getName()+" entra a la dirección "+ (paso ? "norte" : "sur"));
        cantActual++;
    }
    
    public synchronized void salir(String name){
        while(colaIds.peek() != Integer.valueOf(name)){
            try {
                this.wait();
            } catch (InterruptedException ex) {
            }
        }
        colaIds.remove(Integer.valueOf(name));
        cantActual--;
        System.out.println("Auto "+name+" sale del puente");
        //antes era notify, pero como ahora se puede dormir alguien que necesita salir se podria bloquear
        this.notifyAll();
    }
    
    public synchronized void entrarSur(String name){
        while(paso){
            try {
                if (cantActual == 0 || cantAutosN == 0) {
                    System.out.println("Auto "+name+" cambia dirección a "+(paso ? "sur" : "norte"));
                    paso = !paso;
                }else{
                    //System.out.println("Auto "+name+" espera a cambio de dirección. Dir. actual: "+(paso ? "norte" : "sur"));
                    this.wait();
                }
            } catch (InterruptedException ex) {
            }
        }
        colaIds.add(Integer.valueOf(name));
        System.out.println("Auto "+Thread.currentThread().getName()+" entra a la dirección "+ (paso ? "norte" : "sur"));
        cantActual++;
    }
    
}
