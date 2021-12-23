package advent.day22.second;

import java.util.List;

public class Solver1 {
    public static long solve(List<int[]> queries) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE,
                minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE,
                minZ = Integer.MAX_VALUE, maxZ = Integer.MIN_VALUE;

        for (int[] query : queries) {
            minX = Math.min(minX, query[0]);
            maxX = Math.max(maxX, query[1]);
            minY = Math.min(minY, query[2]);
            maxY = Math.max(maxY, query[3]);
            minZ = Math.min(minZ, query[4]);
            maxZ = Math.max(maxZ, query[5]);
        }

        OctoTree tree = new OctoTree(false, minX, maxX, minY, maxY, minZ, maxZ);
        for (int[] q : queries) tree.setVal(q[6] == 1, q[0], q[1], q[2], q[3], q[4], q[5]);
        return tree.getCount();
    }


    private static class OctoTree {
        final long minX, maxX, minY, maxY, minZ, maxZ;
        boolean val;
        OctoTree left, right; // xyz

        OctoTree(boolean newVal, long minX, long maxX, long minY, long maxY, long minZ, long maxZ) {
            this.val = newVal;
            this.minX = minX;
            this.maxX = maxX;
            this.minY = minY;
            this.maxY = maxY;
            this.minZ = minZ;
            this.maxZ = maxZ;
        }

        void setVal(boolean newVal, long qMinX, long qMaxX, long qMinY, long qMaxY, long qMinZ, long qMaxZ) {
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
                    long midX = minX + (maxX - minX) / 2;
                    left = new OctoTree(this.val, minX, midX, minY, maxY, minZ, maxZ);
                    right = new OctoTree(this.val, midX, maxX, minY, maxY, minZ, maxZ);
                } else if (qMaxY < maxY || qMinY > minY) {
                    long midY = minY + (maxY - minY) / 2;
                    left = new OctoTree(this.val, minX, maxX, minY, midY, minZ, maxZ);
                    right = new OctoTree(this.val, minX, maxX, midY, maxY, minZ, maxZ);
                } else {
                    long midZ = minZ + (maxZ - minZ) / 2;
                    left = new OctoTree(this.val, minX, maxX, minY, maxY, minZ, midZ);
                    right = new OctoTree(this.val, minX, maxX, minY, maxY, midZ, maxZ);
                }
            }

            left.setVal(newVal, qMinX, qMaxX, qMinY, qMaxY, qMinZ, qMaxZ);
            right.setVal(newVal, qMinX, qMaxX, qMinY, qMaxY, qMinZ, qMaxZ);
        }

        long getCount() {
            if (left == null) {
                if (!val) return 0;
                return (maxX - minX) * (maxY - minY) * (maxZ - minZ);
            }
            return left.getCount() + right.getCount();
        }

    }
}
