import java.awt.*;
import java.io.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.imageio.*;

public class Task6 {

    public static void main(String[] args) {

        System.out.println("Ring pattern synthesis");

        int x_res = Integer.parseInt(args[0].trim());
        int y_res = Integer.parseInt(args[1].trim());
        String output_filename = args[2];

        BufferedImage image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
        int x_c = x_res / 2;
        int y_c = y_res / 2;
        int color1 = (new Color(0,0,0)).getRGB();
        int color2 = (new Color(255, 255, 255)).getRGB();

        ArrayList <Integer> rings = generateRadiusList(x_res);

        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                double d = Math.sqrt((i - y_c)*(i - y_c) + (j - x_c)*(j - x_c));
                int dist = (int)d;
                if (getRingIndex(rings, dist) % 2 == 0) {
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

    private static ArrayList<Integer> generateRadiusList(int resolution) {
        ArrayList<Integer> result = new ArrayList<>();
        int r = 1;
        int add = 0;
        while (r < resolution/2) {
            result.add(r);
            r += add;
            if (result.size() % 3 == 0) {
                add += 1;
            }
        }
        return result;
    }

    private static int getRingIndex(ArrayList <Integer>rings, int d) {
        int result = 0;
        for (int i = 0; i < rings.size(); i++) {
            d = d - rings.get(i);
            if (d <= 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}
