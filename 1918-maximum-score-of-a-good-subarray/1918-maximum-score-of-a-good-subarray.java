class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int nls[] = new int[n];
        int nsr[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            nls[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        for(int i = n -1 ; i >= 0 ; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            nsr[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int ans =Integer.MIN_VALUE;
        
        for(int i = 0 ; i < n ; i++){
            if(nls[i] < k && k < nsr[i]){
                ans = Math.max(ans , (nsr[i] - nls[i] - 1) * nums[i]);
            }
        }
        return ans;
    }
}


/*class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for(int i = 0 ; i <= k ; i++){
            int mini = nums[i];
            for(int j = i ; j < n ; j++){
                mini = Math.min(mini , nums[j]);
                if(i <= k && k <= j)ans = Math.max(ans , (j - i + 1) * mini);
            }
        }
        return ans;
    }
}*/