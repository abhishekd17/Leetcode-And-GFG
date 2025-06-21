class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        List<Integer> even = new ArrayList<>() , odd = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(nums[i] % 2 == 0) even.add(i);
            else odd.add(i);
        }

        if(Math.abs(even.size() - odd.size()) > 1) return -1;
        int ans = Integer.MAX_VALUE;
        if(even.size() >= odd.size()) ans = Math.min(ans , helper(even));
        if(odd.size() >= even.size()) ans = Math.min(ans , helper(odd));
        return ans;
    }

    private int helper(List<Integer> list){
        int cnt = 0;
        for(int i = 0; i < list.size() ; i++){
            cnt += Math.abs(list.get(i) - (2 * i));
        }
        return cnt;
    }
}