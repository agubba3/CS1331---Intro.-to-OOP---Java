/**
 * AccessDeniedException
 *
 * you may ADD to this class header, but do not change the
 * visibility or class name
 */
public class AccessDeniedException extends Exception {
    private SecurityClearance requiredClearance;

    //your code here
    public AccessDeniedException(String a, SecurityClearance b) {
        super(a);
        requiredClearance = b;

    }
    public AccessDeniedException(SecurityClearance b) {
        requiredClearance = b;
        System.out.println("The current state is "
            + requiredClearance.toString());
    }

    //HINT: requiredClearance.toString() gives the enumerated type's name.

    /**
     * this is here so we can test your code; no need to change it
     * @return clearance that was needed to access the mission that threw
     *         the exception.
     */
    public SecurityClearance getRequiredClearance() {
        return requiredClearance;
    }
}
