package help_requests.five_letter;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static help_requests.five_letter.FiveLetterSolver.MAX_GUESSES;

@SuppressWarnings("SameParameterValue")
public class Helper {
    public static void main(String[] args) throws IOException {
        Strategy root = getStrategy("en6");
//        Strategy root = getStrategy("en5");
//        Strategy root = getStrategy("ru5");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Strategy strategy = root;
            while (strategy != null) {
                System.out.println(strategy.getGuess());
                String s = scanner.next().trim();
                if (s.isBlank()) continue;
                if (s.equals("-1")) return;
                int mark = parseHashedMark(s);
                if (mark == 0) break;
                strategy = strategy.result(mark);
            }
            System.out.println();
        }
    }

    private static int parseHashedMark(String s) {
        int n = s.length(), hash = 0;
        for (int i = 0; i < n; i++) {
            hash <<= 2;
            hash |= s.charAt(i) - '0';
        }
        return hash;
    }

    private static Strategy getStrategy(String variant) throws IOException {
        return getStrategy(
                "src/help_requests/five_letter/strategy_" + variant + ".dmp",
                "src/help_requests/five_letter/solutions_" + variant + ".txt",
                "src/help_requests/five_letter/guesses_" + variant + ".txt"
        );
    }

    private static Strategy getStrategy(String dumpFile, String solutionFile, String guessFile) throws IOException {
        try (
                FileInputStream fis = new FileInputStream(dumpFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Strategy strategy = (Strategy) ois.readObject();
            System.out.println("Successfully restored from dump");
            return strategy;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to restore from dump");
        }

        FiveLetterSolver solver = new FiveLetterSolver(solutionFile, guessFile);
        int[] branches = new int[MAX_GUESSES - 1];
        Arrays.fill(branches, 10);
        Strategy strategy = FiveLetterSolver.computeStrategy(solver, solver.solutionsList, MAX_GUESSES, branches);

        try (
                FileOutputStream fis = new FileOutputStream(dumpFile);
                ObjectOutputStream ois = new ObjectOutputStream(fis);
        ) {
            ois.writeObject(strategy);
            ois.flush();
            ois.close();
            System.out.println("Successfully stored to dump");
        } catch (IOException e) {
            System.out.println("Failed to dump to dump");
        }
        return strategy;
    }
}
