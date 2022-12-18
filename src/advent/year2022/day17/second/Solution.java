package advent.year2022.day17.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static basic.utils.IntegerUtils.lcm;

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
    private static final long FIGURES_TO_FALL = 1000000000000L;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day17/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day17/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int shapeLength = shapes.length;

            String s = scanner.nextLine().trim();
            int steamLength = s.length();
            int[] steams = new int[steamLength];
            for (int i = 0; i < steamLength; i++) steams[i] = s.charAt(i) == '<' ? -1 : 1;

            List<Integer> slow = new ArrayList<>();
            List<Integer> fast = new ArrayList<>();
            slow.add((1 << (WIDTH + 2)) - 1);
            fast.add((1 << (WIDTH + 2)) - 1);
            int lcm = lcm(shapeLength, steamLength);

            State state = new State(1, 0);
            State state1 = processFalling(slow, state, lcm, steams);
            State state2 = processFalling(fast, state, 2 * lcm, steams);

            int startOfCycle = 2 * lcm;

            while (
                    state1.steamPos != state2.steamPos ||
                            !slow.subList(state.h, state1.h).equals(fast.subList(state2.h - (state1.h - state.h), state2.h))
            ) {
                state = state1;
                state1 = processFalling(slow, state1, lcm, steams);
                state2 = processFalling(fast, state2, 2 * lcm, steams);
                startOfCycle += 2 * lcm;
            }

            int lengthOfCycle = 2 * lcm;
            int lengthBeforeCycle = state2.h;
            state2 = processFalling(fast, state2, 2 * lcm, steams);
            while (
                    state1.steamPos != state2.steamPos ||
                            !slow.subList(state.h, state1.h).equals(fast.subList(state2.h - (state1.h - state.h), state2.h))
            ) {

                state2 = processFalling(fast, state2, 2 * lcm, steams);
                lengthOfCycle += 2 * lcm;
            }
            int lengthAfterCycle = state2.h;
            int additionDuringCycle = lengthAfterCycle - lengthBeforeCycle;
            long numberOfCycles = (FIGURES_TO_FALL - startOfCycle) / lengthOfCycle;
            long heightAfterCycles = lengthBeforeCycle + additionDuringCycle * numberOfCycles;

            int mod = (int) ((FIGURES_TO_FALL - startOfCycle) % lengthOfCycle);
            int lengthAfterMod = processFalling(fast, state2, mod, steams).h;

            long ans = heightAfterCycles + (lengthAfterMod - lengthAfterCycle);
            printer.println(ans - 1);
        }
    }

    private static State processFalling(List<Integer> list, State state, int figures, int[] steams) {
        int steamLength = steams.length;
        int shapeLength = shapes.length;
        int h = state.h, steamPos = state.steamPos;
        for (int figure = 0, shapePos = 0; figure < figures; figure++) {
            //spawn figure
            int[] shape = shapes[shapePos++];
            if (shapePos == shapeLength) shapePos = 0;
            int shapeH = shape.length;
            while (list.size() < h + SPACE_X + shapeH) list.add(EMPTY_MSK);
            int x = h + SPACE_X, y = 1 + SPASE_Y;
            while (true) {
                int nextY = y + steams[steamPos++];
                if (steamPos == steamLength) steamPos = 0;
                if (canPlace(list, shape, x, nextY)) y = nextY;
                if (!canPlace(list, shape, x - 1, y)) break;
                x--;
            }
            for (int i = 0; i < shapeH; i++) list.set(x + i, list.get(x + i) | shape[i] << y);
            h = Math.max(h, x + shapeH);
        }
        return new State(h, steamPos);
    }

    private static boolean canPlace(List<Integer> list, int[] shape, int x, int y) {
        boolean ans = true;
        for (int i = 0; i < shape.length; i++) ans &= (list.get(x + i) & shape[i] << y) == 0;
        return ans;
    }

    private record State(int h, int steamPos) {
    }
}
