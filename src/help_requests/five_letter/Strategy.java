package help_requests.five_letter;

import java.io.Serializable;
import java.util.Map;

public class Strategy implements Serializable {
    private String guess;
    private Map<Integer, Strategy> children;
    private int[] total;

    public Strategy(String guess, Map<Integer, Strategy> children, int[] total) {
        this.guess = guess;
        this.children = children;
        this.total = total;
    }

    public String getGuess() {
        return guess;
    }

    public Strategy result(Integer hashedMark) {
        if (children == null) return null;
        return children.get(hashedMark);
    }

    public int[] getTotal() {
        return total;
    }


}
