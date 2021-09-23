package leetcode.leetcode2xx.leetcode247;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        List<String> expected = List.of("0", "1", "8");
        List<String> actual = new Solution().findStrobogrammatic(1);
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test2() {
        List<String> expected = List.of("11", "69", "88", "96");
        List<String> actual = new Solution().findStrobogrammatic(2);
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test3() {
        List<String> expected = List.of(
                "101", "111", "181", "609", "619", "689",
                "808", "818", "888", "906", "916", "986"
        );
        List<String> actual = new Solution().findStrobogrammatic(3);
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test4() {
        List<String> expected = List.of(
                "1001", "1111", "1691", "1881", "1961",
                "6009", "6119", "6699", "6889", "6969",
                "8008", "8118", "8698", "8888", "8968",
                "9006", "9116", "9696", "9886", "9966"
        );
        List<String> actual = new Solution().findStrobogrammatic(4);
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test5() {
        List<String> expected = List.of(
                "10001", "10101", "10801", "11011", "11111",
                "11811", "16091", "16191", "16891", "18081",
                "18181", "18881", "19061", "19161", "19861",
                "60009", "60109", "60809", "61019", "61119",
                "61819", "66099", "66199", "66899", "68089",
                "68189", "68889", "69069", "69169", "69869",
                "80008", "80108", "80808", "81018", "81118",
                "81818", "86098", "86198", "86898", "88088",
                "88188", "88888", "89068", "89168", "89868",
                "90006", "90106", "90806", "91016", "91116",
                "91816", "96096", "96196", "96896", "98086",
                "98186", "98886", "99066", "99166", "99866"
        );
        List<String> actual = new Solution().findStrobogrammatic(5);
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    void test6() {
        List<String> expected = List.of(
                "100001", "101101", "106901", "108801", "109601",
                "110011", "111111", "116911", "118811", "119611",
                "160091", "161191", "166991", "168891", "169691",
                "180081", "181181", "186981", "188881", "189681",
                "190061", "191161", "196961", "198861", "199661",
                "600009", "601109", "606909", "608809", "609609",
                "610019", "611119", "616919", "618819", "619619",
                "660099", "661199", "666999", "668899", "669699",
                "680089", "681189", "686989", "688889", "689689",
                "690069", "691169", "696969", "698869", "699669",
                "800008", "801108", "806908", "808808", "809608",
                "810018", "811118", "816918", "818818", "819618",
                "860098", "861198", "866998", "868898", "869698",
                "880088", "881188", "886988", "888888", "889688",
                "890068", "891168", "896968", "898868", "899668",
                "900006", "901106", "906906", "908806", "909606",
                "910016", "911116", "916916", "918816", "919616",
                "960096", "961196", "966996", "968896", "969696",
                "980086", "981186", "986986", "988886", "989686",
                "990066", "991166", "996966", "998866", "999666"
        );
        List<String> actual = new Solution().findStrobogrammatic(6);
        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }
}