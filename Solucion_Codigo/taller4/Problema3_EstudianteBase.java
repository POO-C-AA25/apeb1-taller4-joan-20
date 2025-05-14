package taller4;

public class Problema3_EstudianteBase {
    private String nombre;
    private String grado;
    private boolean permiso;

    public Problema3_EstudianteBase(String nombre, String grado, boolean permiso) {
        this.nombre = nombre;
        this.grado = grado;
        this.permiso = permiso;
    }

    public boolean tienePermiso() {
        return permiso;
    }

    public String toString() {
        return "Estudiante: " + nombre + ", Grado: " + grado + ", Permiso: " + (permiso ? "Sí" : "No");
    }
}
