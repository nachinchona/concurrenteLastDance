package Parcial2021.ej2;

public class Main {

    public static void main(String[] args) {
        int cantPersonas = 60;
        Entrada entrada = new Entrada();
        Persona[] personas = new Persona[cantPersonas];
        Control control = new Control(entrada);
        control.start();
        for (int i = 0; i < cantPersonas; i++) {
            personas[i] = new Persona(i, entrada);
            personas[i].start();
        }
    }
}
