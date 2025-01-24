class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        int indegree[]=new int[n];

        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                list.get(v).add(u);  
                indegree[u]++;       
            }
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> listt=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            listt.add(node);
            for(int it:list.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(listt);
        return listt;

        
    }
}