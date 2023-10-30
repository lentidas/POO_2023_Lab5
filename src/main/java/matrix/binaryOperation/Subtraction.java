/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

package matrix.binaryOperation;

import matrix.Matrix;

public class Subtraction extends BinaryOperation {

  private Subtraction() {
    super();
  }

  public static Matrix subtract(Matrix matrix1, Matrix matrix2) {
    Subtraction subtraction = new Subtraction();
    return loopAndPerformOperation(matrix1, matrix2, subtraction);
  }

  @Override
  protected int operation(int operand1, int operand2, int modulus) {
    int subtraction = operand1 - operand2;
    int absoluteModulus = Math.abs(modulus);
    return (Math.floorMod(subtraction, modulus) + absoluteModulus) % absoluteModulus;
  }
}
