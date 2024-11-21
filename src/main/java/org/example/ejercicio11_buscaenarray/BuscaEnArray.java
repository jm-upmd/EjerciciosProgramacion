package org.example.ejercicio11_buscaenarray;

import java.util.Scanner;

public class  BuscaEnArray {
    public static void main(String[] args) {

        int miArray[];
        Scanner sc = new Scanner(System.in);
        System.out.println("Tamaño de array:");
        int longitud = sc.nextInt();

        // Creación del array con tamaño que le hemos dado por consola
        miArray = new int[longitud];

        System.out.println("Escribe los valores a guardar en el array:");

        // Metemos un valor dentro de cada posición del array
        int numero;
        for (int i = 0; i < longitud; i++) {
            miArray[i] = sc.nextInt();
        }

        // Pedimos número que queremos encontrar dentro del array
        System.out.println("Dame el valor clave a buscar en el array");
        numero = sc.nextInt();

        // Llamámos a nuestro método de busqueda
        // Como hace búsqueda secuencial, no es necesario ordenar
        // previamente el array

        int resultado = buscar(miArray, numero);

        /*   Lo mismo pero usando método binarySearch de la clase Arrays
        Podemos ordenar el array y utilizar el método binarySearch
        para encontrar el valor clave.

        Arrays.sort(miArray);

        System.out.println(Arrays.toString(miArray));
        int resultado = Arrays.binarySearch(miArray, numero);*/

        if(resultado != -1){  // Si ha encontrado el valor lo muestra
            System.out.println("Encontrado el valor en la posición " + resultado);
        } else {   // Si no encuentra el valor
            System.out.println("No se ha encontrado el número en el array");
        }

    }

    /**
     * Busca numero dentro de array miArray
     * @param miArray Array donde buscar numero
     * @param numero  Entero usado como clave de busqueda.
     * @return La posición donde se encuentra número dentro de miArray, o -1
     *         en caso de que numero no se encuentre en miArray
     */
    private static int buscar(int[] miArray, int numero) {
        int longitud = miArray.length;

        for (int i = 0; i < longitud; i++) {  // Recorremos el array
            if(miArray[i] == numero){  // En cada iteración miramos si el valor de la posión i el igual al busca numero
                // Si valor de la posición i es igual al buscado devolvemos la posición. Aquí termin la función y devuelve el valor
                return i;
            }
        }
        // Si salimos del for es porque no hemos encontrado numero dentro del array
        // En ese caso devolvemos -1
        return -1;
    }

}


