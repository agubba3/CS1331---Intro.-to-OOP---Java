/**
 * Driver for Linear Algebra.
 *
 * @author Michael Maurer
 * @version 1.2
 */
import java.util.InputMismatchException;
public class LinearAlgebraDriver {

    /**
     * Runs program asking user for input and running linear algebra methods.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        LinearAlgebraScanner input = new LinearAlgebraScanner();
        boolean done = false;
        System.out.println("Howdy!");
        System.out.println("This heres the greatest calculator ever");
        System.out.println("created with 10 functions or less.");
        while (!done) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("0. matrix + matrix");
            System.out.println("1. matrix * vector");
            System.out.println("2. vector . vector");
            System.out.println("3. vector + vector");
            System.out.println("4. Exit\n");
            String line = input.nextLine();
            int userInput = Integer.parseInt(line);
            System.out.println();
            if (userInput == 0) {
                System.out.println("Please enter a matrix!");
                System.out.println("Enter empty line to terminate!");
                Matrix m1 = null;
                while (m1 == null) {
                    try {
                        m1 = input.readMatrix();
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Enter again.");
                    }
                }
                System.out.println("Please enter a matrix!");
                System.out.println("Enter empty line to terminate!");
                Matrix m2 = null;
                while (m2 == null) {
                    try {
                        m2 = input.readMatrix();
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Enter again.");
                    }
                }
                System.out.println();
                try {
                    System.out.println(LinearAlgebra.matrixAdd(m1, m2));
                } catch (IllegalOperandException e) {
                    System.out.println(e.getMessage());
                }
            } else if (userInput == 1) {
                System.out.println("Please enter a matrix!");
                System.out.println("Enter empty line to terminate!");
                Matrix m1 = null;
                while (m1 == null) {
                    try {
                        m1 = input.readMatrix();
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Enter again.");
                    }
                }
                System.out.println("Please enter a vector!");
                Vector v1 = null;
                while (v1 == null) {
                    try {
                        v1 = input.readVector();
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Enter again.");
                    }
                }
                System.out.println();
                System.out.println();
                try {
                    System.out.println(
                        LinearAlgebra.matrixVectorMultiply(m1, v1));
                } catch (IllegalOperandException e) {
                    System.out.println(e.getMessage());
                }
            } else if (userInput == 2) {
                System.out.println("Please enter a vector!");
                System.out.println("Separate vector components by "
                    + "using a space.");
                Vector v1 = null;
                while (v1 == null) {
                    try {
                        v1 = input.readVector();
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Enter again.");
                    }
                }
                System.out.println();
                System.out.println("Please enter a vector!");
                System.out.println("Separate vector components by "
                    + "using a space.");
                Vector v2 = null;
                while (v2 == null) {
                    try {
                        v2 = input.readVector();
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Enter again.");
                    }
                }
                System.out.println();
                System.out.println();
                try {
                    System.out.println(LinearAlgebra.dotProduct(v1, v2));
                } catch (IllegalOperandException e) {
                    System.out.println(e.getMessage());
                }
            } else if (userInput == 3) {
                System.out.println("Please enter a vector!");
                System.out.println("Separate vector components by "
                    + "using a space.");
                Vector v1 = null;
                while (v1 == null) {
                    try {
                        v1 = input.readVector();
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Enter again.");
                    }
                }
                System.out.println();
                System.out.println("Please enter a vector!");
                System.out.println("Separate vector components by "
                    + "using a space.");
                Vector v2 = null;
                while (v2 == null) {
                    try {
                        v2 = input.readVector();
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Enter again.");
                    }
                }
                System.out.println();
                System.out.println();
                try {
                    System.out.println(LinearAlgebra.vectorAdd(v1, v2));
                } catch (IllegalOperandException e) {
                    System.out.println(e.getMessage());
                }
            } else if (userInput == 4) {
                done = true;
            }
        }
    }
}