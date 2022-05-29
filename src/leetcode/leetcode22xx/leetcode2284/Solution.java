package leetcode.leetcode22xx.leetcode2284;

import java.util.HashMap;

public class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        int n = messages.length;
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        String ans = senders[0];
        for (int i = 0; i < n; i++) {
            String sender = senders[i];
            String message = messages[i];
            int length = message.length(), numberOfWords = 1;
            for (int j = 0; j < length; j++) if (message.charAt(j) == ' ') numberOfWords++;
            int finalNumberOfWords = numberOfWords;
            int value = map.compute(sender, (k, v) -> v == null ? finalNumberOfWords : v + finalNumberOfWords);
            if (value > max || (value == max && sender.compareTo(ans) >= 0)) {
                max = value;
                ans = sender;
            }
        }
        return ans;
    }
}
