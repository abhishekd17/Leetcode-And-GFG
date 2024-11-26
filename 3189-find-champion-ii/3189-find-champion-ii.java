class Solution {
    public int findChampion(int n, int[][] edges) {
        int indegree[] = new int[n];
        for(int i = 0 ;i < edges.length ; i++){
            indegree[edges[i][1]]++;
        }
        int cnt = 0;
        int ans = -1;
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                cnt++;
                ans = i;
            }
            if(cnt > 1){
                return -1;
            }
        }
        return ans;
    }
}