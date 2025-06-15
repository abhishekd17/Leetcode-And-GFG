class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        int maxi[] = new int[n + 1];
        int mini[] = new int[n + 1];
        maxi[0] = nums[0];
        mini[0] = nums[0];

        for(int i = 1 ; i < n ; i++){
            maxi[i] = Math.max(maxi[i - 1] , nums[i]);
            mini[i] = Math.min(mini[i - 1] , nums[i]);
        }
        if(m == 1) return Math.max((long) maxi[n - 1] * maxi[n - 1] , (long) mini[n - 1] * mini[n - 1]);
        for(int i = m - 1 ; i < n ; i++){
            ans = Math.max(ans , Math.max((long) maxi[i - m + 1] * nums[i] , (long) mini[i - m + 1] * nums[i]));
        }
        return ans;
    }
}


/*class Solution {
    long maxProduct = Long.MIN_VALUE;
    Map<String , Long> map = new HashMap<>();
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        return helper(nums , Integer.MAX_VALUE , Integer.MAX_VALUE , 0 , m);
    }
    private long helper(int nums[] , int first , int last , int idx , int size){
        if(idx == nums.length){
            if(size <= 0 && first != Integer.MAX_VALUE && last != Integer.MAX_VALUE){
                long product = 1L *first * last;
                maxProduct = Math.max(product , maxProduct);
            }
            return maxProduct;
        }
        String key = idx + "$" + first + "$" + last + "$" + size;
        if(map.containsKey(key)) return map.get(key);
        long not_pick = helper(nums , first , last , idx + 1 , size);
        if(first == Integer.MAX_VALUE){
            first = nums[idx];
        }
        long pick = helper(nums ,first , nums[idx] , idx + 1 , size - 1);
        map.put(key , maxProduct);
        return maxProduct;
    }
} */