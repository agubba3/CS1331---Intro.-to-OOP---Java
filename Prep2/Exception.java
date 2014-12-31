public class Exception extends RuntimeException{ //does not work if I extend exception

     public static int operate() throws ArithmeticException {
        // try{
        //     return (4/0);
        // }
        // catch (ArithmeticException e) {
        //     throw new ArithmeticException("nigga");
        // }
        return (4/0);
     }
    public static void main(String[] args) {

        try {
            System.out.println(operate());
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }


     }
     protected int test() {
        return 2;
     }
     public Exception testing(){
        return new Exception();}
}