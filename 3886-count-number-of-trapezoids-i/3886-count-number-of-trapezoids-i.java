class Solution {
    int mod = 1000000007;
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        Map<Integer , Long> map = new HashMap<>();
        for(int point[] : points){
            map.put(point[1] , map.getOrDefault(point[1] , 0L) + 1);
        }
        
        List<Long> values = new ArrayList<>(map.values());

        long totalHorizontalSegments = 0;
        for(long x : values){
            long pairs = (x * (x - 1) / 2);
            totalHorizontalSegments += pairs;
        }
        long ans = 0;
        for(long x : values){
            long pairs = (x * (x - 1) / 2);
            totalHorizontalSegments -= pairs;
            ans = (ans + (pairs * totalHorizontalSegments) % mod) % mod;
        }
        return (int) ans;
    }
}
