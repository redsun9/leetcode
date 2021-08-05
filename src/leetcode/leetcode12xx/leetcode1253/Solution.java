package leetcode.leetcode12xx.leetcode1253;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        List<Integer> l1 = new ArrayList<>(n), l2 = new ArrayList<>(n);
        for (int val : colsum) {
            if(val==0){
                l1.add(0);
                l2.add(0);
            }else if(val==2){
                l1.add(1);
                l2.add(1);
                upper--;
                lower--;
            }else{
                if(upper>=lower){
                    l1.add(1);
                    l2.add(0);
                    upper--;
                }else{
                    l1.add(0);
                    l2.add(1);
                    lower--;
                }
            }
        }
        if(upper!=0 || lower!=0) return Collections.emptyList();
        return List.of(l1,l2);
    }
}
