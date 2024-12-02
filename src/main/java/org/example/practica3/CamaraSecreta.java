package org.example.practica3;

import java.util.Arrays;
import java.util.Scanner;

public class CamaraSecreta {
    // Si creamos aquí el Scanner podremos utilizarlo dentro de todas las funciones de la clase
    // Si lo creamos dentro del main tendremos que pasarselo como parametro a las funciones
    // donde queramos utilizarlo.
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int longitudClave;

        longitudClave = leeEntero("Logitud de la clave secreta: ");

        int[] claveSecreta = new int[longitudClave];  //Array que contiene la clave secreta

        rellenaDeAleatorios(claveSecreta,1,5);

        System.out.println(Arrays.toString(claveSecreta)); // Descomentar para traza

        int[] claveUsuario; // Array con los dígitos recogidos por consola

        do {
            claveUsuario = dameClave(longitudClave);
        } while (!clavesIguales(claveSecreta, claveUsuario));

        System.out.println("\n¡La cámara está abierta!");
    }

    /**
     * Comprueba si el array con los digitos de la clave secreta coincide con los tecleados por el usuarioç
     * Imprimer por consola si cada digito introducido por el usuario es mayor, menor o igual que el de la clave sercreta.
     * @param cs Array con los dígitos de la clave secreta.
     * @param cu Array con los dígitos de la clave del usuario.
     * @return true si ambos arrays tienen los mismos dígitos en el mismo orden; false en caso contrario.
     */
    private static boolean clavesIguales(int[] cs, int[] cu) {
        boolean iguales = true;
        String mensaje="";
        System.out.println("Pistas:");
        for (int i = 0; i < cs.length; i++) {
            if (cu[i] > cs[i]) {
                mensaje = "Menor que ";
                iguales=false;
            } else if (cu[i] < cs[i]) {
                mensaje = "Mayor que ";
                iguales=false;
            } else  {
                mensaje = "Igual que ";
            }
            System.out.println(mensaje + cu[i] );
        }
        return iguales;
    }

    /**
     * Pide por consola al usuario los dígitos de la clave secreta.
     * @param longitud Tamaño (número de digitos) de la clave secreta.
     * @return Un array de enteros conteniendo los dígitos introducidos por el usuario.
     */
    private static int[] dameClave(int longitud) {
        int[] clave = new int[longitud];

        System.out.println("\nEscriba una combinación:");

        for (int i = 0; i < longitud; i++) {
            clave[i] = leeEntero("Damé dígito de la clave: ");
        }
        return clave;
    }

    /**
     * Pide un númro entero por consola.
     * Si el dato escrito en consola no es un número entero, vuelve a pedirlo de forma recurrente.
     * @param mensaje Mensaje que imprime en consola pidiendo el número
     * @return El número entero introducido por consola.
     */
    static int leeEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()){
            System.out.print("Número incorrecto. Vuelva a introducir un número");
            scanner.next();
        }
        return  scanner.nextInt();
    }

    /**
     * Rellena un array de enteros aleatorios generados dentro de un rango
     * @param arr Array a rellenar.
     * @param min Mínimo número aleatorio a generar
     * @param max Máximo número aleatorio a generar
     */
    static void rellenaDeAleatorios(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = min + (int)(Math.random() * ((max - min) + 1));
        }
    }
}
