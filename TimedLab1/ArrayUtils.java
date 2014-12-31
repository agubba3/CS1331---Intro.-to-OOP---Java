public class ArrayUtils {

    public static void main(String[] args) {
        int[] test1 = new int[] {1, 7, 10};
        int[] test2 = new int[] {1, 4, 9};
        //System.out.println("Answer: " + reverseProduct(test1, test2));
        int a = 2;
        a = ++a;
        int t = 4;
        float b = t;
        float gt = 3f/4;
        char gg = 'a' ;
        char ggt = 'b';
        int nig = 1 +-+ 3;
        double[] Scores = {1,2,3};
        double test = (1/3) * 3;
        int hg = 9;
        int y = hg++;
        int o = hg;
        int g1 = 0;
        int result;
        int other;
        int n = 2;
        int[] squares = new int[5];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = i*i;
        }
        System.out.println(squares[4]);
        System.out.println(o);
        System.out.println(((result = (n++)) + (other = (2*(n++)))));
        return 2;
    }
    public static int reverseProduct(int[] a1, int[] a2) {
        int finalproduct = 0;
        int counter2 = (a2.length) - 1;
        for (int indexa = 0; indexa < a1.length; indexa++) {
            finalproduct += (a1[indexa]) * (a2[counter2]);
            counter2--;
        }
        return finalproduct;
    }
}