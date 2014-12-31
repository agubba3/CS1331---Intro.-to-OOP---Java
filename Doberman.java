public class Doberman {
private static int dobieCount = 0;
private String name;
public Doberman(String name) {
this.name = name;
dobieCount++;
}
public String reportDobieCount() {
    dobieCount++;
return name+" says there are "+dobieCount+" dobies.";
}
public static void main(String[] args) {
    Doberman fido = new Doberman("Fido");
System.out.println(fido.reportDobieCount());
Doberman prince = new Doberman("Prince");
System.out.println(prince.reportDobieCount());
Doberman chloe = new Doberman("Chloe");
System.out.println(chloe.reportDobieCount());

}
}
