package TP5.ej7;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parque {

    private Semaphore escalones = new Semaphore(3);
    private Semaphore tobogan1 = new Semaphore(1);
    private Semaphore tobogan2 = new Semaphore(1);
    private Semaphore encargado = new Semaphore(0);
    private Semaphore avisarVis = new Semaphore(0);
    private boolean asignado;

    public void avisarEncargado() {
        encargado.release();
    }

    public boolean esperarAviso() {
        try {
            avisarVis.acquire();
        } catch (InterruptedException ex) {
        }
        return asignado;
    }

    public void avisarVisitante(boolean valor) {
        avisarVis.release();
        asignado = valor;
    }

    public void asignarTobogan(boolean valor) {
        try {
            encargado.acquire();
        } catch (InterruptedException ex) {
        }
        avisarVisitante(valor);
    }

    public void usarToboban(boolean valor) {
        if (valor) {
            try {
                tobogan1.acquire();
            } catch (InterruptedException ex) {
            }
        } else {
            try {
                tobogan2.acquire();
            } catch (InterruptedException ex) {
            }
        }
    }

    public boolean liberarTobogan(boolean valor) {
        if (valor) {
            tobogan1.release();
        } else {
            tobogan2.release();
        }
        return valor;
    }

    public void ocuparEscalon() {
        try {
            escalones.acquire();
        } catch (InterruptedException ex) {
        }
    }

    public void desocuparEscalon() {
        escalones.release();
    }
}
