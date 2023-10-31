/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

package matrix.binaryOperation;

import matrix.Matrix;

public abstract class BinaryOperation {

  protected BinaryOperation() {
    super();
  }

  protected static Matrix loopAndPerformOperation(Matrix matrix1, Matrix matrix2,
      BinaryOperation binaryOperation) {
    if (matrix1 == null || matrix2 == null) {
      throw new RuntimeException(
          "Invalid reference! One of the matrices passed as an argument is null.");
    }
    if (matrix1.getModulus() != matrix2.getModulus()) {
      throw new ArithmeticException("Modulus of matrices is not identical.");
    }

    int resultN = matrix1.getN(),
        resultM = matrix1.getM(),
        resultModulus = matrix1.getModulus();

    if (matrix1.getN() != matrix2.getN() || matrix1.getM() != matrix2.getM()) {
      resultN = Math.max(matrix1.getN(), matrix2.getN());
      resultM = Math.max(matrix1.getM(), matrix2.getM());
      matrix1 = new Matrix(matrix1, resultN, resultM);
      matrix2 = new Matrix(matrix2, resultN, resultM);
    }

    int[][] resultMatrixArray = new int[resultN][resultM];

    for (int line = 0; line < resultN; ++line) {
      for (int column = 0; column < resultM; ++column) {
        resultMatrixArray[line][column] =
            binaryOperation.operation(matrix1.getElement(line, column),
                matrix2.getElement(line, column),
                resultModulus);
      }
    }

    return new Matrix(resultMatrixArray, resultModulus);
  }

  protected abstract int operation(int operand1, int operand2, int modulus);
}

