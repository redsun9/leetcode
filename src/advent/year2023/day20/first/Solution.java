package advent.year2023.day20.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Solution {
    private static final int TOTAL_SIGNALS = 1000;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day20/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day20/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(parseInput(scanner)));
        }
    }

    private static List<Module> parseInput(Scanner scanner) {
        List<Module> modules = new ArrayList<>();
        Map<String, Integer> moduleIndices = new HashMap<>();
        List<String[]> moduleDestinations = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (s.isBlank()) continue;
            int pos = s.indexOf("->");
            String[] split = s.substring(pos + 3).split(", ");

            Module module;
            String name;
            if (s.charAt(0) == '%' || s.charAt(0) == '&') {
                name = s.substring(1, pos - 1);
                module = s.charAt(0) == '%' ? new FlipFlop() : new Conjunction();
            } else {
                module = new Broadcaster();
                name = "broadcaster";
            }

            moduleIndices.put(name, modules.size());
            modules.add(module);
            moduleDestinations.add(split);
        }

        for (int i = 0; i < moduleDestinations.size(); i++) {
            Module module = modules.get(i);
            for (String destinationName : moduleDestinations.get(i)) {
                Integer destinationIndex = moduleIndices.get(destinationName);
                if (destinationIndex != null) {
                    module.destinationModules.add(destinationIndex);
                    Module destinationModule = modules.get(destinationIndex);
                    if (destinationModule instanceof Conjunction conjunction) {
                        conjunction.receivers.put(i, conjunction.receivers.size());
                    }
                } else {
                    module.unknownReceivers++;
                }
            }
        }
        return modules;
    }

    private static long solve(List<Module> modules) {
        int n = modules.size();
        int broadcastIndex = 0;
        for (int i = 0; i < n; i++) {
            Module module = modules.get(i);
            if (module instanceof Broadcaster) broadcastIndex = i;
        }

        Deque<Signal> deque = new ArrayDeque<>();
        long totalLow = 0;
        long totalHi = 0;
        for (int i = 0; i < TOTAL_SIGNALS; i++) {
            deque.offer(new Signal(-1, broadcastIndex, false));
            while (!deque.isEmpty()) {
                Signal signal = deque.pollFirst();
                if (signal.high) totalHi++;
                else totalLow++;

                Module module = modules.get(signal.to);
                Boolean resultLevel = module.receiveSignal(signal);
                if (resultLevel == null) continue;

                if (resultLevel) totalHi += module.unknownReceivers;
                else totalLow += module.unknownReceivers;

                for (Integer destinationIndex : module.destinationModules) {
                    deque.offerLast(new Signal(signal.to, destinationIndex, resultLevel));
                }
            }
        }
        return totalHi * totalLow;
    }

    private static class FlipFlop extends Module {
        boolean on;

        @Override
        public Boolean receiveSignal(Signal signal) {
            if (signal.high) return null;
            else {
                this.on = !this.on;
                return this.on;
            }
        }
    }

    private static class Conjunction extends Module {
        private final Map<Integer, Integer> receivers = new HashMap<>();
        private long lastReceivedValues = 0;

        @Override
        public Boolean receiveSignal(Signal signal) {
            int idx = receivers.get(signal.from);
            lastReceivedValues &= ~(1L << idx);                      // clear bit
            lastReceivedValues |= (signal.high ? 1L : 0L) << idx;     // set bit value
            boolean allHigh = (lastReceivedValues ^ (1L << receivers.size()) - 1) == 0L;
            return !allHigh;
        }
    }

    private static class Broadcaster extends Module {
        @Override
        public Boolean receiveSignal(Signal signal) {
            return signal.high;
        }

    }

    private abstract static class Module {
        public final List<Integer> destinationModules = new ArrayList<>();
        public int unknownReceivers = 0;

        public abstract Boolean receiveSignal(Signal signal);
    }

    private record Signal(int from, int to, boolean high) {
    }
}
