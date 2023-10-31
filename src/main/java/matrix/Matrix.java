package matrix;

import java.util.Random;
import matrix.binaryOperation.*;

/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

public class Matrix {

  private final int modulus;
  private final int nLines;
  private final int mColumns;
  private final int[][] matrixArray;

  public Matrix() {
    this(new int[0][0], 1);
  }

  public Matrix(int nLines, int mColumns, int modulus) {
    if (modulus <= 0) {
      throw new IllegalArgumentException("Modulus should be strictly greater than 0.");
    }
    if (nLines < 0 || mColumns < 0) {
      throw new IllegalArgumentException("Number of lines and/or columns cannot be negative.");
    }

    this.modulus = modulus;
    if (nLines == 0 || mColumns == 0) {
      this.nLines = this.mColumns = 0;
      this.matrixArray = new int[this.nLines][this.mColumns];
    } else {
      this.nLines = nLines;
      this.mColumns = mColumns;
      this.matrixArray = new int[this.nLines][this.mColumns];

      Random random = new Random();
      for (int line = 0; line < this.nLines; ++line) {
        for (int column = 0; column < this.mColumns; ++column) {
          this.matrixArray[line][column] = random.nextInt(modulus);
        }
      }
    }
  }

  public Matrix(int[][] matrixArray, int modulus) {
    if (modulus <= 0) {
      throw new IllegalArgumentException("Modulus should be strictly greater than 0.");
    }
    for (int line = 0; line < matrixArray.length - 1; ++line) {
      if (matrixArray[line].length != matrixArray[line + 1].length) {
        throw new IllegalArgumentException(
            "Invalid matrix array! Lines of the matrix are of different size.");
      }
    }
    for (int[] line : matrixArray) {
      for (int element : line) {
        if (element < 0 || element >= modulus) {
          throw new IllegalArgumentException(
              "Invalid matrix array! Elements must be in the range `0 <= element < modulus`.");
        }
      }
    }

    this.modulus = modulus;
    if (matrixArray.length == 0) {
      this.nLines = this.mColumns = 0;
    } else {
      this.nLines = matrixArray.length;
      this.mColumns = matrixArray[0].length;
    }
    this.matrixArray = matrixArray;
  }

  /**
   * Constructor to copy a Matrix into a new object. This constructor uses the resizing constructor,
   * but instead of passing new values for {@code nLines} and {@code mColumns}, it simply uses the
   * current values from the Matrix passed in argument.
   *
   * @param matrix The Matrix to be copied.
   * @implNote
   * @see matrix.Matrix#Matrix(Matrix, int, int)
   */
  public Matrix(Matrix matrix) {
    this(matrix, matrix.nLines, matrix.mColumns);
  }

  /**
   * Constructor to create a bigger/smaller Matrix based on the Matrix passed as an argument.
   * <p>
   * In the case that the new {@code nLines} or {@code mColumns} is bigger than the current value,
   * the new positions will be filled with zeros. In the case that these are smaller, then the new
   * Matrix will be truncated.
   *
   * @param matrix The Matrix that is the basis of the new smaller/bigger Matrix.
   * @param newN   The new number of lines.
   * @param newM   The new number of columns.
   */
  public Matrix(Matrix matrix, int newN, int newM) {
    if (newN < 0 || newM < 0) {
      throw new IllegalArgumentException("Number of lines and/or columns cannot be negative.");
    }

    nLines = newN;
    mColumns = newM;
    modulus = matrix.modulus;
    matrixArray = new int[this.nLines][this.mColumns];

    final int MIN_LINES = Math.min(this.nLines, matrix.nLines);
    final int MIN_COLUMNS = Math.min(this.mColumns, matrix.mColumns);

    for (int line = 0; line < MIN_LINES; ++line) {
      for (int column = 0; column < MIN_COLUMNS; ++column) {
        this.matrixArray[line][column] = matrix.matrixArray[line][column];
      }
    }
  }

  public int getN() {
    return nLines;
  }

  public int getM() {
    return mColumns;
  }

  public int getModulus() {
    return modulus;
  }

  public int getElement(int line, int column) {
    return this.matrixArray[line][column];
  }

  public void printMatrix() {
    for (int line = 0; line < nLines; ++line) {
      for (int column = 0; column < mColumns; ++column) {
        System.out.print(matrixArray[line][column] + " ");
      }
      System.out.println();
    }
  }

  public Matrix addTo(Matrix otherMatrix) {
    return Addition.add(this, otherMatrix);
  }

  public Matrix subtractWith(Matrix otherMatrix) {
    return Subtraction.subtract(this, otherMatrix);
  }

  public Matrix multiplyBy(Matrix otherMatrix) {
    return Multiplication.multiply(this, otherMatrix);
  }
}
