

class Solution {
    public int maxProfit(int p ,int[] prices) {
        int n = prices.length;
        int prev[][] = new int[2][p + 1];
        
        for(int i = n - 1 ; i >= 0 ; i--){
            int curr[][] = new int[2][p + 1];
            for(int j = 0 ; j <= 1 ; j++){
                for(int k = 1 ; k <= p ; k++){
                    if(j == 0 ){
                        curr[j][k] = Math.max(-prices[i] + prev[1][k] , prev[0][k]);
                    }else{
                        curr[j][k] = Math.max(prices[i] + prev[0][k-1] , prev[1][k]);
                    }
                }
            }
            prev = curr;
        }
        return prev[0][p];
    }
}