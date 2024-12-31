class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[] = new int[n + 1];

        for(int ind = n - 1; ind >= 0 ; ind--){
            int one1 = dp[ind + 1] + costs[0];

            int next7 = ind;
            while(next7 < days.length && days[next7] <= days[ind] + 6){
                next7++;
            }
            int seven7 = dp[next7] + costs[1];

            int next30 = ind;
            while(next30 < days.length && days[next30] <= days[ind] + 29){
                next30++;
            }
            int thirty30 = dp[next30] + costs[2];

            dp[ind] = Math.min(one1 , Math.min(seven7 , thirty30));
        }
        return dp[0];
    }
}

/*class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days.length];
        Arrays.fill(dp , -1);
        return helper(days , costs , 0 , dp);
    }

    private int helper(int[] days , int[] costs , int ind , int dp[]) {
        int n = days.length;
        if(ind >= days.length) return 0;
        if(dp[ind] != -1) return dp[ind];
        // if we are choosing everyday as a onr day pass
        int one1 = helper(days , costs , ind + 1 , dp) + costs[0];

        int next7 = ind;
        while(next7 < days.length && days[next7] <= days[ind] + 6){
            next7++;
        }
        int seven7 = helper(days , costs , next7, dp ) + costs[1];

        int next30 = ind;
        while(next30 < days.length && days[next30] <= days[ind] + 29){
            next30++;
        }
        int thirty30 = helper(days , costs , next30 ,dp) + costs[2];

        return dp[ind] = Math.min(one1 , Math.min(seven7 , thirty30));
    }
}*/

/*class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return helper(days , costs , 0);
    }

    private int helper(int[] days , int[] costs , int ind) {
        int n = days.length;
        if(ind >= days.length) return 0;

        // if we are choosing everyday as a onr day pass
        int one1 = helper(days , costs , ind + 1) + costs[0];

        int next7 = ind;
        while(next7 < days.length && days[next7] <= days[ind] + 6){
            next7++;
        }
        int seven7 = helper(days , costs , next7 ) + costs[1];

        int next30 = ind;
        while(next30 < days.length && days[next30] <= days[ind] + 29){
            next30++;
        }
        int thirty30 = helper(days , costs , next30 ) + costs[2];

        return Math.min(one1 , Math.min(seven7 , thirty30));
    }
} */