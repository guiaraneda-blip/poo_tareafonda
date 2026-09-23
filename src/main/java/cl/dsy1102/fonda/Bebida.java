package cl.dsy1102.fonda;

public abstract class Bebida {
   protected String nombre;
   protected int volumenML;
   protected int stock;


    public Bebida(String nombre, int volumenML, int stock){
        this.nombre = nombre;
        this.volumenML = volumenML;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio ni ser nulo ");
        } else {
            this.nombre = nombre;
        }
    }

    public int getVolumenML() {
        return volumenML;
    }

    public void setVolumenML(int volumenML) {
        if (volumenML < 100 && volumenML > 3.000){
            throw new IllegalArgumentException("Los valores de ML no pueden ser menores a 100ML o mayores a 3000ML");
        } else {
            this.volumenML = volumenML;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock <= 0){
            throw new IllegalArgumentException("El valor no puede ser menor o igual a 0");
        } else {
            this.stock = stock;
        }
    }

    public abstract double calcularPrecio();

    public abstract String obtenerDetalle();

    @Override
    public String toString(){
        return "Nombre: " + nombre + " Volumen en ML: " + volumenML;
    }




}
