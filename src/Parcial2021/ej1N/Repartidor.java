package Parcial2021.ej1N;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repartidor extends Thread{
    private Mostrador mostrador;
    private Random r = new Random();
    private int viajes = 0;
    private int MAX_VIAJES = 10;
    private int nombre;
    
    public Repartidor(int nombre, Mostrador mostrador){
        this.mostrador = mostrador;
        this.nombre = nombre;
    }
    
    public void run(){
        while(true){
            try {
                mostrador.tomarPedidoListo();
                System.out.println("Repartidor "+nombre+" tomó un pedido.");
                viajes++;
                Thread.sleep(r.nextInt(500, 2000));
                System.out.println("Repartidor "+nombre+" terminó de entregar un pedido.");
                if (viajes % MAX_VIAJES == 0) {
                    System.out.println("Repartidor "+nombre+" está descansando.");
                    Thread.sleep(r.nextInt(500, 1000));
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
