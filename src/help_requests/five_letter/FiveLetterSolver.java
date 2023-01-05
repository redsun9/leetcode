package help_requests.five_letter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static java.util.Comparator.naturalOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@SuppressWarnings({"OptionalGetWithoutIsPresent", "DataFlowIssue"})
public class FiveLetterSolver {
    public static final int MAX_GUESSES = 6;
    final List<String> guessesList;
    final List<String> solutionsList;

    public FiveLetterSolver(String solutionPath, String guessPath) throws IOException {
        try (
                FileInputStream fisSolutions = new FileInputStream(solutionPath);
                FileInputStream fisGuesses = new FileInputStream(guessPath);
                Scanner scannerSolutions = new Scanner(fisSolutions);
                Scanner scannerGuesses = new Scanner(fisGuesses);
        ) {
            Set<String> guessesSet = new HashSet<>();
            Set<String> solutionsSet = new HashSet<>();

            while (scannerSolutions.hasNextLine()) {
                String s = scannerSolutions.nextLine().trim();
                guessesSet.add(s);
                solutionsSet.add(s);
            }

            while (scannerGuesses.hasNextLine()) {
                String s = scannerGuesses.nextLine().trim();
                guessesSet.add(s);
            }
            guessesList = new ArrayList<>(guessesSet);
            solutionsList = new ArrayList<>(solutionsSet);
        }
    }

    public FiveLetterSolver(Collection<String> solutions, Collection<String> guesses) {
        guessesList = new ArrayList<>(guesses);
        guessesList.addAll(solutions);
        solutionsList = new ArrayList<>(solutions);
    }

    // 0 - ok, 1 - wrong position, 2 - no
    private static int hashedMark(String solution, String guess) {
        int n = guess.length();
        Set<Character> usedCharacters = new HashSet<>();
        for (int i = 0; i < n; i++) usedCharacters.add(solution.charAt(i));
        int hash = 0;
        for (int i = 0; i < n; i++) {
            hash <<= 2;
            if (solution.charAt(i) == guess.charAt(i)) hash |= 0;
            else if (usedCharacters.contains(guess.charAt(i))) hash |= 1;
            else hash |= 2;
        }
        return hash;
    }

    private static int maxWouldBeLeft(String guess, List<String> leftSolutions) {
        return leftSolutions.parallelStream()
                .filter(it -> !it.equals(guess))
                .map(it -> hashedMark(it, guess))
                .collect(groupingBy(identity(), counting()))
                .values().stream().max(naturalOrder()).get().intValue();
    }

    public static Strategy computeStrategy(
            FiveLetterSolver solver, List<String> leftSolutions, int leftTries, int[] branching
    ) {
        if (leftTries == 1) return new Strategy(leftSolutions.get(0), null, new int[]{1, leftSolutions.size() - 1});
        return Arrays.stream(solver.bestGuesses(leftSolutions, branching[leftTries - 2])).parallel().map(guess -> {
            int[] curr = new int[leftTries + 1];
            Map<Integer, List<String>> map = leftSolutions.stream().collect(groupingBy(it -> hashedMark(it, guess)));
            Map<Integer, Strategy> children = new HashMap<>();
            for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
                if (entry.getKey() == 0) curr[0]++;
                else {
                    Strategy child = computeStrategy(solver, entry.getValue(), leftTries - 1, branching);
                    int[] additional = child.getTotal();
                    for (int i = 0; i < additional.length; i++) curr[i + 1] += additional[i];
                    children.put(entry.getKey(), child);
                }
            }
            return new Strategy(guess, children, curr);
        }).min((first, second) -> {
            int[] a = first.getTotal(), b = second.getTotal();
            for (int i = leftTries; i >= 0; i--) if (a[i] != b[i]) return a[i] - b[i];
            return 0;
        }).get();
    }


    String[] bestGuesses(List<String> leftSolutions, int limit) {
        if (leftSolutions.size() <= limit + 1) {
            String[] ans = new String[Math.min(limit, leftSolutions.size())];
            for (int i = 0; i < ans.length; i++) ans[i] = leftSolutions.get(i);
            return ans;
        } else {
            PriorityQueue<Integer> pqMaxLeft = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<GuessResult> pqGuess = new PriorityQueue<>(Comparator.comparingInt(x -> -x.maxWouldBeLeft));
            for (String guess : guessesList) {
                int maxWouldBeLeft = maxWouldBeLeft(guess, leftSolutions);
                pqGuess.offer(new GuessResult(guess, maxWouldBeLeft));
                pqMaxLeft.offer(maxWouldBeLeft);
                if (pqMaxLeft.size() > limit) {
                    pqMaxLeft.poll();
                    while (pqMaxLeft.peek() < pqGuess.peek().maxWouldBeLeft) pqGuess.poll();
                }
            }
            String[] ans = new String[pqGuess.size()];
            for (int i = 0; i < ans.length; i++) ans[i] = pqGuess.poll().s;
            return ans;
        }
    }

    private record GuessResult(String s, int maxWouldBeLeft) {
    }
}
