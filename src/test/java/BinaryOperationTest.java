/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

import javax.swing.plaf.SpinnerUI;
import matrix.Matrix;
import matrix.binaryOperation.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryOperationTest {

  @Test
  public void testAdd() {
    final int MODULUS = 4;
    final int[][] matrixArray1 = {
        {0, 1, 2, 3},
        {3, 2, 1, 0}
    };
    final int[][] matrixArray2 = {
        {0, 3},
        {1, 2},
        {2, 1},
        {3, 0}
    };
    final int[][] matrixArrayResult = {
        {0, 0, 2, 3},
        {0, 0, 1, 0},
        {2, 1, 0, 0},
        {3, 0, 0, 0}
    };

    Matrix matrix1 = new Matrix(matrixArray1, MODULUS);
    Matrix matrix2 = new Matrix(matrixArray2, MODULUS);

    Matrix result = Addition.add(matrix1, matrix2);

    Assertions.assertEquals(4, result.getN());
    Assertions.assertEquals(4, result.getM());

    for (int line = 0; line < result.getN(); ++line) {
      for (int column = 0; column < result.getM(); ++column) {
        Assertions.assertEquals(matrixArrayResult[line][column], result.getElement(line, column));
      }
    }
  }

  @Test
  public void testAddEmptyMatrix() {
    final int MODULUS = 4;
    final int[][] matrixArray2 = {
        {0, 1},
        {2, 3}
    };
    final int[][] matrixArrayResult = {
        {0, 1},
        {2, 3}
    };

    Matrix matrix1 = new Matrix(0, 0, MODULUS);
    Matrix matrix2 = new Matrix(matrixArray2, MODULUS);

    Matrix result = Addition.add(matrix1, matrix2);

    Assertions.assertEquals(2, result.getN());
    Assertions.assertEquals(2, result.getM());

    for (int line = 0; line < result.getN(); ++line) {
      for (int column = 0; column < result.getM(); ++column) {
        Assertions.assertEquals(matrixArrayResult[line][column], result.getElement(line, column));
      }
    }
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
    final int MODULUS = 4;
    final int[][] matrixArray1 = {
        {0, 1, 2, 3},
        {3, 2, 1, 0}
    };
    final int[][] matrixArray2 = {
        {0, 3},
        {1, 2},
        {2, 1},
        {3, 0}
    };
    final int[][] matrixArrayResult = {
        {0, 2, 2, 3},
        {2, 0, 1, 0},
        {2, 3, 0, 0},
        {1, 0, 0, 0}
    };

    Matrix matrix1 = new Matrix(matrixArray1, MODULUS);
    Matrix matrix2 = new Matrix(matrixArray2, MODULUS);

    Matrix result = Subtraction.subtract(matrix1, matrix2);

    Assertions.assertEquals(4, result.getN());
    Assertions.assertEquals(4, result.getM());

    for (int line = 0; line < result.getN(); ++line) {
      for (int column = 0; column < result.getM(); ++column) {
        Assertions.assertEquals(matrixArrayResult[line][column], result.getElement(line, column));
      }
    }
  }

  @Test
  public void testSubtractEmptyMatrix() {
    final int MODULUS = 4;
    final int[][] matrixArray2 = {
        {0, 1},
        {2, 3}
    };
    final int[][] matrixArrayResult = {
        {0, 3},
        {2, 1}
    };

    Matrix matrix1 = new Matrix(0, 0, MODULUS);
    Matrix matrix2 = new Matrix(matrixArray2, MODULUS);

    Matrix result = Subtraction.subtract(matrix1, matrix2);

    Assertions.assertEquals(2, result.getN());
    Assertions.assertEquals(2, result.getM());

    for (int line = 0; line < result.getN(); ++line) {
      for (int column = 0; column < result.getM(); ++column) {
        Assertions.assertEquals(matrixArrayResult[line][column], result.getElement(line, column));
      }
    }
  }

  @Test
  public void testSubtractExceptions() {
    Matrix matrix1 = new Matrix(2, 4, 2);
    Matrix matrix2 = new Matrix(4, 2, 2);
    Matrix matrixWithDifferentModulus = new Matrix(4, 4, 4);

    Assertions.assertDoesNotThrow(() -> Subtraction.subtract(matrix1, matrix2));
    Assertions.assertThrows(RuntimeException.class,
        () -> Subtraction.subtract(matrix1, matrixWithDifferentModulus));
    Assertions.assertThrows(RuntimeException.class,
        () -> Subtraction.subtract(matrixWithDifferentModulus, matrix2));
    Assertions.assertThrows(RuntimeException.class, () -> Subtraction.subtract(matrix1, null));
    Assertions.assertThrows(RuntimeException.class, () -> Subtraction.subtract(null, matrix2));
  }

  @Test
  public void testMultiplication() {
    final int MODULUS = 4;
    final int[][] matrixArray1 = {
        {0, 1, 2, 3},
        {3, 2, 1, 0}
    };
    final int[][] matrixArray2 = {
        {0, 3},
        {1, 2},
        {2, 1},
        {3, 0}
    };
    final int[][] matrixArrayResult = {
        {0, 3, 0, 0},
        {3, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };

    Matrix matrix1 = new Matrix(matrixArray1, MODULUS);
    Matrix matrix2 = new Matrix(matrixArray2, MODULUS);

    Matrix result = Multiplication.multiply(matrix1, matrix2);

    Assertions.assertEquals(4, result.getN());
    Assertions.assertEquals(4, result.getM());

    for (int line = 0; line < result.getN(); ++line) {
      for (int column = 0; column < result.getM(); ++column) {
        Assertions.assertEquals(matrixArrayResult[line][column], result.getElement(line, column));
      }
    }
  }

  @Test
  public void testMultiplicationEmptyMatrix() {
    final int MODULUS = 4;
    Matrix matrix1 = new Matrix(0, 0, MODULUS);
    Matrix matrix2 = new Matrix(new int[][]{{0, 1}, {2, 3}}, MODULUS);

    Matrix result = Multiplication.multiply(matrix1, matrix2);

    Assertions.assertEquals(2, result.getN());
    Assertions.assertEquals(2, result.getM());

    for (int line = 0; line < result.getN(); ++line) {
      for (int column = 0; column < result.getM(); ++column) {
        Assertions.assertEquals(0, result.getElement(line, column));
      }
    }
  }

  @Test
  public void testMultiplicationExceptions() {
    Matrix matrix1 = new Matrix(2, 4, 2);
    Matrix matrix2 = new Matrix(4, 2, 2);
    Matrix matrixWithDifferentModulus = new Matrix(4, 4, 4);

    Assertions.assertDoesNotThrow(() -> Multiplication.multiply(matrix1, matrix2));
    Assertions.assertThrows(RuntimeException.class,
        () -> Multiplication.multiply(matrix1, matrixWithDifferentModulus));
    Assertions.assertThrows(RuntimeException.class,
        () -> Multiplication.multiply(matrixWithDifferentModulus, matrix2));
    Assertions.assertThrows(RuntimeException.class, () -> Multiplication.multiply(matrix1, null));
    Assertions.assertThrows(RuntimeException.class, () -> Multiplication.multiply(null, matrix2));
  }
}
