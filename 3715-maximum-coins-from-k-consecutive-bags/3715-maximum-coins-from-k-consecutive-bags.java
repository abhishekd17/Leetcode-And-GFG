class Solution {
    public long maximumCoins(int[][] coins, int k) {
        int n = coins.length;
        Arrays.sort(coins , (a,b) -> a[0] - b[0]);

        long ans = 0 , curr = 0;

        // start at coins[i][0]
        for(int i = 0 , j = 0 ; i < n ; i++){
            // add from one interval
            while(j < n && coins[j][1] <= coins[i][0] + k - 1){
                curr += (long) (coins[j][1] - coins[j][0] + 1 ) * coins[j][2];
                j++;
            }
            // now if there is overlap , so just add necessary part in overlapping portion
            if(j < n){
                long partial = (long) Math.max(0 , coins[i][0] + k - 1 - coins[j][0] + 1) * coins[j][2];
                ans = Math.max(ans , curr + partial);
            }
            curr -= (long) (coins[i][1] - coins[i][0] + 1 ) * coins[i][2];
        }

        // end at coins[i][1]

        curr = 0;

        for(int i = 0 , j = 0 ;i < n ; i++){
            curr += (long) (coins[i][1] - coins[i][0] + 1) * coins[i][2];

            while(coins[j][1] < coins[i][1] - k + 1){
                curr -= (long)(coins[j][1] - coins[j][0] + 1) * coins[j][2];
                j++;
            }

            long partial = (long) Math.max(0 , coins[i][1] - k - coins[j][0] + 1) * coins[j][2];
            ans = Math.max(ans , curr - partial);
        }
        return ans;
    }
}