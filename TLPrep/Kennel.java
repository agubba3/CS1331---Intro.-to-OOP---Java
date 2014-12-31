public class Kennel {
    private Dog[] dogs;
    public Kennel(Dog...arr) {
        dogs = arr;
    }
    public void soundOff() {
        for(Dog d: dogs) {
            System.out.println(d.getName() + d.speak());
        }
    }
}