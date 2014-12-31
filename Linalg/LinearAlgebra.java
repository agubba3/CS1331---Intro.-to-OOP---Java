public class LinearAlgebra {
    /**
     * The method which multiples a matrix with a vector
     * @param   Matrix m   The matrix which is to be multiplied by the vector
     * @param   Vector v   The vector which is multiplied with the matrix
     * @return  The vector which is the product
     * of the Matrix and Vector passed in
     */
    public static Vector matrixVectorMultiply(Matrix m, Vector v)
        throws IllegalOperandException {
        if (m.getWidth() != v.getLength()) {
            throw new IllegalOperandException(
                "The column dimension of the matrix is "
                + m.getWidth() + " which must equal the "
                + v.getLength() + " row(s) the vector contains!");
        }
        double[] output = new double[m.getHeight()];
        for (int i = 0; i < m.getHeight(); i++) {
            for (int j = 0; j < m.getWidth(); j++) {
                try {
                    output[i] += m.get(i, j) * v.get(j);
                } catch (MatrixIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                } catch (VectorIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        Vector out = new Vector(output);
        return out;
    }
    /**
     * The method to add two matrices together and return the sum
     * @param   Matrix m1  The matrix which is to be added to
     * another matrix passed in
     * @param   Matrix m2  The other matrix which is added to m1
     * @return  The matrix which is the sum of the two matrices passed in
     */
    public static Matrix matrixAdd(Matrix m1, Matrix m2)
        throws IllegalOperandException {
        //dimensions of both matrices must be identical
        if (m1.getWidth() != m2.getWidth()) {
            throw new IllegalOperandException("The width"
                + " dimensions of the two matrices do not equal. "
                + "The first matrix's width is " + m1.getWidth()
                + " whereas the second matrix's width is "
                + m2.getWidth() + ".");
        }
        if (m1.getHeight() != m2.getHeight()) {
            throw new IllegalOperandException("The height"
                + " dimensions of the two matrices do not equal."
                + " The first matrix's width is " + m1.getHeight()
                + " whereas the second matrix's width is "
                + m2.getHeight() + ".");
        }
        double[][] output = new double[m1.getHeight()][m1.getWidth()];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                try {
                    output[i][j] = m1.get(i, j) + m2.get(i, j);
                } catch (MatrixIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        Matrix out = new Matrix(output);
        return out;
    }
    /**
     * The method to dot two matrices and return the dot product
     * @param   Vector v1  The first vector which is to
     * be dotted by another vector
     * @param   Vector v2  The second vector which is dotted
     * by the first vector passed in
     * @return  The dot product of the two vectors as a double
     */
    public static double dotProduct(Vector v1, Vector v2)
        throws IllegalOperandException {
        if (v1.getLength() != v2.getLength()) {
            throw new IllegalOperandException("To compute the dot product,"
                + " the length of the vectors must equal! The length"
                + " of your first vector is " + v1.getLength()
                + " and the length of your second vector is "
                + v2.getLength() + ".");
        }
        double output = 0; //both matrices must be the same size
        for (int a = 0; a < v1.getLength(); a++) {
            try {
                output += v1.get(a) * v2.get(a);
            } catch (VectorIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        return output;
    }
    /**
     * The method which adds two vectors and returns a vector
     * @param   Vector v1  The first vector which is added to another vector
     * @param   Matrix m2  The second vector which is added to the first vector
     * @return  The vector which is the sum of two vectors
     */
    public static Vector vectorAdd(Vector v1, Vector v2)
        throws IllegalOperandException {
        if (v1.getLength() != v2.getLength()) {
            throw new IllegalOperandException("To add two vectors, "
                + " the length of the vectors must equal!"
                + " The length of your first vector is "
                + v1.getLength() + " and the length of your second"
                + " vector is " + v2.getLength() + ".");
        }
        double[] b = new double[v1.getLength()];
        for (int c = 0; c < b.length; c++) {
            try {
                b[c] = v1.get(c) + v2.get(c);
            } catch (VectorIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        Vector out = new Vector(b);
        return out;
    }
}