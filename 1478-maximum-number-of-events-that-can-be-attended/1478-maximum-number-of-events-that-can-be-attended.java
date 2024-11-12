class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events , (a,b) -> Integer.compare(a[0] , b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ans = 0;
        int i = 0;
        for(int day = 1 ; day <= 100000 ; day++){

            while(i < n && events[i][0] == day){
                pq.add(events[i++][1]);
            }

            while(!pq.isEmpty() && pq.peek() < day) pq.poll();

            if(!pq.isEmpty()){
                ans++;
                pq.poll();
            }
        }
        return ans;
    }
}