package taller4;

public class Problema2_EmpleadoBase {
    private String nombre;
    private double salario;
    private int edad;

    public Problema2_EmpleadoBase(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void aumentarSalario(double porcentaje) {
        salario += salario * (porcentaje / 100);
    }

    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Salario: $" + salario;
    }
}
