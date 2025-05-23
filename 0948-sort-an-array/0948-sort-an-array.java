class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++) pq.offer(nums[i]);
        int ans[] = new int[n];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }
        return ans;
    }
}