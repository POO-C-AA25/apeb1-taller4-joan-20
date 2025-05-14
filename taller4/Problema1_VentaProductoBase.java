package taller4;

public class Problema1_VentaProductoBase {
    private double precio;
    private int cantidad;

    public Problema1_VentaProductoBase(double precio, int cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double calcularDescuento() {
        if (precio >= 1000 && cantidad >= 10) {
            return 0.10;
        } else if (precio < 1000) {
            return 0.05;
        }
        return 0.0;
    }

    public double calcularPrecioFinal() {
        double descuento = calcularDescuento();
        return (precio * cantidad) * (1 - descuento);
    }

    public String toString() {
        return "Precio por unidad: $" + precio + "\n" +
               "Cantidad: " + cantidad + "\n" +
               "Descuento aplicado: " + (calcularDescuento() * 100) + "%\n" +
               "Precio final: $" + calcularPrecioFinal();
    }
}
