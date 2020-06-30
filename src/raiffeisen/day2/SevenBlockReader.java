package raiffeisen.day2;

import java.util.HashMap;


/*
        "._. ... ._. ._. ... ._. ._. ._. ._. ._.\n" +
        "|.| ..| ._| ._| |_| |_. |_. ..| |_| |_|\n" +
        "|_| ..| |_. ._| ..| ._| |_| ..| |_| ._|\n";
 */

public class SevenBlockReader {
    private static final HashMap<Long, Integer> digitBitMasks = new HashMap<>();

    static {
        String s =
                "._. ... ._. ._. ... ._. ._. ._. ._. ._.\n" +
                        "|.| ..| ._| ._| |_| |_. |_. ..| |_| |_|\n" +
                        "|_| ..| |_. ._| ..| ._| |_| ..| |_| ._|\n";
        String[] split = s.replace(" ", "").replace(".", " ").split("\n");
        for (int i = 0; i <= 9; i++) {
            long a = 0;
            for (int h = 0; h < 3; h++) {
                for (int w = 0; w < 3; w++) {
                    switch (split[h].charAt(3 * i + w)) {
                        case '_' -> a = a * 3 + 1;
                        case '|' -> a = a * 3 + 2;
                        default -> a = a * 3;
                    }
                    ;
                }
            }
            digitBitMasks.put(a, i);
        }
    }


    public static long parseInt(String str) throws NumberFormatException {
        if (str == null || str.isEmpty()) throw new NumberFormatException("Empty string");
        String[] split = str.split("\n");
        if (split.length < 3) throw new NumberFormatException("Less than three strings");
        if (split[0].length() != split[1].length() || split[0].length() != split[2].length())
            throw new NumberFormatException("Strings of different length");
        if (split[0].length() % 3 != 0) throw new NumberFormatException("Digits should be represented as group of 3*3");
        int n = (split[0].length()) / 3;
        long ans = 0;
        for (int i = 0; i < n; i++) ans = ans * 10 + parseDigit(split, i);
        return ans;
    }

    private static int parseDigit(String[] split, int i) throws NumberFormatException {
        long a = 0;
        for (int h = 0; h < 3; h++) {
            for (int w = 0; w < 3; w++) {
                switch (split[h].charAt(3 * i + w)) {
                    case '_' -> a = a * 3 + 1;
                    case '|' -> a = a * 3 + 2;
                    default -> a = a * 3;
                }
                ;
            }
        }
        return digitBitMasks.get(a);
    }
}
