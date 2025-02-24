class Solution {

    int maxIncome;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;

        maxIncome = Integer.MIN_VALUE;
        
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < edges.length ; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        Map<Integer , Integer> map = new HashMap<>();

        int t = 0;

        int vis[] = new int[n];

        dfs(list , bob, vis , map , t);

        int income = 0;

        Arrays.fill(vis , 0);
        dfs1(list , 0 , vis , map , 0 , income , amount);

        return maxIncome;
    }

    private boolean dfs(List<List<Integer>> list , int curr , int vis[] , Map<Integer , Integer> map, int t){
        vis[curr] = 1;

        map.put(curr , t);

        if(curr == 0){
            return true;
        }

        for(int it : list.get(curr)){
            if(vis[it] == 0){
                if(dfs(list , it , vis , map , t + 1)){
                    return true;
                }
            }
        }

        map.remove(curr);
        return false;
    }

    private void dfs1(List<List<Integer>> list, int curr , int vis[] , Map<Integer, Integer> map , int t , int income , int amount[]){
        vis[curr] = 1;
        
        if(!map.containsKey(curr) || t < map.get(curr)){
            income += amount[curr];
        }else if(t == map.get(curr)){
            income += (amount[curr] / 2);
        }

        if(list.get(curr).size() == 1 && curr != 0){
            maxIncome = Math.max(income , maxIncome);
        }

        for(int it : list.get(curr)){
            if(vis[it] == 0){
                dfs1(list , it , vis , map , t + 1 , income , amount);
            }
        }
    }
}