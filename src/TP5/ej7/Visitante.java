package TP5.ej7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Visitante extends Thread {

    private Parque parque;
    private boolean tobAsignado;

    public Visitante(String nombre, Parque parque) {
        this.parque = parque;
        this.setName(nombre);
    }

    @Override
    public void run() {
        parque.ocuparEscalon();
        System.out.println("Visitante " + this.getName() + " entró a la escalera");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        parque.desocuparEscalon();
        System.out.println("Visitante " + this.getName() + " dejó la escalera");
        parque.avisarEncargado();
        System.out.println("Visitante " + this.getName() + " avisó a encargado");
        tobAsignado = parque.esperarAviso();
        parque.usarToboban(tobAsignado);
        System.out.println("Visitante " + this.getName() + " se subio al tobogan " + (tobAsignado ? "1" : "2"));
        try {
            Thread.sleep(600);
        } catch (InterruptedException ex) {
        }
        parque.liberarTobogan(tobAsignado);
        System.out.println("Visitante " + this.getName() + " se bajo del tobogan " + (tobAsignado ? "1" : "2"));
        System.out.println("mM?");
    }
}
