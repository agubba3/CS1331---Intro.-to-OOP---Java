public class IllegalOperandException extends Exception {
     /**
     * Initialize instance variables
     * @param   String msg  The message which is
     * passed in to the superclass's constructor
     * and displayed when the throw is caught
     */
    public IllegalOperandException(String msg) {
        super(msg);
    }
     /**
     * no args constructor which just calls the super constructor
     */
    public IllegalOperandException() {
        super();
    }
}