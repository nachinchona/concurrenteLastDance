package TP7.ej1;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        int cantPersonas = 50;
        int cantJubilados = 0;
        int cantNoJubilados;
        Persona[] personas = new Persona[cantPersonas];
        Random r = new Random();
        Sala sala = new Sala(cantPersonas);
        Medidor medidor = new Medidor(sala);
        for (int i = 0; i < cantPersonas; i++) {
            boolean aux = r.nextBoolean();
            personas[i] = new Persona(i, aux, sala);
            if (aux) {
                cantJubilados++;
            }
        }
        cantNoJubilados = cantPersonas - cantJubilados;
        System.out.println("Cant. jubilados: "+cantJubilados);
        System.out.println("Cant. no jubilados: "+cantNoJubilados);
        medidor.start();
        for (int i = 0; i < cantPersonas; i++) {
            personas[i].start();
        }
    }
}
