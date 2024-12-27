class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans1 = 0;
        int ans2 = 0;

        int max1 = 0, max2 = 0, start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the score using the current maximum (max1) and the current index
            if (i > 0) {
                ans1 = Math.max(ans1, max1 + values[i] - i);
            }

            // Update max1 for the next iteration
            if (values[i] + i > max1) {
                max1 = values[i] + i;
                start = i;
            }

            // Debugging output to verify logic
            System.out.println(max1 + " " + values[i] + " " + start + " " + end + " ");
        }
        return ans1; // Return the maximum score
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