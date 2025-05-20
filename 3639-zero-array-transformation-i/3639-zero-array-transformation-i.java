class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        int d[] = new int[n + 1];
        for(int query[] : queries){
            int l = query[0];
            int r = query[1];
            d[l]++;
            if(r + 1 > n) continue;
            else d[r + 1]--;
        }
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            cnt += d[i];
            if(cnt < nums[i]) return false;
        }
        return true;
    }
}


/*class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int d[] = new int[n + 1];
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            d[l]++;
            if(r + 1 > n ) continue;
            else if(r + 1 < n ) d[r + 1]--; 
        }
        
        int ans = 0;
        for(int i = 0; i < n ; i++){
            ans += d[i];
            if(ans < nums[i]) return false;
        }
        return true;
    }
}*/

//         for(int i = 0 ; i < m ; i++){
//             for(int j = queries[i][0] ;j <= queries[i][1] ; j++ ){
//                 if(nums[j] != 0) nums[j]--;
//             }
//         }
        
//         for(int i = 0 ; i < n ; i++){
//             if(nums[i] != 0) return false;
//         }
//         return true; 