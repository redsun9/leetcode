package leetcode.leetcode4xx.leetcode468;

public class Solution {
    private static final String neither = "Neither";
    private static final String ipv4 = "IPv4";
    private static final String ipv6 = "IPv6";

    public String validIPAddress(String ip) {

        if (ip.contains(".")) {
            if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') return neither;
            String[] split = ip.split("\\.");
            if (split.length != 4) return neither;
            for (String ipPart : split) {
                int length = ipPart.length();
                if (length > 0 && length < 4) {
                    int part = 0;
                    if (ipPart.charAt(0) == '0' && length > 1) return neither;
                    for (int j = 0; j < length; j++) {
                        char c = ipPart.charAt(j);
                        if (c >= '0' && c <= '9') {
                            part = part * 10 + c - '0';
                        } else return neither;
                    }
                    if (part >= 256) return neither;
                } else return neither;
            }
            return ipv4;
        } else if (ip.contains(":")) {
            if (ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') return neither;
            String[] split = ip.split(":");
            if (split.length != 8) return neither;
            for (String ipPart : split) {
                int length = ipPart.length();
                if (length > 0 && length <= 4) {
                    for (int j = 0; j < length; j++) {
                        char c = Character.toLowerCase(ipPart.charAt(j));
                        if ((c < '0' || c > '9') && (c < 'a' || c > 'f')) return neither;
                    }
                } else return neither;
            }
            return ipv6;
        } else return neither;
    }
}
