

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        Arrays.fill(ans , -1);
        for(int i=0;i<=n-k;){
            boolean flag=true;
            for(int j=i+1;j<i+k;j++){
                if(nums[j-1] + 1 != nums[j]){
                    i=j;
                    flag=false;
                    break;
                }
            }
            if(flag) ans[i++]=nums[i+k-2] ;
        }
        return ans;
    }
} 