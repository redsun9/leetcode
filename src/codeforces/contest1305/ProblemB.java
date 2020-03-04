package codeforces.contest1305;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = str.length();
        Boolean[] res = new Boolean[n];
        for (int i = 0; i < n; i++) {
            res[i] = str.charAt(i) == '(';
        }
        LinkedList<Integer> openS = new LinkedList<>();
        LinkedList<Integer> ends = new LinkedList<>();
        int startI = 0;
        int endI = n - 1;
        while (startI < endI) {
            while (startI < endI) {
                if (res[startI]) break;
                startI++;
            }
            while (startI < endI) {
                if (!res[endI]) break;
                endI--;
            }
            if (startI < endI) {
                openS.addLast(startI);
                ends.addFirst(endI);
            }
            startI++;
            endI--;
        }
        if (openS.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(1);
            System.out.println(2 * openS.size());
            StringBuilder sb = new StringBuilder();
            Iterator<Integer> iterator = openS.iterator();
            sb.append(iterator.next() + 1);
            while (iterator.hasNext()) {
                sb.append(' ').append(iterator.next() + 1);
            }
            iterator = ends.iterator();
            while (iterator.hasNext()) {
                sb.append(' ').append(iterator.next() + 1);
            }
            System.out.println(sb.toString());
        }
    }
}
