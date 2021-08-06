package leetcode.leetcode10xx.leetcode1054;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0, maxBarcode = 0;
        for (int barcode : barcodes) {
            int val = map.compute(barcode, (k, v) -> v == null ? 1 : v + 1);
            if (val > maxCount) {
                maxCount = val;
                maxBarcode = barcode;
            }
        }
        int pos = 0;
        while (maxCount-- != 0) {
            barcodes[pos] = maxBarcode;
            pos += 2;
        }
        if (pos >= n) pos = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int barcode = entry.getKey();
            if (barcode == maxBarcode) continue;
            int count = entry.getValue();
            while (count-- != 0) {
                barcodes[pos] = barcode;
                pos += 2;
                if (pos >= n) pos = 1;
            }
        }
        return barcodes;
    }
}
