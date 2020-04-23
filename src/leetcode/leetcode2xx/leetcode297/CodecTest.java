package leetcode.leetcode2xx.leetcode297;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodecTest {

    @Test
    @org.junit.jupiter.api.Disabled
    void testSerialize() {
        Codec codec = new Codec();
        IntStream.range(0, 10000).parallel().forEach(x -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            TreeNode treeNode = getRandomTree(random, new AtomicInteger(1000));
            assertEquals(treeNode, codec.deserialize(codec.serialize(treeNode)));
        });
    }

    private TreeNode getRandomTree(Random random, AtomicInteger maxCounter) {
        if (maxCounter.get() <= 0 || random.nextInt(10) == 0) {
            return null;
        }
        maxCounter.decrementAndGet();
        TreeNode treeNode = new TreeNode(random.nextInt());
        treeNode.right = getRandomTree(random, maxCounter);
        treeNode.left = getRandomTree(random, maxCounter);
        return treeNode;
    }
}