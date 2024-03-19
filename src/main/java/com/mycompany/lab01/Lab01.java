package com.mycompany.lab01;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Lian Morgado, Xavier Soliz Rojas
 */

public class Lab01 {
    
    public static Random random = new Random();
    
    public static void main(String[] args) {
        MostrarOpciones();
    }
    
    private static void MostrarOpciones() {
        
        int continuar = 0;
        while (continuar == 0) {
            Scanner leer = new Scanner(System.in);

            System.out.println("1........Matriz 4x4, diagonal principal.");
            System.out.println("2........Matriz 4x4, triangular inferior.");
            System.out.println("3........Matriz 4x4, triangular superior.");
            System.out.println("4........Salir.");
            System.out.println("Su eleccion: ");
            int opcion = leer.nextInt();

            while (opcion <= 0 || opcion > 4) {
                System.out.println("Error, ingrese una opcion valida entre 1 y 4.");
                System.out.println("Su eleccion: ");
                opcion = leer.nextInt();
            }

            int[][] matriz = new int[4][4];

            switch (opcion) {
                case (1):
                    matriz = MatrizDiagonal(matriz);
                    break;

                case (2):
                    matriz = MatrizTriangularInferior(matriz);
                    break;

                case (3):
                    matriz = MatrizTriangularSuperior(matriz);
                    break;

                case (4):
                    System.exit(0);
                    break;
            }

            MostrarMatriz(matriz);
            
            System.out.println("Ingrese 0 para continuar");
            
            continuar = leer.nextInt();
        }
        
    }
    
    private static void MostrarMatriz(int[][] matriz_a_mostrar) {
        
        System.out.println("Mostrando la matriz: ");
        
        for (int j = 0; j < matriz_a_mostrar.length; j++) {
            String linea = "[ ";
            for (int i = 0; i < matriz_a_mostrar[j].length; i++) {
                linea += matriz_a_mostrar[j][i] + " ";
            }
            System.out.println(linea + "]");
        }
    }
    
    private static int[][] MatrizDiagonal(int[][] matriz_a_convertir) {
        
        for (int j = 0; j < matriz_a_convertir.length; j++) {
            
            for (int i = 0; i < matriz_a_convertir[j].length; i++) {
                
                if (i == j) {
                    matriz_a_convertir[j][i] = random.nextInt(101);
                }
                
            }
        }
        
        return matriz_a_convertir;
    }
    
    private static int[][] MatrizTriangularSuperior(int[][] matriz_a_convertir) {
        
        for (int j = 0; j < matriz_a_convertir.length; j++) {
            
            for (int i = 0; i < matriz_a_convertir[j].length; i++) {
                
                if (i > j) {
                    matriz_a_convertir[j][i] = random.nextInt(101);
                }
                
            }
        }
        
        return matriz_a_convertir;
    }
    
    private static int[][] MatrizTriangularInferior(int[][] matriz_a_convertir) {
        
        for (int j = 0; j < matriz_a_convertir.length; j++) {
            
            for (int i = 0; i < matriz_a_convertir[j].length; i++) {
                
                if (i < j) {
                    matriz_a_convertir[j][i] = random.nextInt(101);
                }
                
            }
        }
        
        return matriz_a_convertir;
    }
}
