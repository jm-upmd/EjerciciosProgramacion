package org.example.arrays_quitadup;

import java.util.Arrays;
// Ejercicio 18. Versión alternativa al del powerpoint
public class QuitaDuplicados {
    public static void main(String[] args) {
        final int NUM_ELEMENTOS = 10_000;  // NÚMERO DE ELEMENTOS DEL ARRAY

        int[] miArray =  new int[NUM_ELEMENTOS];

        // Rellena array con númros aleatorios en el rango [1,NUM_ELEMENTOS]
        rellenaDeAleatorios(miArray,1,NUM_ELEMENTOS);

        long t = System.currentTimeMillis();

        // Obtiene array sin suplicados
        // Se puede sustituir por quitDuplicados2, quitDubplicados3 (el del powerpoint) para dif. de tiempos
        int[] sinDuplicados = quitaDuplicados(miArray);

        t = System.currentTimeMillis() - t;


        System.out.println("Array inicial:");
        System.out.println(Arrays.toString(miArray));
        System.out.println("Nuevo array sin duplicados:");
        System.out.println(Arrays.toString(sinDuplicados));
        System.out.println("Núm. elementos no duplicados: " + sinDuplicados.length);
        System.out.println("Tiempo proceso (mlsg): " + t);

    }


    /**
     * Esta versión devuelve array sin suplicados con los valores en el mismo orden
     * que estaban el el array inicial.
     * El array original no lo modifica.
     * Hace uso de la función buacarHasta
     * @param arr Array con los valores inciales
     * @return Nuevo array con los valores de arr pero sin repeticiones.
     */
    private static int[] quitaDuplicados(int[] arr) {

        int[] sinDuplicados = new int[arr.length];
        int contSinDup = 0;

        if (arr.length != 0) {
            contSinDup=1;
            sinDuplicados[0] = arr[0];
            for (int e : arr) {
                if (busca(sinDuplicados, e, contSinDup) == -1) {
                    sinDuplicados[contSinDup] = e;
                    contSinDup++;
                }
            }
        }
        return Arrays.copyOf(sinDuplicados,contSinDup);
    }

    /**
     * Extráe los elementos de un array omitiendo duplicidades.
     * El array original no lo modifica.
     * @param arr Array de enteros que puede contener números repetidos
     * @return un nuevo array con los elementos de arr, pero sin repetidos y ordenado de forma creciente
     */
    private static int[] quitaDuplicados2(int[] arr) {
        // Como no queremos modificaf el original lo copiamos en aux
        int[] aux = Arrays.copyOf(arr,arr.length);
        // ordenamos aux
        Arrays.sort(aux);
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


    /**
     * Versión del PowerPoint
     * @param tabla
     * @return
     */
    public static int[] quitaDuplicados3(int[] tabla) {
        int sinRepetidos[] = new int[0];
        for(int elemento: tabla) {
            if(busca(sinRepetidos, elemento) == -1){
                sinRepetidos = Arrays.copyOf(sinRepetidos, sinRepetidos.length+1);
                sinRepetidos[sinRepetidos.length - 1] = elemento;
            }
        }
        return sinRepetidos;
    }


    private static int busca(int[] miArray, int numero) {

        for (int i = 0; i < miArray.length; i++) {  // Recorremos el array
            if(miArray[i] == numero){  // En cada iteración miramos si el valor de la posión i el igual al busca numero
                // Si valor de la posición i es igual al buscado devolvemos la posición. Aquí termin la función y devuelve el valor
                return i;
            }
        }
        // Si salimos del for es porque no hemos encontrado numero dentro del array
        // En ese caso devolvemos -1
        return -1;
    }

    /**
     * Sobrecargamos el método busca
     * Busca numero dentro de array miArray.
     * La búsqueda la realiza en el rango [0,hasta-1]
     * @param miArray Array donde buscar numero
     * @param numero  Entero usado como clave de busqueda.
     * @param hasta Posición del array hasta donde mira si está el elemento buscado.
     * @return La posición donde se encuentra número dentro de miArray, o -1
     *         en caso de que numero no se encuentre en miArray
     */
    private static int busca(int[] miArray, int numero, int hasta) {

        for (int i = 0; i < hasta; i++) {  // Recorremos el array
            if(miArray[i] == numero){  // En cada iteración miramos si el valor de la posión i el igual al busca numero
                // Si valor de la posición i es igual al buscado devolvemos la posición. Aquí termin la función y devuelve el valor
                return i;
            }
        }
        // Si salimos del for es porque no hemos encontrado numero dentro del array
        // En ese caso devolvemos -1
        return -1;
    }

    static void rellenaDeAleatorios(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = min + (int)(Math.random() * ((max - min) + 1));
        }

    }
}
