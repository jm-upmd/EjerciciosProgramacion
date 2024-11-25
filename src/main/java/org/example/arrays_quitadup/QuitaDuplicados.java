package org.example.arrays_quitadup;

import java.util.Arrays;
// Ejercicio 18. Versión alternativa al del powerpoint
public class QuitaDuplicados {
    public static void main(String[] args) {
        int[] miArray = {101,1,34, 7, 7, 45,9, 21, 45, 2, 7, 2,100};
        int[] sinDuplicados = quitaDuplicados(miArray);
        System.out.println("Array inicial:");
        System.out.println(Arrays.toString(miArray));
        System.out.println("Nuevo array sin duplicados:");
        System.out.println(Arrays.toString(sinDuplicados));

    }

    /**
     * Extráe los elementos de un array omitiendo duplicidades.
     * El array original no lo modifica.
     * @param arr Array de enteros que puede contener números repetidos
     * @return un nuevo array con los elementos de arr, pero sin repetidos y ordenado de forma creciente
     */
    private static int[] quitaDuplicados(int[] arr) {
        // Como no queremos modificaf el original lo copiamos en aux
        int[] aux = Arrays.copyOf(arr,arr.length);
        // ordenamos aux
        Arrays.sort(aux);
        //aux = {2,2,7,7,7,21,34,45,45}
        // creamos aux2 del tamaño de aux
        int[] aux2 = new int[aux.length];
        int i=0,j=0; // i contador de aux; j contador de aux2
        // Mientras no lleguemos a PENULTIMA posición de axu
        while (i < aux.length - 1) {
            // Si el elemento que está a la derecha del actual es distino
            if (aux[i + 1] != aux[i]) {
                aux2[j]= aux[i];  //meto en aux2 elemento actual
                j++;  // incrementamos posición del siguiente elemento de aux2
            }
            i++;  // Elemento actual es el siguiente de aux
        }
        aux2[j] = aux[i]; // Copio a aux2 el último elemento de aux

        // Devuelvo una copia de aux2 copiando solo  los elementos no duplicados
        // que he extraido de aux
        // j es la pos del último elemento de aux2 copiado desde aux
        return Arrays.copyOf(aux2,j+1);
    }
}
