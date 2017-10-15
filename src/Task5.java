import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Task5 {

    // draws canvas filled with multiple circles in equal distance from each other

    public static void main(String[] args) {

        System.out.println("Circles pattern synthesis");

        BufferedImage image;

        // console parameters:

        // image resolution
        final int x_res = Integer.parseInt(args[0].trim());
        final int y_res = Integer.parseInt(args[1].trim());

        // radius of circle
        final int r = Integer.parseInt(args[2].trim());

        // side length of square in which circle is placed
        final int a = Integer.parseInt(args[3].trim());

        // filename for output
        final String filename = args[4];

        final Color circle_color = new Color(0,0,0);
        final Color bg_color = new Color(255,255,255);

        image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < y_res; i++) {
            for (int j = 0; j < x_res; j++) {
                int ni = i % (2*a);
                int nj = j % (2*a);
                int q_index = getQuarterIndex(nj, ni, 2*a);
                if (isInsideCircle(nj, ni, q_index, a, r)) {
                    image.setRGB(j, i, circle_color.getRGB());
                }
                else {
                    image.setRGB(j, i, bg_color.getRGB());
                }
            }
        }

        try {
            ImageIO.write(image, "BMP", new File(filename));
        } catch (IOException e) {
            System.out.println("This image couldn't be stored.");
        }
    }

    // returns distance betwen two points in 2-dimensional space
    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    // return upper left corner coordinates of square of 'a' length in which point (x,y) is placed
    // given that squares are equally deployed over canvas from upper left corner
    private static Point getPointZero(int x, int y, int a) {
        return new Point((x/(2*a))*2*a, (y/(2*a))*2*a);
    }

    /**
     *
     * @param x
     * @param y
     * @param a side lenght of square
     * @return index of quarter in which point exist
     */
    private static int getQuarterIndex(int x, int y, int a) {
        if (x < a/2) {
            if (y < a/2) {
                return 1;
            }
            else {
                return 4;
            }
        }
        else {
            if (y < a/2) {
                return 2;
            }
            else {
                return 3;
            }
        }
    }

    private static boolean isInsideCircle(int x, int y, int quarter_index, int a, int r) {
        Point point_zero = getPointZero(x, y, a);
        switch (quarter_index) {
            case 1:
                break;
            case 2:
                point_zero.setLocation(point_zero.x + 2*a, point_zero.y);
                break;
            case 3:
                point_zero.setLocation(point_zero.x + 2*a, point_zero.y + 2* a);
                break;
            case 4:
                point_zero.setLocation(point_zero.x, point_zero.y + 2*a);
                break;
        }
        return distance(point_zero.x, point_zero.y, x, y) < r;
    }

}
