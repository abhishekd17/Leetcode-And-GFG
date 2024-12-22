class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if( m < n - 1) return -1;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int[] c : connections){
            list.get(c[0]).add(c[1]);
            list.get(c[1]).add(c[0]);

        }
        int components = 0;
        boolean[] vis =new boolean[n];
        for(int i = 0 ; i  < n ; i++){
            components += dfs(i , list , vis);
        } 
        return components - 1;
    }

    private int dfs(int node , List<List<Integer>> list , boolean vis[]){
        if(vis[node]) return 0;
        vis[node] = true;
        for(int v : list.get(node)){
            dfs(v , list , vis);
        }
        return 1;
    }
}

/*class DisjointSet{
    int parent[];
    int rank[];
    int size[];
    public DisjointSet(int n ){
        this.parent = new int[n];
        this.rank = new int[n];
        this.size =new int[n];
        
        for(int i = 0 ; i < n ; i++){
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }
    }
    int findParent(int node){
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }
    
    void unionByRank(int u , int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v) return;
        if(rank[ulp_u] > rank[ulp_v]){
            parent[ulp_v] = ulp_u;
        }else if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }else{
            parent[ulp_u] = ulp_v;
            rank[ulp_u]++;
        }
    }
    
    void unionBySize(int u , int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v) return ;
        
        if(size[ulp_u] > size[ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
    }
    
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if(m < n -1 ) return -1;
        DisjointSet ds = new DisjointSet(n);
        for(int[] c : connections){
            int u = c[0];
            int v = c[1];

            if(ds.findParent(u) != ds.findParent(v)){
                ds.unionBySize(u , v);
            }
        }
        int cnt = 0;
        for(int i = 0 ;i < n ; i++){
            if(ds.findParent(i) == i) cnt++;
        }
        return cnt - 1;
    }
} */