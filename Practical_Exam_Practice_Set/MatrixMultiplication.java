import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input dimensions of first matrix
            System.out.print("Enter number of rows for Matrix A: ");
            int r1 = sc.nextInt();
            System.out.print("Enter number of columns for Matrix A: ");
            int c1 = sc.nextInt();

            // Input dimensions of second matrix
            System.out.print("Enter number of rows for Matrix B: ");
            int r2 = sc.nextInt();
            System.out.print("Enter number of columns for Matrix B: ");
            int c2 = sc.nextInt();

            // Check dimension conformity: c1 must equal r2
            if (c1 != r2) {
                System.out.println("Error: Matrix multiplication not possible!");
                System.out.println("Reason: Columns of A (" + c1 + 
                                   ") ≠ Rows of B (" + r2 + ")");
                return; // Exit program
            }

            // Input Matrix A
            int[][] A = new int[r1][c1];
            System.out.println("Enter elements of Matrix A:");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    A[i][j] = sc.nextInt();
                }
            }

            // Input Matrix B
            int[][] B = new int[r2][c2];
            System.out.println("Enter elements of Matrix B:");
            for (int i = 0; i < r2; i++) {
                for (int j = 0; j < c2; j++) {
                    B[i][j] = sc.nextInt();
                }
            }

            // Resultant matrix
            int[][] C = new int[r1][c2];

            // Multiplication
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    for (int k = 0; k < c1; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }

            // Print result
            System.out.println("Resultant Matrix (A x B):");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please enter integers only.");
        } finally {
            sc.close();
        }
    }
}