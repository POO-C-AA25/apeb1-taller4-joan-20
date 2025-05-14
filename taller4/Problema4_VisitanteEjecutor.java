package taller4;

import java.util.Scanner;

public class Problema4_VisitanteEjecutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos visitantes desea ingresar? ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        int totalAcceden = 0;

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("\n--- Visitante #" + i + " ---");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Edad: ");
            int edad = sc.nextInt();

            System.out.print("Altura (en metros): ");
            double altura = sc.nextDouble();
            sc.nextLine();

            System.out.print("¿A qué juego desea ingresar? ");
            String juego = sc.nextLine();

            System.out.print("Edad mínima para el juego: ");
            int edadMinima = sc.nextInt();

            System.out.print("Altura mínima para el juego (en metros): ");
            double alturaMinima = sc.nextDouble();
            sc.nextLine();

            Problema4_VisitanteBase visitante = new Problema4_VisitanteBase(nombre, edad, altura, juego, edadMinima, alturaMinima);
            System.out.println(visitante);

            if (visitante.puedeAcceder()) {
                totalAcceden++;
            }
        }

        System.out.println("\n🔹 Total que pueden ingresar: " + totalAcceden);
        sc.close();
    }
}
