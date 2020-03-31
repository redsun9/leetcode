package leetcode.leetcode3xx.leetcode355;

import java.util.*;

public class Twitter {
    private static final int FEED_LENGTH = 10;
    private long timer = 0;
    private final HashMap<Integer, LinkedHashSet<Integer>> subscriptions = new HashMap<>();
    private final HashMap<Integer, LinkedList<Tweet>> tweets = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        tweets.compute(userId, (key, list) -> {
            if (list == null) list = new LinkedList<>();
            list.addFirst(new Tweet(timer++, tweetId));
            return list;
        });
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<IteratorWrapper> tweetQueue =
                new PriorityQueue<>(10, Comparator.comparingLong(IteratorWrapper::peek).reversed());
        LinkedHashSet<Integer> set = subscriptions.get(userId);
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        if (set != null && !set.isEmpty()) {
            for (Integer followeeId : set) {
                LinkedList<Tweet> list = tweets.get(followeeId);
                if (list != null && !list.isEmpty()) {
                    IteratorWrapper wrapper = new IteratorWrapper(list.iterator());
                    wrapper.next();
                    tweetQueue.offer(wrapper);
                }
            }
        }
        LinkedList<Tweet> byUser = this.tweets.get(userId);
        if (byUser != null && !byUser.isEmpty()) {
            IteratorWrapper wrapper = new IteratorWrapper(byUser.iterator());
            wrapper.next();
            tweetQueue.offer(wrapper);
        }

        while (result.size() < FEED_LENGTH && !tweetQueue.isEmpty()) {
            IteratorWrapper poll = tweetQueue.poll();
            result.add(poll.tweet.value);
            if (poll.next()) tweetQueue.offer(poll);
        }
        return new ArrayList<>(result);

    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        subscriptions.compute(followerId, (key, set) -> {
            if (set == null) set = new LinkedHashSet<>();
            set.add(followeeId);
            return set;
        });
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        subscriptions.computeIfPresent(followerId, (key, set) -> {
            set.remove(followeeId);
            return set;
        });
    }

    private static class Tweet {
        long time;
        int value;

        public Tweet(long time, int value) {
            this.time = time;
            this.value = value;
        }
    }

    private static class IteratorWrapper {
        private Tweet tweet;
        private Iterator<Tweet> iterator;

        public IteratorWrapper(Iterator<Tweet> iterator) {
            this.iterator = iterator;
        }

        public long peek() {
            return tweet.time;
        }

        public boolean next() {
            if (iterator.hasNext()) {
                tweet = iterator.next();
                return true;
            } else {
                tweet = null;
                return false;
            }
        }

    }
}
