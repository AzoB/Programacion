
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Amine Banks
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static int[] array;
    
    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        /*
         EJERCICIO 01
         Descripción del problema:
         Escribe una aplicación modular en Java que solicite por consola al usuario el número
         de elementos que tendrá un array unidimensional de enteros. El contenido del array
         será calculado aleatoriamente por el programa siendo posibles valores enteros de 0 a
         100.
         A continuación el programa deberá ejecutar las siguientes acciones:
         a. Solicitar al usuario una posición y un valor. Insertar en el vector en la
         posición dada el valor dado. Mostrar por consola el contenido del array.
         b. Calcular y mostrar el valor más alto y el valor más bajo del array
         c. Calcular la media de todos los valores y mostrar los valores del array que se
         encuentran por encima de esta media
         Antes de comenzar a programar, define el pseudocode o flowchart de la aplicación.
         Requisitos no funcionales de la aplicación:
          El programa sólo puede contener una Clase.
          El programa debe ser modular
          Cada módulo del programa debe disponer de una breve descripción funcional
         del mismo
          El programa debe respetar The Clean Coding Practices*/

        array = solicitarAlUsuario();
        System.out.println("2 Funcion valores mas alto y mas bajos del array");
        calcularValorMasAltoYMasBajoArray(array);
        System.out.println("3 Funcion calcular el valor media del array ");
        calcularValorMediaDelArray(array);

    }

    /*escripción del problema:
     Escribe una aplicación modular en Java que solicite por consola al usuario el número
     de elementos que tendrá un array unidimensional de enteros. El contenido del array
     será calculado aleatoriamente por el programa siendo posibles valores enteros de 0 a
     100.
     A continuación el programa deberá ejecutar las siguientes acciones:
     a. Solicitar al usuario una posición y un valor. Insertar en el vector en la
     posición dada el valor dado. Mostrar por consola el contenido del array.*/
    //crear una funcion de comprobacion:
    public static int leerInt() throws IOException {
        boolean error = false;
        int numero = 0;
        do {
            try {
                error = false;
                numero = Integer.valueOf(entrada.readLine()).intValue();
            } catch (NumberFormatException ex) {
                System.out.println("valor incorrecto" + ex);
                error = true;
            } catch (IOException e) {
                System.out.println("Error de E/S" + e);
                if (entrada != null) {
                    entrada.close();
                }
            }
        } while (error);
        return (numero);
    }

//

    static int[] solicitarAlUsuario() throws IOException {
        int posicion = 0, valor = 0, n = 0;
        do {
            System.out.println("Los numeros enteros son: ");
            n = leerInt();
            if (n > 100) {
                System.out.println(" El valor no puede ser superior a 100: ");
            }
        } while ((n < 0) || (n > 100));
        array = new int[n];

        do {
            System.out.println("Pedir posicion");
            posicion = leerInt();
            if ((posicion > array.length) ||(posicion<0)) {
                System.out.println("El valor de la posicion no es posible: ");
            } else {
                for (int i = 0; i < array.length; i++) {
                    array[i] = (int) (Math.random() * 100);
                }
                System.out.println("Pedir valor: ");
                valor = leerInt();
                for (int i = 0; i < array.length; i++) {
                    array[posicion] = valor;
                    System.out.println("valor despues de actualizacion: " + array[i]);
                }

            }
        } while ((posicion < 0) || (posicion > array.length));

        return array;
    }

    //calcular el valor mas bajo y mas alto del array: 
    static void calcularValorMasAltoYMasBajoArray(int[] array) {
        int masBajo = 100;
        int masAlto = 0;
        //recorrer el array:
        for (int i = 0; i < array.length; i++) {
            //verificar si 
            if (array[i] > masAlto) {
                masAlto = array[i];
            } else if (array[i] < masBajo) {
                masBajo = array[i];
            }
        }
        System.out.println("valor mas alto es: " + masAlto);
        System.out.println("valor mas bajo es: " + masBajo);

    }

    //c. Calcular la media de todos los valores y mostrar los valores del array que se
    static void calcularValorMediaDelArray(int[] array) {
        int valorMedia = 0, suma = 0;
        int i = 0;
        for (i = 0; i < array.length; i++) {
            //para calcular los valores por encima del array:
            if (valorMedia < array[i]) {
                //la suma es para poder calcular todos los valores que estan dentro del array:
                suma = suma + array[i];
            }
            System.out.println("valores encima del array: " + array[i]);
        }
        //calculo de la media de los valores: 
        valorMedia = suma / array.length;
        //imprimir el valor mediaArray
        System.out.println(" Media es: " + valorMedia);

    }

}
