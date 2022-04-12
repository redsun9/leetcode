package leetcode.leetcode5xx.leetcode535;

public class Codec {
    private static final char[] alphabet = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
    private static final int BASE = alphabet.length;
    private final String[] store = new String[BASE * BASE * BASE];
    private final XorShift17 random = new XorShift17(1);

    public String encode(String longUrl) {
        int tmp = random.nextInteger();
        store[tmp] = longUrl;
        char[] arr = new char[3];
        for (int i = 2; i >= 0; i--) {
            arr[i] = alphabet[tmp % BASE];
            tmp /= BASE;
        }
        return new String(arr);
    }

    public String decode(String shortUrl) {
        int tmp = 0;
        for (int i = 0; i < 3; i++) {
            tmp *= BASE;
            char c = shortUrl.charAt(i);
            if (c >= 'a' && c <= 'z') tmp += c - 'a';
            else if (c >= 'A' && c <= 'Z') tmp += c - 'A' + 26;
            else tmp += c - '0' + 52;
        }
        return store[tmp];
    }

    private static class XorShift17 {
        private int a;

        private XorShift17(int a) {
            this.a = a;
        }

        public int nextInteger() {
            a ^= a << 5;
            a ^= a >>> 8;
            a ^= a << 3;
            return a &= 0x1ffff;
        }
    }
}
