package advent.year2024.day14.second;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import static java.lang.Integer.parseInt;

public class Solution {
    private static final int startOfP = "p=".length();
    private static final int lengthOfDelimiterV = " v=".length();
    private static final boolean debug = false;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day14/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day14/second/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            String[] split = scanner.nextLine().trim().split(",");
            int w = parseInt(split[0]), h = parseInt(split[1]);

            List<int[]> robots = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) continue;
                //p=0,4 v=3,-3
                int pos = s.indexOf(" ");
                split = s.substring(startOfP, pos).split(",");
                int x = parseInt(split[0]), y = parseInt(split[1]);

                split = s.substring(pos + lengthOfDelimiterV).split(",");
                int vx = parseInt(split[0]), vy = parseInt(split[1]);
                robots.add(new int[]{x, y, vx, vy});
            }
            printer.println(solve(robots, w, h));
        }
    }

    private static int solve(List<int[]> robots, int w, int h) throws IOException {
        // we simulate robots and see how much of it iы mirrored.
        int maxSymmetric = 10;
        int maxSymmetricTime = -1;
        for (int t = 0; t < 100_000; t++) {
            boolean[][] mat = process(robots, w, h, t);
            int tmp = 0;
            for (int x1 = 0, x2 = w - 1; x1 <= x2; x1++, x2--) {
                for (int y = 0; y < h; y++) if (mat[x1][y] && mat[x2][y]) tmp++;
            }
            if (tmp > maxSymmetric) {
                maxSymmetric = tmp;
                maxSymmetricTime = t;
                if (debug) logMat(mat, t);
                System.out.println(maxSymmetric);
            }
        }
        return maxSymmetricTime;
    }

    private static boolean[][] process(List<int[]> robots, int w, int h, int t) {
        boolean[][] mat = new boolean[w][h];
        for (int[] robot : robots) {
            int endX = (w + (robot[0] + robot[2] * t) % w) % w, endY = (h + (robot[1] + robot[3] * t) % h) % h;
            mat[endX][endY] = true;
        }
        return mat;
    }

    private static void logMat(boolean[][] mat, int t) throws IOException {

        final int rgbWhite = Color.WHITE.getRGB();
        int w = mat.length;
        int h = mat[0].length;
        BufferedImage bufferedImage = new BufferedImage(w, h, TYPE_INT_RGB);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (mat[i][j]) bufferedImage.setRGB(i, j, rgbWhite);
            }
        }
        ImageIO.write(bufferedImage, "png", new File("src/advent/year2024/day14/second" + "/" + t + ".png"));
    }

}
