class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return List.of(0);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) list.add(new ArrayList<>());
        int degree[] = new int[n];

        for(int edge[] : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        // now i have to trim all the leaf node , if there is a single edge from a particular node, u -- v then v is a leaf node

        // 0 --> 3
        // 1 --> 3
        // 2 --> 3 
        // 3 --> 0 , 1 , 2 , 4
        // 4 --> 3 , 5
        // 5 --> 4

        // create a list to store the leaves 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(degree[i] == 1) q.offer(i);
        }

        int rem = n;

        while(rem > 2){
            int size = q.size();
            rem -= size;

            for(int i = 0 ; i < size ; i++){
                int x = q.poll();
                for(int nbr : list.get(x)){
                    degree[nbr]--;
                    if(degree[nbr] == 1){
                        q.offer(nbr);
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
    }
}


/*class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        List<Integer> ans = new ArrayList<>();
        List<Integer> heights = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;
        
        // now calculate height for each node
        for(int i = 0 ; i < n ; i++){
            Set<Integer> vis = new HashSet<>();
            int x = helper(list , i, vis);
            minHeight = Math.min(minHeight , x);
            heights.add(x);
        }
        for(int i = 0 ; i < n ; i++) System.out.print(heights.get(i) + " ");
        
        for(int i = 0 ; i < n ; i++){
            if(minHeight == heights.get(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    private int helper(List<List<Integer>> list , int node , Set<Integer> vis){
        vis.add(node);
        int depth = 0;
        for(int x : list.get(node)){
            if(!vis.contains(x)){
                depth =  Math.max(depth  , helper(list , x , vis));
            }
        }
        return depth + 1;
    }
} */