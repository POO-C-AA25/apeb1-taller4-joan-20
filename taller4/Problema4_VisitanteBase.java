package taller4;

class Problema4_VisitanteBase {
    private String nombre;
    private int edad;
    private double altura;
    private String juego;
    private int edadMinima;
    private double alturaMinima;

    public Problema4_VisitanteBase(String nombre, int edad, double altura, String juego, int edadMinima, double alturaMinima) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.juego = juego;
        this.edadMinima = edadMinima;
        this.alturaMinima = alturaMinima;
    }

    public boolean puedeAcceder() {
        return edad >= edadMinima && altura >= alturaMinima;
    }

    public String toString() {
        String estado = puedeAcceder() ? "Puede acceder" : "No puede acceder";
        return String.format("%s (Edad: %d, Altura: %.2f m) - Juego: %s [%s]", 
                              nombre, edad, altura, juego, estado);
    }
}
