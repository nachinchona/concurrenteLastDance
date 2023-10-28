package TP6.ej4;

public class Main {
    public static void main(String[] args){
        Almacen donPepe = new Almacen();
        Productor[] productores = new Productor[3];
        Consumidor[] consumidores = new Consumidor[3];
        for (int i = 0; i < 3; i++) {
            productores[i] = new Productor(Integer.toString(i), donPepe);
            consumidores[i] = new Consumidor(Integer.toString(i), donPepe);
            productores[i].start();
            consumidores[i].start();
        }
        
    }
}
