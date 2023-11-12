package TP8.ej2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Observatorio obs = new Observatorio();
        int cantPersonas = 100;
        int cantPersonal = 6;
        int cantInvestigadores = 10;
        Persona[] personas = new Persona[cantPersonas];
        Personal[] personal = new Personal[cantPersonal];
        int cantD = 0;
        Investigador[] investigadores = new Investigador[cantInvestigadores];
        for (int i = 0; i < cantPersonas; i++) {
            if (i < cantInvestigadores) {
                investigadores[i] = new Investigador(i, obs);
                investigadores[i].start();
            }
            if (i < cantPersonal) {
                personal[i] = new Personal(i, obs);
                personal[i].start();
            }
            if ((i+1)%25==0) {
                cantD++;
                personas[i] = new Persona(i, true, obs);
            }else{
                personas[i] = new Persona(i, false, obs);
            }
            personas[i].start();
        }
        System.out.println("Cant D: "+cantD);
    }
}
