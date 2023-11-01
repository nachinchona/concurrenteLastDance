package TP7.ej1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona extends Thread {

    private boolean tipo;
    private Sala sala;

    public Persona(int id, boolean tipo, Sala sala) {
        this.setName(Integer.toString(id));
        this.sala = sala;
        this.tipo = tipo;
    }

    public void run() {
        if (tipo) {
            sala.entrarSalaJubilado();
        } else {
            sala.entrarSala();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        sala.salirSala();
    }
}
