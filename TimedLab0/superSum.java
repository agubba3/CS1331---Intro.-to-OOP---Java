import java.util.Scanner;

public class superSum{
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        System.out.println("Enter list: ");
        String input = c.nextLine();
        int c1 = 0;
        int c2 = 1;
        int c3 = 0;
        int listcount = 0;
        int sum = 0;
        int totalsum = 0;
        int n = 0;
        while(listcount < input.length() + 2){
            while(c1 < input.length()-n){
                System.out.println(totalsum);
                System.out.println("sum: " + sum);
            sum += Integer.parseInt(input.substring(c1,c2));
            c1 += 2;
            c2 += 2;
        }
        n += 2;
        totalsum += sum;
        listcount += 2;;
        }
        System.out.println(totalsum);
        //System.out.println(Integer.parseInt(input.substring(c1,c2)));
    }
}