package taller4;

import java.util.*;

public class Problema3_EstudianteEjecutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Problema3_EstudianteBase> estudiantes = new ArrayList<>();
        int aceptados = 0, rechazados = 0;

        System.out.print("¿Cuántos estudiantes desea registrar? ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        for (int i = 0; i < n; i++) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Grado: ");
            String grado = sc.nextLine();
            System.out.print("¿Tiene permiso (true/false)? ");
            boolean permiso = sc.nextBoolean();
            sc.nextLine();

            Problema3_EstudianteBase estudiante = new Problema3_EstudianteBase(nombre, grado, permiso);
            estudiantes.add(estudiante);
        }

        System.out.println("\n--- Ingreso de estudiantes al autobús ---");
        for (Problema3_EstudianteBase est : estudiantes) {
            if (est.tienePermiso()) {
                System.out.println(est + " => Puede subir");
                aceptados++;
            } else {
                System.out.println(est + " => No puede subir");
                rechazados++;
            }
        }

        System.out.println("\nResumen:");
        System.out.println("Estudiantes aceptados: " + aceptados);
        System.out.println("Estudiantes rechazados: " + rechazados);
    }
}
