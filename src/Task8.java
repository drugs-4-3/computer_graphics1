import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task8 {

    public static void main(String[] args) {

        System.out.println("Mixing images");

        final int w = 10;

        String filename1 = args[0];
        String filename2 = args[1];
        String output_filename = args[2];
        BufferedImage image1 = null;
        BufferedImage image2 = null;

        try {
            image1 = ImageIO.read(new File(filename1));
            image2 = ImageIO.read(new File(filename2));
        } catch(IOException e) {
            System.out.println("Error: Images could not be opened.");
            System.exit(1);
        }

        int x_res = image1.getWidth();
        int y_res = image1.getHeight();
        int x_c = x_res/2;
        int y_c = y_res/2;


        int color1 = (new Color(0,0,0)).getRGB();
        int color2 = (new Color(255, 255, 255)).getRGB();

        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                double d = Math.sqrt((i - y_c)*(i - y_c) + (j - x_c)*(j - x_c));
                int r = (int)d / w;
                if (r % 2  == 0) {
                    image1.setRGB(j, i, image2.getRGB(j, i));
                }
            }
        }

        try {
            ImageIO.write(image1, "BMP", new File(output_filename));
        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }

    // returns distance betwen two points in 2-dimensional space
    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
}
