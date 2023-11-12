package TP8.ej3;

public class Main {

    public static void main(String[] args) {
        Mostrador mos = new Mostrador();

        Horno hornoA = new Horno('A', mos);
        Horno hornoB = new Horno('B', mos);
        Horno hornoC = new Horno('C', mos);

        Caja caja = new Caja();

        int cantEmpaq = 2;
        Empaquetadora[] emp = new Empaquetadora[cantEmpaq];

        Brazo brazo = new Brazo(caja);

        for (int i = 0; i < cantEmpaq; i++) {
            emp[i] = new Empaquetadora(i, caja, mos);
        }

        brazo.start();

        hornoA.start();
        hornoB.start();
        hornoC.start();
        
        for (int i = 0; i < cantEmpaq; i++) {
            emp[i].start();
        }
    }
}
