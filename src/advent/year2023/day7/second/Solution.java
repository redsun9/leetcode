package advent.year2023.day7.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.lang.Integer.parseInt;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final char[] order = {'A', 'K', 'Q', 'T', '9', '8', '7', '6', '5', '4', '3', '2', 'J'};
    private static final Map<Character, Integer> cardToPriority;
    private static final int NUMBER_OF_ORDERS = 13;

    private static final int JOKER_ORDER = 12;
    private static final int BASE_FOR_COMBINATION = 13 * 13 * 13 * 13 * 13;

    static {
        cardToPriority = new HashMap<>();
        for (int i = 0; i < order.length; i++) cardToPriority.put(order[i], i);
    }

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day7/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day7/second/output.txt");
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
        int powerForCards = 0;
        int jokerCount = 0;
        int cardCount = 0;
        for (int i = 0; i < 5; i++) {
            int card = cardToPriority.get(s.charAt(i));
            powerForCards = powerForCards * NUMBER_OF_ORDERS + card;
            if (card == JOKER_ORDER) jokerCount++;
            else cards[cardCount++] = card;
        }

        Arrays.sort(cards, 0, cardCount);

        int combination;

        if (jokerCount >= 4) combination = 0;
        else if (jokerCount == 3) {
            if (cards[0] == cards[1]) combination = 0;
            else combination = 1;
        } else if (jokerCount == 2) {
            if (cards[0] == cards[2]) combination = 0;
            else if (cards[0] == cards[1] || cards[1] == cards[2]) combination = 1;
            else combination = 3;
        } else if (jokerCount == 1) {
            if (cards[0] == cards[3]) combination = 0;
            else if (cards[0] == cards[2] || cards[1] == cards[3]) combination = 1;
            else if (cards[0] == cards[1] && cards[2] == cards[3]) combination = 2;
            else if (cards[0] == cards[1] || cards[1] == cards[2] || cards[2] == cards[3]) combination = 3;
            else combination = 5;
        } else {
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
        }
        return combination * BASE_FOR_COMBINATION + powerForCards;
    }
}