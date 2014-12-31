public class PersonList {

    private static int count;
    private Person[] people;

    public PersonList(int maxSize) {
        people = new Person[maxSize];
    }

    public void listPeople() {
        int dummy = 0;
        for (int p = 0; p < people.length; p++) {
            if (people[p] == null) {
                dummy++;
            } else {
                System.out.println(people[p]);
            }
        }
    }
    // public void add(Person p) {
    //     for(int i = 0; i < people.length; i++) {
    //         if (people[i] == null) {
    //             people[i] = p;
    //             break;
    //         }
    //     }
    // }
    public void add(Person p) {
        int dummy = 0;
        int i = 0;
        for (i = 0; people[i] != null && i < people.length; i++) {
            dummy++;
        }
        if (i == people.length) {
            System.out.println("Reached the end!");
        } else {
            people[i] = p;
        }
    }
}