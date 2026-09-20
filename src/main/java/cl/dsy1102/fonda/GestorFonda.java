package cl.dsy1102.fonda;

import java.util.ArrayList;
import java.util.List;

public class GestorFonda {
    private List<Bebida> bebidas;

    public GestorFonda() {
        this.bebidas = new ArrayList<>();
    }

    public void registrarBebida(Bebida bebida) {
        if (bebida != null) {
            this.bebidas.add(bebida);
            System.out.println("Bebida: " + bebida.getNombre() + " incorporada correctamente.");
        }
    }

    public List<Bebida> buscarPorNombre(String nombre) {
        List<Bebida> encontradas = new ArrayList<>();

        for (Bebida b : this.bebidas) {
            if (b.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                encontradas.add(b);
            }
        }
        return encontradas;
    }

    public void vender(String nombre, int unidades) {
        for (Bebida b : this.bebidas) {
            if (b.getNombre().equalsIgnoreCase(nombre)) {


                if (b instanceof ConsumoResponsable) {
                    ConsumoResponsable cr = (ConsumoResponsable) b;

                    if (cr.tieneVentaRestringida()) {
                        System.out.println("Venta rechazada: La bebida tiene la venta restringida.");
                        return;
                    }

                    if (cr.superaLimite(unidades)) {
                        System.out.println("Venta rechazada: Supera la cantidad máxima por persona.");
                        return;
                    }
                }


                if (b.getStock() < unidades) {
                    System.out.println("Venta rechazada: Stock insuficiente. Disponible: " + b.getStock());
                    return;
                }


                b.setStock(b.getStock() - unidades);
                double total = b.calcularPrecio() * unidades;
                System.out.println("Venta exitosa de " + unidades + " unidades de " + b.getNombre() + ". Total a pagar: $" + total);
                return;
            }
        }


        System.out.println("La bebida '" + nombre + "' no existe en el sistema.");
    }

    public List<Bebida> obtenerTodas() {
        return this.bebidas;
    }
}