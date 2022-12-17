package help_requests.reading_books;

// Bob read random unread before book, until meet uninteresting book or all book are read.
// return estimated time he'll spend on reading
public class Solution {
    public static double estimatedTime(int[] times) {
        int n = times.length;
        int countPositive = 0, countNegative = 0, sumPositive = 0, sumNegative = 0;
        for (int time : times) {
            if (time >= 0) {
                countPositive++;
                sumPositive += time;
            } else {
                countNegative++;
                sumNegative -= time;
            }
        }
        if (countNegative == 0) return sumPositive;
        if (countPositive == 0) return (double) sumNegative / n;
        return ((double) sumPositive / (countNegative + 1)) + ((double) sumNegative / countNegative);
    }
}
