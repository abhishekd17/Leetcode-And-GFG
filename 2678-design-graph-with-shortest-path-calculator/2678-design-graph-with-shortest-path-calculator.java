class Graph {
    List<List<int[]>> adjList;
    public Graph(int n, int[][] edges) {
        adjList = new ArrayList<>();
        for(int i = 0 ; i < n ;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        adjList.get(edge[0]).add(new int[]{edge[1] , edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        return dijkstra(node1 , node2);
    }

    private int dijkstra(int start , int end){
        int n = adjList.size();
        int dis[] = new int[n];
        Arrays.fill(dis , Integer.MAX_VALUE);
        dis[start] = 0 ;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a ,b) -> a[0] - b[0]);
        pq.offer(new int[]{0 , start});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int w = temp[0];
            int node = temp[1];
            if(w > dis[node]) continue;
            if(node == end) return w;
            for(int[] edge : adjList.get(node)){
                int v = edge[0];
                int ww = edge[1];
                if(dis[v] > ww + w){
                    dis[v] = ww + w;
                    pq.offer(new int[]{dis[v] , v});
                }
            }
        }
        return dis[end] == Integer.MAX_VALUE ? -1 : dis[end];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */