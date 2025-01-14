package org.example.cadenas.ejercicio9;

import java.util.Scanner;

public class CadenasEjercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nombre completo: ");
        String nombre = sc.nextLine();
        System.out.println(nombre + " -> " + sinVocales(nombre));
    }

    static boolean esVocal(char caracter) {
        char[] vocales={'a','e','i','o','u','á','é','í','ó','ú','ü'};

        for(char c: vocales){
            if(c == Character.toLowerCase(caracter)) {
                return true;
            }
        }
        return false;
    }

    static String sinVocales(String cadena){
        //Aquí utilizo un StringBuilder para ir componiendo el texto de salida, añadiendo las letras
        // que no son vocales. Imaginad que cadena es un texto muy grande (El Quijote), entonces tendríamos que
        // hacer muchas concatenaciones de String, lo cual ya sabéis que no es nada eficiente...
        // Acostumbraros a usar StringBuilder cuando preeveáis que se pueden hacer muchas concatenaciones.

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) {
            if(!esVocal(cadena.charAt(i))){
                sb.append(cadena.charAt(i)); // Añade caracter no vocal al StringBuilder
            }
        }
        return sb.toString();  // Devuelve contenido del StringBuilder convertido en un String.
    }
}