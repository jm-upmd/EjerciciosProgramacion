package org.example.concatenacionstring;

public class ConcatenaString {


    public static void main(String[] args) {
        final String TEXTO = "Hola caracola. Como estás hoy";
        final int NUM_CONCATENACIONES = 1_000_000;
        long tiempo;

        // Concatenamos y medimos usando concatenación normal de Strings
        tiempo = System.currentTimeMillis();
        System.out.println("Concatenando con operador de concatenación de Strings...");
        concatenaString(TEXTO, NUM_CONCATENACIONES);
        System.out.println("Tiempo (msg): " + (System.currentTimeMillis() - tiempo));
        System.out.println("Tiempo (sg): " + (System.currentTimeMillis() - tiempo)/1000);


        // Concatenamos y medimos usando StringBuilder
        System.out.println("Concatenando con objeto StringBuilder");
        tiempo = System.currentTimeMillis();
        concatenaStrigOK(TEXTO,NUM_CONCATENACIONES);
        System.out.println("Tiempo (msg): " + (System.currentTimeMillis() - tiempo));

    }

    private static void concatenaString(String texto, int numConcatenaciones) {
        String textoFinal = "";   // String con ningún caracter.
        for (int i = 1; i <= numConcatenaciones; i++) {
            textoFinal += texto;
        }
        System.out.println("Tamaño total del texto concatenado: " + textoFinal.length());
    }

    private static void concatenaStrigOK(String texto, int nunConcatenaciones) {
        // Utilizamos un objeto StringBuilder. A diferncia de String este sí es mutable
        // Es como un array que almacena texto (strings, chars, ...).
        // Con append añade al final de lo que ya tiene guardado

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= nunConcatenaciones ; i++) {
            sb.append(texto);
        }

        // Con el método StringBuilder.toString() convierte el contenido en un String
        String s = sb.toString();
        System.out.println(s.length());
    }
}
