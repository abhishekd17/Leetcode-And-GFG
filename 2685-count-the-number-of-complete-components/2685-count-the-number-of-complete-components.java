class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        DSU dsu = new DSU(n);

        Map<Integer , Integer> map = new HashMap<>();

       for(int[] e : edges){
        dsu.unionBySize(e[0] , e[1]);
       }

       for(int[] e : edges){
        int x = dsu.findParent(e[0]);
        map.put(x , map.getOrDefault(x , 0) + 1);
       }
       int ans = 0;

        for(int i = 0 ; i < n ; i++){
            if(dsu.findParent(i) == i){
                int s = dsu.size[i];
                int e = s * (s - 1) / 2;
                int ee = map.getOrDefault(i, 0);
                if(e == ee) ans++;
            }
        }

        return ans;
    }
}


/*class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        int vis[] = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                List<Integer> components = new ArrayList<>();
                dfs(i, vis, components , list);

                if (isCompleteComponent(components, list)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(int node, int vis[], List<Integer> components, List<List<Integer>> adj) {
        vis[node] = 1;
        components.add(node);
        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                dfs(neighbor, vis, components, adj);
            }
        }
    }

    private boolean isCompleteComponent(List<Integer> components, List<List<Integer>> adj) {
        int k = components.size();
        if (k == 1)
            return true;
        int requiredEdges = k * (k - 1) / 2;
        int actualEdges = 0;
        for (int node : components) {
            actualEdges += adj.get(node).size();
        }
        actualEdges /= 2;
        return requiredEdges == actualEdges;
    }
}*/

class DSU {
    int parent[];
    int rank[];
    int size[];

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
    }

    public int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]);
    }

    public void unionByRank(int u, int v) {
        int pU = findParent(u);
        int pV = findParent(v);

        if (pU == pV)
            return;

        if (rank[pU] > rank[pV]) {
            parent[pV] = pU;
        } else if (rank[pU] < rank[pV]) {
            parent[pU] = pV;
        } else {
            parent[pU] = pV;
            rank[pV]++;
        }
    }

    public void unionBySize(int u, int v) {
        int pU = findParent(u);
        int pV = findParent(v);

        if (pU == pV)
            return;
        if (size[pU] > size[pV]) {
            parent[pV] = pU;
            size[pU] += size[pV];
        } else {
            parent[pU] = pV;
            size[pV] += size[pU];
        }
    }
}
