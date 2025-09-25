class Solution {
    public int minimumTotal(List<List<Integer>> t) {
         int n=t.size();
        int prev[]=new int[n];
        // last row of traingle
        for(int j=0;j<t.get(n-1).size();j++){
            prev[j]=t.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            int curr[]=new int[i+1];
            for(int j=i ;j>=0 ;j--){
                int d=prev[j];
                int di=prev[j+1];
                curr[j]=Math.min(d,di) + t.get(i).get(j);
            }
            prev=curr;
        }
        return prev[0];
    }
}



/*class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n=t.size();
        int dp[][]=new int[n][n];
        // last row of traingle
        for(int j=0;j<n;j++){
            dp[n-1][j]=t.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i ; j>=0 ;j--){
                int d=dp[i+1][j];
                int di=dp[i+1][j+1];
                dp[i][j]=Math.min(d,di) + t.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}*/


// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n= triangle.size();
//         int dp[][]=new int[n][n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<triangle.get(i).size();j++){
//                 dp[i][j]=-1;
//             }
//         }

//         return helper(triangle , 0 , 0 , dp);
//     }
//     private int helper(List<List<Integer>> triangle , int n , int m , int[][] dp){
//         if(n==triangle.size()) return 0;
//         if(dp[n][m]!=-1) return dp[n][m];
//         int first=helper(triangle , n+1 , m , dp);
//         int second=helper(triangle , n+1 , m + 1 ,dp);
//         return dp[n][m]= Math.min(first , second) + triangle.get(n).get(m);
//     }
// }