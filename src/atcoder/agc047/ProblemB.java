package atcoder.agc047;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemB {
    public static final int max = 1_000_001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] strings = new char[n][];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine().toCharArray();
        }
        System.out.println(solve(strings));
    }

    public static long solve(char[][] strings) {
        for (char[] chars : strings) {
            for (int j = chars.length - 1; j >= 0; j--) {
                chars[j] -= 'a';
            }
        }
        int[][] child = new int[max][26];
        boolean[] isWord = new boolean[max];
        int length = strings.length;
        int[][] paths = new int[length][];
        int nxt = 1;
        for (int k = 0; k < length; k++) {
            char[] s = strings[k];
            int n = s.length;
            int[] path = new int[n];
            int node = 0;
            for (int i = n - 1, j = 0; i >= 0; i--, j++) {
                int c = s[i];
                path[j] = node;
                if (child[node][c] == 0) child[node][c] = nxt++;
                node = child[node][c];
            }
            paths[k] = path;
            isWord[node] = true;
        }
        long ans = 0;
        for (int k = 0; k < length; k++) {
            char[] s = strings[k];
            int n = s.length;
            int[] path = paths[k];
            Set<Character> set = new HashSet<>();
            for (int i = 0, j = n - 1; j >= 0; i++, j--) {
                set.add(s[i]);
                int node = path[j];
                for (Character c : set) {
                    if (isWord[child[node][c]]) ans++;
                }
            }
        }
        return ans - length;

    }
}
