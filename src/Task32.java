import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task32 {

    // todo: ustawiać parametrycznie kolory pól

    public static void main(String[] args) {

        System.out.println("Chessboard pattern synthesis 2");

        // arguments from console
        final int x_res = Integer.parseInt(args[0].trim());
        final int y_res = Integer.parseInt(args[1].trim());
        final int field_width = Integer.parseInt(args[2].trim());
        final String filename = args[3];


        final Color color1 = new Color(0,0,0);
        final Color color2 = new Color(255,255,255);
        final double a = field_width*Math.sqrt(2);

        BufferedImage image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
        Color color;
        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                int ni = (int)(i % a);
                int nj = (int)(j % a);
                if (nj < (a/2)) {
                    if (ni < (a/2)) {
                        color = (ni + nj) < (a/2) ? color1 : color2;
                    }
                    else {
                        ni = (int)(ni % (a/2));
                        color = (ni % (a/2)) - nj >= 0 ? color1 : color2;
                    }
                }
                else {
                    nj = (int)(nj % (a/2));
                    if (ni < (a/2)) {
                        color = ni - nj < 0 ? color1 : color2;
                    } else {
                        ni = (int)(ni % (a/2));
                        color = ni + nj >= a/2 ? color1 : color2;
                    }
                }
                image.setRGB(j, i, color.getRGB());
            }
        }
        System.out.println("We did it!");

        try {
            ImageIO.write(image, "BMP", new File(filename));
        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }

}
