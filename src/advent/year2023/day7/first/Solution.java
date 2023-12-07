package advent.year2023.day7.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Solution {
    private static final char[] order = {'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2'};
    private static final Map<Character, Integer> cardToPriority;
    private static final int NUMBER_OF_ORDERS = 13;
    private static final int BASE_FOR_COMBINATION = 13 * 13 * 13 * 13 * 13;

    static {
        cardToPriority = new HashMap<>();
        for (int i = 0; i < order.length; i++) cardToPriority.put(order[i], i);
    }

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day7/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day7/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<int[]> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().trim().split(" +");
                list.add(new int[]{parse(split[0]), parseInt(split[1])});
            }

            long ans = 0;
            list.sort(Comparator.comparingLong(x -> -x[0]));
            for (int i = 0; i < list.size(); i++) ans += (i + 1L) * list.get(i)[1];
            printer.println(ans);
        }
    }

    private static int parse(String s) {
        int[] cards = new int[5];
        for (int i = 0; i < 5; i++) cards[i] = cardToPriority.get(s.charAt(i));
        int powerForCards = 0;
        for (int i = 0; i < 5; i++) powerForCards = powerForCards * NUMBER_OF_ORDERS + cards[i];

        Arrays.sort(cards);
        int combination;
        if (cards[0] == cards[4]) combination = 0;
        else if (cards[0] == cards[3] || cards[1] == cards[4]) combination = 1;
        else if (cards[0] == cards[2] && cards[3] == cards[4] || cards[0] == cards[1] && cards[2] == cards[4])
            combination = 2;
        else if (cards[0] == cards[2] || cards[1] == cards[3] || cards[2] == cards[4]) combination = 3;
        else if (cards[0] == cards[1] && (cards[2] == cards[3] || cards[3] == cards[4]) || cards[1] == cards[2] && cards[3] == cards[4])
            combination = 4;
        else if (cards[0] == cards[1] || cards[1] == cards[2] || cards[2] == cards[3] || cards[3] == cards[4])
            combination = 5;
        else combination = 6;

        return combination * BASE_FOR_COMBINATION + powerForCards;
    }
}
