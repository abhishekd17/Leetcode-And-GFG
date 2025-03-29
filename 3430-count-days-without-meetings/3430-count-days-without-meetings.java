class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings , (a,b) -> Integer.compare(a[0] , b[0]));

        int ans = meetings[0][0] - 1;
        int end = meetings[0][1];

        for(int i = 1 ; i < n ; i++){
            if(meetings[i][0] > end){
                ans += (meetings[i][0] - end - 1);
            }
            end = Math.max(end , meetings[i][1]);
        }

        ans += (days - end);
        return ans;
    }
}


/*class Solution {
    public int countDays(int days, int[][] meetings) {
        int vis[] = new int[days + 1];
        vis[0] = 1;

        for(int[] meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];
            for(int i = start ; i <= end ; i++){
                vis[i] = 1;
            } 
        }

        int ans = 0;
        for(int i = 0 ; i <= days ; i++){
            if(vis[i] == 0) ans++;
        }

        return ans;
    }
} */