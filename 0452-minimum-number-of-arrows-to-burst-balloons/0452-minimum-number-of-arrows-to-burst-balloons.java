class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int cnt = 1;
        int last = points[0][1];
        for(int i = 1 ; i < n ; i++){
            if(points[i][0] > last){
                cnt++;
                last = points[i][1];
            }
        }
        return cnt;
    }
}