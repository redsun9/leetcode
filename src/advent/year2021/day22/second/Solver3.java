package advent.year2021.day22.second;

import java.util.*;

@SuppressWarnings("DuplicatedCode")
public class Solver3 {
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

        OctoTree tree = new OctoTree(false, 0, idxX - 1, 0, idxY - 1, 0, idxZ - 1);
        for (int[] q : queries)
            tree.setVal(
                    q[6] == 1,
                    mapX.get(q[0]), mapX.get(q[1]),
                    mapY.get(q[2]), mapY.get(q[3]),
                    mapZ.get(q[4]), mapZ.get(q[5])
            );
        return tree.getCount(xValues, yValues, zValues);
    }

    private static class OctoTree {
        final int minX, maxX, minY, maxY, minZ, maxZ;
        boolean val;
        OctoTree left, right; // xyz

        OctoTree(boolean newVal, int minX, int maxX, int minY, int maxY, int minZ, int maxZ) {
            this.val = newVal;
            this.minX = minX;
            this.maxX = maxX;
            this.minY = minY;
            this.maxY = maxY;
            this.minZ = minZ;
            this.maxZ = maxZ;
        }

        void setVal(boolean newVal, int qMinX, int qMaxX, int qMinY, int qMaxY, int qMinZ, int qMaxZ) {
            if (qMinX >= maxX || qMaxX <= minX) return;
            if (qMinY >= maxY || qMaxY <= minY) return;
            if (qMinZ >= maxZ || qMaxZ <= minZ) return;

            if (this.val == newVal && left == null && right == null) return;
            if (qMinX <= minX && qMaxX >= maxX && qMinY <= minY && qMaxY >= maxY && qMinZ <= minZ && qMaxZ >= maxZ) {
                this.val = newVal;
                left = null;
                right = null;
                return;
            }

            if (left == null) {
                if (qMaxX < maxX || qMinX > minX) {
                    int midX = minX + (maxX - minX) / 2;
                    left = new OctoTree(this.val, minX, midX, minY, maxY, minZ, maxZ);
                    right = new OctoTree(this.val, midX, maxX, minY, maxY, minZ, maxZ);
                } else if (qMaxY < maxY || qMinY > minY) {
                    int midY = minY + (maxY - minY) / 2;
                    left = new OctoTree(this.val, minX, maxX, minY, midY, minZ, maxZ);
                    right = new OctoTree(this.val, minX, maxX, midY, maxY, minZ, maxZ);
                } else {
                    int midZ = minZ + (maxZ - minZ) / 2;
                    left = new OctoTree(this.val, minX, maxX, minY, maxY, minZ, midZ);
                    right = new OctoTree(this.val, minX, maxX, minY, maxY, midZ, maxZ);
                }
            }

            left.setVal(newVal, qMinX, qMaxX, qMinY, qMaxY, qMinZ, qMaxZ);
            right.setVal(newVal, qMinX, qMaxX, qMinY, qMaxY, qMinZ, qMaxZ);
        }

        long getCount(int[] xValues, int[] yValues, int[] zValues) {
            if (left == null) {
                if (!val) return 0;
                return ((long) xValues[maxX] - xValues[minX]) *
                        (yValues[maxY] - yValues[minY]) *
                        (zValues[maxZ] - zValues[minZ]);
            }
            return left.getCount(xValues, yValues, zValues) + right.getCount(xValues, yValues, zValues);
        }

    }
}
