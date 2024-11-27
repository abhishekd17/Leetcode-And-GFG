class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int q = queries.length;
        int ans[] = new int[q];
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
            list.get(i).add(i + 1);
        }

        for(int i = 0; i < q ; i++){
            list.get(queries[i][0]).add(queries[i][1]);
            Queue<Pair> qu = new LinkedList<>();
            qu.offer(new Pair(0 , 0));
            Set<Integer> vis = new HashSet<>();
            vis.add(0);

            while(!qu.isEmpty()){
                Pair pair = qu.poll();
                int node = pair.node;
                int d = pair.distance;

                if(node == n - 1){
                    ans[i] = d;
                    break;   
                } 

                for(int adjNode : list.get(node)){
                    if(!vis.contains(adjNode)){
                        qu.offer(new Pair(adjNode, d + 1));
                        vis.add(adjNode);
                    }
                }
            }
        }
        return ans;
    }
}

class Pair{
    int node;
    int distance;
    Pair(int node , int distance){
        this.node = node;
        this.distance = distance;
    }
}