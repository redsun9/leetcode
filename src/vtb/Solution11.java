package vtb;

import java.util.Arrays;
import java.util.List;

public class Solution11 {
    public static List<Integer> findDivisors(int num) {
        // Напишите ваш код здесь...
        if (num == 1) return Arrays.asList(1, 2);
        if (num == 2) return Arrays.asList(2, 2);

        int num1 = num + 1;
        int a = 1, b = num1;
        int min = b - a;

        for (int i = 2; i * i <= num1; i++) {
            if (num1 % i == 0 && min > num1 / i - i) {
                a = i;
                b = num1 / i;
                min = b - a;
            }
        }
        int num2 = num + 2;
        for (int i = 2; i * i <= num2; i++) {
            if (num2 % i == 0 && min > num2 / i - i) {
                a = i;
                b = num2 / i;
                min = b - a;
            }
        }
        return Arrays.asList(a, b);
    }
}
