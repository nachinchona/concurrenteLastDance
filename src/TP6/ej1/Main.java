package TP6.ej1;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random r = new Random();
        GestorTrafico puente = new GestorTrafico();
        int cantAutos = 20;
        int cantN = 0;
        int cantS = 0;
        Auto[] autos = new Auto[cantAutos];
        for (int i = 0; i < cantAutos; i++) {
            boolean aux = r.nextBoolean();
            if (aux) {
                cantN++;
            }else{
                cantS++;
            }
            autos[i] = new Auto(Integer.toString(i), aux, puente);
        }
        puente.setCantidades(cantN, cantS);
        System.out.println("Cantidad de autos que pasan por Norte: "+cantN);
        System.out.println("Cantidad de autos que pasan por Sur: "+cantS);
        for (int i = 0; i < cantAutos; i++) {
            autos[i].start();
        }
        
    }
}
