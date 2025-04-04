class Solution {
    public int findCircleNum(int[][] nums) {
        int n = nums.length;
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0 ; i < n ;  i++) list.add(new ArrayList<>());

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(nums[i][j] == 1 && i != j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }

        boolean vis[] = new boolean[n];
        
        int ans =0;
       
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                ans++;
                dfs(list , i , vis);
            }
        }
        return ans;
    }

    private void dfs(List<List<Integer>> adj , int u , boolean vis[]){
        vis[u] = true;

        for(int x : adj.get(u)){
            if(!vis[x]) dfs(adj , x , vis);
        }
    }
}