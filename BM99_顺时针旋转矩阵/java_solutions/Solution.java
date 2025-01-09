package BM99_顺时针旋转矩阵.java_solutions;

public class Solution {

    /**
     * This method rotates a given NxN matrix 90 degrees clockwise.
     * The approach involves two main steps:
     * 1. Transpose the matrix (swap rows and columns).
     * 2. Reverse each row to complete the 90-degree rotation.
     * 
     * @param mat The NxN matrix to be rotated.
     * @param n   The size of the matrix (N x N).
     * @return The rotated NxN matrix.
     */
    public int[][] rotateMatrix(int[][] mat, int n) {
        // Step 1: Transpose the matrix
        swap(mat);

        // Step 2: Reverse each row to complete the 90-degree rotation
        reverse(mat);

        // Return the rotated matrix
        return mat;
    }

    /**
     * This method transposes the matrix by swapping elements across the diagonal.
     * For each element at (i, j), swap it with the element at (j, i).
     * 
     * @param matrix The matrix to be transposed.
     */
    private void swap(int[][] matrix) {
        // Iterate over each element in the upper triangular part of the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                // Swap the elements at (i, j) and (j, i)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * This method reverses each row of the matrix.
     * This is the second step in the clockwise rotation process.
     * 
     * @param matrix The matrix whose rows need to be reversed.
     */
    private void reverse(int[][] matrix) {
        // Iterate over each row of the matrix
        for (int i = 0; i < matrix.length; i++) {
            // Reverse elements in each row by swapping
            // from the start (j) and the end (matrix.length - j - 1)
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }
}
