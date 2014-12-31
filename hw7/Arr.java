import java.util.ArrayList;
import java.util.*;
public class Arr {
public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList();
    a.add(2);
    a.add(3);
    //a.add("four");
    int x = a.get(0);
     //HashMap<String, Double> tm = new HashMap();
    TreeMap<String, Double> tm = new HashMap();
      // Put elements to the map
      tm.put("Zara", new Double(3434.34));
      tm.put("Mahnaz", new Double(123.22));
      tm.put("Ayan", new Double(1378.00));
      tm.put("Daisy", new Double(99.22));
      tm.put("Qadir", new Double(-19.08));
    Set<String> add = tm.keySet();
    for(String t: add) {
        System.out.println(t);
    }
}
}