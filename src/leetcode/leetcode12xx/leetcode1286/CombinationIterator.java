package leetcode.leetcode12xx.leetcode1286;

public class CombinationIterator {
    private final char[] chars;
    private final int n;
    private final int length;
    private final int[] current;
    private final char[] ans;
    private final int space;

    public CombinationIterator(String characters, int combinationLength) {
        this.chars = characters.toCharArray();
        this.n = characters.length();
        this.length = combinationLength;
        this.space = n - length;
        this.current = new int[combinationLength];
        this.ans = new char[combinationLength];
        for (int i = 0; i < length; i++) {
            current[i] = i;
            ans[i] = chars[i];
        }
        current[length - 1]--;
    }

    public String next() {
        int i = length - 1;
        while (current[i] == i + space) i--;
        int tmp = current[i] + 1;
        for (; i < length; i++, tmp++) {
            current[i] = tmp;
            ans[i] = chars[tmp];
        }
        return new String(ans);

    }

    public boolean hasNext() {
        return current[0] != space;
    }
}
