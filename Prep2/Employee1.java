import java.util.Date;

public class Employee1 {

    private String name;
    private Date hireDate;

    public Employee1(String aName, Date aHireDate) {
        disallowNullArguments(aName, aHireDate);
        name = aName;
        hireDate = aHireDate;
    }
    public String getName() {
        return name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String toString() {
        return name + "; " + hireDate;
    }

    private void disallowNullArguments(Object ... args) {
        for (Object arg: args) {
            if (arg == null) {
                String msg = "Null arguments not allowed.";
                throw new IllegalArgumentException(msg);
            }
        }
    }
}
