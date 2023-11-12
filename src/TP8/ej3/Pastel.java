package TP8.ej3;

public class Pastel {

    private char tipo;
    private int peso;

    public Pastel(char tipo) {
        this.tipo = tipo;
        peso = switch (tipo) {
            case 'A' -> 250;
            case 'B' -> 175;
            case 'C' -> 120;
            default -> 120;
        };
    }

    public int getPeso() {
        return peso;
    }
}
