class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i =  0;  i < n ; i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        boolean vis[] = new boolean[n];

        
        return dfs(source , vis , list ,destination);
    }
    private boolean dfs(int node , boolean vis[] , List<List<Integer>> list, int destination){
        if(node == destination) return true;
        vis[node] = true;
        for(int x : list.get(node)){
            if(!vis[x]){
                if(dfs(x , vis , list ,destination)){
                    return true;
                }
            }
        } 
        // System.out.println(vis[source] + " " + vis[destination]);
        return false;
    }
}