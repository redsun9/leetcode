package leetcode.leetcode38xx.leetcode3815;

import java.util.*;

public class AuctionSystem {
    private final Map<UserItem, Integer> userBids = new HashMap<>();
    private final Map<Integer, SortedSet<BidAmountUserId>> itemBids = new HashMap<>();
    private final Comparator<BidAmountUserId> comparator = Comparator.comparingInt(BidAmountUserId::bidAmount).thenComparingInt(BidAmountUserId::userId);

    public void addBid(int userId, int itemId, int bidAmount) {
        removeBid(userId, itemId);
        userBids.put(new UserItem(userId, itemId), bidAmount);
        itemBids.computeIfAbsent(itemId, k -> new TreeSet<>(comparator)).add(new BidAmountUserId(bidAmount, userId));
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        addBid(userId, itemId, newAmount);
    }

    public void removeBid(int userId, int itemId) {
        UserItem userItem = new UserItem(userId, itemId);
        Integer prev = userBids.remove(userItem);
        if (prev != null) itemBids.get(itemId).remove(new BidAmountUserId(prev, userId));
    }

    public int getHighestBidder(int itemId) {
        SortedSet<BidAmountUserId> set = itemBids.get(itemId);
        if (set != null && !set.isEmpty()) return set.last().userId;
        else return -1;
    }

    private record UserItem(int userId, int itemId) {
    }

    private record BidAmountUserId(int bidAmount, int userId) {
    }
}
