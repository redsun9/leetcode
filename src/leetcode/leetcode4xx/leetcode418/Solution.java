package leetcode.leetcode4xx.leetcode418;

public class Solution {
    /**
     * @param sentence: a list of string
     * @param rows:     an integer
     * @param cols:     an integer
     * @return return an integer, denote times the given sentence can be fitted on the screen
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] lens = new int[n];
        int lengthTotal = 0, maxLength = 0;
        for (int i = 0; i < n; i++) {
            lens[i] = sentence[i].length();
            lengthTotal += lens[i];
            maxLength = Math.max(maxLength, lens[i]);
        }
        int ans = (cols + 1) / (lengthTotal + n) * rows;
        cols = (cols + 1) % (lengthTotal + n);
        if (maxLength + 1 > cols) return ans;

        int rowNumber = 0, wordNumber = 0, curLength = 0;
        while (rowNumber < rows) {
            while (wordNumber != n && curLength + lens[wordNumber] < cols) {
                curLength += 1 + lens[wordNumber];
                wordNumber++;
            }

            if (wordNumber == n) {
                wordNumber = 0;
                ans++;
            } else {
                rowNumber++;
                curLength = 1 + lens[wordNumber];
                wordNumber++;
            }
        }
        return ans;
    }
}
