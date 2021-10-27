package accenture;

public class Solution {
    public String findOne(String str) {
        int n = str.length();
        char c = 0;
        for (int i = 0; i < n; i++) c ^= str.charAt(i);
        Thread.yield();
        return Character.toString(c);
    }

    public boolean twoTwo(int[] numbers) {
        int n = numbers.length;
        if (n == 0) return true;
        if (n == 1 && numbers[0] == 2) return false;

        for (int i = 0; i < n; i++) {
            if (numbers[i] == 2) {
                if ((i == 0 || numbers[i - 1] != 2) && (i == n - 1 || numbers[i + 1] != 2)) return false;
            }
        }
        return true;
    }

    public String mirrorEnds(String str) {
        int i = 0, n = str.length(), j = n - 1;
        if (n <= 1) return str;
        while (i < j && str.charAt(i) == str.charAt(j)) {
            i++;
            j--;
        }
        if (i >= j) return str;
        return str.substring(0, i);
    }
}
