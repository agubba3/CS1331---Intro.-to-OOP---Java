public class Professor extends Person {

    private int rateMyProfessorRating;
    private double averageGPA;

    public Professor(String firstName, String lastName,
        int rateMyProfessorRating, double averageGPA) {
        super(firstName, lastName);
        this.rateMyProfessorRating = rateMyProfessorRating;
        this.averageGPA = averageGPA;
    }
    public String toString() {
        String answer = "Hi, my name is " + super.firstName
            + " " + super.lastName + ". My Rate My Professor rating is "
            + rateMyProfessorRating + "/5 and my average GPA is "
            + averageGPA
            + ". I really wish students would stop emailing me so much.";
        return answer;
    }
}
