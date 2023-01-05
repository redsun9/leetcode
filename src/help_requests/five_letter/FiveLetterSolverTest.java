package help_requests.five_letter;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static help_requests.five_letter.FiveLetterSolver.MAX_GUESSES;

@SuppressWarnings("DuplicatedCode")
public class FiveLetterSolverTest {

    // Only 2315 possible solutions
    // [0, 54, 951, 1256, 54, 0, 0]
    @Test
    void testSmallEnglish() throws IOException {
        FiveLetterSolver solver = new FiveLetterSolver("src/help_requests/five_letter/solutions_en5.txt", "src/help_requests/five_letter/guesses_en5.txt");
        System.out.println("best guess - " + Arrays.toString(solver.bestGuesses(solver.solutionsList, 10)));
        int[] branches = new int[MAX_GUESSES - 1];
        Arrays.fill(branches, 10);
        int[] count = FiveLetterSolver.computeStrategy(solver, solver.solutionsList, MAX_GUESSES, branches).getTotal();
        System.out.println("Only solutions available - " + Arrays.toString(count));
    }

    // All 12972 possible words
    // [1, 55, 1562, 6412, 4247, 654, 41]
    @Test
    void testLargeEnglish() throws IOException {
        FiveLetterSolver solver = new FiveLetterSolver("src/help_requests/five_letter/solutions_en5.txt", "src/help_requests/five_letter/guesses_en5.txt");
        System.out.println("best guess - " + Arrays.toString(solver.bestGuesses(solver.solutionsList, 10)));
        int[] branches = new int[MAX_GUESSES - 1];
        Arrays.fill(branches, 10);
        int[] count = FiveLetterSolver.computeStrategy(solver, new ArrayList<>(solver.guessesList), MAX_GUESSES, branches).getTotal();
        System.out.println("All words available - " + Arrays.toString(count));
    }

    // Only 725 possible solutions
    // [1, 91, 410, 215, 8, 0, 0]
    @Test
    void testSmallRussian() throws IOException {
        FiveLetterSolver solver = new FiveLetterSolver("src/help_requests/five_letter/solutions_ru5.txt", "src/help_requests/five_letter/guesses_ru5.txt");
        System.out.println("best guess - " + Arrays.toString(solver.bestGuesses(solver.solutionsList, 10)));
        int[] branches = new int[MAX_GUESSES - 1];
        Arrays.fill(branches, 10);
        int[] count = FiveLetterSolver.computeStrategy(solver, solver.solutionsList, MAX_GUESSES, branches).getTotal();
        System.out.println("Only solutions available - " + Arrays.toString(count));
    }

    // All 6372 possible words
    // [1, 72, 1510, 3732, 1031, 26, 0]
    @Test
    void testLargeRussian() throws IOException {
        FiveLetterSolver solver = new FiveLetterSolver("src/help_requests/five_letter/solutions_ru5.txt", "src/help_requests/five_letter/guesses_ru5.txt");
        System.out.println("best guess - " + Arrays.toString(solver.bestGuesses(solver.solutionsList, 10)));
        int[] branches = new int[MAX_GUESSES - 1];
        Arrays.fill(branches, 2);
        int[] count = FiveLetterSolver.computeStrategy(solver, new ArrayList<>(solver.guessesList), MAX_GUESSES, branches).getTotal();
        System.out.println("All words available - " + Arrays.toString(count));
    }

    @Test
    void testRandom() {
        int alphabet = 50, n = 6, solutionSize = 500, guessSize = 200;
        Set<String> guesses = new HashSet<>();
        Set<String> solutions = new HashSet<>();
        Random random = new Random(0);
        while (solutions.size() != solutionSize) {
            String s = generate(random, alphabet, n);
            solutions.add(s);
        }
        while (guesses.size() != guessSize) {
            String s = generate(random, alphabet, n);
            if (!solutions.contains(s)) guesses.add(s);
        }
        FiveLetterSolver solver = new FiveLetterSolver(solutions, guesses);

        int[] branches = new int[MAX_GUESSES - 1];
        for (int k = 1; k <= 10; k++) {
            Arrays.fill(branches, k);
            int[] count = FiveLetterSolver.computeStrategy(solver, solver.solutionsList, MAX_GUESSES, branches).getTotal();
            System.out.println("Only solutions available - " + Arrays.toString(count));
        }
    }

    private static String generate(Random random, int alphabet, int n) {
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            int c = random.nextInt(alphabet);
            if (c < 10) arr[i] = (char) ('0' + c);
            else if (c < 36) arr[i] = (char) ('a' + c - 10);
            else arr[i] = (char) ('A' + c - 36);
        }
        return new String(arr);
    }
}