package leetcode.leetcode4xx.leetcode406;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparingInt((int[] x) -> -x[0]).thenComparing(x -> x[1]));
        for (int i = 1; i < people.length; i++) {
            if (people[i][1] != i) {
                int[] tmp = people[i];
                for (int j = i; j > tmp[1]; j--) {
                    people[j] = people[j - 1];
                }
                people[tmp[1]] = tmp;
            }
        }
        return people;
    }
}
