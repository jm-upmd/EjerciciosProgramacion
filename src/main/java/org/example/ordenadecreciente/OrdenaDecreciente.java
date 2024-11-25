package org.example.ordenadecreciente;

import java.util.Arrays;

public class OrdenaDecreciente {
    public static void main(String[] args) {
        int[] miArray = {4, 6, 1, 3, 5,89,33,6};
        System.out.println("Original: " + Arrays.toString(miArray));
        ordenaInverso2(miArray);
        System.out.println("Ordenado decreciente: " + Arrays.toString(miArray));
    }


    /**
     * Ordena un array de enteros arr, en orden decreciente
     * @param arr Un array de enteros
     */
    private static void ordenaInverso(int[] arr) {
        int longitud = arr.length;
        int[] aux = new int[longitud];
        Arrays.sort(arr);  // Ordena array en orden creciente

        // invierte el orden
        // 1.Copia los valores de arr en orden inverso en otro array aux.

        for (int i = 0; i < longitud; i++) {
            aux[i] = arr[longitud - i - 1];
        }
        // 2. Copia los valores de axu en arr en el mismo orden
        // con lo cual arr queda on los valores en orden inverso
        for (int i = 0; i < longitud; i++) {
            arr[i] = aux[i];
        }

        // Forma alternativa de copiar el array con System.arraycopy
        //System.arraycopy(aux, 0, arr, 0, longitud);
    }

    /**
     * Versión mejorada
     * En esta versión no utilizamos un nuevo array para invertir el original ordenado
     * sino que utilizamos una variable aux para ir haciendo la inversión directamente
     * sobre el array original ordenado
     * @param arr Un array de enteros
     */

    private static void ordenaInverso2(int[] arr) {
        int aux;
        int longitud = arr.length;
        int contador = longitud/2; // Solo tenemos que recorrer la mitad de array
        Arrays.sort(arr); // Ordena array en orden creciente
        for (int i = 0; i < contador; i++) {
            aux = arr[i];  // Aqúi guarda el valor antes de machacarlo con el nuevo
            arr[i] = arr[longitud - i - 1];
            arr[longitud - i -1] = aux; // Guarda el valor previamente guardado en aux
        }
    }

}
