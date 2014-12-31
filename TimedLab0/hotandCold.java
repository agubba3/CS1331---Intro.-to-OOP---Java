import java.util.Scanner;
public class hotandCold{
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Enter actual: ");
        String input = c.nextLine();
        int inputnum = Integer.parseInt(input);
        int times = 0;
        int guess = 0;
        int count;
        for(count = 0; guess != inputnum; count++){
            System.out.println("Enter guess: ");
            guess = Integer.parseInt(c.nextLine());
            if (guess < inputnum){
            System.out.println("Too Low");
            }
            else if(guess > inputnum){
                System.out.println("Too High");
            }

        }
        System.out.println("You are correct and got it in " + count + " tries");
    }
}