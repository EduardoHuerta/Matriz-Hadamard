package matrix.hadamard;
/*
        * Aquí la tarea es generar H (N), una matriz booleana NxN Hadamard, donde h2,h4,h8
        * es una potencia de 2, utilizando la recursividad. H (N) tiene la propiedad ingeniosa de que dos
        * filas diferentes difieren en las entradas N / 2, lo que lo hace útil para corregir
        * códigos de error .
        *
        * Puede construir H (N) utilizando H (N / 2) cuatro veces como "bloque",
        * o "submatriz". Así, las entradas de NxN matriz
        * son dados por cuatro (N / 2) x (N / 2) matrices "pegadas".
        * Además, el bloque inferior derecho debe ser negado (verdadero-> falso, falso-> verdadero).
        *
        * H (N / 2) H (N / 2)
        * H (N / 2)! H (N / 2)
        *
        * Saco "1" para "verdadero" y "-1" para "falso", para mejorar la legibilidad.
        * Tenga en cuenta el uso de "mejorado para bucles" en printMatrix.
        *
        * El programa debe imprimir H (2), H (4), H (8):
        * 1 1
        * 1 -1

        *1  1  1  1
        *1 -1  1 -1
        *1  1 -1 -1
        *1 -1 -1  1
        *

        * 1  1  1  1  1  1  1  1
        * 1 -1  1 -1  1 -1  1 -1
        * 1  1 -1 -1  1  1 -1 -1
        * 1 -1 -1  1  1 -1 -1  1
        * 1  1  1  1 -1 -1 -1 -1
        * 1 -1  1 -1 -1  1 -1  1
        * 1  1 -1 -1 -1 -1  1  1
        * 1 -1 -1  1 -1  1  1 -1
*/
public class Hadamard {
    public static void main(String[] args) {
        int h2 = (int)Math.pow(2, 1);  //El entero h2 toma el tamaño de la matriz inicial
        int h4 = (int)Math.pow(2, 2); //El entero h4 toma el tamaño de la matriz siguiente
        int h8 = (int)Math.pow(2, 3); //El entero h8 toma el tamaño de la matriz final.
        int[][] mat = new int[h2][h2];
        fillHadamard(mat);
        imprimirMatrizResultante(mat);
        System.out.println();
        int[][] mat2 = new int[h4][h4];  //Declaramos la matriz de tamaño 4 x 4
        fillHadamard(mat2);
        imprimirMatrizResultante(mat2);  //llamamos al metodo para imprimir la matriz despues de llamar al metodo recursivo para llenar la matriz de Hadamard
        System.out.println();
        //int[][] mat3 = new int[h8][h8];
        //fillHadamard(mat3);
        //printA(mat3);
    }

    public static void fillHadamard(int mat[][]) {
        fillHadamard(mat, mat.length / 2);
    }

    public static void fillHadamard(int mat[][], int index) {
        if(index == 0) {
            mat[0][0] = 1;
            return;
        }

        fillHadamard(mat, index / 2);

        copy(mat, 0, 0, index, index,  0,  1);
        copy(mat, 0, 0, index,  0, index,  1);
        copy(mat, 0, 0, index, index, index, -1);
    }

    public static void copy(int m[][], int i, int j, int max, int desplazamientoEnI, int desplazamientoEnJ, int invert) {
        if(j == max) {
            j = 0;
            i = i + 1;
        }
        if(i == max) {
            return;
        }
        m[i + desplazamientoEnI][j + desplazamientoEnJ] = m[i][j] * invert;
        copy(m, i, j + 1, max, desplazamientoEnI, desplazamientoEnJ, invert);
    }

    public static void imprimirMatrizResultante(int mat[][]) {  //Metodo para imprimir la matriz resultante de Hadamard
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print( mat[i][j] + "\t");
            }
            System.out.println(" ");
        }
    }
}