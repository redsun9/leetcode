package yandex.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LightWarriorTest {

    //only one goblin
    @Test
    void test1() {
        int[] goblins = {5};
        LightWarrior warrior = new LightWarrior();
        assertEquals(3, warrior.minimumNumberOfHits(goblins, 2, 4));
    }

    //p==q
    @Test
    void test2() {
        int[] goblins = {6, 11};
        LightWarrior warrior = new LightWarrior();
        assertEquals(3, warrior.minimumNumberOfHits(goblins, 4, 4));
    }

    //q=0
    @Test
    void test3() {
        int[] goblins = {7, 11};
        LightWarrior warrior = new LightWarrior();
        assertEquals(10, warrior.minimumNumberOfHits(goblins, 2, 0));
    }

    //p=0
    @Test
    void test4() {
        int[] goblins = {7, 11};
        LightWarrior warrior = new LightWarrior();
        assertEquals(10, warrior.minimumNumberOfHits(goblins, 0, 2));
    }

    //p=0
    @Test
    void test5() {
        int[] goblins = {5, 5, 5};
        LightWarrior warrior = new LightWarrior();
        assertEquals(3, warrior.minimumNumberOfHits(goblins, 0, 3));
    }
}