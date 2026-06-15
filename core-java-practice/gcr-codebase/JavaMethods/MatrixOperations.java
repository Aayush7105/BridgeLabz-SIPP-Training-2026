import java.util.Scanner;

public class MatrixOperations {
    public static int[][] createRandomMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }

        return matrix;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter rows for first matrix:");
        int rows1 = input.nextInt();

        System.out.println("Enter columns for first matrix:");
        int columns1 = input.nextInt();

        System.out.println("Enter rows for second matrix:");
        int rows2 = input.nextInt();

        System.out.println("Enter columns for second matrix:");
        int columns2 = input.nextInt();

        int[][] matrix1 = createRandomMatrix(rows1, columns1);
        int[][] matrix2 = createRandomMatrix(rows2, columns2);

        System.out.println("First matrix:");
        displayMatrix(matrix1);

        System.out.println("Second matrix:");
        displayMatrix(matrix2);

        if (rows1 == rows2 && columns1 == columns2) {
            System.out.println("Addition:");
            displayMatrix(addMatrices(matrix1, matrix2));

            System.out.println("Subtraction:");
            displayMatrix(subtractMatrices(matrix1, matrix2));
        } else {
            System.out.println("Addition and subtraction need matrices of the same size");
        }

        if (columns1 == rows2) {
            System.out.println("Multiplication:");
            displayMatrix(multiplyMatrices(matrix1, matrix2));
        } else {
            System.out.println("Multiplication needs columns of first matrix equal to rows of second matrix");
        }

        input.close();
    }
}
