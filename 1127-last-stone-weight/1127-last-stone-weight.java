class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int i = 0 ; i < n ; i++) pq.offer(stones[i]);

        while(pq.size() != 1){
            int y = pq.poll();
            int x = pq.poll();
            pq.offer(y - x);
        }
        return pq.poll();
    }
}