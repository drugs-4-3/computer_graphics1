import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task32 {

    // todo: ustawiać parametrycznie kolory pól

    public static void main(String[] args) {

        System.out.println("Chessboard pattern synthesis 2");

        BufferedImage image;

        final int x_res = Integer.parseInt(args[0].trim());
        final int y_res = Integer.parseInt(args[1].trim());
        final int field_width = Integer.parseInt(args[2].trim());
        final Color color1 = new Color(0,0,0);
        final Color color2 = new Color(255,255,255);
        final String filename = args[3];
        final double a = field_width*Math.sqrt(2);

        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                double dj = j % a;
                double di = i % a;
                if (di < a/2) {
                    if (dj < a/2) {
                        if (i )
                    }
                }
                else {

                }
            }
        }

        try {
            ImageIO.write(image, "BMP", new File(filename));
        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }

}
