public abstract class Animal {
    private String name;
    public abstract Animal(String n);
    public String getName() {
        return name;
    }
    public void setName(String a) {
        name = a;
    }
    public String speak() {
        return "Dummie";
    }
}