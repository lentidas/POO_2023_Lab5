/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

import matrix.Matrix;

public class Main {

  public static void main(String[] args) {
    Matrix test = new Matrix(5, 5, -7);
    Matrix test2 = new Matrix(new int[][]{{1, 2, 0}, {1, 1, 0}}, 3);
    Matrix test3 = new Matrix(test2, 4,4);
    Matrix test4 = new Matrix(test2, 1, 2);
  }
}
