package cl.dsy1102.fonda;

public class BebidaSinAlcohol extends Bebida{

    int azucarPorLitro;

    public BebidaSinAlcohol(String nombre, int volumenML, int stock, int azucarPorLitro){
        super(nombre, volumenML, stock);
        this.azucarPorLitro = azucarPorLitro;
    }

    public int getAzucarPorLitro() {
        return azucarPorLitro;
    }

    public void setAzucarPorLitro(int azucarPorLitro) {
        if (azucarPorLitro < 0){
            throw new IllegalArgumentException("El valor del azucar no puede ser menor a 0");
        } else {
            this.azucarPorLitro = azucarPorLitro;
        }
    }

    @Override
    public double calcularPrecio() {
        if (azucarPorLitro >= 80){
            return 2000 * 1.10;
        } else {
            return 2000;
        }
    }

    @Override
    public String obtenerDetalle() {
        return "===FICHA BEBIDA SIN ALCOHOL===\n" +
                "Nombre: " + nombre + "\n" +
                "Cantidad de ML: " + volumenML + "\n" +
                "Azucar: " + azucarPorLitro + "g/L\n" +
                "Precio Final: " + calcularPrecio();
    }
}
