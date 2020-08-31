package microsoft.threepart;

public class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n < 3) return 0;
        int count = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == 'a') count++;
        if (count % 3 != 0) return 0;
        if (count == 0) return (n - 1) * (n - 2) / 2;
        count /= 3;

        int firstStart = -1;
        int tmp = count;
        while (tmp > 0) if (s.charAt(++firstStart) == 'a') tmp--; // firstStart - position of count-th 'a'
        int firstEnd = firstStart + 1;
        while (s.charAt(firstEnd) != 'a') firstEnd++;

        int thirdStart = n;
        tmp = count;
        while (tmp > 0) if (s.charAt(--thirdStart) == 'a') tmp--; // thirdStart - position of count-th 'a'
        int thirdEnd = thirdStart - 1;
        while (s.charAt(thirdEnd) != 'a') thirdEnd--;

        return (firstEnd - firstStart) * (thirdStart - thirdEnd);
    }
}
