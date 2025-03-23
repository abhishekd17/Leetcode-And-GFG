class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {

        DSU dsu = new DSU(n);
        int nn = query.length;

        int cost[] = new int[n];
        int ans[] = new int[nn];

        Arrays.fill(cost , -1);

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
    
            if(dsu.findParent(u) != dsu.findParent(v)){
                int pU = dsu.findParent(u);
                int pV = dsu.findParent(v);
                dsu.unionBySize(u , v);
                int newParent = dsu.findParent(u);
                cost[newParent] = cost[pU] & cost[pV] & w;
            }else{
                cost[dsu.findParent(u)] &= w;
            }
            cost[dsu.findParent(u)] &= cost[v] & w; 
        }
        int i = 0;
        for(int[] q : query){
            int u = q[0];
            int v = q[1];
            if(u == v) ans[i++] = 0;
            else if(dsu.findParent(u) != dsu.findParent(v)) ans[i++] = -1;
            else{
                ans[i++] = cost[dsu.findParent(u)];
            }
        }
        return ans;
    }
}



class DSU{
    int parent[] ;
    int rank[];
    int size[];

    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i ;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    int findParent(int node){
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }

    void unionByRank(int u , int v){
        int pU = findParent(u);
        int pV = findParent(v);

        if(pU == pV) return;

        if(rank[pU] > rank[pV]){
            parent[pV] = pU;
        }else if(rank[pU] < rank[pV]){
            parent[pU] = pV;
        }else{
            parent[pU] = pV;
            rank[pV]++;
        }
    }

    void unionBySize(int u , int v){
        int pU = findParent(u);
        int pV = findParent(v);

        if(pU == pV) return;
        if(size[pU] > size[pV]){
            parent[pV] = pU;
            size[pU] += size[pV];
        }else{
            parent[pU] = pV;
            size[pV] += size[pU];
        }
    }
}