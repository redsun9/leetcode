package vtb;

import java.util.ArrayList;

/*
    last digit of n-th fibonacci number
 */
public class Solution4 {
    public static int lastDigit(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int a = 0;
        int b = 1;
        int p = 1;
        while (true) {
            p++;
            int c = (a + b) % 10;
            list.add(c);
            a = b;
            b = c;
            if (a == 0 && b == 1) break;
        }

        return list.get(n % p);
    }
}
