package taller4;

import java.util.ArrayList;
import java.util.List;

class Problema5_GimnacioBase {

    public static class ClienteGimnasioProblema5 {
        private String nombre;
        private String tipoEjercicio;
        private int duracion;
        private boolean completo;

        public ClienteGimnasioProblema5(String nombre, String tipoEjercicio, int duracion, boolean completo) {
            this.nombre = nombre;
            this.tipoEjercicio = tipoEjercicio;
            this.duracion = duracion;
            this.completo = completo;
        }

        public int getDuracion() {
            return duracion;
        }

        public boolean rutinaCompletada() {
            return completo;
        }

        public String toString() {
            return "Cliente: " + nombre + " | Ejercicio: " + tipoEjercicio +
                   " | Duración: " + duracion + " min | Completado: " + (completo ? "Sí" : "No");
        }
    }

    public static class GimnasioProblema5 {
        private List<ClienteGimnasioProblema5> clientes;

        public GimnasioProblema5() {
            clientes = new ArrayList<>();
        }

        public void agregarCliente(ClienteGimnasioProblema5 c) {
            clientes.add(c);
        }

        public int totalRutinasCompletadas() {
            int contador = 0;
            for (ClienteGimnasioProblema5 c : clientes) {
                if (c.rutinaCompletada()) {
                    contador++;
                }
            }
            return contador;
        }

        public double promedioTiempo() {
            if (clientes.isEmpty()) return 0;
            int total = 0;
            for (ClienteGimnasioProblema5 c : clientes) {
                total += c.getDuracion();
            }
            return (double) total / clientes.size();
        }

        public void mostrarResumen() {
            System.out.println("Resumen de Rutinas del Gimnasio:");
            for (ClienteGimnasioProblema5 c : clientes) {
                System.out.println(c.toString());
            }
            System.out.println("\nTotal que completaron rutina: " + totalRutinasCompletadas());
            System.out.printf("Tiempo promedio invertido: %.2f minutos\n", promedioTiempo());
        }
    }
}
