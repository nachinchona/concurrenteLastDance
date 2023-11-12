package Parcial2021.ej1N;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        Mostrador mostrador = new Mostrador();
        GeneradorPedidos g = new GeneradorPedidos(mostrador);
        int cantPizzeros = 2;
        int cantV = 0, cantN = 0;
        int cantRepartidores = 2;
        MaestroPizzero[] pizzeros = new MaestroPizzero[cantPizzeros];
        Repartidor[] repartidores = new Repartidor[cantRepartidores];
        for (int i = 0; i < Math.max(cantPizzeros, cantRepartidores); i++) {
            if (i < cantPizzeros) {
                boolean aux = r.nextBoolean();
                pizzeros[i] = new MaestroPizzero(i, aux, mostrador);
                if (aux) {
                    cantV++;
                }else{
                    cantN++;
                }
            }
            if (cantRepartidores > i) {
                repartidores[i] = new Repartidor(i, mostrador);
            }
        }
        System.out.println("PIZZEROS VEGANOS: "+cantV);
        System.out.println("PIZZEROS NAPO: "+cantN);
        g.start();
        for (int i = 0; i < Math.max(cantPizzeros, cantRepartidores); i++) {
            if (i < cantPizzeros) {
                pizzeros[i].start();
            }
            if (cantRepartidores > i) {
                repartidores[i].start();
            }
        }
    }
}
