/**
 * @author Gonçalo Carvalheiro Heleno
 * @author Sven Ferreira Silva
 */

// TODO Constructors need to verify modulo is != 0
// TODO nLines and mColumns need to be >= 0
// TODO Matrices cannot have negative integers
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

  Matrix() {
    this(new int[0][0], 1); // TODO Add unitary test
  }

  public Matrix(int nLines, int mColumns, int modulus) {
    if (modulus == 0) { // TODO Add unitary test
      throw new IllegalArgumentException("Modulus cannot be nul because we cannot divide by 0.");
    }
    if (nLines < 0 || mColumns < 0) { // TODO Add unitary test
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
      Random randomInt = new Random();
      for (int line = 0; line < nLines; ++line) {
        for (int column = 0; column < mColumns; ++column) {
          this.matrixArray[line][column] = randomInt.nextInt(modulus);
        }
      }
    }
  }

  public Matrix(int[][] matrixArray, int modulus) {
    if (modulus == 0) { // TODO Add unitary test
      throw new IllegalArgumentException("Modulus cannot be nul because we cannot divide by 0.");
    }
    for (int i = 0; i < matrixArray.length - 1; ++i) { // TODO Add unitary test
      if (matrixArray[i].length != matrixArray[i + 1].length) {
        throw new IllegalArgumentException(
            "Invalid matrix array! Lines of the matrix are of different size.");
      }
    }
    for (int[] line : matrixArray) { // TODO Add unitary test
      for (int element : line) {
        if (element < 0 || element >= modulus) {
          throw new IllegalArgumentException(
              "Invalid matrix array! Elements must be between 0 and modulus - 1.");
        }
      }
    }

    this.nLines = matrixArray.length;
    this.mColumns = matrixArray[0].length;
    this.modulus = modulus;
    this.matrixArray = matrixArray;
  }

  Matrix(Matrix matrix) {
    this(matrix, matrix.nLines, matrix.mColumns); // TODO Add unitary test
  }

  public Matrix(Matrix matrix, int newN, int newM) {
    if (newN < 0 || newM < 0) { // TODO Add unitary test
      throw new IllegalArgumentException("Number of lines and/or columns cannot be negative.");
    }
    // TODO Consider if we should add an exception in the case newN or newM are inferior to
    //  matrix.nLines or matrix.mColumns or if we should accept it and reduce the matrix.

    nLines = newN;
    mColumns = newM;
    modulus = matrix.modulus;

    // TODO Implement creation of this.matrixArray from matrix.matrixArray with the extra 0 on the end;
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
}
