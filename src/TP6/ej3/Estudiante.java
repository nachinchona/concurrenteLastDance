package TP6.ej3;

public class Estudiante extends Thread{
    private Sala sala;
    
    public Estudiante(String name, Sala sala){
        this.sala = sala;
        this.setName(name);
    }
    
    @Override
    public void run(){
        try {
            sala.ocuparMesa();
        } catch (InterruptedException ex) {
        }
        System.out.println("Estudiante "+this.getName()+" ocupó una mesa. ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        System.out.println("Estudiante "+this.getName()+" dejó una mesa. ");
        sala.dejarMesa();
    }
}
