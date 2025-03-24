class Solution {
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
}

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

    private void unionBySize(int u, int v) {
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
