package microsoft.oddstring;

import java.util.Arrays;

public class Solution {
    public String solution(int n) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        if (n % 2 == 0 && n != 0) ans[0] = 'b';
        return new String(ans);
    }
}
