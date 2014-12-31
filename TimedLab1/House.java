public class House {

    private String homeowner;
    private int numberOfBedrooms;
    private double numberOfBathrooms;
    private boolean garage;
    private final String def = "HOMEOWNER";
    private int numberofHousesInstantiated;

    public House(String homeownername, int bed, int bath, boolean garag) {
        homeowner = homeownername;
        numberOfBedrooms = bed;
        numberOfBathrooms = bath;
        garage = garag;
        numberofHousesInstantiated++;
    }
    public String getOwner() {
        return homeowner;
    }
    public void setOwner(String owner) {
        if (owner.equals("") || owner.equals(null)) {
            homeowner = owner;
        } else {
            homeowner = def;
        }
    }
    public void buildBedroom() {
        numberOfBedrooms++;
    }
    public String toString() {
        String output = "House owned by " + homeowner
            + ", " + numberOfBedrooms + " bed/"
            + numberOfBathrooms + " bath, garage: "
            + garage + ", total houses: "
            + numberofHousesInstantiated;
        return output;
    }
    public static void main(String[] args) {
        House a = new House("ani", 2, 4, true);
        House b = a;
        System.out.println(a.equals(b));
        System.out.println(a.toString());
    }

}