class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = 0;

        int max = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                ans = Math.max(ans, max + values[i] - i);
            }

            if (values[i] + i > max) {
                max = values[i] + i;
            }

        }
        return ans;
    }
}

    // private void helper(int values[] , int ind){
    //     if(ind == values.length) return ;

    //     // pick
    //     int pick = helper(values , ind + 1 , arr[ind] + arr[] )
    //     // not_pick
    //     int not_pick = helper(values , ind + 1 , )
    // }
// }

/*class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                ans = Math.max(ans , values[i] + values[j] + i - j );
            }
        }
        return ans;
    }
} */