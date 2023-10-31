package TP6.ej7;

public class Control extends Thread {

    private Ferry ferry;

    public Control(Ferry ferry) {
        this.ferry = ferry;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ferry.chequeo();
            } catch (InterruptedException ex) {
            }
        }
    }
}
