public class Fac {
    private static int answer = 1;
    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(fact(3));
    }
    public static int fact(int in) {

        if(in > 1) {
            //answer *= in * fact(in-1);
            return in * fact(in-1);
        }
        return answer;
    }
}