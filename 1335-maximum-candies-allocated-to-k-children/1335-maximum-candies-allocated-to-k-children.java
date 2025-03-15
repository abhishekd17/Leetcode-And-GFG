class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int maxi = 0;

        for(int i = 0 ; i < n ; i++) maxi = Math.max(maxi , candies[i]);

        int l = 1 , r = maxi;
        int ans = 0;
        while(l <= r){

            int mid = (l + r) / 2;
            long cnt = 0;

            for(int i = 0 ; i < n ; i++){
                cnt += (candies[i] / mid);
            }
            
            if(cnt >= k){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }
}