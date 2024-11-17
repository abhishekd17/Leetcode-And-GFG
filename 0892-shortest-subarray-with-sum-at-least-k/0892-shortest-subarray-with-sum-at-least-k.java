class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long pref[] = new long[n];
        Deque<Integer> dq = new LinkedList<>();
        int ans =Integer.MAX_VALUE;
        int j = 0;
        while(j < n ){
            if(j == 0){
                pref[j] = nums[j];
            }else{
                pref[j] = nums[j] + pref[j - 1];
            }
            if(pref[j] >= k ) {
                ans = Math.min(ans , j + 1);
            }
            while(!dq.isEmpty() && pref[j] - pref[dq.peekLast()] >= k){
                ans = Math.min(ans , j - dq.peekLast());
                dq.pollLast();
            }

            while(!dq.isEmpty() && pref[j] <= pref[dq.peekFirst()]){
                dq.pollFirst();
            }
            dq.push(j);
            j++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

/*class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = i ; j < n ; j++){
                sum += nums[j];
                if(sum >= k) {
                    ans = Math.min(ans , j - i + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
} */