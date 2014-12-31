/**
 * Secret Mission
 *
 * you may ADD to this class header, but do not change the
 * visibility or class name
 */
public class SecretMission extends Mission {

    private String state;
    private SecurityClearance clearance;

    public static final String CLASSIFIED_STRING = "This information "
        + "is Classified.";

    public SecretMission(String t, String d,
        String state, SecurityClearance s) {
        super(t, d);
        state = "locked";
        clearance = s;
    }
    //your code here
    @Override
    public void setDescription(String d) {
        if (state.equals("unlocked")) {
            description = d;
        }
    }

    @Override
    public String toString() {
        if (state.equals("locked")) {
            return CLASSIFIED_STRING;
        } else if (state.equals("unlocked")) {
            return String.format(
                "%s\n--------------------------------------\n\n%s",
                description);
        }
        return CLASSIFIED_STRING; //default
    }


    /**
     * unlocks the mission's info, given some security clearance
     * should check the given clearance against the mission's clearance and
     * throw an AccessDeniedException if it is insufficient clearance.
     *
     * You may (must) ADD to this method header, but do not change the
     * visibility, return type, or method name.
     */
    public void unlockInfo() throws AccessDeniedException {
        if (this.clearance.ordinal() >= clearance.ordinal()) {
            state = "unlocked";
        }
        throw new AccessDeniedException(this.clearance);
    }


    /*
        HINT
        the .ordinal() method on an enum value gives you its position relative
        to the other values.
        For example, you can compare like so:
        someClearance.ordinal() < anotherClearance.ordinal()
        someClearance.ordinal() >= anotherClearance.ordinal()
        someClearance.ordinal() == anotherClearance.ordinal()

        e.g, SecurityClearance.CONFIDENTIAL.ordinal() < SecurityClearance.
            SECRET.ordinal() would return true
    */
}
