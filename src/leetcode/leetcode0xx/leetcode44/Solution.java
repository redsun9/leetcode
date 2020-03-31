package leetcode.leetcode0xx.leetcode44;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        char[] stringChars = s.toCharArray();
        char[] patternChars = p.toCharArray();
        List<Integer> positionsOfStarsBeginning = new ArrayList<>();
        List<Integer> positionOfStarsEnding = new ArrayList<>();
        boolean previousStar = false;
        for (int i = 0; i < patternChars.length; i++) {
            if (patternChars[i] == '*') {
                if (!previousStar) {
                    positionsOfStarsBeginning.add(i);
                    positionOfStarsEnding.add(i + 1);
                } else {
                    positionOfStarsEnding.set(positionOfStarsEnding.size() - 1, i + 1);
                }
                previousStar = true;
            } else {
                previousStar = false;
            }
        }

        if (positionsOfStarsBeginning.isEmpty()) {
            //без звездочек
            if (stringChars.length != patternChars.length) return false;
            return checkSubPatternWithoutStars(stringChars, patternChars, 0, 0, patternChars.length);
        }
        int currentStringBeginning = positionsOfStarsBeginning.get(0);
        if (currentStringBeginning != 0) {
            if (currentStringBeginning > stringChars.length) return false;
            if (!checkSubPatternWithoutStars(stringChars, patternChars, 0, 0, currentStringBeginning)) {
                return false;
            }
        }
        int lastSymbolSubPatternStart = positionOfStarsEnding.get(positionOfStarsEnding.size() - 1);
        int currentStringEnd = stringChars.length - (patternChars.length - lastSymbolSubPatternStart);
        if (lastSymbolSubPatternStart != patternChars.length) {
            if (currentStringBeginning > currentStringEnd) return false;
            if (!checkSubPatternWithoutStars(stringChars, patternChars, currentStringEnd, lastSymbolSubPatternStart, patternChars.length)) {
                return false;
            }
        }
        if (positionsOfStarsBeginning.size() == 1) {
            return true;
        } else {
            for (int i = 0; i < positionOfStarsEnding.size() - 1; i++) {
                int patternStart = positionOfStarsEnding.get(i);
                int patternEnd = positionsOfStarsBeginning.get(i + 1);
                int pos = findPos(
                        stringChars, patternChars, currentStringBeginning, currentStringEnd,
                        patternStart, patternEnd
                );
                if (pos < 0) return false;
                currentStringBeginning = pos + patternEnd - patternStart;
            }
        }
        ;
        return true;
    }

    private int findPos(
            char[] stringChars, char[] patternChars,
            int fromPosition, int endPosition,
            int patternStart, int patternEnd
    ) {
        int patternLength = patternEnd - patternStart;
        if (endPosition - fromPosition < patternLength) return -1;
        char patternCharAtBeginning = patternChars[patternStart];
        if (patternLength == 1) {
            if (patternCharAtBeginning == '?') return fromPosition;
            for (; fromPosition < endPosition; fromPosition++) {
                if (stringChars[fromPosition] == patternCharAtBeginning) return fromPosition;
            }
            return -1;
        }
        LinkedList<Integer> state = new LinkedList<>();
        for (; fromPosition < endPosition; fromPosition++) {
            char stringChar = stringChars[fromPosition];
            ListIterator<Integer> listIterator = state.listIterator();
            while (listIterator.hasNext()) {
                int next = listIterator.next();
                char patternChar = patternChars[patternStart + next];
                if (patternChar == '?' || patternChar == stringChar) {
                    next++;
                    if (next == patternLength) return fromPosition - next + 1;
                    listIterator.set(next);
                } else {
                    listIterator.remove();
                }
            }
            if (patternCharAtBeginning == '?' || stringChar == patternCharAtBeginning) {
                state.addLast(1);
            }
        }
        return -1;
    }

    private boolean checkSubPatternWithoutStars(
            char[] stringChars, char[] patternChars,
            int stringStart, int patternStart, int patternEnd
    ) {
        for (; patternStart < patternEnd; patternStart++, stringStart++) {
            char patternChar = patternChars[patternStart];
            if (patternChar != '?' && patternChar != stringChars[stringStart]) return false;
        }
        return true;
    }
}
