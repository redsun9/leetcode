package advent.year2021.day19.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int[][][] mutations = {
            {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}},
            {{1, 0, 0}, {0, 0, -1}, {0, 1, 0}},
            {{1, 0, 0}, {0, -1, 0}, {0, 0, -1}},
            {{1, 0, 0}, {0, 0, 1}, {0, -1, 0}},
            {{0, 0, -1}, {0, 1, 0}, {1, 0, 0}},
            {{0, -1, 0}, {0, 0, -1}, {1, 0, 0}},
            {{0, 0, 1}, {0, -1, 0}, {1, 0, 0}},
            {{0, 1, 0}, {0, 0, 1}, {1, 0, 0}},
            {{-1, 0, 0}, {0, 1, 0}, {0, 0, -1}},
            {{-1, 0, 0}, {0, 0, -1}, {0, -1, 0}},
            {{-1, 0, 0}, {0, -1, 0}, {0, 0, 1}},
            {{-1, 0, 0}, {0, 0, 1}, {0, 1, 0}},
            {{0, 0, 1}, {0, 1, 0}, {-1, 0, 0}},
            {{0, 1, 0}, {0, 0, -1}, {-1, 0, 0}},
            {{0, 0, -1}, {0, -1, 0}, {-1, 0, 0}},
            {{0, -1, 0}, {0, 0, 1}, {-1, 0, 0}},
            {{0, -1, 0}, {1, 0, 0}, {0, 0, 1}},
            {{0, 0, 1}, {1, 0, 0}, {0, 1, 0}},
            {{0, 1, 0}, {1, 0, 0}, {0, 0, -1}},
            {{0, 0, -1}, {1, 0, 0}, {0, -1, 0}},
            {{0, -1, 0}, {-1, 0, 0}, {0, 0, -1}},
            {{0, 0, 1}, {-1, 0, 0}, {0, -1, 0}},
            {{0, 1, 0}, {-1, 0, 0}, {0, 0, 1}},
            {{0, 0, -1}, {-1, 0, 0}, {0, 1, 0}}
    };


    private static final Point centerCoordinate = new Point(0, 0, 0);

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(mutations));

        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day19/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day19/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<List<Point>> radarCandidates = new ArrayList<>();
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                List<Point> radar = new ArrayList<>();
                while (scanner.hasNextLine()) {
                    String s = scanner.nextLine().trim();
                    if (s.isEmpty()) break;
                    String[] split = s.split(",");
                    radar.add(new Point(
                            Integer.parseInt(split[0]),
                            Integer.parseInt(split[1]),
                            Integer.parseInt(split[2])
                    ));
                }
                radarCandidates.add(radar);
            }

            Set<Point> points = new HashSet<>(radarCandidates.get(0));
            Set<Point> restrictedPositions = new HashSet<>();

            points.add(centerCoordinate);
            restrictedPositions.add(centerCoordinate);
            radarCandidates.remove(0);

            while (!radarCandidates.isEmpty()) {
                int maxCollision = 0, maxRadarIdx = 0, maxMutationIdx = 0;
                Point maxCollisionShift = centerCoordinate;
                for (int radarIdx = 0; radarIdx < radarCandidates.size(); radarIdx++) {
                    List<Point> radarCandidate = radarCandidates.get(radarIdx);
                    int size = radarCandidate.size();
                    Point[] candidatePoints = new Point[size];
                    for (int mutationIdx = 0; mutationIdx < mutations.length; mutationIdx++) {
                        int[][] candidateMutation = mutations[mutationIdx];
                        for (int k = 0; k < size; k++)
                            candidatePoints[k] = radarCandidate.get(k).multiply(candidateMutation);
                        Map<Point, Integer> shiftCollisionMap = new HashMap<>();
                        for (Point candidatePoint : candidatePoints) {
                            for (Point alreadyFixedPoint : points) {
                                Point candidateShift = candidatePoint.substract(alreadyFixedPoint);
                                shiftCollisionMap.compute(candidateShift, (k, v) -> v == null ? 1 : v + 1);
                            }
                        }

                        for (Map.Entry<Point, Integer> entry : shiftCollisionMap.entrySet()) {
                            if (restrictedPositions.contains(entry.getKey())) continue;

                            if (entry.getValue() > maxCollision) {
                                maxCollision = entry.getValue();
                                maxRadarIdx = radarIdx;
                                maxMutationIdx = mutationIdx;
                                maxCollisionShift = entry.getKey();
                            }
                        }
                    }
                }
                System.out.println("max collision - " + maxCollision);
                List<Point> pointsToAdd = radarCandidates.get(maxRadarIdx);
                int[][] mutation = mutations[maxMutationIdx];
                for (Point point : pointsToAdd) points.add(point.multiply(mutation).substract(maxCollisionShift));
                points.add(centerCoordinate.substract(maxCollisionShift));
                restrictedPositions.add(centerCoordinate.substract(maxCollisionShift));
                radarCandidates.remove(maxRadarIdx);
            }
            printer.println(points.size() - restrictedPositions.size());
        }
    }


    private record Point(int x, int y, int z) {
        Point multiply(int[][] mutation) {
            return new Point(
                    x * mutation[0][0] + y * mutation[0][1] + z * mutation[0][2],
                    x * mutation[1][0] + y * mutation[1][1] + z * mutation[1][2],
                    x * mutation[2][0] + y * mutation[2][1] + z * mutation[2][2]
            );
        }

        Point substract(Point other) {
            return new Point(
                    x - other.x,
                    y - other.y,
                    z - other.z
            );
        }

    }
}
