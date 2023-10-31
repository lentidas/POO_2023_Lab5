/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

import matrix.Matrix;
import matrix.binaryOperation.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO test limit case with empty matrices when doing calculations

public class BinaryOperationTest {

  @Test
  public void testAdd() {
    // TODO
  }

  @Test
  public void testAddExceptions() {
    Matrix matrix1 = new Matrix(2, 4, 2);
    Matrix matrix2 = new Matrix(4, 2, 2);
    Matrix matrixWithDifferentModulus = new Matrix(4, 4, 4);

    Assertions.assertDoesNotThrow(() -> Addition.add(matrix1, matrix2));
    Assertions.assertThrows(RuntimeException.class,
        () -> Addition.add(matrix1, matrixWithDifferentModulus));
    Assertions.assertThrows(RuntimeException.class,
        () -> Addition.add(matrixWithDifferentModulus, matrix2));
    Assertions.assertThrows(RuntimeException.class, () -> Addition.add(matrix1, null));
    Assertions.assertThrows(RuntimeException.class, () -> Addition.add(null, matrix2));
  }

  @Test
  public void testSubtract() {
    // TODO
  }

  @Test
  public void testSubtractExceptions() {
    // TODO
  }

  @Test
  public void testMultiplication() {
    // TODO
  }

  @Test
  public void testMultiplicationExceptions() {
    // TODO
  }
}
