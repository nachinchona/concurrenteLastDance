package TP6.ej7;

public class Main {

    public static void main(String[] args) {
        Ferry fer = new Ferry(28, 6);
        int cantPasajeros = 28;
        int cantAutos = 6;
        Pasajero[] colPas = new Pasajero[cantPasajeros];
        Auto[] colAutos = new Auto[cantAutos];
        Control control = new Control(fer);
        control.start();
        for (int i = 0; i < 28; i++) {
            if (i < 6) {
                colAutos[i] = new Auto(Integer.toString(i), fer);
                colAutos[i].start();
            }
            colPas[i] = new Pasajero(Integer.toString(i), fer);
            colPas[i].start();
        }
    }
}
