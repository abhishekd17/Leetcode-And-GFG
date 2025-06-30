class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0 , j = 0;
        int ans = 0;
        while(i < n){
            while(nums[i] - nums[j] > 1) j++;
            if(nums[i] - nums[j] == 1){
                ans = Math.max(i - j + 1 ,  ans);
            }
            i++;
        }
        return ans;
    }
}


/*class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        int ans = 0;
        for(int num : nums){
            if(map.containsKey(num + 1)){
                int x = map.get(num) + map.get(num + 1);
                ans = Math.max(ans , x);
            }
        }
        return ans;
    }
} */