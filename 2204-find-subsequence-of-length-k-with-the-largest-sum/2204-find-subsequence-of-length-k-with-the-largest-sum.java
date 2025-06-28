class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i = 0 ; i < n ; i++){
            pq.offer(new int[]{nums[i] , i});
            if(pq.size() > k) pq.poll();
        }
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int ans[] = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            pq1.offer(pq.poll());
        }

        while(!pq1.isEmpty()){
            int top[] = pq1.poll();
            ans[i++] = top[0];
        }
        return ans;
    }
}