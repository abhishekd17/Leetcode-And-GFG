class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n -1 ; i >= 0 ; i--){
            while(!st.isEmpty() && st.peek() > prices[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? 0 : st.peek();
            st.push(prices[i]);
        }
        for(int i = 0 ; i < n ; i++){
            prices[i] = prices[i] - nse[i];
        }
        return prices;
    }
}

/*class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(prices[j] <= prices[i]){
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }
} */