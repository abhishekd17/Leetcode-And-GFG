class Solution {
    public int numBusesToDestination(int[][] routes, int source, int end) {
        if(source == end) return 0;
        Map<Integer , List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < routes.length ; i++){
            for(int stop : routes[i]){
                map.putIfAbsent(stop , new ArrayList<>());
                map.get(stop).add(i);
            }
        }

        if (!map.containsKey(source) || !map.containsKey(end)) {
            return -1;  
        }

        boolean vis[] = new boolean[routes.length];
        Queue<Integer> q = new LinkedList<>();
        for(int s : map.get(source)){
            q.offer(s);
            vis[s] = true;
        }
        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int route = q.poll();
                for(int stop : routes[route]){
                    if(stop == end) return ans;

                    for(int next : map.get(stop)){
                        if(vis[next] == false){
                            vis[next] = true;
                            q.offer(next);
                        }
                    }
                }
            }
            ans++;
        }

        return -1;
    }
}