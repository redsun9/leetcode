package google.foobar.level2.en_route_salute;

public class Answer {
    public static int answer(String s) {
        int counter = 0, ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '>') counter++;
            else if (c == '<') ans = ans + counter;
        }
        return ans * 2;
    }
}
