package advent.year2022.day19.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int MINUTES = 24;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day19/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day19/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int ans = 0;
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().trim().replaceAll("[^0-9]+", " ")
                        .replaceAll(" +", " ").trim().split(" ");
                int id = Integer.parseInt(split[0]);
                int[] costs = new int[6];
                for (int i = 0; i < 6; i++) costs[i] = Integer.parseInt(split[i + 1]);
                ans += id * maxGeodeCollected(costs);
            }
            printer.println(ans);
        }
    }

    private static int maxGeodeCollected(int[] costs) {
        return dfs(0, new int[]{1, 0, 0, 0}, new int[]{0, 0, 0, 0}, costs);
    }

    private static int dfs(int currentTime, int[] robotCount, int[] resourceCount, int[] costs) {
        //we don't build anything
        int ans = resourceCount[3] + robotCount[3] * (MINUTES - currentTime);

        //we wish to construct ore robot
        {
            int timeToBuildOreRobot = (Math.max(0, costs[0] - resourceCount[0]) + robotCount[0] - 1) / robotCount[0] + 1;
            if (currentTime + timeToBuildOreRobot < MINUTES) {
                processCollecting(robotCount, resourceCount, timeToBuildOreRobot);
                robotCount[0]++;
                resourceCount[0] -= costs[0];
                ans = Math.max(ans, dfs(currentTime + timeToBuildOreRobot, robotCount, resourceCount, costs));
                resourceCount[0] += costs[0];
                robotCount[0]--;
                processCollecting(robotCount, resourceCount, -timeToBuildOreRobot);
            }
        }


        //we wish to construct clay robot
        {
            int timeToBuildClayRobot = (Math.max(0, costs[1] - resourceCount[0]) + robotCount[0] - 1) / robotCount[0] + 1;
            if (currentTime + timeToBuildClayRobot < MINUTES) {
                processCollecting(robotCount, resourceCount, timeToBuildClayRobot);
                robotCount[1]++;
                resourceCount[0] -= costs[1];
                ans = Math.max(ans, dfs(currentTime + timeToBuildClayRobot, robotCount, resourceCount, costs));
                resourceCount[0] += costs[1];
                robotCount[1]--;
                processCollecting(robotCount, resourceCount, -timeToBuildClayRobot);
            }

        }

        {
            if (robotCount[1] != 0) {
                int timeToBuildObsidianRobot = Math.max(
                        (Math.max(0, costs[2] - resourceCount[0]) + robotCount[0] - 1) / robotCount[0],
                        (Math.max(0, costs[3] - resourceCount[1]) + robotCount[1] - 1) / robotCount[1]
                ) + 1;
                if (currentTime + timeToBuildObsidianRobot < MINUTES) {
                    processCollecting(robotCount, resourceCount, timeToBuildObsidianRobot);
                    robotCount[2]++;
                    resourceCount[0] -= costs[2];
                    resourceCount[1] -= costs[3];
                    ans = Math.max(ans, dfs(currentTime + timeToBuildObsidianRobot, robotCount, resourceCount, costs));
                    resourceCount[0] += costs[2];
                    resourceCount[1] += costs[3];
                    robotCount[2]--;
                    processCollecting(robotCount, resourceCount, -timeToBuildObsidianRobot);
                }
            }
        }

        {
            if (robotCount[2] != 0) {
                int timeToBuildGeodeRobot = Math.max(
                        (Math.max(0, costs[4] - resourceCount[0]) + robotCount[0] - 1) / robotCount[0],
                        (Math.max(0, costs[5] - resourceCount[2]) + robotCount[2] - 1) / robotCount[2]
                ) + 1;
                if (currentTime + timeToBuildGeodeRobot < MINUTES) {
                    processCollecting(robotCount, resourceCount, timeToBuildGeodeRobot);
                    robotCount[3]++;
                    resourceCount[0] -= costs[4];
                    resourceCount[2] -= costs[5];
                    ans = Math.max(ans, dfs(currentTime + timeToBuildGeodeRobot, robotCount, resourceCount, costs));
                    resourceCount[0] += costs[4];
                    resourceCount[2] += costs[5];
                    robotCount[3]--;
                    processCollecting(robotCount, resourceCount, -timeToBuildGeodeRobot);
                }
            }
        }

        return ans;
    }

    private static void processCollecting(int[] robotCount, int[] resourceCount, int time) {
        for (int i = 0; i < 4; i++) resourceCount[i] += robotCount[i] * time;
    }
}
