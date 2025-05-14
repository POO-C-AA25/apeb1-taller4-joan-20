import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class encriptado {

    public static char[][] claveCaracteres = new char[3][3];
    public static double[][] claveNumerica = new double[3][3];
    public static double[][] claveInversa = new double[3][3];

    public static char[][] mensajeCaracteres = new char[3][9];
    public static double[][] mensajeNumerico = new double[3][9];
    public static double[][] mensajeEncriptado = new double[3][9];
    public static double[][] mensajeDesencriptado = new double[3][9];

    // Diccionarios de conversión
    public static ArrayList<Character> letrasPermitidas = new ArrayList<>(
            Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                        'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't',
                        'u', 'v', 'w', 'x', 'y', 'z', ' '));
                        
    public static ArrayList<Integer> valoresNumericos = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,
                        10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28));

    // Lector de entrada
    public static Scanner entradaUsuario = new Scanner(System.in);

    public static void main(String[] args) {

        String mensajeClave, mensaje;
        String separadorLinea = "----------------------------------------";

        mostrarTitulo("Cifrado y Descifrado de Mensajes", separadorLinea);

        mensajeClave = leerClaveDeUsuario();
        mensaje = capturarMensajeUsuario();

        cargarClaveEnMatriz(mensajeClave);
        transformarCaracteresANumeros(claveCaracteres, claveNumerica, 3, 3);
        claveInversa = calcularMatrizInversa(claveNumerica);

        distribuirCaracteresEnBloques(mensaje);
        transformarCaracteresANumeros(mensajeCaracteres, mensajeNumerico, 3, 9);

        mensajeEncriptado = realizarProductoMatrices(claveNumerica, mensajeNumerico);
        mensajeDesencriptado = realizarProductoMatrices(claveInversa, mensajeEncriptado);

        // Mostrar Resultados
        System.out.println(separadorLinea);

        mostrarTitulo("Matriz Clave", separadorLinea);
        mostrarMatrizDeClave();

        System.out.println(separadorLinea);

        mostrarTitulo("Matriz Mensaje", separadorLinea);
        mostrarMatrizDeMensaje();

        System.out.println(separadorLinea);

        mostrarTitulo("Matriz Clave Numérica", separadorLinea);
        mostrarMatrizDeValoresDouble(claveNumerica);

        System.out.println(separadorLinea);

        mostrarTitulo("Matriz Mensaje Numérica", separadorLinea);
        mostrarMatrizDeValoresDouble(mensajeNumerico);

        System.out.println(separadorLinea);

        mostrarTitulo("Matriz Clave Inversa", separadorLinea);
        mostrarMatrizDeValoresDouble(claveInversa);

        System.out.println(separadorLinea);

        mostrarTitulo("Matriz Mensaje Encriptada", separadorLinea);
        mostrarMatrizDeValoresDouble(mensajeEncriptado);

        System.out.println(separadorLinea);

        mostrarTitulo("Matriz Mensaje Desencriptada", separadorLinea);
        mostrarMatrizDeValoresDouble(mensajeDesencriptado);

        System.out.println(separadorLinea);

        mostrarTitulo("Mensaje Desencriptado", separadorLinea);
        mostrarMensajeDesencriptado(mensajeDesencriptado);

        System.out.println();
    }

    public static void mostrarTitulo(String titulo, String separador) {
        System.out.println(separador);
        System.out.println(">>> " + titulo + " <<<");
        System.out.println(separador);
    }

    public static String leerClaveDeUsuario() {
        String entradaTexto;
        boolean entradaValida;

        System.out.print("\nIngrese una clave de exactamente 9 caracteres (sin números): ");

        do {
            entradaValida = true;

            if (entradaUsuario.hasNextInt()) {
                System.out.print("\nNo se permiten números. Intente nuevamente: ");
                entradaUsuario.next();
                entradaValida = false;
            } else {
                entradaTexto = entradaUsuario.nextLine();

                if (entradaTexto.length() != 9) {
                    System.out.print("\nLa clave debe tener exactamente 9 caracteres. Intente nuevamente: ");
                    entradaValida = false;
                } else {
                    return entradaTexto;
                }
            }
        } while (!entradaValida);

        return null;
    }

    public static String capturarMensajeUsuario() {
        String mensajeIngresado;

        System.out.println("\nEscribe el mensaje que deseas enviar (máximo 27 caracteres, solo letras y espacios):");

        do {
            mensajeIngresado = entradaUsuario.nextLine().toLowerCase();

            boolean longitudExcedida = mensajeIngresado.length() > 27;
            boolean contieneCaracteresInvalidos = !mensajeIngresado.matches("[a-zñ ]+");

            if (longitudExcedida) {
                System.out.printf("\nTu mensaje tiene %d caracteres. Por favor, reduce el texto a 27 o menos: ", mensajeIngresado.length());
            } else if (contieneCaracteresInvalidos) {
                System.out.print("\nTu mensaje contiene caracteres no permitidos. Solo se aceptan letras y espacios. Intenta de nuevo: ");
            } else {
                break;
            }

        } while (true);

        return mensajeIngresado;
    }

    public static void cargarClaveEnMatriz(String claveTexto) {
        if (claveTexto == null || claveTexto.length() != 9) {
            System.out.println("Error: La clave debe contener exactamente 9 caracteres.");
            return;
        }

        int indiceCaracter = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                claveCaracteres[fila][columna] = claveTexto.charAt(indiceCaracter);
                indiceCaracter++;
            }
        }
    }

    public static void transformarCaracteresANumeros(char[][] entrada, double[][] resultado, int totalFilas, int totalColumnas) {

        for (int filaActual = 0; filaActual < totalFilas; filaActual++) {

            for (int columnaActual = 0; columnaActual < totalColumnas; columnaActual++) {

                char letra = Character.toLowerCase(entrada[filaActual][columnaActual]);
                int posicion = letrasPermitidas.indexOf(letra);

                if (posicion >= 0) {
                    resultado[filaActual][columnaActual] = valoresNumericos.get(posicion);
                } else {
                    resultado[filaActual][columnaActual] = 0;
                }

            }

        }
    }

    public static double[][] calcularMatrizInversa(double[][] matrizOriginal) {

        int dimension = matrizOriginal.length;
        double[][] matrizExpandida = new double[dimension][dimension * 2];

        for (int fila = 0; fila < dimension; fila++) {

            for (int columna = 0; columna < dimension; columna++) {
                matrizExpandida[fila][columna] = matrizOriginal[fila][columna];
            }
            matrizExpandida[fila][dimension + fila] = 1.0;

        }

        for (int pivoteFila = 0; pivoteFila < dimension; pivoteFila++) {

            double valorPivote = matrizExpandida[pivoteFila][pivoteFila];

            if (valorPivote == 0.0) {

                boolean intercambioExitoso = false;

                for (int filaIntercambio = pivoteFila + 1; filaIntercambio < dimension; filaIntercambio++) {

                    if (matrizExpandida[filaIntercambio][pivoteFila] != 0.0) {

                        double[] filaTemporal = matrizExpandida[pivoteFila];
                        matrizExpandida[pivoteFila] = matrizExpandida[filaIntercambio];
                        matrizExpandida[filaIntercambio] = filaTemporal;

                        valorPivote = matrizExpandida[pivoteFila][pivoteFila];
                        intercambioExitoso = true;
                        break;
                    }
                }

                if (!intercambioExitoso) {
                    throw new ArithmeticException("No se puede invertir la matriz: no es invertible (pivote cero no intercambiable).");
                }
            }

            for (int col = 0; col < dimension * 2; col++) {
                matrizExpandida[pivoteFila][col] /= valorPivote;
            }

            for (int otraFila = 0; otraFila < dimension; otraFila++) {

                if (otraFila != pivoteFila) {

                    double factor = matrizExpandida[otraFila][pivoteFila];

                    for (int col = 0; col < dimension * 2; col++) {
                        matrizExpandida[otraFila][col] -= factor * matrizExpandida[pivoteFila][col];
                    }
                }
            }
        }

        double[][] matrizInversa = new double[dimension][dimension];

        for (int fila = 0; fila < dimension; fila++) {

            for (int columna = 0; columna < dimension; columna++) {

                matrizInversa[fila][columna] = matrizExpandida[fila][dimension + columna];
            }
        }

        return matrizInversa;
    }

    public static void distribuirCaracteresEnBloques(String textoPlano) {
        int contadorCaracteres = 0;
        int totalFilas = 3;
        int totalColumnas = 9;

        for (int filaActual = 0; filaActual < totalFilas; filaActual++) {
            for (int columnaActual = 0; columnaActual < totalColumnas; columnaActual++) {

                boolean hayCaracterDisponible = contadorCaracteres < textoPlano.length();

                if (hayCaracterDisponible) {
                    char caracterActual = textoPlano.charAt(contadorCaracteres);
                    mensajeCaracteres[filaActual][columnaActual] = caracterActual;
                    contadorCaracteres++;
                } else {
                    mensajeCaracteres[filaActual][columnaActual] = ' ';
                }

            }
        }
    }

    public static double[][] realizarProductoMatrices(double[][] primeraMatriz, double[][] segundaMatriz) {

        int numeroFilasPrimera = primeraMatriz.length;
        int numeroColumnasPrimera = primeraMatriz[0].length;
        int numeroColumnasSegunda = segundaMatriz[0].length;

        double[][] resultadoFinal = new double[numeroFilasPrimera][numeroColumnasSegunda];

        for (int fila = 0; fila < numeroFilasPrimera; fila++) {

            for (int columna = 0; columna < numeroColumnasSegunda; columna++) {

                double acumulado = 0;

                for (int interacion = 0; interacion < numeroColumnasPrimera; interacion++) {

                    acumulado += primeraMatriz[fila][interacion] * segundaMatriz[interacion][columna];

                }

                resultadoFinal[fila][columna] = Math.round(acumulado);
            }
        }

        return resultadoFinal;
    }

    public static void mostrarMatrizDeClave() {

        int filasMatriz = 3;
        int columnasMatriz = 3;

        for (int filaIndex = 0; filaIndex < filasMatriz; filaIndex++) {

            for (int columnaIndex = 0; columnaIndex < columnasMatriz; columnaIndex++) {

                System.out.print(claveCaracteres[filaIndex][columnaIndex] + " ");

            }

            System.out.println();
        }
    }

    public static void mostrarMatrizDeMensaje() {

        int filasDeMensaje = 3;
        int columnasDeMensaje = 9;

        for (int filaIndice = 0; filaIndice < filasDeMensaje; filaIndice++) {

            for (int columnaIndice = 0; columnaIndice < columnasDeMensaje; columnaIndice++) {

                System.out.print(mensajeCaracteres[filaIndice][columnaIndice] + " ");

            }

            System.out.println();
        }
    }

    public static void mostrarMatrizDeValoresDouble(double[][] matrizDeValores) {

        int numeroDeFilas = matrizDeValores.length;
        int numeroDeColumnas = matrizDeValores[0].length;

        for (int indiceFila = 0; indiceFila < numeroDeFilas; indiceFila++) {

            for (int indiceColumna = 0; indiceColumna < numeroDeColumnas; indiceColumna++) {

                System.out.print(matrizDeValores[indiceFila][indiceColumna] + " ");

            }

            System.out.println();
        }
    }

    public static void mostrarMensajeDesencriptado(double[][] matrizDeNumeros) {

        int numeroDeFilas = matrizDeNumeros.length;
        int numeroDeColumnas = matrizDeNumeros[0].length;
        int valorMatriz;
        char caracterDescifrado;

        System.out.println();

        for (int fila = 0; fila < numeroDeFilas; fila++) {

            for (int columna = 0; columna < numeroDeColumnas; columna++) {

                valorMatriz = (int) matrizDeNumeros[fila][columna];
                caracterDescifrado = letrasPermitidas.get(valoresNumericos.indexOf(valorMatriz));

                System.out.print(caracterDescifrado);

            }

        }
    }

}