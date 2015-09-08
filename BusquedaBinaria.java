/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package busquedabinaria;

import java.util.Scanner;

public class BusquedaBinaria {

    public static int busquedaBinaria(int[] Arreglo, int elemento)
    {
        int i = 0, centro = 0, posicion = 0, inferior = 0, superior = Arreglo.length-1;

        while(inferior <= superior)
        {
            centro = (superior + inferior) / 2;

              if (Arreglo[centro] == elemento)
                 return centro;

              else
                 if (Arreglo[centro] > elemento)
                       superior = centro - 1;
                 else
                       inferior = centro + 1;
        }

          return -1;
    }

    public static void main (String[] args)
    {
        Scanner Leer = new Scanner(System.in);

        System.out.print("Tamaño del arreglo: ");
        int tamañoArreglo = Leer.nextInt();

        int[] Arreglo = new int[tamañoArreglo];

        for(int i=0; i<Arreglo.length; i++)
            Arreglo[i] = Leer.nextInt();

        System.out.print("Elemento a buscar: ");
        int elemento = Leer.nextInt();

        int posicion = busquedaBinaria(Arreglo, elemento);

        if(posicion == -1)
            System.out.println("\nElemento no encontrado");
        else
            System.out.println("\nElemento " + elemento + " encontrado en la posición " + posicion);
    }
}

