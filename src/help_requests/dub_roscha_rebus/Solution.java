package help_requests.dub_roscha_rebus;

/*
    ДУБ + ДУБ + ... + ДУБ = РОЩА
    Сколько всего решений? Каково минимальное и максимальное количество дубов в роще?
 */

@SuppressWarnings("unused")
public class Solution {
    public static void main(String[] args) {
        boolean[] used = new boolean[10];

        int minMul = Integer.MAX_VALUE, minDub = 0, minRowa = 0;
        int maxMul = Integer.MIN_VALUE, maxDub = 0, maxRowa = 0;
        int totalSolutions = 0;

        for (int d = 1; d < 10; d++) {
            used[d] = true;
            for (int u = 0; u < 10; u++) {
                if (used[u]) continue;
                used[u] = true;
                for (int b = 0; b < 10; b++) {
                    if (used[b]) continue;
                    used[b] = true;
                    for (int r = 1; r < 10; r++) {
                        if (used[r]) continue;
                        used[r] = true;
                        for (int o = 0; o < 10; o++) {
                            if (used[o]) continue;
                            used[o] = true;
                            for (int w = 0; w < 10; w++) {
                                if (used[w]) continue;
                                used[w] = true;
                                for (int a = 0; a < 10; a++) {
                                    if (used[a]) continue;
                                    int dub = d * 100 + u * 10 + b;
                                    int rowa = r * 1000 + o * 100 + w * 10 + a;


                                    if (rowa % dub == 0) {
                                        int mul = rowa / dub;
                                        System.out.println(dub + " * " + mul + " = " + rowa);

                                        totalSolutions++;
                                        if (minMul > mul) {
                                            minMul = mul;
                                            minDub = dub;
                                            minRowa = rowa;
                                        }
                                        if (maxMul < mul) {
                                            maxMul = mul;
                                            maxDub = dub;
                                            maxRowa = rowa;
                                        }
                                    }
                                }
                                used[w] = false;
                            }
                            used[o] = false;
                        }
                        used[r] = false;
                    }
                    used[b] = false;
                }
                used[u] = false;
            }
            used[d] = false;
        }

        System.out.println(totalSolutions);
        System.out.println(minDub + " * " + minMul + " = " + minRowa);
        System.out.println(maxDub + " * " + maxMul + " = " + maxRowa);
    }
}
