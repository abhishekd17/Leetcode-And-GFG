class Solution {
    private int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> list) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        
        for(List<Integer> l : list){
            adj.get(l.get(0)).add(l.get(1));
            adj.get(l.get(1)).add(l.get(0));
        }

        int disc[] = new int[n];
        int low[] = new int[n];
        int parent[] = new int[n];
        
        Arrays.fill(disc , -1);
        Arrays.fill(low , -1);
        Arrays.fill(parent , -1);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(disc[i] == -1){
                dfs(i , adj , disc , low , parent , ans);
            }
        }
        return ans;
    }

    private void dfs(int u , List<List<Integer>> adj , int disc[] , int low[] , int parent[] ,List<List<Integer>> ans){
        disc[u] = low[u] = ++time;

        for(int v : adj.get(u)){
            if(disc[v] == -1){
                parent[v] = u;
                dfs(v, adj, disc, low, parent, ans);
                low[u] = Math.min(low[u] , low[v]);

                if(low[v] > disc[u]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(u);
                    temp.add(v);
                    ans.add(temp);
                }
            }
            else if(v != parent[u]){
                low[u] = Math.min(low[u] , disc[v]);
            }
        }
    }
}