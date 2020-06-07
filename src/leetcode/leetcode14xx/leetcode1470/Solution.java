package leetcode.leetcode14xx.leetcode1470;

public class Solution {
    public int[] shuffle(int[] arr, int n) {
        n *= 2;
        // shuffle to {5, 0, 6, 1, 7, 2, 8, 3, 9, 4}
        int i, startPos = 0;
        while (startPos < n) {
            i = lookUp(n - startPos);
            shiftRight(arr, startPos + (i - 1) / 2, (n - startPos) / 2, (i - 1) / 2);
            perfectShuffle(arr, startPos, i - 1);
            startPos += (i - 1);
        }

        // local swap to {0, 5, 1, 6, 2, 7, 3, 8, 4, 9}
        for (i = 0; i < n; i += 2) {
            int tmp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = tmp;
        }
        return arr;
    }

    // cycle
    void cycle(int[] arr, int offset, int length, int start) {
        int curIndex, temp1, temp2;
        curIndex = (start * 2) % (length + 1);
        temp1 = arr[offset + curIndex - 1];
        arr[offset + curIndex - 1] = arr[offset + start - 1];

        while (curIndex != start) {
            temp2 = arr[offset + (curIndex * 2) % (length + 1) - 1];
            arr[offset + (curIndex * 2) % (length + 1) - 1] = temp1;
            temp1 = temp2;
            curIndex = (curIndex * 2) % (length + 1);
        }
    }


    // loop-move array
    void reverse(int[] Data, int offset, int Len) {
        int i, Temp;
        for (i = 0; i < Len / 2; i++) {
            Temp = Data[offset + i];
            Data[offset + i] = Data[offset + Len - i - 1];
            Data[offset + Len - i - 1] = Temp;
        }
    }

    void shiftRight(int[] arr, int offset, int len, int k) {
        reverse(arr, offset, len - k);
        reverse(arr, offset + len - k, k);
        reverse(arr, offset, len);
    }

    // perfect shuffle of satisfying [Lenth=3^k-1]
    void perfectShuffle(int[] arr, int offset, int length) {
        int i = 1;
        if (length == 2) {
            i = arr[offset + length - 1];
            arr[offset + length - 1] = arr[offset + length - 2];
            arr[offset + length - 2] = i;
            return;
        }
        while (i < length) {
            cycle(arr, offset, length, i);
            i = i * 3;
        }
    }

    // look for 3^k that nearnest to N
    int lookUp(int n) {
        int i = 3;
        while (i <= n + 1) i *= 3;
        if (i > 3) i = i / 3;
        return i;
    }
}
