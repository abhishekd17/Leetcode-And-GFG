class DisjointSet{
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
            rank[ulp_v]++;
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
    public int removeStones(int[][] stones) {
        int row = 0;
        int col = 0;
        for(int it[] : stones){
            row = Math.max(row ,it[0]);
            col = Math.max(col , it[1]);
        }

        DisjointSet ds = new DisjointSet(row + col + 2);
        HashSet<Integer> set = new HashSet<>();
        for(int it[] : stones){
            int rowNode = it[0];
            int colNode = row + it[1] + 1;
            ds.unionBySize(rowNode , colNode);
            set.add(rowNode);
            set.add(colNode);
        }
        int cnt = 0;
        for(int x : set){
            if(ds.findParent(x) == x) cnt++;
        }
        return stones.length - cnt;
    }
}