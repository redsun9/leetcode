package hackerrank.sherlock_valid_string;

public class Solution {
    private static String isValid(String s) {
        int n = s.length();
        if (n < 5) return "YES";
        int[] count = new int[26];
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;
        int maxCount = 0; // maximum number of occurences of a char
        int maxFreqCount = 0; // number of chars with count[i] == maxCount
        int maxFreqMinus1Count = 0; //number of chars with count[i]== maxCount-1
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            if (count[i] > maxCount) {
                if (count[i] == maxCount + 1) maxFreqMinus1Count = maxFreqCount;
                else maxFreqMinus1Count = 0;
                maxCount = count[i];
                maxFreqCount = 1;
            } else if (count[i] == maxCount) maxFreqCount++;
            else if (count[i] == maxCount - 1) maxFreqMinus1Count++;
        }

        if (maxCount * maxFreqCount == n) return "YES"; // "aabbccdd"
        if (maxCount * maxFreqCount + 1 == n) return "YES"; //"aabbccd"
        if (maxFreqCount == 1 && maxCount + (maxCount - 1) * maxFreqMinus1Count == n) return "YES"; //aaabbcc
        return "NO";
    }
}
