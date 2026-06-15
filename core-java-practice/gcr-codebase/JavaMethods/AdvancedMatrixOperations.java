import java.util.Scanner;

public class AdvancedMatrixOperations {
    public static double[][] createRandomMatrix(int rows, int columns) {
        double[][] matrix = new double[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 9) + 1;
            }
        }

        return matrix;
    }

    public static double[][] findTranspose(double[][] matrix) {
        double[][] transpose = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    public static double findDeterminant2x2(double[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static double findDeterminant3x3(double[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    public static double[][] findInverse2x2(double[][] matrix) {
        double determinant = findDeterminant2x2(matrix);

        if (determinant == 0) {
            return new double[0][0];
        }

        return new double[][] {
                { matrix[1][1] / determinant, -matrix[0][1] / determinant },
                { -matrix[1][0] / determinant, matrix[0][0] / determinant }
        };
    }

    public static double[][] findMinor(double[][] matrix, int row, int column) {
        double[][] minor = new double[2][2];
        int minorRow = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (i == row) {
                continue;
            }

            int minorColumn = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == column) {
                    continue;
                }

                minor[minorRow][minorColumn] = matrix[i][j];
                minorColumn++;
            }
            minorRow++;
        }

        return minor;
    }

    public static double[][] findInverse3x3(double[][] matrix) {
        double determinant = findDeterminant3x3(matrix);

        if (determinant == 0) {
            return new double[0][0];
        }

        double[][] inverse = new double[3][3];

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                double cofactor = Math.pow(-1, row + column) * findDeterminant2x2(findMinor(matrix, row, column));
                inverse[column][row] = cofactor / determinant;
            }
        }

        return inverse;
    }

    public static void displayMatrix(double[][] matrix) {
        if (matrix.length == 0) {
            System.out.println("Matrix has no inverse");
            return;
        }

        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(Math.round(value * 100.0) / 100.0 + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter matrix size 2 or 3:");
        int size = input.nextInt();

        if (size != 2 && size != 3) {
            System.out.println("Only 2x2 and 3x3 matrices are supported");
        } else {
            double[][] matrix = createRandomMatrix(size, size);

            System.out.println("Matrix:");
            displayMatrix(matrix);

            System.out.println("Transpose:");
            displayMatrix(findTranspose(matrix));

            if (size == 2) {
                System.out.println("Determinant is " + findDeterminant2x2(matrix));
                System.out.println("Inverse:");
                displayMatrix(findInverse2x2(matrix));
            } else {
                System.out.println("Determinant is " + findDeterminant3x3(matrix));
                System.out.println("Inverse:");
                displayMatrix(findInverse3x3(matrix));
            }
        }

        input.close();
    }
}
