class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int q = queries.length;
        int ans[] = new int[q];
        Arrays.sort(items , (a , b) -> Integer.compare(a[0] , b[0]));

        for(int i = 1 ; i < n ; i++){
            items[i][1] = Math.max(items[i][1] , items[i -1][1]);
        }
        for(int i = 0 ; i < q ; i++){
            int l = 0 ;
            int r = n - 1;
            int maxi = 0;
            while(l <= r){
                int mid = (l + r) / 2;
                if(items[mid][0] <= queries[i]){
                    maxi = items[mid][1];
                    l = mid + 1;
                }else{
                    r = mid -1;
                }
            }
            ans[i] = maxi;
        }
        return ans;
    }
}

/*class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int q = queries.length;
        int ans[] = new int[q];
        for(int i = 0 ; i < q ; i++){
            int maxi = 0;
            for(int j = 0 ; j < n ; j++){
                if(items[j][0] <= queries[i]){
                    maxi = Math.max(maxi , items[j][1]);
                }
            }
            ans[i] = maxi;
        }
        return ans;
    }
} */