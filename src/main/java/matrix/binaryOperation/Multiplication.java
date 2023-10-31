package matrix.binaryOperation;

import matrix.Matrix;

/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

public class Multiplication extends BinaryOperation {

  private Multiplication() {
    super();
  }

  public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
    Multiplication multiplication = new Multiplication();
    return loopAndPerformOperation(matrix1, matrix2, multiplication);
  }

  @Override
  protected int operation(int operand1, int operand2, int modulus) {
    return (operand1 * operand2) % modulus;
  }
}
