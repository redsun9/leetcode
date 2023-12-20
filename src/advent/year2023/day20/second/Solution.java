package advent.year2023.day20.second;

import basic.utils.IntegerUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final String LOOKING_MODULE = "rx";

    // these nodes are right before last conjunction. they are conjunctions and cycled.
    // so the answer is lcm of cycle lengths for these nodes
    private static final Set<String> cycleNodes = Set.of("vz", "bq", "qh", "lt");

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day20/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day20/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(parseInput(scanner)));
        }
    }

    private static Pair<List<Module>, List<Integer>> parseInput(Scanner scanner) {
        List<Module> modules = new ArrayList<>();
        Map<String, Integer> moduleIndices = new HashMap<>();
        List<String[]> moduleDestinations = new ArrayList<>();
        List<Integer> cycleNodeIndices = new ArrayList<>();

        modules.add(new Looking());
        moduleIndices.put(LOOKING_MODULE, 0);
        moduleDestinations.add(new String[0]);

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
            if (cycleNodes.contains(name)) cycleNodeIndices.add(modules.size());
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
                }
            }
        }
        return new Pair<>(modules, cycleNodeIndices);
    }

    private static long solve(Pair<List<Module>, List<Integer>> input) {
        long ans = 1;
        for (Integer cycleNodeIndex : input.second) {
            int cycle = findCycle(input.first, cycleNodeIndex);
            ans = IntegerUtils.lcm(ans, cycle);
            input.first.forEach(Module::resetState);
        }
        return ans;
    }

    private static int findCycle(List<Module> modules, int cycleNodeIndex) {
        int n = modules.size();
        int broadcastIndex = 0;
        for (int i = 0; i < n; i++) {
            Module module = modules.get(i);
            if (module instanceof Broadcaster) broadcastIndex = i;
        }

        Deque<Signal> deque = new ArrayDeque<>();
        int ans = 0;
        while (true) {
            deque.offer(new Signal(-1, broadcastIndex, false));
            ans++;
            while (!deque.isEmpty()) {
                Signal signal = deque.pollFirst();
                Module module = modules.get(signal.to);
                Boolean resultLevel = module.receiveSignal(signal);
                if (resultLevel == null) continue;

                if (cycleNodeIndex == signal.to && resultLevel) return ans;
                for (Integer destinationIndex : module.destinationModules) {
                    deque.offerLast(new Signal(signal.to, destinationIndex, resultLevel));
                }
            }
        }
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

        @Override
        public void resetState() {
            this.on = false;
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

        @Override
        public void resetState() {
            this.lastReceivedValues = 0L;
        }
    }

    private static class Broadcaster extends Module {
        @Override
        public Boolean receiveSignal(Signal signal) {
            return signal.high;
        }

        @Override
        public void resetState() {
        }

    }

    private static class Looking extends Module {

        @Override
        public Boolean receiveSignal(Signal signal) {
            return null;
        }

        @Override
        public void resetState() {

        }
    }

    private abstract static class Module {
        public final List<Integer> destinationModules = new ArrayList<>();

        public abstract Boolean receiveSignal(Signal signal);

        public abstract void resetState();
    }

    private record Signal(int from, int to, boolean high) {
    }

    private record Pair<A, B>(A first, B second) {
    }
}
