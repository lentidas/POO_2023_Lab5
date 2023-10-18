/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

public abstract class BinaryOperation {

  private int operand1, operand2, modulus;

  BinaryOperation() {
    this(0,0,1);
  }

  BinaryOperation(int operand1, int operand2, int modulus) {
    this.setAttributes(operand1, operand2, modulus);
  }

  public void setAttributes(int operand1, int operand2, int modulus) {
    this.operand1 = operand1;
    this.operand2 = operand2;
    this.modulus = modulus;
  }

  public abstract int operation();
}

