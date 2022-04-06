package leetcode.leetcode17xx.leetcode1797;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AuthenticationManager {
    private final int timeToLive;
    private final Map<String, Integer> tokens;
    private final PriorityQueue<Token> pq;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokens = new HashMap<>();
        this.pq = new PriorityQueue<>(Comparator.comparingInt(Token::expirationTime));
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
        pq.offer(new Token(tokenId, currentTime + timeToLive));
    }

    public void renew(String tokenId, int currentTime) {
        Integer expirationTime = tokens.get(tokenId);
        if (expirationTime != null && expirationTime > currentTime) generate(tokenId, currentTime);
    }

    public int countUnexpiredTokens(int currentTime) {
        while (!pq.isEmpty() && pq.peek().expirationTime <= currentTime) {
            tokens.compute(pq.poll().tokenId, (k, v) -> v == null || v <= currentTime ? null : v);
        }
        return tokens.size();
    }

    private record Token(String tokenId, int expirationTime) {
    }
}
