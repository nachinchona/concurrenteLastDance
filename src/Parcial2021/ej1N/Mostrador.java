package Parcial2021.ej1N;

import java.util.concurrent.Semaphore;

public class Mostrador {

    private Semaphore pedidosVeg = new Semaphore(0); //true
    private Semaphore pedidosNapo = new Semaphore(0); //false
    private Semaphore pedidosCompletados = new Semaphore(0);

    public void nuevoPedido(boolean tipo) {
        if (tipo) {
            pedidosVeg.release();
            System.out.println("SE GENERÓ NUEVO PEDIDO VEGANA. PEDIDOS V: " + pedidosVeg.availablePermits());

        } else {
            pedidosNapo.release();
            System.out.println("SE GENERÓ NUEVO PEDIDO NAPO. PEDIDOS N: " + pedidosNapo.availablePermits());
        }
    }

    public void tomarPedido(boolean tipo) throws InterruptedException {
        if (tipo) {
            pedidosVeg.acquire();
        } else {
            pedidosNapo.acquire();
        }
    }

    public void completarPedido() {
        pedidosCompletados.release();
    }

    public void tomarPedidoListo() throws InterruptedException {
        pedidosCompletados.acquire();
    }
}
