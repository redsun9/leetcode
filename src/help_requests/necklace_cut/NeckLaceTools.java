package help_requests.necklace_cut;

import java.util.Arrays;
import java.util.Random;

import static basic.utils.ArrayTools.shuffle;

public class NeckLaceTools {
    static int[] generate(int n, long seed, int gemTypes, boolean separatable) {
        int[] arr = new int[n];
        Random random = new Random(seed);

        for (int i = 0; i < n; i += 2) {
            int gem = 1 + random.nextInt(gemTypes);
            arr[i] = gem;
            arr[i + 1] = gem;
        }

        if (!separatable) {
            while (arr[0] == arr[1]) arr[1] = 1 + random.nextInt(gemTypes);
        }

        shuffle(arr, random);
        return arr;
    }

    static boolean check(int[] necklace, int[] cuts, int gemTypes) {
        if (cuts == null || cuts.length > gemTypes || necklace.length == 0) return false;
        int[] cnt = new int[gemTypes];
        for (int gem : necklace) cnt[gem - 1]++;

        Arrays.sort(cuts);
        if (cuts[0] <= 0 || cuts[cuts.length - 1] >= necklace.length) return false;
        for (int i = cuts.length - 1; i > 0; i--) {
            if (cuts[i] == cuts[i - 1]) return false;
        }

        for (int i = 0; i < gemTypes; i++) cnt[i] >>>= 1;
        int partLength = 0;
        int[] borders = new int[cuts.length + 2];
        borders[borders.length - 1] = necklace.length;
        System.arraycopy(cuts, 0, borders, 1, cuts.length);

        for (int cutIndexEnd = 1; cutIndexEnd < borders.length; cutIndexEnd += 2) {
            int start = borders[cutIndexEnd - 1], end = borders[cutIndexEnd];
            partLength += end - start;
            for (int i = start; i < end; i++) cnt[necklace[i] - 1]--;
        }
        if (partLength != necklace.length / 2) return false;
        for (int val : cnt) if (val != 0) return false;
        return true;
    }
}
