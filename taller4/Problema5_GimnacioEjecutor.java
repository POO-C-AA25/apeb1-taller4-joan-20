package taller4;

public class Problema5_GimnacioEjecutor {
    public static void main(String[] args) {
        Problema5_GimnacioBase.GimnasioProblema5 gimnasio = new Problema5_GimnacioBase.GimnasioProblema5();

        gimnasio.agregarCliente(new Problema5_GimnacioBase.ClienteGimnasioProblema5("Juan Pérez", "Cardio", 45, true));
        gimnasio.agregarCliente(new Problema5_GimnacioBase.ClienteGimnasioProblema5("Ana Torres", "Fuerza", 60, true));
        gimnasio.agregarCliente(new Problema5_GimnacioBase.ClienteGimnasioProblema5("Carlos Ruiz", "Estiramiento", 30, false));
        gimnasio.agregarCliente(new Problema5_GimnacioBase.ClienteGimnasioProblema5("Luisa Gómez", "Cardio", 50, true));

        gimnasio.mostrarResumen();
    }
}
