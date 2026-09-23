package cl.dsy1102.fonda;

public class BebidaAlcoholica extends Bebida implements ConsumoResponsable{
    protected int LIMITE_UNIDADES_POR_CLIENTE = 3;
    protected double gradosAlcohol;
    protected boolean certificada;
    protected boolean ventaRestringida;


    public BebidaAlcoholica(String nombre, int volumenML, int stock, double gradosAlcohol, boolean certificada, boolean ventaRestringida) {
        super(nombre, volumenML, stock);
        this.gradosAlcohol = gradosAlcohol;
        this.certificada = certificada;
        this.ventaRestringida = ventaRestringida;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(double gradosAlcohol) {
        this.gradosAlcohol = gradosAlcohol;
    }

    public boolean isCertificada() {
        return certificada;
    }

    public void setCertificada(boolean certificada) {
        this.certificada = certificada;
    }

    @Override
    public boolean tieneVentaRestringida() {
        return this.ventaRestringida;
    }

    @Override
    public void restringirVenta() {
        this.ventaRestringida = true;
    }

    @Override
    public boolean superaLimite(int unidades) {
        if (unidades > LIMITE_UNIDADES_POR_CLIENTE){
         return true;
        } else {
            return false;
        }
    }

    @Override
    public double calcularPrecio() {
        if(!certificada){
            return 3500 * 1.20;
        } else {
            return 3500;
        }
    }

    @Override
    public String obtenerDetalle() {
        return "Nombre: " + nombre + "\n" +
                "Volumen en ML: " + volumenML + "\n" +
                "Stock: " + stock + "\n" +
                "Grados de alcohol: " + gradosAlcohol + "\n" +
                "Certificada: " + certificada + "\n" +
                "Tiene venta restringida?: " + ventaRestringida;
    }
}
