class Solution {
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

}