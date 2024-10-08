class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int height[] = new int[m];
        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            int area = largestRectangleArea(height);
            maxArea = Math.max(area , maxArea);
        }

        return maxArea;
    }
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int maxans = 0;
        
        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : nums[i];
            while (!st.isEmpty() && height < nums[st.peek()]) {
                int h = nums[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                if(width >= h){
                    int area = h * h;
                    maxans = Math.max(maxans, area);
                }
            }
            st.push(i);
        }
        return maxans;
    }
}