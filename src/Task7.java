import java.awt.*;
import java.io.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.imageio.*;

public class Task7 {

    public static void main(String[] args) {

        System.out.println("Multiring pattern synthesis");

        int x_res = Integer.parseInt(args[0].trim());
        int y_res = Integer.parseInt(args[1].trim());
        int a = Integer.parseInt(args[2].trim()); // square side length
        int w = Integer.parseInt(args[3].trim()); // ring thickness
        String output_filename = args[4];

        BufferedImage image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
        int color1 = (new Color(0,0,0)).getRGB();
        int color2 = (new Color(255, 255, 255)).getRGB();

        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                int ni = i%a;
                int nj = j%a;
                int zi = i/a;
                int zj = j/a;
                int cx = zj + a/2;
                int cy = zi + a/2;
                double d = distance(cx, cy, ni, nj);
                if (((int)d/w)%2 == 0) {
                    image.setRGB(j, i, color1);
                }
                else {
                    image.setRGB(j, i, color2);
                }
            }
        }

        try {
            ImageIO.write(image, "BMP", new File(output_filename));
        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }

    // returns distance betwen two points in 2-dimensional space
    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
}
