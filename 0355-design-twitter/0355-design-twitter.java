class Twitter {
    private static class Tweet{
        int tweetId;
        int time;
        public Tweet(int tweetId , int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer , Set<Integer>> followMap;
    private Map<Integer , List<Tweet>> tweetsMap;
    private int time;
    public Twitter() {
        followMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetsMap.putIfAbsent(userId , new ArrayList<>());
        tweetsMap.get(userId).add(new Tweet(tweetId , time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        followMap.putIfAbsent(userId , new HashSet<>());
        followMap.get(userId).add(userId);

        for(int followeeId : followMap.get(userId)){
            List<Tweet> tweets = tweetsMap.get(followeeId);
            if(tweets != null){
                for(Tweet tweet : tweets){
                    pq.offer(tweet);
                    if(pq.size() > 10){
                        pq.poll();
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().tweetId);
        }
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId , new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        Set<Integer> followees = followMap.get(followerId);
        if(followees != null) followees.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */