package TP8.ej2;

public class Observatorio {

    private int cantActual = 0;
    private final int CAPACIDAD_MAX = 50;
    private final int CAPACIDAD_MIN = 30;
    private int capacidadActual = 50;
    private int cantDiscapacitadosActual = 0;
    private int cantPersonalActual = 0;
    private boolean hayInvestigador = false;

    public synchronized void entrar() throws InterruptedException {
        while (cantActual == capacidadActual || cantPersonalActual > 0 || hayInvestigador) {
            this.wait();
        }
        cantActual++;
        System.out.println("Persona " + Thread.currentThread().getName() + " entró al observatorio. " + imprimirEstado());
    }

    public synchronized void entrarDiscapacitado() throws InterruptedException {
        while (cantActual == CAPACIDAD_MIN || cantPersonalActual > 0 || hayInvestigador) {
            this.wait();
        }
        capacidadActual = CAPACIDAD_MIN;
        cantActual++;
        this.cantDiscapacitadosActual++;
        System.out.println("Persona discapacitada" + Thread.currentThread().getName() + " entró al observatorio. " + imprimirEstado());
    }

    public synchronized void salir(){
        cantActual--;
        System.out.println("Persona " + Thread.currentThread().getName() + " salió del observatorio. " + imprimirEstado());
        this.notifyAll();
    }
    
    public synchronized void salirDiscapacitado(){
        cantActual--;
        this.cantDiscapacitadosActual--;
        if (this.cantDiscapacitadosActual == 0) {
            capacidadActual = CAPACIDAD_MAX;
        }
        System.out.println("Persona discapacitada" + Thread.currentThread().getName() + " salió del observatorio. " + imprimirEstado());
        this.notifyAll();
    }
    
    public synchronized void mantener() throws InterruptedException{
        while(cantActual > 0 || hayInvestigador){
            this.wait();
        }
        this.cantPersonalActual++;
        System.out.println("Personal" + Thread.currentThread().getName() + " entró a mantener. Cant. personal: " + this.cantPersonalActual);
    }
    
    public synchronized void salirPersonal(){
        this.cantPersonalActual--;
        System.out.println("Personal" + Thread.currentThread().getName() + " dejó de mantener. Cant. personal: " + this.cantPersonalActual);
        this.notifyAll();
    }
    
    public synchronized void investigar() throws InterruptedException{
        while(cantActual > 0 || this.cantPersonalActual > 0 || hayInvestigador){
            this.wait();
        }
        hayInvestigador = true;
        System.out.println("Investigador "+Thread.currentThread().getName()+" entró a investigar. Hay investigador? "+hayInvestigador);
    }
    
    public synchronized void salirInvestigador(){
        hayInvestigador = false;
        System.out.println("Investigador "+Thread.currentThread().getName()+" dejó de investigar. Hay investigador? "+hayInvestigador);
        this.notifyAll();
    }
    
    public String imprimirEstado() {
        return "Capacidad actual: " + capacidadActual + " | Cant. actual: " + cantActual;
    }
}
