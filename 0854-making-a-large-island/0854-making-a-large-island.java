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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        
        boolean allOne = true;
        for(int[] row : grid){
            for(int cell : row){
                if(cell == 0){
                    allOne = false;
                    break;
                }
            }
            if(allOne == false) break;
        }
        int drow[] = {-1 , 0 , 1 , 0};
        int dcol[] = {0 , 1 , 0 , -1};
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int node = i * n + j;
                if(grid[i][j] == 1){
                    for(int k = 0 ; k < 4 ; k++){
                        int nrow = i + drow[k];
                        int ncol = j + dcol[k];
                        int nNode = (nrow * n) + ncol;
                        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n  && grid[nrow][ncol] == 1){
                            if(ds.findParent(node) != ds.findParent(nNode)){
                                ds.unionBySize(node , nNode);
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i < n ;  i++){
            for(int j = 0 ; j < n ; j++){
                int cnt = 0;
                Set<Integer> set = new HashSet<>();
                if(grid[i][j] == 0){
                    for(int k = 0 ; k < 4 ; k++){
                        int nrow = i + drow[k];
                        int ncol = j + dcol[k];
                        int nNode = nrow * n + ncol;
                        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1){
                            int ul_p = ds.findParent(nNode);
                            if(!set.contains(ul_p)){
                                cnt += ds.size[ul_p];
                                set.add(ul_p);
                            }
                        }
                    }
                    ans = Math.max(ans , cnt + 1);
                }
            }
        }

        return allOne == true ? n * n : ans;
    }
}