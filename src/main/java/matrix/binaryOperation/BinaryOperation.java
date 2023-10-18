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

  protected void loopAndPerformOperation(Matrix matrix1, Matrix matrix2) {
    // TODO
  }

  public abstract int operation(int operand1, int operand2, int modulus);
}

