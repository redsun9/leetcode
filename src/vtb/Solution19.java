package vtb;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution19 {
    public static int shortEncoding(List<String> words) {
        // Напишите ваш код здесь...
        Set<String> s = new HashSet<>(words);
        for (String w : words)
            for (int i = 1; i < w.length(); ++i)
                s.remove(w.substring(i));
        int res = 0;
        for (String w : s) res += w.length() + 1;
        return res;

    }

}
