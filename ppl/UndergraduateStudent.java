public class UndergraduateStudent extends Student {
    public UndergraduateStudent(String firstName, String lastName
        , int intelligence, int motivation) {
        super(firstName, lastName, intelligence, motivation);
    }
    public String toString() {
        String b = "Hi, my name is " + super.firstName
            + " " + super.lastName + ". My intelligence is "
            + super.intelligence + "/10 and my motivation is "
            + super.motivation
            + "/10. I'm going home this weekend to get"
            + " laundry done; talk about clutch.";
        return b;
    }
}