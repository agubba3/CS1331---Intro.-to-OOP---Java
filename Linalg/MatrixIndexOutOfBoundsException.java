public class MatrixIndexOutOfBoundsException extends IndexOutOfBoundsException {
     /**
     * no args constructor which just calls the super constructor
     */
    public MatrixIndexOutOfBoundsException() {
        super();
    }
     /**
     * Initialize instance variables
     * @param   String msg  The message which is passed
     *  in to the superclass's constructor and displayed
     * when the throw is caught
     */
    public MatrixIndexOutOfBoundsException(String msg) {
        super(msg);
    }
}