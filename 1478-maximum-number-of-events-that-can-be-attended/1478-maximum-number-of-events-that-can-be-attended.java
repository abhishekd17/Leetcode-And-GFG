class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });

        int i = 0 , ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int day = 1 ; day <= 100000 ; day++){
            while(i < n  && events[i][0] == day) pq.offer(events[i++][1]);
            while(!pq.isEmpty() && pq.peek() < day) pq.poll();
            if(!pq.isEmpty()){
                ans++;
                pq.poll();
            }
        }
        return ans;
    }
}