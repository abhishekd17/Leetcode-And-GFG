class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int n = connections.length, q = queries.length;
        List<Integer> list = new ArrayList<>();
        DSU dsu = new DSU(c);
        for (int connection[] : connections) {
            int u = connection[0] - 1;
            int v = connection[1] - 1;
            int pu = dsu.find(u);
            int pv = dsu.find(v);
            if (pu == pv)
                continue;
            dsu.union(u, v);
        }
        int online[] = new int[c];
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < c; i++) {
            int root = dsu.find(i);
            map.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }
        for (int query[] : queries) {
            int mode = query[0];
            int node = query[1] - 1;
            int root = dsu.find(node);
            if (mode == 2) {
                online[node] = 1;
                map.get(root).remove(node);
            } else {
                if (online[node] == 0) {
                    list.add(node + 1);
                } else {
                    TreeSet<Integer> set = map.get(root);
                    if (set == null || set.isEmpty() || (set.size() == 1 && set.contains(node))) {
                        list.add(-1);
                    } else {
                        for (int val : set) {
                            if (val != node) {
                                list.add(val + 1);
                                break;
                            }
                        }
                    }
                }
            }
        }
        int ans[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }
}

class DSU {
    int parent[];
    int size[];

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (parent[node] == node)
            return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv)
            return;

        if (size[pu] > size[pv]) {
            parent[pv] = parent[pu];
            size[pu] += size[pv];
        } else {
            parent[pu] = parent[pv];
            size[pv] += size[pu];
        }
    }
}