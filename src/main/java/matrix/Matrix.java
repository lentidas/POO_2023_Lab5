/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

package matrix;

import java.util.Random;
import matrix.binaryOperation.*;

public class Matrix {

  private final int modulus;
  private final int nLines;
  private final int mColumns;
  private final int[][] matrixArray;

  public Matrix() {
    this(new int[0][0], 1);
  }

  public Matrix(int nLines, int mColumns, int modulus) {
    if (modulus == 0) {
      throw new IllegalArgumentException("Modulus cannot be nul because we cannot divide by 0.");
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
      final int ABSOLUTE_MODULUS = Math.abs(this.modulus);
      for (int line = 0; line < this.nLines; ++line) {
        for (int column = 0; column < this.mColumns; ++column) {
          this.matrixArray[line][column] = random.nextInt(ABSOLUTE_MODULUS);
        }
      }
    }
  }

  public Matrix(int[][] matrixArray, int modulus) {
    if (modulus == 0) {
      throw new IllegalArgumentException("Modulus cannot be nul because we cannot divide by 0.");
    }
    for (int line = 0; line < matrixArray.length - 1; ++line) {
      if (matrixArray[line].length != matrixArray[line + 1].length) {
        throw new IllegalArgumentException(
            "Invalid matrix array! Lines of the matrix are of different size.");
      }
    }
    final int ABSOLUTE_MODULUS = Math.abs(modulus);
    for (int[] line : matrixArray) {
      for (int element : line) {
        if (element < 0 || element >= ABSOLUTE_MODULUS) {
          throw new IllegalArgumentException(
              "Invalid matrix array! Elements must be in the range `0 <= element < abs(modulus)`.");
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

  // TODO Add comment saying that this throws the same exceptions as the resize constructor
  //  but it should not be a problem since the current matrix should already be valid and contain
  //  proper nLines and mColumn values.
  //  Also, there is no validation of the parameter matrix, as it should already have been
  //  validated by the rest of the code.
  public Matrix(Matrix matrix) {
    this(matrix, matrix.nLines, matrix.mColumns);
  }

  // TODO Add comment about the behavior of this constructor saying that it truncates or adds zeros.
  //  Also, there is no validation of the parameter matrix, as it should already have been
  //  validated by the rest of the code.
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

  public void printMatrix() { // TODO Add test?
    for (int line = 0; line < nLines; ++line) {
      for(int column = 0; column < mColumns; ++column) {
        System.out.print(matrixArray[line][column] + " ");
      }
      System.out.println();
    }
  }

  // TODO Implement swaps to use on the intrinsic operations below
  // TODO Implement also single parameter swap

  public void swap(Matrix otherMatrix) {
    int nLinesTemp = otherMatrix.nLines;
    int mColumnsTemp = otherMatrix.mColumns;
    int modulusTemp = otherMatrix.modulus;
    int[][] tempMatrixArray = otherMatrix.matrixArray;

    // FIXME I do not know what it is best to do... Maybe a private setter?
//    nLines = otherMatrix.nLines;
  }

  public void addTo(Matrix otherMatrix) {
//    this = Addition.add(this, otherMatrix); // FIXME Use swap because we cannot do an affectation with this
  }

  public void subtractTo(Matrix otherMatrix) {
//    this = Subtraction.subtract(this, otherMatrix); // FIXME Use swap because we cannot do an affectation with this
  }

  public void multiplyBy(Matrix otherMatrix) {
//    this = Multiplication.multiply(this, otherMatrix); // FIXME Use swap because we cannot do an affectation with this
  }
}
