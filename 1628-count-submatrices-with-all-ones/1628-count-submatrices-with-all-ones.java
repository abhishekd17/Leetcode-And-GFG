class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int height[] = new int[m];
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
            }
            ans += helper(height);
        }
        return ans;
    }

    private int helper(int height[]){
        int sum[] = new int[height.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < height.length ; i++){
            while(!st.isEmpty() && height[st.peek()] >= height[i]) st.pop();

            if(!st.isEmpty()){
                int preIndex = st.peek();
                sum[i] = sum[preIndex];
                sum[i] += height[i] * (i - preIndex);
            }else{
                sum[i] = height[i] * (i + 1);
            }
            st.push(i);
        }
        int res = 0;
        for(int s : sum) res += s;
        return res;
    }
}


/*class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int height[] =  new int[m];

        int res = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ;j++){
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
                for(int k = j , min = height[j] ; k >= 0 && min > 0 ; k-- ){
                    min = Math.min(min , height[k]);
                    res += min;
                }
            }
        }
        return res;
    }
} */