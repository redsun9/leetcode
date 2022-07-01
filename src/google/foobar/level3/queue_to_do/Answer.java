package google.foobar.level3.queue_to_do;

//xor of [0,n] =
// n if n%4==0
// 1 if n%4==1
// n+1 if n%4==2
// 0 if n%4==3

public class Answer {
    public static int answer(int start, int length) {
        if (length == 1) return start;
        if (length == 2) return start ^ (start + 1) ^ (start + 2);
        if (length == 3) return start ^ (start + 1) ^ (start + 2) ^ (start + 3) ^ (start + 4) ^ (start + 6);

        int ans = 0;
        for (int i = 0, startOfRow = start, endOfRow = start + length - 1; i < 4; i++, startOfRow += length, endOfRow += length - 1) {
            int numberOfRowsWithSameMod = (length - i - 1) / 4 + 1;
            int prefStart = switch ((startOfRow - 1) % 4) {
                case 0 -> xorOfArithmeticProgression(startOfRow - 1, 4 * length, numberOfRowsWithSameMod);
                case 1 -> numberOfRowsWithSameMod & 1;
                case 2 -> xorOfArithmeticProgression(startOfRow, 4 * length, numberOfRowsWithSameMod);
                default -> 0;
            };
            ans ^= prefStart;
            int prefEnd = switch (endOfRow % 4) {
                case 0 -> xorOfArithmeticProgression(endOfRow, 4 * (length - 1), numberOfRowsWithSameMod);
                case 1 -> numberOfRowsWithSameMod & 1;
                case 2 -> xorOfArithmeticProgression(endOfRow + 1, 4 * (length - 1), numberOfRowsWithSameMod);
                default -> 0;
            };
            ans ^= prefEnd;
        }
        return ans;
    }

    public static int xorOfArithmeticProgression(int a, int d, int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) ans |= (f(d, a, 1 << i, n) & 1) << i;
        return ans;
    }

    private static int f(int a, int b, int c, int n) {
        if (n == 0) return 0;
        return (b / c) * n + (a / c) * n * (n - 1) / 2 + f(c, (a * n + b) % c, a % c, (a % c * n + b % c) / c);
    }
}
