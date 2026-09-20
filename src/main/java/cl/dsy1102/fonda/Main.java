package cl.dsy1102.fonda;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        GestorFonda gestor = new GestorFonda();

        System.out.println("=== 1. REGISTRO DE BEBIDAS ===");

        BebidaAlcoholica piscoSour = new BebidaAlcoholica("Pisco Sour", 350, 10, 15.0, true, false);
        BebidaAlcoholica chicha = new BebidaAlcoholica("Chicha", 500, 8, 12.0, true, false);
        BebidaSinAlcohol mote = new BebidaSinAlcohol("Mote con Huesillo", 500, 15, 85);

        chicha.restringirVenta();

        gestor.registrarBebida(piscoSour);
        gestor.registrarBebida(chicha);
        gestor.registrarBebida(mote);

        System.out.println("\n=== 2. PRUEBAS DE VENTA EN ORDEN ===");


        gestor.vender("Pisco Sour", 2);


        gestor.vender("Pisco Sour", 5);
        gestor.vender("Chicha", 1);
        gestor.vender("Mote con Huesillo", 6);

        System.out.println("\n=== 3. BÚSQUEDA POR NOMBRE ===");


        List<Bebida> busqueda = gestor.buscarPorNombre("Pisco");
        for (Bebida b : busqueda) {
            System.out.println(b.obtenerDetalle());
        }

        System.out.println("\n=== 4. LISTADO GENERAL===");


        for (Bebida b : gestor.obtenerTodas()) {
            System.out.println(b);
        }
    }
}