package sbercraft;

public class Solution4 {
    public static String encode(String text) {
        String[] split = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (!s.isEmpty() && Character.isLetter(s.charAt(0))) {
                sb.append(' ').append(s.substring(1)).append(s.charAt(0)).append("оп");
            } else sb.append(' ').append(s);
        }
        return sb.substring(1);
    }
}
