package atcoder.abc158;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        LinkedList<Integer> list = s.chars().boxed().collect(Collectors.toCollection(LinkedList::new));
        boolean reversed = false;
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String req = scanner.nextLine().trim();
            if (req.isEmpty()) {
                i--;
                continue;
            }
            if (req.charAt(0) == '1') {
                reversed = !reversed;
            } else {
                String[] split = req.split(" +");
                int f = Integer.parseInt(split[1]);
                Integer c = (int) split[2].charAt(0);
                if ((f == 1) ^ reversed) {
                    list.addFirst(c);
                } else {
                    list.addLast(c);
                }
            }
        }
        Iterator<Integer> iterator;
        if (reversed) {
            iterator = list.descendingIterator();
        } else {
            iterator = list.iterator();
        }
        while (iterator.hasNext()) {
            System.out.print((char) (int) iterator.next());
        }
    }
}
