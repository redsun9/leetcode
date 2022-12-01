package advent.year2021.day22.second;

import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solver2 {
    public static long solve(List<int[]> queries) {
        Set<Integer> setX = new HashSet<>(), setY = new HashSet<>(), setZ = new HashSet<>();
        Map<Integer, Integer> mapX = new HashMap<>(), mapY = new HashMap<>(), mapZ = new HashMap<>();

        for (int[] query : queries) {
            setX.add(query[0]);
            setX.add(query[1]);
            setY.add(query[2]);
            setY.add(query[3]);
            setZ.add(query[4]);
            setZ.add(query[5]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(setX);
        int[] xValues = new int[pq.size()];
        int idxX = 0;
        while (!pq.isEmpty()) {
            xValues[idxX] = pq.poll();
            mapX.put(xValues[idxX], idxX);
            idxX++;
        }

        pq.addAll(setY);
        int[] yValues = new int[pq.size()];
        int idxY = 0;
        while (!pq.isEmpty()) {
            yValues[idxY] = pq.poll();
            mapY.put(yValues[idxY], idxY);
            idxY++;
        }

        pq.addAll(setZ);
        int[] zValues = new int[pq.size()];
        int idxZ = 0;
        while (!pq.isEmpty()) {
            zValues[idxZ] = pq.poll();
            mapZ.put(zValues[idxZ], idxZ);
            idxZ++;
        }

        BitSet[][] a = new BitSet[idxX - 1][idxY - 1];
        for (int i = 0; i < idxX - 1; i++) {
            for (int j = 0; j < idxY - 1; j++) {
                a[i][j] = new BitSet(idxZ - 1);
            }
        }

        for (int[] request : queries) {
            int minX = mapX.get(request[0]);
            int maxX = mapX.get(request[1]);
            int minY = mapY.get(request[2]);
            int maxY = mapY.get(request[3]);
            int minZ = mapZ.get(request[4]);
            int maxZ = mapZ.get(request[5]);
            boolean val = request[6] == 1;
            for (int i = minX; i < maxX; i++) {
                for (int j = minY; j < maxY; j++) {
                    if (val) a[i][j].set(minZ, maxZ);
                    else a[i][j].clear(minZ, maxZ);
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < idxX - 1; i++) {
            long l = (long) xValues[i + 1] - (long) xValues[i];
            for (int j = 0; j < idxY - 1; j++) {
                long fromY = yValues[j], toY = yValues[j + 1];
                long s2 = l * (toY - fromY);
                for (int k = 0; k < idxZ - 1; k++) {
                    long fromZ = zValues[k], toZ = zValues[k + 1];
                    if (a[i][j].get(k)) {
                        ans += s2 * (toZ - fromZ);
                    }
                }
            }
        }

        return ans;
    }
}
