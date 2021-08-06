package com.ds.matrix;

public class TriangularMatrix {

	public static void main(String[] args) {

		int matrix[][] = { { 1, 2, 3 }, 
						   { 4, 5, 6 },
						   { 7, 8, 9 } };

		lowerTriangular(matrix);
		System.out.println("--------------------");
		upperTriangular(matrix);

	}

	public static void lowerTriangular(int matrix[][]) {

		int rows = matrix.length;

		for (int i = 0; i < rows; i++) {
			int columns = matrix[i].length;

			for (int j = 0; j < columns; j++) {

				System.out.print((i >= j) ? matrix[i][j] + " " : "0 ");

			}

			System.out.println("");
		}

	}

	public static void upperTriangular(int matrix[][]) {
		int rows = matrix.length;

		for (int i = 0; i < rows; i++) {
			int columns = matrix[i].length;

			for (int j = 0; j < columns; j++) {

				System.out.print((i <= j) ? matrix[i][j] + " " : "0 ");

			}

			System.out.println("");
		}
	}

}
