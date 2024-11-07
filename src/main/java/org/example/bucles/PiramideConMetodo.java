package org.example.bucles;

import java.util.Scanner;

public class PiramideConMetodo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numFilas;

         do {
            System.out.println("Dame el número de filas (impar)");
         } while (( (numFilas = sc.nextInt())  % 2) == 0);


        // Pintamos el tríangulo;

        int numEspacios = numFilas -1;
        int numAsteriscos = 1;


        for (int i = 1; i <= numFilas ; i++) { // Bucle para las filas

            System.out.print(creaLineaCaracteres(" ", numEspacios));
            System.out.println(creaLineaCaracteres("*",numAsteriscos));
            numEspacios--;  // Decrementamos una unidad para la siguiente fila
            numAsteriscos+=2;  // Incrementa dos unidades para la siguiente fila.

        }
    }

    /**
     * Genera un String compuesto por la repetición de un caracter
     * @param s Caracter con el que componer el string
     * @param largo Número de repeticiones de s en el string generado
     * @return String compuesto por largo ocurrencias del caracter s
     */
    private static String creaLineaCaracteres(String s, int largo) {
        String linea="";
        for (int i = 0; i < largo; i++) {
            linea+=s;
        }
        return linea;
    }
}
