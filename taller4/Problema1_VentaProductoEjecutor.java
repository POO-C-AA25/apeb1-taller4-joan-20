package taller4;

import java.util.Scanner;

public class Problema1_VentaProductoEjecutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese la cantidad de productos: ");
        int cantidad = sc.nextInt();

        Problema1_VentaProductoBase venta = new Problema1_VentaProductoBase(precio, cantidad);
        System.out.println(venta.toString());
    }
}
