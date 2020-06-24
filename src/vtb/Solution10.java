package vtb;

import java.util.Arrays;
import java.util.List;

/*
Дан массив целых чисел nums, отсортированных в порядке возрастания.
Найдите начальную и конечную позицию заданного значения target.
Числа в массиве могут повторяться. Если в массиве одно число, равное target,
то начальная и конечная позиция для него будут одинаковыми.

Если цель не найдена в массиве, верните [-1, -1].

На входе:
nums - массив целых чисел, отсортированных по возрастанию
target - число, для которого необходимо найти начальную и конечную позицию
На выходе: массив вида [start_position, end_position]
 */

public class Solution10 {
    public static List<Integer> searchRange(List<Integer> nums, int target) {
        // Напишите ваш код здесь...
        int n = nums.size();
        if (n == 0) return Arrays.asList(-1, -1);
        int lo = 0, hi = n - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums.get(mid) < target) lo = mid + 1;
            else hi = mid;
        }
        if (nums.get(hi) != target) return Arrays.asList(-1, -1);
        int left = hi;
        lo = 0;
        hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (nums.get(mid) > target) hi = mid - 1;
            else lo = mid;
        }
        int right = lo;
        return Arrays.asList(left, right);
    }
}
