class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long cnt = 0;
        Map<Integer , Integer> map = new HashMap<>();
        long pairs = 0;
        int l = 0 , r = 0;
       
        while(l < n && r < n){
            pairs += map.getOrDefault(nums[r] , 0);
            map.put(nums[r] , map.getOrDefault(nums[r] , 0) + 1);
            while(l < n  && pairs >= k){
                map.put(nums[l] , map.getOrDefault(nums[l] , 0) - 1);
                pairs -= map.get(nums[l]);
                l++;
            }
            cnt += l;
            r++;
        }
        
        return cnt;
    }
}


/*class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;

        for(int i = 0 ; i < n ; i++){
            Map<Integer , Integer> map = new HashMap<>();
            long pairs = 0;
            for(int j = i ; j < n ; j++){
                pairs += map.getOrDefault(nums[j] , 0);
                map.put(nums[j] , map.getOrDefault(nums[j] , 0) + 1);
                if(pairs >= k) ans++;
            }
        }
        return ans;
    }
} */