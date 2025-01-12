class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
  
        Arrays.sort(edges , Comparator.comparingInt(a -> a[2]));
        
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            list.get(e[0]).add(e);
        }
        
        // for(int i = 0 ; i < n ; i++){
        //     list.get(i).sort(Comparator.comparingInt(a -> a[2]));
        // }
        
        int l = 1 ;
        int r = 1000000;
        int ans = -1;
        
        while(l <= r){
            int mid = l + (r - l) / 2;
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            for(int i = 0 ; i < n ; i++) temp.add(new ArrayList<>());
            
            for(int i = 0 ; i < n ; i++){
                // int cnt = threshold;
                for(int[] e : list.get(i)){
                    if(e[2] > mid) break; // if weight > curr
                    temp.get(e[1]).add(e[0]);
                    // cnt--;
                    // if(cnt == 0) break;
                }
            }
            
            int vis[] = new int[n];
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            vis[0] = 1;
            while(!q.isEmpty()){
                int x = q.poll();
                for(int it : temp.get(x)){
                    if(vis[it] == 0){
                        vis[it] = 1;
                        q.offer(it);
                    }
                }
            }
            
            boolean isAll = true;
            for(int i = 0 ; i < n ; i++){
                if(vis[i] == 0){
                    isAll = false;
                    break;
                }
            }
            
            if(isAll == true){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

}


/*
5
[[1,0,1],[2,0,2],[3,0,1],[4,3,1],[2,1,1]]
2
5
[[0,1,1],[0,2,2],[0,3,1],[0,4,1],[1,2,1],[1,4,1]]
1
5
[[1,2,1],[1,3,3],[1,4,5],[2,3,2],[3,4,2],[4,0,1]]
1
5
[[1,2,1],[1,3,3],[1,4,5],[2,3,2],[4,0,1]]
1
6
[[0,4,26],[4,3,68],[1,0,84],[0,1,22],[1,2,82],[0,3,78],[5,0,86],[1,3,70],[3,1,43],[4,2,61],[2,4,13],[5,4,38]]
1
*/