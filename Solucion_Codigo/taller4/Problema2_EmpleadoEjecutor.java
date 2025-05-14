package taller4;

import java.util.*;

public class Problema2_EmpleadoEjecutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Problema2_EmpleadoBase> empleados = new ArrayList<>();
        String continuar;

        // Agregar empleados
        do {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Salario: ");
            double salario = sc.nextDouble();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            empleados.add(new Problema2_EmpleadoBase(nombre, salario, edad));
            System.out.print("¿Desea agregar otro empleado? (s/n): ");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        // Mostrar empleados
        System.out.println("\n--- Empleados registrados ---");
        for (Problema2_EmpleadoBase emp : empleados) {
            System.out.println(emp);
        }

        // Aumento salarial
        double suma = 0;
        for (Problema2_EmpleadoBase emp : empleados) {
            suma += emp.getSalario();
        }
        double promedio = suma / empleados.size();
        System.out.println("Salario promedio: $" + promedio);

        System.out.print("Ingrese porcentaje de aumento: ");
        double porcentaje = sc.nextDouble();

        System.out.println("\n--- Aumentos aplicados ---");
        for (Problema2_EmpleadoBase emp : empleados) {
            if (emp.getSalario() < promedio) {
                emp.aumentarSalario(porcentaje);
            }
            System.out.println(emp);
        }
    }
}
