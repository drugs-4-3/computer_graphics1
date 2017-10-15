import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task2 {

    public static void main(String[] args) {

        System.out.println("Grid pattern synthesis");

        BufferedImage image;

        final int x_res = Integer.parseInt(args[0].trim());
        final int y_res = Integer.parseInt(args[1].trim());
        final int bar_width = Integer.parseInt(args[2].trim());
        final int center_distance_x = Integer.parseInt(args[3].trim());
        final int center_distance_y = Integer.parseInt(args[4].trim());
        final String filename = args[5];

        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                Color color = new Color(0,0,0);
                if (j % center_distance_x < (center_distance_x - bar_width)/2 || j % center_distance_x > (center_distance_x - bar_width)/2 + bar_width) {
                    if (i % center_distance_y < (center_distance_y - bar_width)/2 || i % center_distance_y > (center_distance_y - bar_width)/2 + bar_width) {
                        color = new Color(255,255,255);
                    }
                }
                image.setRGB(j, i, color.getRGB());
            }
        }

        try {
            ImageIO.write(image, "BMP", new File(filename));
        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }

}
