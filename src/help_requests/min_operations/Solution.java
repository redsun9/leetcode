package help_requests.min_operations;


import static java.lang.Math.max;

// Дан массив интов и число k.
//
// Следующую операцию можно выполнить любое количество раз:
//   1) Выбрать индекс i на промежутке [0, n-1] и увеличить nums[i] на 1.
//
// Нужно найти минимальное количество операций, такое, что в любом подмассиве размера 3 или более, максимальный элемент больше или равен k.
public class Solution {
    public static long minOperations(int[] nums, int k) {
        long a = 0, b = 0, c = 0, d;
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            d = min(
                    c + max(0L, k - nums[i]),
                    b + max(0, k - nums[i - 1]),
                    a + max(0, k - nums[i - 2])
            );
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    private static long min(long a, long b, long c) {
        return Math.min(a, Math.min(b, c));
    }
}
