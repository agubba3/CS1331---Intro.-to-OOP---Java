public class nig extends Exception{
    public static void main(String[] args) {
        Exception a = new nig();
        System.out.println(a.test());
    }
    public int test() {
        return 3;
    }
    // public Exception testing() {
    //     return new nig();
    // }
    public nig testing() {
        return new nig();
    }
    public nig testing(int a) {
        return new nig();
    }
}