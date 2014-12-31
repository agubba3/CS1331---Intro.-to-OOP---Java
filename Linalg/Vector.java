/**
 * Immutable abstraction for Vector
 *
 * @author Michael Maurer
 * @version 1.2
 */
public final class Vector {

    /*
    Create final instance variables
    */
    private final double[] vector;
    private final int length;

    /**
     * Initialize instance variables
     * @param vector array representation of vector
     */
    public Vector(double[] vector) {
        this.vector = vector;
        this.length = vector.length;
    }

    /**
     * Gets value located at specified index
     * @param i index in vector
     * @return double located at index 'i' in vector
     */
    public double get(int i) throws VectorIndexOutOfBoundsException {
        if (i >= vector.length) {
            throw new VectorIndexOutOfBoundsException(
                "You tried to index the " + i
                + "th element but the vector has only "
                + vector.length + " elements.");
        }
        return vector[i];
    }

    /**
     * Get's the length of the Vector.
     * @return number of components in vector
     */
    public int getLength() {
        return length;
    }

    /**
     * String representation of vector with components
     * separated by tabs
     * @return String representation of vector
     */
    public String toString() {
        String output = "";
        for (int a = 0; a < vector.length; a++) {
            output += vector[a] + "\t";
        }
        return output;
    }
}