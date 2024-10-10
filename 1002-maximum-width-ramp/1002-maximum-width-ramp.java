class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            if(st.isEmpty() || nums[st.peek()] > nums[i]){
                st.add(i);
            }
        }
        int res = 0;
        for(int i = n -1 ; i >= 0 ; i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                res = Math.max(res , i - st.pop());
            }
        }
        return res;
    }
}


/*class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
           for(int j = i + 1 ; j < n ; j++){
            if(nums[i] <= nums[j]){
                ans = Math.max(ans , j - i);
            }
           }
        }
        return ans;
    }
} */