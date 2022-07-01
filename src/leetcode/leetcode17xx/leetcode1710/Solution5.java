package leetcode.leetcode17xx.leetcode1710;

import java.util.Random;

// Hoare quick select
public class Solution5 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int total = 0, totalSum = 0;
        for (int[] boxType : boxTypes) {
            total += boxType[0];
            totalSum += boxType[0] * boxType[1];
        }
        if (total <= truckSize) return totalSum;
        int target = total - truckSize;
        quickSelect(boxTypes, target);

        for (int[] boxType : boxTypes) {
            int spent = Math.min(target, boxType[0]);
            totalSum -= spent * boxType[1];
            target -= spent;
            if (target == 0) break;
        }
        return totalSum;
    }

    private void quickSelect(int[][] arr, int target) {
        int loIndex = 0, hiIndex = arr.length - 1;

        while (true) {
            PartitionReturn mid = partition(arr, loIndex, hiIndex);
            if (mid.lowerPivotCount <= target && mid.lowerPivotCount + mid.pivotCount() >= target) {
                // hack, breaking array
                arr[mid.storeIndex][0] = mid.pivotCount;
                return;
            } else if (mid.lowerPivotCount < target) {
                loIndex = mid.storeIndex + 1;
                target -= mid.lowerPivotCount + arr[mid.storeIndex][0];
            } else {
                hiIndex = mid.storeIndex - 1;
            }
        }
    }

    // return [pivotValue, pivotCount, storeIndex, cnt[left,storeIndex)]
    // elements from the left of storeIndex will be lower than pivotValue
    private PartitionReturn partition(int[][] arr, int left, int right) {
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivotValue = arr[pivotIndex][1];
        int pivotCount = arr[pivotIndex][0];
        int lowerPivotCount = 0;
        swap(arr, right, pivotIndex);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i][1] < pivotValue) {
                lowerPivotCount += arr[i][0];
                swap(arr, storeIndex++, i);
            } else if (arr[i][1] == pivotValue) {
                pivotCount += arr[i][0];
            }
        }
        swap(arr, right, storeIndex);
        return new PartitionReturn(storeIndex, pivotCount, lowerPivotCount);
    }


    private static void swap(int[][] a, int i, int j) {
        int[] tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private record PartitionReturn(int storeIndex, int pivotCount, int lowerPivotCount) {
    }
}
