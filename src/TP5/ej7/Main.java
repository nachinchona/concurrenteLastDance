package TP5.ej7;

/*
En el parque acuático ?Naturaleza Plena? hay un hermoso mirador al que se accede por
una escalera natural que soporta X cantidad de personas, cada escalón esta ocupado por
una persona. El Mirador tiene 2 toboganes acuáticos para descender. Una vez arriba los
visitantes deben esperar a que el encargado del mirador los habilite a utilizar uno de los
toboganes. El encargado es quién decide por qué tobogán baja cada visitante.
Tenga en cuenta que un tobogán está habilitado sólo cuando no hay ningún visitante
bajando por él
*/

public class Main {
    public static void main(String[] args){
        Parque nationalPark = new Parque();
        Encargado gordo = new Encargado("sanchez", nationalPark);
        Visitante[] publico = new Visitante[10];
        gordo.start();
        for (int i = 0; i < 10; i++) {
            publico[i] = new Visitante(Integer.toString(i), nationalPark);
            publico[i].start();
        }
    }
}
