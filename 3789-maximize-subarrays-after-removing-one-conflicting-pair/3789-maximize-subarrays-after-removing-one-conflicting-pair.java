class Solution {
    public long maxSubarrays(int n, int[][] nums) {

        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int p[] : nums){
            int a = Math.min(p[0] , p[1]);
            int b = Math.max(p[0] , p[1]);
            if(!map.containsKey(b)){
                map.put(b , new ArrayList<>());
            }
            map.get(b).add(a);
        }

        int maxi1 = 0 , maxi2 = 0;
        long ans = 0;

        long extra[] = new long[n + 1];

        for(int i = 1 ; i <= n ; i++){
            for(int x : map.getOrDefault(i, new ArrayList<>())){
                if(x >= maxi1 ){
                    maxi2 = maxi1;
                    maxi1 = x;
                }else if(maxi2 < x){
                    maxi2 = x;
                }
            }

            ans += (i - maxi1);
            extra[maxi1] += (maxi1 - maxi2);
        }

        long max = 0;
        for(int i = 0 ; i <= n ; i++) max = Math.max(max , extra[i]);
        return ans + max;
    }
}