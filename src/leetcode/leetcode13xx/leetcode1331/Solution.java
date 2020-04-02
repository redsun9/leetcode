package leetcode.leetcode13xx.leetcode1331;

import java.util.LinkedList;
import java.util.TreeMap;

public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> list = map.getOrDefault(arr[i], new LinkedList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        int i = 0;
        for (LinkedList<Integer> value : map.values()) {
            i++;
            for (Integer integer : value) {
                arr[integer] = i;
            }
        }
        return arr;
    }
}
