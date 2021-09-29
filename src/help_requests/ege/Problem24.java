package help_requests.ege;

import java.util.Scanner;

public class Problem24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ans = 0;
        String str;
        while ((str = scanner.nextLine()) != null) {
            if (str.matches(".*A.R.*")) ans++;
        }
        System.out.println(ans);
    }
}
