class Solution {
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Map<Double , Integer> map = new HashMap<>();
        for(int r = 4 ; r < n - 2 ; r++){
            int q = r - 2;
            for(int p = 0 ; p < q -1 ; p++){
                double key = 1.0 * nums[p] /nums[q];
                map.put(key , map.getOrDefault(key , 0 ) + 1);
            }

            for(int s = r + 2 ; s < n ; s++){
                double key = 1.0 * nums[s] / nums[r];
                ans += map.getOrDefault(key , 0);
            }
        }
        return ans;
    }
}

/*class Solution {
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int p = 0 ; p < n  ;p++){
            for(int q = p + 1 ; q < n ; q++ ){
                for(int r = q + 1 ; r < n ; r++){
                    for(int s = r + 1 ; s < n ; s++){
                        if( q - p > 1 &&  r - q > 1 &&  s - r > 1 ){
                            if(nums[p] * nums[r] == nums[s] * nums[q]){
                                ans++;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
} */