/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

package matrix.binaryOperation;

import matrix.Matrix;

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
    int multiplication = operand1 + operand2;
    int absoluteModulus = Math.abs(modulus);
    return (Math.floorMod(multiplication, modulus) + absoluteModulus) % absoluteModulus;
  }
}
