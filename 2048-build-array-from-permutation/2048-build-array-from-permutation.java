class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
       for(int i=0;i<n;i++){
           nums[i]=nums[i]+n*(nums[nums[i]]%n);
       } 
       for(int i=0;i<n;i++){
           nums[i]=nums[i]/n;
       }
       return nums;
    }
}

/*class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=nums[nums[i]];
        }
        return ans;
    }
} */