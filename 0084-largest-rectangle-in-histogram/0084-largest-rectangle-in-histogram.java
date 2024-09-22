//jai maa saraswati
//optimal
/*class Solution {
    public int largestRectangleArea(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int leftSmall[]=new int[n];
        int rightSmall[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()) leftSmall[i]=0;
            else leftSmall[i]=st.peek()+ 1;
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()) rightSmall[i]=n-1;
            else rightSmall[i]=st.peek()-1;
            st.push(i);
        }
        int maxans=0;
        for(int i=0;i<n;i++){
            maxans=Math.max(maxans , nums[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxans;
    }
}*/

class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int maxans = 0;
        
        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : nums[i];
            while (!st.isEmpty() && height < nums[st.peek()]) {
                int h = nums[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                int area = h * width;
                maxans = Math.max(maxans, area);
            }
            st.push(i);
        }
        return maxans;
    }
}



// brute force
/* class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int MaxAns = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int mini = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (nums[j] < mini) {
                    mini = nums[j];
                }
                int ans = mini * (j - i + 1);
                if (ans > MaxAns) {
                    MaxAns = ans;
                }
            }
        }
        return MaxAns;
    }
}*/