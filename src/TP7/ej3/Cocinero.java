package TP7.ej3;

import java.util.Random;

public class Cocinero extends Thread{
    private Random r;
    private Cocina cocina;
    char tipo;
    
    public Cocinero(int id, char tipo, Cocina cocina){
        this.r = new Random();
        this.setName(Integer.toString(id));
        this.tipo = tipo;
        this.cocina = cocina;
    }
    
    @Override
    public void run(){
        switch(tipo){
            case 'C' ->  {
            try {
                cocina.obtenerCarne();
                Thread.sleep(r.nextInt(500, 1400));
            } catch (InterruptedException ex) {
            }
                cocina.reponerCarne();
            }
            case 'V' ->  {
            try {
                cocina.obtenerVeg();
                Thread.sleep(r.nextInt(500, 1400));
            } catch (InterruptedException ex) {
            }
                cocina.reponerVeg();
            }
            case 'P' ->  {
            try {
                cocina.obtenerPasta();
                Thread.sleep(r.nextInt(500, 1400));
            } catch (InterruptedException ex) {
            }
                cocina.reponerPasta();
            }
        }
    }
}
