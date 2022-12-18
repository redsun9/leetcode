package advent.year2022.day17.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int[][] shapes = {
            {0b1111},
            {0b010, 0b111, 0b010},
            {0b111, 0b100, 0b100},
            {1, 1, 1, 1},
            {0b11, 0b11}
    };
    private static final int WIDTH = 7;
    private static final int EMPTY_MSK = 1 << (WIDTH + 1) | 1;
    private static final int SPACE_X = 3;
    private static final int SPASE_Y = 2;
    private static final int FIGURES_TO_FALL = 2022;

    private static final boolean DEBUG = false;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day17/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day17/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String s = scanner.nextLine().trim();
            int steamLength = s.length();
            int[] steams = new int[steamLength];
            for (int i = 0; i < steamLength; i++) steams[i] = s.charAt(i) == '<' ? -1 : 1;

            List<Integer> list = new ArrayList<>();
            list.add((1 << (WIDTH + 2)) - 1);

            int h = 1;

            for (int figure = 0, shapePos = 0, steamPos = 0; figure < FIGURES_TO_FALL; figure++) {
                //spawn figure
                int[] shape = shapes[shapePos++];
                if (shapePos == shapes.length) shapePos = 0;
                int shapeH = shape.length;
                while (list.size() < h + SPACE_X + shapeH) list.add(EMPTY_MSK);
                int x = h + SPACE_X, y = 1 + SPASE_Y;
                if (DEBUG) debugPrint(list, shape, x, y);
                while (true) {
                    int nextY = y + steams[steamPos++];
                    if (steamPos == steamLength) steamPos = 0;
                    if (canPlace(list, shape, x, nextY)) y = nextY;
                    if (DEBUG) debugPrint(list, shape, x, y);
                    if (!canPlace(list, shape, x - 1, y)) break;
                    x--;
                    if (DEBUG) debugPrint(list, shape, x, y);
                }
                for (int i = 0; i < shapeH; i++) list.set(x + i, list.get(x + i) | shape[i] << y);
                h = Math.max(h, x + shapeH);

                if (DEBUG) debugPrint(list, new int[0], 0, 0);
            }
            printer.println(h - 1);
        }
    }

    private static boolean canPlace(List<Integer> list, int[] shape, int x, int y) {
        boolean ans = true;
        for (int i = 0; i < shape.length; i++) ans &= (list.get(x + i) & shape[i] << y) == 0;
        return ans;
    }

    private static String reverse(String s) {
        char[] arr = s.toCharArray();
        char tmp;
        for (int l = 0, r = arr.length - 1; l < r; l++, r--) {
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        return new String(arr);
    }

    private static void debugPrint(List<Integer> list, int[] shape, int x, int y) {
        System.out.println();
        for (int i = list.size() - 1; i >= x + shape.length; i--) {
            System.out.println(reverse(Integer.toBinaryString(list.get(i))));
        }
        for (int i = shape.length - 1; i >= 0; i--) {
            System.out.println(reverse(Integer.toBinaryString(list.get(x + i) | shape[i] << y)));
        }
        for (int i = x - 1; i >= 0; i--) {
            System.out.println(reverse(Integer.toBinaryString(list.get(i))));
        }
    }
}
