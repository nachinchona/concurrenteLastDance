package TP7.ej3;

import java.util.Random;

public class Main {
    public static void main (String[] args){
        Random r = new Random();
        String tipos = "CVP";
        int cantCocineros = 40;
        int cantC = 0;
        int cantV = 0;
        int cantP = 0;
        Cocinero[] cocineros = new Cocinero[cantCocineros];
        Cocina cocina = new Cocina(10,10,10);
        for (int i = 0; i < cantCocineros; i++) {
            char aux = tipos.charAt(r.nextInt(0, 3));
            cocineros[i] = new Cocinero(i, aux, cocina);
            switch (aux) {
                case 'C' -> cantC++;
                case 'V' -> cantV++;
                case 'P' -> cantP++;
                default -> {
                }
            }
        }
        System.out.println("Cant. C: "+cantC);
        System.out.println("Cant. V: "+cantV);
        System.out.println("Cant. P: "+cantP);
        for (int i = 0; i < cantCocineros; i++) {
            cocineros[i].start();
        }
    }
}
