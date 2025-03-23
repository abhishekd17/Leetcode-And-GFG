class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        // add ing. in set
        Set<String> set = new HashSet<>(Arrays.asList(supplies));

        Map<String , List<Integer>> adj = new HashMap<>();
        int indegree[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            for(String ing : ingredients.get(i)){
                if(!set.contains(ing)){
                    adj.putIfAbsent(ing , new ArrayList<>());
                    adj.get(ing).add(i);
                    indegree[i]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        List<String> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int i = q.poll();
            String recipe = recipes[i];
            ans.add(recipe);

            if(adj.containsKey(recipe)){
                for(int idx : adj.get(recipe)){
                    indegree[idx]--;
                    if(indegree[idx] == 0){
                        q.add(idx);
                    }
                }
            }
        }
        return ans;        
    }
}


// brute force
/*class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> list, String[] supplies) {
        int n = recipes.length;

        Set<String> set = new HashSet();

        List<String> ans = new ArrayList<>();
        for(String s : supplies){
            set.add(s);
        }
        int cnt = n;
        int cooked[] = new int[n];
        while(cnt-- > 0){
            for(int i = 0 ; i < n ; i++){
                if(cooked[i] == 1) continue;
                boolean isPossible = true;
                for(int j = 0 ; j < list.get(i).size() ; j++){
                    if(!set.contains(list.get(i).get(j))){
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible){
                    cooked[i] = 1;
                    ans.add(recipes[i]);
                    set.add(recipes[i]);
                }
            }
        }
        return ans;
    }
} */