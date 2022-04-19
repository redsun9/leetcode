package leetcode.leetcode15xx.leetcode1507;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final Map<String, Integer> monthMap = new HashMap<>();

    static {
        for (int i = 0; i < months.length; i++) monthMap.put(months[i], i);
    }

    public String reformatDate(String date) {
        int n = date.length();
        int year = Integer.parseInt(date.substring(n - 4, n));
        int month = monthMap.get(date.substring(n - 8, n - 5));
        int day = Integer.parseInt(date.substring(0, n - 11));
        return String.format("%4d-%02d-%02d", year, month + 1, day);

    }
}
