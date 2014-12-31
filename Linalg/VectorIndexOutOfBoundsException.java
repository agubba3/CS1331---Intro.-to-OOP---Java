public class VectorIndexOutOfBoundsException extends IndexOutOfBoundsException {
     /**
     * no args constructor which just calls the super constructor
     */
    public VectorIndexOutOfBoundsException() {
        super();
    }
     /**
     * Initialize instance variables
     * @param   String msg  The message which is
     * passed in to the superclass's constructor
     * and displayed when the throw is caught
     */
    public VectorIndexOutOfBoundsException(String msg) {
        super(msg);
    }
}