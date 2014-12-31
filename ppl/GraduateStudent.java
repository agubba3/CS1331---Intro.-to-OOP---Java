public class GraduateStudent extends Student {
    public GraduateStudent(String firstName, String lastName,
        int intelligence, int motivation) {
        super(firstName, lastName, intelligence, motivation);
    }

    public String toString() {
        String g = "Hi, my name is " + super.firstName + " "
            + super.lastName + ". My intelligence is "
            + super.intelligence + "/10 and my motivation is "
            + super.motivation + "/10. I'm stressed out AND broke.";
        return g;
    }
}