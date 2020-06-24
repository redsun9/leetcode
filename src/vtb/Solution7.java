package vtb;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*
Дан массив целых чисел a, определяющих высоту. Склоном считаем набор из двух элементов с индексами i и j, такой что
i < j и a[i] < a[j]. Длина склона равна j-i.

Найдите максимальную длину склона в a. Если в a не существует склонов, верните 0.

На входе: a - массив целых чисел
На выходе: целое число - максимальная длина склона или 0, если склонов в a не существует
 */

public class Solution7 {
    public static int maxWidth(List<Integer> a) {
        int n = a.size();
        if (n < 2) return 0;
        int ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int num = a.get(i);
            if (num < max) {
                Map.Entry<Integer, Integer> entry = map.ceilingEntry(num + 1);
                ans = Math.max(ans, entry.getValue() - i);
            } else if (num > max) {
                map.put(num, i);
                max = num;
            }
        }
        return ans;
    }
}
