import java.util.*;
public class Trooper {
private String name;
private boolean mustached;
public Trooper(String name, boolean hasMustache) {
this.name = name; this.mustached = hasMustache;
}
public String getName() { return name; }
public boolean hasMustache() { return mustached; }
public boolean equals(Object other) {
if (this == other) return true;
if (null == other || !(other instanceof Trooper)) return false;
Trooper that = (Trooper) other;
return this.name.equals(that.name) && this.mustached == that.mustached;
}
public int hashCode() { return super.hashCode(); }
public static void main(String[] args) {
    ArrayList<Trooper> troopers = new ArrayList<>();
troopers.add(new Trooper("Farva", true));
troopers.add(new Trooper("Farva", true));
troopers.add(new Trooper("Rabbit", false));
troopers.add(new Trooper("Mac", true));
 ArrayList a = new ArrayList();
 a.add(1);
 a.add(2);
 a.add(3);
 a.add("four");

// Collections.sort(troopers, (a,b) -> {
//     if((!a.hasMustache())&&b.hasMustache()) {
//         return 1;
//     } else if(a.hasMustache()&&(!b.hasMustache())) { //a is greater than b u return -1
//         return 11;
//     } else {
//         return a.getName().compareTo(b.getName());
//     }
// });
}
}
