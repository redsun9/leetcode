package help_requests.colour_fill;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageGenerator {
    public static void main(String[] args) throws IOException {
        int[][] prev = {{2}};
        for (int k = 1; k <= 13; k++) {
            int n1 = prev.length, n2 = 2 * n1 + 1, n3 = n2 / 2 - n1 / 2;
            int[][] next = new int[n2][n2];
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < n1; j++) {
                    next[n1 + 1 + i][n3 + j] |= prev[i][j];
                    next[n3 + j][n1 - 1 - i] |= prev[i][j];
                    next[n3 + j][n1 + 1 + i] |= prev[i][j];
                }
                next[i][n1] = 1;
            }
            next[n1][n1] = 1;
            prev = next;

            BufferedImage image = new BufferedImage(n2, n2 - n2 / 4, BufferedImage.TYPE_BYTE_GRAY);
            for (int i = n2 / 4; i < n2; i++) {
                for (int j = 0; j < n2; j++) {
                    int colour = 127 * prev[i][j];
                    image.setRGB(j, i - n2 / 4, colour | colour << 8 | colour << 16);
                }
            }
            ImageIO.write(image, "png", new File("src/help_requests/colour_fill/Image" + k + ".png"));
        }
    }
}
