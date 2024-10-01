class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0] ; 
            int v = road[1];
            int t = road[2];
            list.get(u).add(new Pair(v , t));
            list.get(v).add(new Pair(u , t));
        }

        int ways[] = new int[n];
        long time[] = new long[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((x , y) -> Long.compare(x.t, y.t));

        pq.add(new Pair(0 , 0));
        Arrays.fill(time , Long.MAX_VALUE);
        time[0] = 0;
        ways[0] = 1;

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int uu = pair.u;
            long tt = pair.t;

            for(Pair  pp : list.get(uu)){
                int adjNode = pp.u;
                long adjTime = pp.t;

                if(tt + adjTime < time[adjNode]){
                    time[adjNode] = (tt + adjTime);
                    ways[adjNode] = ways[uu];
                    pq.add(new Pair(adjNode , time[adjNode]));
                }else if(tt + adjTime == time[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[uu]) % 1000000007;
                }
            }
        }
        return ways[n - 1] % 1000000007;
    }
}

class Pair{
    int u ; 
    long t;
    Pair(int u , long t){
        this.u = u ;
        this.t = t;
    }
}
