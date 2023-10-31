package matrix.binaryOperation;

import matrix.Matrix;

/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

public class Addition extends BinaryOperation {

  private Addition() {
    super();
  }

  public static Matrix add(Matrix matrix1, Matrix matrix2) {
    Addition addition = new Addition();
    return loopAndPerformOperation(matrix1, matrix2, addition);
  }

  @Override
  protected int operation(int operand1, int operand2, int modulus) {
    return (operand1 + operand2) % modulus;
  }
}
