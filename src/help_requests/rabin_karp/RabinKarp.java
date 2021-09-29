package help_requests.rabin_karp;

public class RabinKarp {

    //works only till 3^n not cause integer overflow
    public static boolean contains(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (m < n) return false;
        if (n == 0) return true;

        long needleHash = 0, haystackHash = 0;
        long pow = 1;
        for (int i = 0; i < n; i++) {
            needleHash += (needle.charAt(i) % 3) * pow;
            haystackHash += (haystack.charAt(i) % 3) * pow;
            pow *= 3;
        }


        if (needleHash == haystackHash) return true;

        pow /= 3;
        for (int start = 1, end = n; end < m; end++, start++) {
            haystackHash = (haystackHash - haystack.charAt(start - 1) % 3) / 3 + haystack.charAt(end) % 3 * pow;
            if (haystackHash == needleHash) return true;
        }
        return false;
    }
}
