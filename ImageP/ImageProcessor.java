import java.util.Scanner;

public class ImageProcessor {

    private Pic picture;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like an overlay? Type Yes or No: ");
        String in = input.nextLine();
        Pic troll = new Pic("troll.jpg");
        ImageProcessor mega = new ImageProcessor(troll);
        if (in.equals("Yes")) {
            System.out.print("Specify name of image: ");
            String name = input.nextLine();
            Pic a = new Pic(name);
            mega.overlay(a).show();
        } else if (in.equals("No")) {
            System.out.print("Thank for using Image Processor!");
        } else {
            System.out.print("INVALID INPUT!");
        }
        mega.grayscale().show();
        mega.invert().show();
        mega.noRed().show();
        mega.blackAndWhite().show();
        mega.maximize().show();
    }
    public ImageProcessor(Pic picture) {
        this.picture = picture;
    }
    public Pic grayscale() {
        int sum = 0;
        Pic p = new Pic("troll.jpg");
        Pixel[][] samples = p.getPixels();
        for (int a = 0; a < samples.length; a++) {
            for (int b = 0; b < samples[a].length; b++) {
                sum = (samples[a][b].getRed() + samples[a][b].getGreen()
                    + samples[a][b].getBlue()) / 3;
                samples[a][b].setRed(sum);
                samples[a][b].setBlue(sum);
                samples[a][b].setGreen(sum);
            }
        }
        return p;
    }
    public Pic invert() {
        Pic p = new Pic("troll.jpg");
        Pixel[][] samples = p.getPixels();
        for (int a = 0; a < samples.length; a++) {
            for (int b = 0; b < samples[a].length; b++) {
                samples[a][b].setRed(255 - samples[a][b].getRed());
                samples[a][b].setBlue(255 - samples[a][b].getBlue());
                samples[a][b].setGreen(255 - samples[a][b].getGreen());
            }
        }
        return p;
    }
    public Pic noRed() {
        Pic p = new Pic("troll.jpg");
        Pixel[][] samples = p.getPixels();
        for (int a = 0; a < samples.length; a++) {
            for (int b = 0; b < samples[a].length; b++) {
                samples[a][b].setRed(0);
            }
        }
        return p;
    }
    public Pic blackAndWhite() {
        Pic p = new Pic("troll.jpg");
        int average = 0;
        Pixel[][] samples = p.getPixels();
        for (int a = 0; a < samples.length; a++) {
            for (int b = 0; b < samples[a].length; b++) {
                average = (samples[a][b].getRed() + samples[a][b].getGreen()
                    + samples[a][b].getBlue()) / 3;
                if (average > 127) {
                    samples[a][b].setRed(255);
                    samples[a][b].setBlue(255);
                    samples[a][b].setGreen(255);
                } else {
                    samples[a][b].setRed(0);
                    samples[a][b].setBlue(0);
                    samples[a][b].setGreen(0);
                }
            }
        }
        return p;
    }
    public Pic maximize() {
        Pic p = new Pic("troll.jpg");
        int max = 0;
        Pixel[][] samples = p.getPixels();
        for (int a = 0; a < samples.length; a++) {
            for (int b = 0; b < samples[a].length; b++) {
                max = Math.max(samples[a][b].getRed(),
                    Math.max(samples[a][b].getBlue(),
                        samples[a][b].getGreen()));
                if (samples[a][b].getRed() < max) {
                    samples[a][b].setRed(0);
                }
                if (samples[a][b].getBlue() < max) {
                    samples[a][b].setBlue(0);
                }
                if (samples[a][b].getGreen() < max) {
                    samples[a][b].setGreen(0);
                }
            }
        }
        return p;
    }
    public Pic overlay(Pic gt) {
        Pic p = new Pic("troll.jpg");
        Pixel[][] samples = p.getPixels();
        Pixel[][] car = gt.getPixels();
        int minimumW = Math.min((samples[1].length), (car[1].length));
        int minimumH = Math.min((samples.length), (car.length));
        if (car[1].length > samples[1].length && car.length > samples.length) {
            for (int a = 0; a < samples.length; a++) {
                for (int b = 0; b < samples[1].length; b++) {
                    samples[a][b].setRed(car[a][b].getRed() / 2
                        + samples[a][b].getRed() / 2);
                    samples[a][b].setGreen(car[a][b].getGreen() / 2
                        + samples[a][b].getGreen() / 2);
                    samples[a][b].setBlue(car[a][b].getBlue() / 2
                        + samples[a][b].getBlue() / 2);
                }
            }
        } else {
            for (int a = 0; a < minimumH; a++) {
                for (int b = 0; b < minimumW; b++) {
                    samples[a][b].setRed(car[a][b].getRed() / 2
                        + samples[a][b].getRed() / 2);
                    samples[a][b].setGreen(car[a][b].getGreen() / 2
                        + samples[a][b].getGreen() / 2);
                    samples[a][b].setBlue(car[a][b].getBlue() / 2
                        + samples[a][b].getBlue() / 2);
                }
            }
        }
        return p;
    }
}