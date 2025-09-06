class Solution {
    public int[] minDifference(int n, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(n , k , 1 , new ArrayList<>() , list);
        int ans[] = new int[k];
        for(int i = 0 ; i < k ; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void dfs(int n , int k , int start , List<Integer> path , List<Integer> list){
        // base case
        if(k == 0){
            if(n == 1){
                int maxi = Collections.max(path);
                int mini = Collections.min(path);
                if(list.isEmpty() || (maxi - mini) < (Collections.max(list) - Collections.min(list))){
                    list.clear();
                    list.addAll(new ArrayList<>(path));
                }
            }
            return ;
        }

        for(int i = start ; i <= n ; i++){
            path.add(i);
            if(n % i == 0){
                dfs(n / i , k - 1 , i , path , list);
            }
            path.remove(path.size() - 1);
        }
    }
}