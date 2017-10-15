import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task4 {

    // todo: ustawiać parametrycznie kolory pól

    public static void main(String[] args) {

        // arguments from console
        final String filename_from = args[0];
        final String filename_to = args[1];
        final int field_width = Integer.parseInt(args[2].trim());

        // color used to draw pattern
        final Color color1 = new Color(255,255,255);
        final Color color2 = new Color(255, 67, 99);

        BufferedImage image = null;
        int x_res;
        int y_res;

        System.out.println("Drawing pattern on existing image");

        try {
            image = ImageIO.read(new File(filename_from));
        } catch(IOException e) {
            System.out.println("Error! The image could not be read.");
            System.exit(1);
        }
        x_res = image.getWidth();
        y_res = image.getHeight();

        Color color;
        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                if (j % (2*field_width) < field_width) {
                    if (i % (2*field_width) < field_width) {
                        image.setRGB(j,i,color1.getRGB());
                    }
                }
                else {
                    if (i % (2*field_width) >= field_width) {
                        image.setRGB(j,i,color2.getRGB());
                    }
                }
            }
        }
        System.out.println("We did it!");

        try {
            ImageIO.write(image, "BMP", new File(filename_to));
        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }

    private void setImageData() {

    }

}
