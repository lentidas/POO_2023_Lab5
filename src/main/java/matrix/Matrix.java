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

public class Matrix {

  private final int modulus;
  private final int nLines;
  private final int mColumns;
  private int[][] matrixArray;

  Matrix() {
    this(new int[0][0], 1);
  }

  Matrix(int nLines, int mColumns, int modulus) {
    // TODO Add exception if modulus equals 0 or if nLines/mColumns is negative

    this.modulus = modulus;
    this.nLines = nLines;
    this.mColumns = mColumns;
    this.matrixArray = new int[nLines][mColumns];

    // TODO Implement creation of random matrixArray
  }

  Matrix(int[][] matrixArray, int modulus) {
    // TODO Add exception if modulus equals 0

    this.nLines = matrixArray.length;
    this.mColumns = matrixArray[0].length;
    this.modulus = modulus;
    this.matrixArray = matrixArray;
  }

  Matrix(Matrix matrix) {
    this(matrix, matrix.nLines, matrix.mColumns);
  }

  Matrix(Matrix matrix, int newN, int newM) {
    // TODO Add exception if nLines/mColumns is negative

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
