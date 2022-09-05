import java.util.*;

class Twitter {
    HashMap<Integer, ArrayList<Integer>> userPosts;
    HashMap<Integer, HashSet<Integer>> userFollowing;
    ArrayList<int[]> allPosts;

    public Twitter() {
        this.userPosts = new HashMap<>();
        this.userFollowing = new HashMap<>();
        this.allPosts = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (this.userPosts.containsKey(userId)) {
            this.userPosts.get(userId).add(tweetId);
        } else {
            ArrayList<Integer> posts = new ArrayList<>();
            posts.add(tweetId);
            this.userPosts.put(userId, posts);
        }
        int[] userPost = new int[2];
        userPost[0] = userId;
        userPost[1] = tweetId;
        this.allPosts.add(userPost);
        if (!this.userFollowing.containsKey(userId)) {
            HashSet<Integer> followings = new HashSet<>();
            this.userFollowing.put(userId, followings);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        for (int i = this.allPosts.size() - 1; i >= 0; i--) {
            int[] userPost = this.allPosts.get(i);
            if (userId == userPost[0] ||
                    this.userFollowing.get(userId).contains(userPost[0])) {
                feed.add(userPost[1]);
            }
            if (feed.size() == 10) {
                return feed;
            }
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (this.userFollowing.containsKey(followerId)) {
            this.userFollowing.get(followerId).add(followeeId);
        } else {
            HashSet<Integer> followings = new HashSet<>();
            followings.add(followeeId);
            this.userFollowing.put(followerId, followings);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (this.userFollowing.containsKey(followerId)) {
            this.userFollowing.get(followerId).remove(followeeId);
        }
    }
}
