package atcoder.hitachi2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<Integer>[] nodes = new HashSet[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new HashSet<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            nodes[a].add(b);
            nodes[b].add(a);
        }
        int root = random.nextInt(n);
        // покрасим в два цвета
        int color1 = 0;
        int color2 = 0;
        boolean firstColor = true;
        int lastOfGeneration = 0;
        ArrayList<Integer> nodesToProcess = new ArrayList<>(n);
        nodesToProcess.add(root);
        for (int i = 0; i < n; i++) {
            int node = nodesToProcess.get(i);
            if (firstColor) color1++;
            else color2++;
            nodes[node].forEach(neighbour -> {
                nodes[neighbour].remove(node);
            });
            nodesToProcess.addAll(nodes[node]);
            if (lastOfGeneration == i) {
                firstColor = !firstColor;
                lastOfGeneration = nodesToProcess.size() - 1;
            }
        }
        int[] sequence = new int[n];

        int x = n / 3;
        if (Math.min(color1, color2) <= x) {
            //те, что меньше - числа кратные 3
            firstColor = color1 <= color2;
            int counter3 = 3;
            nodesToProcess.clear();
            lastOfGeneration = 0;
            nodesToProcess.add(root);
            for (int i = 0; i < n; i++) {
                int node = nodesToProcess.get(i);
                if (firstColor) {
                    sequence[node] = counter3;
                    counter3 += 3;
                }
                nodesToProcess.addAll(nodes[node]);
                if (lastOfGeneration == i) {
                    firstColor = !firstColor;
                    lastOfGeneration = nodesToProcess.size() - 1;
                }
            }
            int counter = 1;
            for (int i = 0; i < n; i++) {
                if (sequence[i] == 0) {
                    sequence[i] = counter;
                    counter++;
                    if (counter % 3 == 0 && counter < counter3) counter++;
                }
            }
        } else {
            //одному цвету 3n+1, другому 3n+2
            //те, что меньше - числа кратные 3
            firstColor = color1 <= color2;
            int counter1 = 1;
            int counter2 = 2;
            nodesToProcess.clear();
            lastOfGeneration = 0;
            nodesToProcess.add(root);
            for (int i = 0; i < n; i++) {
                int node = nodesToProcess.get(i);
                if (firstColor) {
                    sequence[node] = counter1;
                    counter1 += 3;
                } else {
                    sequence[node] = counter2;
                    counter2 += 3;
                }
                nodesToProcess.addAll(nodes[node]);
                if (lastOfGeneration == i) {
                    firstColor = !firstColor;
                    lastOfGeneration = nodesToProcess.size() - 1;
                }
            }
            int counter = 3;
            for (int i = 0; i < n; i++) {
                if (sequence[i] == 0 || sequence[i] > n) {
                    sequence[i] = counter;
                    counter += 3;
                }
            }
        }
        System.out.print(sequence[0]);
        for (int i = 1; i < n; i++) {
            System.out.print(" " + sequence[i]);
        }
    }
}
