/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

import matrix.Matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTest {

  @Test
  public void testDefaultConstructor() {
    Matrix defaultMatrix = new Matrix();
    Assertions.assertEquals(0, defaultMatrix.getN());
    Assertions.assertEquals(0, defaultMatrix.getM());
    Assertions.assertEquals(1, defaultMatrix.getModulus());
  }

  @Test
  public void testRandomConstructor() {
    final int[][] MATRIX_SPECIFICATIONS = {{0, 0, 1}, {2, 2, 2}, {4, 4, 4}};

    for (int[] SPECIFICATION : MATRIX_SPECIFICATIONS) {
      int nLines = SPECIFICATION[0],
          mColumns = SPECIFICATION[1],
          modulus = SPECIFICATION[2];
      Matrix randomMatrix = new Matrix(nLines, mColumns, modulus);

      // Test that the matrices have the correct specifications.
      Assertions.assertEquals(nLines, randomMatrix.getN());
      Assertions.assertEquals(mColumns, randomMatrix.getM());
      Assertions.assertEquals(modulus, randomMatrix.getModulus());

      // Test that the random values are in the proper range (i.e. 0 <= element < modulus).
      for (int line = 0; line < nLines; ++line) {
        for (int column = 0; column < mColumns; ++column) {
          Assertions.assertTrue(randomMatrix.getElement(line, column) >= 0
              && randomMatrix.getElement(line, column) < modulus);
        }
      }
    }
  }

  @Test
  public void testRandomConstructorExceptions() {
    Assertions.assertThrows(RuntimeException.class, () -> new Matrix(2, 2, 0));
    Assertions.assertThrows(RuntimeException.class, () -> new Matrix(-1, 1, 1));
    Assertions.assertThrows(RuntimeException.class, () -> new Matrix(1, -1, 1));
  }

  @Test
  public void testArrayConstructor() {
    final int MODULUS = 4;
    final int[][] MATRIX_ARRAY = {
        {0, 1, 2, 3},
        {1, 2, 3, 0},
        {2, 3, 0, 1},
        {3, 0, 1, 2}
    };

    Matrix testMatrix = new Matrix(MATRIX_ARRAY, MODULUS);

    for (int line = 0; line < MATRIX_ARRAY.length; ++line) {
      for (int column = 0; column < MATRIX_ARRAY[line].length; ++column) {
        Assertions.assertEquals(testMatrix.getElement(line, column), MATRIX_ARRAY[line][column]);
      }
    }
  }

  @Test
  public void testArrayConstructorExceptions() {
    final int[][] TEST_ARRAY_1 = {{0, 1}, {1, 0}}, // Valid matrix but to use with null modulus.
        TEST_ARRAY_2 = {{0, 1, 0}, {1, 0, 1, 0}}, // Matrix with lines with different lengths.
        TEST_ARRAY_3 = {{0, 1, 0, 1}, {-1, 0, 1, 1}, {0, 1, 1, 0}}, // Matrix with negative values.
        TEST_ARRAY_4 = {{0, 1}, {2, 1}}; // Matrix with value outside range (modulus 2).

    // Bunch up all the arrays inside a single one and create another array with the modulus to test.
    final int[][][] TEST_MATRICES = {TEST_ARRAY_1, TEST_ARRAY_2, TEST_ARRAY_3, TEST_ARRAY_4};
    final int[] TEST_MODULUS = {0, 2, 2, 2};

    for (int index = 0; index < TEST_MATRICES.length; ++index) {
      final int finalIndex = index;
      Assertions.assertThrows(RuntimeException.class,
          () -> new Matrix(TEST_MATRICES[finalIndex], TEST_MODULUS[finalIndex]));
    }
  }

  @Test
  public void testCopyConstructor() {
    Matrix testMatrix = new Matrix(8, 8, 8);
    Matrix copyMatrix = new Matrix(testMatrix);

    Assertions.assertEquals(testMatrix.getN(), copyMatrix.getN());
    Assertions.assertEquals(testMatrix.getM(), copyMatrix.getM());
    Assertions.assertEquals(testMatrix.getModulus(), copyMatrix.getModulus());

    for (int line = 0; line < testMatrix.getN(); ++line) {
      for (int column = 0; column < testMatrix.getM(); ++column) {
        Assertions.assertEquals(testMatrix.getElement(line, column),
            copyMatrix.getElement(line, column));
      }
    }
  }

  @Test
  public void testCopyConstructorExceptions() {
    Matrix testMatrix = new Matrix(8, 8, 8);
    Assertions.assertDoesNotThrow(() -> new Matrix(testMatrix));
  }

  @Test
  public void testResizingConstructor() {
    final int[][] MATRIX_SPECIFICATIONS = {{2, 2, 4}, {2, 4, 4}, {4, 2, 4}};
    final int NEW_N = 4, NEW_M = 4;

    for (int[] SPECIFICATION : MATRIX_SPECIFICATIONS) {
      int nLines = SPECIFICATION[0],
          mColumns = SPECIFICATION[1],
          modulus = SPECIFICATION[2];

      Matrix randomMatrix = new Matrix(nLines, mColumns, modulus);
      Matrix resizedMatrix = new Matrix(randomMatrix, NEW_N, NEW_M);

      Assertions.assertEquals(NEW_N, resizedMatrix.getN());
      Assertions.assertEquals(NEW_M, resizedMatrix.getM());
      Assertions.assertEquals(modulus, resizedMatrix.getModulus());

      int line = 0;
      for (; line < nLines; ++line) {
        int column = 0;
        for (; column < mColumns; ++column) {
          Assertions.assertEquals(randomMatrix.getElement(line, column),
              resizedMatrix.getElement(line, column));
        }
        for (; column < NEW_M; ++column) {
          Assertions.assertEquals(0, resizedMatrix.getElement(line, column));
        }
      }
      for (; line < NEW_N; ++line) {
        for (int column = mColumns; column < NEW_M; ++column) {
          Assertions.assertEquals(0, resizedMatrix.getElement(line, column));
        }
      }
    }
  }

  @Test
  public void testResizingConstructorExceptions() {
    Matrix testMatrix = new Matrix(2, 2, 2);
    Assertions.assertDoesNotThrow(() -> new Matrix(testMatrix, 4, 4));
    Assertions.assertThrows(RuntimeException.class, () -> new Matrix(testMatrix, -2, 4));
    Assertions.assertThrows(RuntimeException.class, () -> new Matrix(testMatrix, 4, -2));
  }
}
