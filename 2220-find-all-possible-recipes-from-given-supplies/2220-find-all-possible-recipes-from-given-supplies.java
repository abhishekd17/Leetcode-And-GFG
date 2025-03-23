class Solution {
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
}