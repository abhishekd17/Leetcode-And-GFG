class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0] , b[0]);
            }
            return Integer.compare(a[1] , b[1]);
        });
        for(int i = 0 ; i < n ; i++){
            pq.offer(new int[]{nums[i] , i});
        }
        for(int i = 0 ; i < k ; i++){
            int[] top = pq.poll();
            int mini =top[0];
            int idx = top[1];
            nums[idx] *= multiplier;
            pq.offer(new int[]{nums[idx] , idx});
        }
        return nums;
    }
}