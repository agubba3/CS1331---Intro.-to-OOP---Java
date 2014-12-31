public class Dog extends Mammal {
public void speak() {
System.out.println("Woof, woof!");
}
public static void main(String[] args) {
    Dog fido = new Dog();
    Mammal fido2 = fido;
    Mammal sparky = new Dog();
    Dog huh = (Dog) sparky; //interesting
    Mammal u = new Mammal();

}
}