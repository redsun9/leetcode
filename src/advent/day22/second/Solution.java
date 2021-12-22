package advent.day22.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static final int MIN_VAL = -1_000_000;
    public static final int MAX_VAL = 1_000_000;


    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day22/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day22/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            OctoTree tree = new OctoTree(
                    false,
                    MIN_VAL, MAX_VAL,
                    MIN_VAL, MAX_VAL,
                    MIN_VAL, MAX_VAL
            );

            int posStart, posMid, posEnd;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();

                posStart = s.indexOf('=');
                posMid = s.indexOf("..", posStart);
                posEnd = s.indexOf(',', posMid);

                int startX = Integer.parseInt(s, posStart + 1, posMid, 10);
                int endX = Integer.parseInt(s, posMid + 2, posEnd, 10);

                posStart = s.indexOf('=', posEnd);
                posMid = s.indexOf("..", posStart);
                posEnd = s.indexOf(',', posMid);

                int startY = Integer.parseInt(s, posStart + 1, posMid, 10);
                int endY = Integer.parseInt(s, posMid + 2, posEnd, 10);

                posStart = s.indexOf('=', posEnd);
                posMid = s.indexOf("..", posStart);
                posEnd = s.length();

                int startZ = Integer.parseInt(s, posStart + 1, posMid, 10);
                int endZ = Integer.parseInt(s, posMid + 2, posEnd, 10);

                boolean val = s.charAt(1) == 'n';

                tree.setVal(val, startX, endX + 1, startY, endY + 1, startZ, endZ + 1);
            }
            printer.println(tree.getCount());
        }
    }

    private static class OctoTree {
        final long minX, maxX, minY, maxY, minZ, maxZ;
        boolean val;
        OctoTree left, right; // xyz

        OctoTree(boolean newVal, long minX, long maxX, long minY, long maxY, long minZ, long maxZ) {
            this.val = newVal;
            this.minX = minX;
            this.maxX = maxX;
            this.minY = minY;
            this.maxY = maxY;
            this.minZ = minZ;
            this.maxZ = maxZ;
        }

        void setVal(boolean newVal, long qMinX, long qMaxX, long qMinY, long qMaxY, long qMinZ, long qMaxZ) {
            if (qMinX >= maxX || qMaxX <= minX) return;
            if (qMinY >= maxY || qMaxY <= minY) return;
            if (qMinZ >= maxZ || qMaxZ <= minZ) return;

            if (this.val == newVal && left == null && right == null) return;
            if (qMinX <= minX && qMaxX >= maxX && qMinY <= minY && qMaxY >= maxY && qMinZ <= minZ && qMaxZ >= maxZ) {
                this.val = newVal;
                left = null;
                right = null;
                return;
            }

            if (left == null) {
                if (qMaxX < maxX || qMinX > minX) {
                    long midX = minX + (maxX - minX) / 2;
                    left = new OctoTree(this.val, minX, midX, minY, maxY, minZ, maxZ);
                    right = new OctoTree(this.val, midX, maxX, minY, maxY, minZ, maxZ);
                } else if (qMaxY < maxY || qMinY > minY) {
                    long midY = minY + (maxY - minY) / 2;
                    left = new OctoTree(this.val, minX, maxX, minY, midY, minZ, maxZ);
                    right = new OctoTree(this.val, minX, maxX, midY, maxY, minZ, maxZ);
                } else {
                    long midZ = minZ + (maxZ - minZ) / 2;
                    left = new OctoTree(this.val, minX, maxX, minY, maxY, minZ, midZ);
                    right = new OctoTree(this.val, minX, maxX, minY, maxY, midZ, maxZ);
                }
            }

            left.setVal(newVal, qMinX, qMaxX, qMinY, qMaxY, qMinZ, qMaxZ);
            right.setVal(newVal, qMinX, qMaxX, qMinY, qMaxY, qMinZ, qMaxZ);
        }

        long getCount() {
            if (left == null) {
                if (!val) return 0;
                return (maxX - minX) * (maxY - minY) * (maxZ - minZ);
            }
            return left.getCount() + right.getCount();
        }

    }
}
