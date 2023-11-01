/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

import matrix.Matrix;

public class Main {

  public static void main(String[] args) {
    int[] values = Input.parseInput(args);

    int modulus = values[args.length - 1];

    Matrix matrix1 = new Matrix(values[0], values[1], modulus),
        matrix2 = new Matrix(values[2], values[3], modulus);

    System.out.println("\nThe modulus is " + modulus + ".\n");
    System.out.println("one:");
    matrix1.printMatrix();
    System.out.println("\ntwo:");
    matrix2.printMatrix();

    System.out.println("\none + two:");
    Matrix result = matrix1.addTo(matrix2);
    result.printMatrix();

    System.out.println("\none - two:");
    result = matrix1.subtractWith(matrix2);
    result.printMatrix();

    System.out.println("\none x two:");
    result = matrix1.multiplyBy(matrix2);
    result.printMatrix();

  }
}
