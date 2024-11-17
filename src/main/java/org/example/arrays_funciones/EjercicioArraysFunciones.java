package org.example.arrays_funciones;

import java.util.Arrays;

public class EjercicioArraysFunciones {

    public static void main(String[] args) {

        // PUNTO A)

        int[] miArray = {23,2, 5, 8, 12, 8, 77, 45, 1, 10};  // Creamos el array de 10 enteros
        System.out.println(Arrays.toString(miArray));  // Mostramos contenido por consola

        // PUNTO B)
        ponNumeroEnPrimeraPos(miArray,888);
        System.out.println(Arrays.toString(miArray));


        // PUNTO C)
        // Obtenemos un array con los elementos de miArray en orden inverso
        int[] arrDevuelto = invierteArray(miArray);
        // Lo mostramos pos consola
        System.out.println(Arrays.toString(arrDevuelto));


        // PUNTO D)
        // Extrae los valores pares de arr y los devuelve en un nuevo array
        arrDevuelto = extraeArrayDePares(miArray);
        System.out.println(Arrays.toString(arrDevuelto));

        // PUNTO E)
        // Rellena el mismo array que le pasamos como parámetro de enteros entre 1 y 100
        rellenaDeAleatorios(miArray,1,100);  // Lo rellena de aleatorios entre 1 y 100
        System.out.println(Arrays.toString(miArray));  // Muestra contenido del array por consola

        // PUNTO F)
        // Imprimimos el array de enteros probando nuestras 2 versiones de método de imprimir por consola.
        imprimeArray(miArray);
        imprimeArray2(miArray);

    }

    // *** Métodos ***

    /**
     * Imprime el contenido de arr por consola con formato {a1 : a2 : ... : an}
     * @param arr un array de enteros
     */
    static void imprimeArray(int[] arr){
        String s = "{";
        // Recorre arr hasta la penúltima posición
        int i;
        for (i = 0; i < arr.length -1 ; i++) {
            s+=arr[i] + " : ";
        }
        // pinta el último elemento y llave de cierre
        s += arr[i] + "}";
        System.out.println(s); // Imprime el string
    }

    /**
     * Otra versión que hace lo mismo que imprimeArray.
     * Aqui se utilizan los métodos Arrays.toString() y String.replaceAll()
     * y no es necsario hacer un bucle que recorra el array
     * @param arr Array de enteros de entrada
     */
    static void imprimeArray2(int[] arr) {
        // Comvierte a String y luego reemplaza las llaves por corchetes y las comas por espacio más dos puntos.
        System.out.println(Arrays.toString(arr)
                // Tenemos que scapar dos veces el corchete porque es un caracter especial en una expresión regular
                .replaceAll("\\[", "{")
                .replaceAll("]", "}")
                .replaceAll(",", " :"));

    }

    static int[] extraeArrayDePares(int[] arr) {
        int[] arrSal;
        int cuentaPares = 0; // Contador del número de pares en arr

        // Contamos los pares que hay en arr
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                cuentaPares++;
            }
        }

        // Creamos el array de salida de tamaño cuentaPares
        arrSal = new int[cuentaPares];

        int contArrSal = 0; // Contador de la posición del array arrSal
        for (int i = 0; i < arr.length; i++) {  // Recorre arr con pos i
            if (arr[i] % 2 == 0) {              // Si valor de la pos i es par
                arrSal[contArrSal] = arr[i];    // Lo guarda en pos contArrSal de arrSal
                contArrSal++;
            }
        }
        return arrSal;
    }

    /**
     * Almacena en la primera posición del array arr el número n
     * @param arr array de enteros
     * @param n número entero
     */
    static void ponNumeroEnPrimeraPos(int[] arr, int n) {
        arr[0] = n;
    }

    /**
     * Crea y devuelve un array que contiene los elementos de arr en orden inverso
     * @param arr array de números enteros
     * @return un nuevo array conteniendo los elementos de arr en orden inverso
     */
    static int[] invierteArray(int[] arr) {
        int longitudArr = arr.length;

        // Crea nuevo array del mismo tamaño que es de entrada
        int[] arrSal = new int[longitudArr];

        // Rellena con los valores de arr pero en orden inverso
        for (int i = 0; i < longitudArr; i++) {
            arrSal[longitudArr - i -1] = arr[i]; // arrSal lo va llenando de derecha a izquierda
        }
        return arrSal; // devuelve el array

    }

    /**
     *
     * Rellena arr de números enteros aleatorios comprendidos en un rango
     * @param arr Array de enteros
     * @param min Varlor entero mínimo del rango
     * @param max Valor entero máximo del rango
     */
    static void rellenaDeAleatorios(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = min + (int)(Math.random() * ((max - min) + 1));
        }

    }

}
