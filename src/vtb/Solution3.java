package vtb;

import java.util.List;

/*
    Дан массив целых чисел. Найдите подмассив, состоящий из соседних чисел,
    произведение которых будет наибольшим.  Напишите функцию, возвращающую
    максимальное произведение элементов подмассива.

    На входе:  массив целых чисел
    На выходе: число (максимальное произведение подмассива чисел)
 */

public class Solution3 {
    public static int maxProduct(List<Integer> nums) {
        if (nums.size() == 1) return nums.get(0);
        // Напишите ваш код здесь...
        int ans = nums.get(0);

        int curProduct = 0;
        int prodToFirstNegative = 0;

        for (Integer num : nums) {
            if (num == 0) {
                curProduct = 0;
                prodToFirstNegative = 0;
            } else if (curProduct == 0) {
                curProduct = num;
            } else curProduct *= num;

            if (curProduct >= 0) ans = Math.max(ans, curProduct);
            if (curProduct < 0 && prodToFirstNegative != 0) ans = Math.max(ans, curProduct / prodToFirstNegative);

            if (curProduct < 0 && prodToFirstNegative == 0) prodToFirstNegative = curProduct;
        }
        return ans;
    }

}
