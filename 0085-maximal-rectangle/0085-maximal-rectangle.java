class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int cols = matrix[0].length;
        int rows = matrix.length;

        int[] height = new int[cols];     // height of '1's
        int[] left = new int[cols];       // left boundary
        int[] right = new int[cols];      // right boundary
        Arrays.fill(right, cols);         // initialize right to cols

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            int currLeft = 0, currRight = cols;

            // Update height
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }

            // Update left
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1')
                    left[j] = Math.max(left[j], currLeft);
                else {
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }

            // Update right
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], currRight);
                else {
                    right[j] = cols;
                    currRight = j;
                }
            }

            // Calculate area
            for (int j = 0; j < cols; j++) {
                int area = (right[j] - left[j]) * height[j];
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}

/*class Solution {
    public int maximalRectangle(char[][] matrix) {
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
                int area = h * width;
                maxans = Math.max(maxans, area);
            }
            st.push(i);
        }
        return maxans;
    }
}
*/

/*class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int height[] = new int[m];
        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            int area = histArea(height);
            maxArea = Math.max(area , maxArea);
        }

        return maxArea;

    }
    private void nextSmallerElement(int nse[] , int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i =  n - 1; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }
    private void prevSmallerElement(int pse[] , int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i =  0; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    private int histArea(int heights[]){
        int n = heights.length;

        int[] nse = new int[n];
        nextSmallerElement(nse , heights);
        
        int[] pse = new int[n];
        prevSmallerElement(pse , heights);

        int maxi = 0;

        for(int i = 0 ; i < n ; i++){
            int area = heights[i] * ( nse[i] - pse[i] - 1 );
            maxi = Math.max(area , maxi);
        }
        return maxi;
    }

} */