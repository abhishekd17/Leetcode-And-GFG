class Solution {
    private int timer  = 1;
    private void dfs(int node,  int parent , int InsertionTime[] , int LowestTime[] , int vis[] ,List<List<Integer>> bridges , List<List<Integer>> adj){
        vis[node] = 1;
        InsertionTime[node] = LowestTime[node] = timer;
        timer++;

        for(int adjNode : adj.get(node)){
            if(adjNode == parent) continue;
            if(vis[adjNode] == 0){
                dfs(adjNode , node , InsertionTime , LowestTime , vis , bridges , adj);
                LowestTime[node] = Math.min(LowestTime[adjNode] , LowestTime[node]);
                if(LowestTime[adjNode] > InsertionTime[node]){
                    bridges.add(Arrays.asList(adjNode , node));
                }
            }
            else{
                LowestTime[node] = Math.min(LowestTime[adjNode] , LowestTime[node]); 
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> bridges = new ArrayList<>();
        for(int i = 0 ; i  < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> it : connections){
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int InsertionTime[] = new int[n];
        int LowestTime[] = new int[n];
        int vis[] = new int[n];
        dfs(0 , -1 , InsertionTime , LowestTime , vis , bridges , adj);
        return bridges;
    }
}