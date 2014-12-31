import java.util.Scanner;
public class Doomsday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Doomsday Calculator!");
        System.out.print("Enter year: ");
        String inputyear = in.nextLine();
        String inputyeartrim = inputyear.trim();
        System.out.print("Enter month (1-12): ");
        String inputmonth = in.nextLine();
        String inputmonthtrim = inputmonth.trim();
        System.out.print("Enter day: ");
        String inputday = in.nextLine();
        String inputdaytrim = inputday.trim();
        if ((Integer.parseInt(inputdaytrim) <= 31)
                && (Integer.parseInt(inputdaytrim) >= 1)
                && (Integer.parseInt(inputmonthtrim) <= 12)
                && (Integer.parseInt(inputmonthtrim) >= 1)
                && (Integer.parseInt(inputyeartrim) >= 1900)
                && (Integer.parseInt(inputyeartrim) < 2000)) {
            System.out.println(inputmonthtrim + "/"
                + inputdaytrim + "/" + inputyeartrim
                + " was a "
                + outputday(inputyeartrim, inputmonthtrim, inputdaytrim));
        } else {
            System.out.println("Invalid Input! Try again.");
        }
    }
    public static int findDoom(String year) {
        String lasttwo = year.substring(2, 4);
        int year1 = Integer.parseInt(lasttwo);
        int step1 = Math.round(year1 / 12);
        int step2 = year1 % 12;
        int step3 = Math.round(step2 / 4);
        int anchor = step1 + step2 + step3 + 3;
        int anchormoda = anchor % 7;
        return anchormoda;
    }
    public static boolean leap(String year) {
        int year2 = Integer.parseInt(year);
        if (year2 % 4 != 0) {
            return false;
        } else {
            return year2 % 100 != 0 || year2 % 400 == 0;
        }
    }
    public static String outputday(String year, String month, String day) {
        int doomsdate = 0;
        boolean leapyear = leap(year);
        if (month.equals("1")) {
            if (leapyear) {
                doomsdate = 4;
            } else {
                doomsdate = 3;
            }
        } else if (month.equals("2")) {
            if (leapyear) {
                doomsdate = 29;
            } else {
                doomsdate = 28;
            }
        } else if (month.equals("3")) {
            doomsdate = 7;
        } else if (month.equals("4")) {
            doomsdate = 4;
        } else if (month.equals("5")) {
            doomsdate = 9;
        } else if (month.equals("6")) {
            doomsdate = 6;
        } else if (month.equals("7")) {
            doomsdate = 11;
        } else if (month.equals("8")) {
            doomsdate = 8;
        } else if (month.equals("9")) {
            doomsdate = 5;
        } else if (month.equals("10")) {
            doomsdate = 10;
        } else if (month.equals("11")) {
            doomsdate = 7;
        } else if (month.equals("12")) {
            doomsdate = 12;
        } else {
            System.out.println("Month is not valid");
        }
        int daydiff = (Integer.parseInt(day) - doomsdate) + findDoom(year);
        int dayofweek = daydiff % 7;
        if (dayofweek < 0) {
            dayofweek = dayofweek + 7;
        }
        if (dayofweek == 0) {
            return "Sunday";
        } else if (dayofweek == 1) {
            return "Monday";
        } else if (dayofweek == 2) {
            return "Tuesday";
        } else if (dayofweek == 3) {
            return "Wednesday";
        } else if (dayofweek == 4) {
            return "Thursday";
        } else if (dayofweek == 5) {
            return "Friday";
        } else if (dayofweek == 6) {
            return "Saturday";
        } else {
            return "error";
        }
    }
}