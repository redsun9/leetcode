package help_requests.colour_fill;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageGenerator2 {
    public static void main(String[] args) throws IOException {
        int[][] prev = new int[5][3];
        prev[0][0] = 2;
        prev[0][2] = 2;
        prev[4][0] = 2;
        prev[4][2] = 2;
        for (int i = 0; i < 5; i++) prev[i][1] = 1;

        writeImage(prev, 0);

        for (int k = 1; k <= 5; k++) {
            int h1 = prev.length, w1 = prev[0].length;
            int h2 = 2 * w1 + 3;
            int[][] next = new int[h2][h1];

            for (int i = 0; i < h1; i++) {
                for (int j = 0; j < w1; j++) {
                    next[j][i] |= prev[i][j];
                    next[h2 - 1 - j][i] |= prev[i][j];
                }
            }

            for (int i = w1 / 2; i <= h2 - 1 - w1 / 2; i++) next[i][h1 / 2] = 1;

            writeImage(next, k);
            prev = next;
        }
    }

    private static void writeImage(int[][] mat, int k) throws IOException {
        int h2 = mat.length, w2 = mat[0].length;
        BufferedImage image = new BufferedImage(w2, h2, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < h2; i++) {
            for (int j = 0; j < w2; j++) {
                int colour = 255 - 127 * mat[i][j];
                image.setRGB(j, i, colour | colour << 8 | colour << 16);
            }
        }
        ImageIO.write(image, "png", new File("src/help_requests/colour_fill/Image" + k + ".png"));
    }
}
