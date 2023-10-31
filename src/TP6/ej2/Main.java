package TP6.ej2;

public class Main {
    public static void main(String[] args){
        Sala sala = new Sala();
        int cantEstudiantes = 20;
        Estudiante[] colEst = new Estudiante[cantEstudiantes];
        for (int i = 0; i < cantEstudiantes; i++) {
            colEst[i] = new Estudiante(Integer.toString(i), sala);
            colEst[i].start();
        }
    }
}
