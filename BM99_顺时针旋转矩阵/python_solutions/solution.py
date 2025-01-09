from typing import List

#
# 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
# 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵。
# 
# @param mat int整型二维数组 
# @param n int整型 
# @return int整型二维数组
#
class Solution:
    def rotateMatrix(self , mat: List[List[int]], n: int) -> List[List[int]]:
        """
        This method rotates a given NxN matrix 90 degrees clockwise.
        
        The rotation is performed in two steps:
        1. Transpose the matrix by swapping elements across the diagonal.
        2. Reverse each row to complete the 90-degree clockwise rotation.
        
        :param mat: The NxN matrix to be rotated.
        :param n: The size of the matrix (N x N).
        :return: The rotated NxN matrix.
        """
        self.swap(mat)  # Step 1: Transpose the matrix
        self.reverse(mat)  # Step 2: Reverse each row
        return mat  # Return the rotated matrix

    def swap(self, matrix: List[List[int]]) -> None:
        """
        This method transposes the matrix, which means swapping elements across the diagonal.
        For each element at (i, j), it swaps with the element at (j, i).
        
        :param matrix: The matrix to be transposed.
        """
        for i in range(len(matrix)):  # Loop through each row
            for j in range(i):  # Loop through each element in the upper triangular part of the matrix
                # Swap elements at (i, j) and (j, i)
                temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp

    def reverse(self, matrix: List[List[int]]) -> None:
        """
        This method reverses each row of the matrix.
        This is the second step in the clockwise rotation process.
        
        :param matrix: The matrix whose rows need to be reversed.
        """
        for i in range(len(matrix)):  # Iterate over each row of the matrix
            # Reverse the row by swapping elements from the start and the end
            for j in range(len(matrix) // 2):  # Only need to iterate over the first half of the row
                # Swap elements at (i, j) and (i, len(matrix) - j - 1)
                temp = matrix[i][j]
                matrix[i][j] = matrix[i][len(matrix) - j - 1]
                matrix[i][len(matrix) - j - 1] = temp
