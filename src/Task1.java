import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task1 {

    public static void main(String[] args) {

        System.out.println("Ring with blur effect pattern synthesis");

        BufferedImage image;
        int x_res, y_res;
        int x_c, y_c;
        int i, j;

        x_res = Integer.parseInt(args[0].trim());
        y_res = Integer.parseInt(args[1].trim());
        final int w = Integer.parseInt(args[2].trim());

        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        x_c = x_res / 2;
        y_c = y_res / 2;

        for (i = 0; i < y_res; i++) {
            for (j = 0; j < x_res; j++) {
                double d;
                int r;
                d = Math.sqrt((i - y_c)*(i - y_c) + (j - x_c)*(j - x_c));
                r = (int)d / w;
                int alpha = (int)(((d % w)/w)*255);
                if (r % 2 == 0) {
                    alpha = 255 - alpha;
                }
                image.setRGB(j, i, new Color(alpha, alpha, alpha).getRGB());
            }
        }

        try {
            ImageIO.write(image, "BMP", new File(args[3]));
        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }

}
