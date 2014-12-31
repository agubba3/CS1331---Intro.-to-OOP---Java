/**
 * Immutable abstraction of Matrix.
 *
 * @author Michael Maurer
 * @version 1.2
 */
public final class Matrix {

    /*
    Create final instance variables
    */
    private final double[] [] matrix;
    private final int height;
    private final int width;

    /**
     * Initialize instance variables
     * @param matrix 2D array representation of Matrix
     */
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.height = matrix.length;
        this.width = matrix[0].length;
    }
    /**
     * Gets value located at specified row and column
     * @param i row
     * @param j column
     * @return double located at row i and column j in matrix
     */
    public double get(int i, int j)
        throws MatrixIndexOutOfBoundsException {
        if (i >= matrix.length) {
            throw new MatrixIndexOutOfBoundsException(
                "You tried to index into the "
                + i + "th row but the matrix has only "
                + matrix.length + " rows.");
        } else if (j >= matrix[0].length) {
            throw new MatrixIndexOutOfBoundsException(
                "You tried to index into the "
                + j + "th column but the matrix has only "
                + matrix[0].length + " columns.");
        }
        return matrix[i][j];
    }

    /**
     * Get's the height of the matrix.
     * @return number of rows in matrix
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get's the width of the matrix.
     * @return number of columns in matrix
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets String representation of matrix.
     * Columns separated by tabs, rows by new lines.
     * @return String representation of matrix.
     */
    public String toString() {
        String output = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output += matrix[i][j] + "\t";
            }
            output += "\n";
        }
        return output;
    }
}