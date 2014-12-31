public class Zoo {
    private Animal[] animals;
    private static int animalCount;
    public Zoo(Dog...arr) {
        animals = arr;
    }
    public void soundOff() {
        for(Animal d: animals) {
            System.out.println(d.getName() + d.speak());
        }
    }
}
// public boolean equals(Object other) {
// if (null == other) { return false; }
// if (this == other) { return true; }
// if (!(other instanceof Person)) { return false; }
// Person that = (Person) other;
// return this.name.equals(that.name);
// }
