class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int pairSum[] = new int[n - 1];
        for(int i = 0 ; i < n - 1 ; i++){
            pairSum[i] = nums[i] + nums[i + 1];
        }

        int i = n - 1 , j = n - 3;
        while(i >= 0 && j >= 0){
            if(nums[i] < pairSum[j]) return nums[i] + pairSum[j];
            else{
                i--;
                j--;
            }
        }
        return 0;
    }
}