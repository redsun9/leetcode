package vtb;

import java.util.List;

public class Solution14 {
    public static int minSwap(List<Integer> a, List<Integer> b) {
        int swapRecord = 1, fixRecord = 0;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i - 1) >= b.get(i) || b.get(i - 1) >= a.get(i)) {
                swapRecord++;
            } else if (a.get(i - 1) >= a.get(i) || b.get(i - 1) >= b.get(i)) {
                int temp = swapRecord;
                swapRecord = fixRecord + 1;
                fixRecord = temp;
            } else {
                int min = Math.min(swapRecord, fixRecord);
                swapRecord = min + 1;
                fixRecord = min;
            }
        }
        return Math.min(swapRecord, fixRecord);
    }
}
