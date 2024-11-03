package org.example.bucles;

/*
Pedir un entero impar n por consola y pintar un triángulo
con altura n.
Haced un chequeo para comprobar que n es impar y si no lo es
volver a pedirlo

n = 5 = num filas del triangulo

    *
   ***
  *****
 *******
*********


s = filas -1 ; a =1
// En cada iteración los contadores se mueven así
s = s -1 ; a = a + 2

 */


import java.util.Scanner;

public class Piramide {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el número de filas (impar):");
        int numFilas; // = sc.nextInt();
        /*while(numFilas % 2 == 0) {  // Si el numero es impar lo volvemos a pedir
            System.out.println("El número es incorrecto. Vuelve a introducirlo");
            numFilas = sc.nextInt();
        }*/
		
		// Alternativa aal while de arriba

         do {
            System.out.println("Dame el número");
        } while (( (numFilas = sc.nextInt())  % 2) == 0);


        // Pintamos el tríangulo;

        int numEspacios = numFilas -1;
        int numAsteriscos = 1;


        for (int i = 1; i <= numFilas ; i++) { // Bucle para las filas
            for (int j = 1; j <=numEspacios ; j++) {  // Bucle que pinta espacios de una fila
                System.out.print(" ");
            }

          

            for (int j = 1; j <= numAsteriscos ; j++) {  // Bucle que pinta los asteriscos de una fila
                System.out.print("*");
            }

            System.out.println(); 
			
			// Alternativa al for y prinln de arriba
			//System.out.println("*".repeat(numAsteriscos));


            numEspacios--;  // Decrementamos una unidad para la siguiente fila
            numAsteriscos+=2;  // Incrementa dos unidades para la siguiente fila.

        }


    }
}
