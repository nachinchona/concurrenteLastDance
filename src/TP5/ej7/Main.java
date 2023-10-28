package TP5.ej7;

/*
En el parque acu�tico ?Naturaleza Plena? hay un hermoso mirador al que se accede por
una escalera natural que soporta X cantidad de personas, cada escal�n esta ocupado por
una persona. El Mirador tiene 2 toboganes acu�ticos para descender. Una vez arriba los
visitantes deben esperar a que el encargado del mirador los habilite a utilizar uno de los
toboganes. El encargado es qui�n decide por qu� tobog�n baja cada visitante.
Tenga en cuenta que un tobog�n est� habilitado s�lo cuando no hay ning�n visitante
bajando por �l
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
