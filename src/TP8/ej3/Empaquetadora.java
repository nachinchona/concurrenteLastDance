package TP8.ej3;

public class Empaquetadora extends Thread {

    private Caja caja;
    private Mostrador buffer;

    public Empaquetadora(int i, Caja caja, Mostrador buffer){
        this.setName(Integer.toString(i));
        this.caja = caja;
        this.buffer = buffer;
    }
    
    public void run() {
        while (true) {
            try {
                Pastel aux = buffer.tomarPastel();
                int peso = aux.getPeso();
                caja.adquirirMutex();
                if (caja.sePuedeAgregar(peso)) {
                    caja.soltarPastel(peso);
                } else {
                    caja.avisarBrazo();
                    caja.esperarAviso();
                    caja.soltarPastel(peso);
                }
                Thread.sleep(200);
            } catch (InterruptedException ex) {
            }
        }
    }
}
