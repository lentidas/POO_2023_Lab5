/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

// TODO Constructors need to verify modulo is != 0
// TODO nLines and mColumns need to be >= 0
// TODO test limit case with empty matrices when doing calculations
// TODO Report should contain modelisation UML, choices

// TODO Questions to ask:
//  - Q: Should the explicit constructor verify that every matrix element is strictly positive
//  - Q: Should the modulus also be positive? I think not, because otherwise the floorMod() usage
//    would not be necessary...
//  - Q: I do no see how to implement generic loops for the unary operations like printing the elements
//    of the matrix or the one to generate matrix with random elements.
//    A: Prof. Graf says that this is not asked of the laboratory and we can repeat the loops.

package matrix;

import java.util.Random;

public class Matrix {

  private final int modulus;
  private final int nLines;
  private final int mColumns;
  private int[][] matrixArray;

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
      int absoluteModulus = Math.abs(this.modulus);
      for (int line = 0; line < this.nLines; ++line) {
        for (int column = 0; column < this.mColumns; ++column) {
          this.matrixArray[line][column] = random.nextBoolean() ? random.nextInt(absoluteModulus)
              : -random.nextInt(
                  absoluteModulus); // TODO Verify with Sven if we really want to have negative elements
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
    int absoluteModulus = Math.abs(modulus);
    for (int[] line : matrixArray) {
      for (int element : line) {
        if (element <= -absoluteModulus || element >= absoluteModulus) {
          throw new IllegalArgumentException(
              "Invalid matrix array! Elements must be in the range `-abs(modulus) < element < abs(modulus)`.");
          // TODO Change comment depending if we only have positive values or not
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

  public Matrix(Matrix matrix) {
    this(matrix, matrix.nLines, matrix.mColumns); // TODO Add unitary test
  }

  // TODO Add comment about the behavior of this constructor saying that it truncates or adds zeros
  public Matrix(Matrix matrix, int newN, int newM) {
    if (newN < 0 || newM < 0) { // TODO Add unitary test
      throw new IllegalArgumentException("Number of lines and/or columns cannot be negative.");
    }

    nLines = newN;
    mColumns = newM;
    modulus = matrix.modulus;
    matrixArray = new int[this.nLines][this.mColumns];

    for (int line = 0; line < Math.min(this.nLines, matrix.nLines); ++line) {
      for (int column = 0; column < Math.min(this.mColumns, matrix.mColumns); ++column) {
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

  public String toString() {
    // TODO
    return null;
  }

  public void printMatrix() {
    // TODO
  }

  public int getElement(int line, int column) {
    return this.matrixArray[line][column];
  }

  public void addTo(Matrix otherMatrix) {

  }

  public void subtractTo(Matrix otherMatrix) {

  }

  public void multiplyBy(Matrix otherMatrix) {

  }
}
