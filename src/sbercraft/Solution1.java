package sbercraft;

import java.util.Arrays;

public class Solution1 {
    public static int fourLetters(String names) {
        return (int) Arrays.stream(names.split(" ")).filter(s -> s.length() == 4).count();
    }
}
