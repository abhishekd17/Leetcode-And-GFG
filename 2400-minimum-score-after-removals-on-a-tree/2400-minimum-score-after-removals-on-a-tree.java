class Solution {
    private void dfs(int node , int parent ,List<List<Integer>> list, int nums[], int inTime[] , int outTime[] , int timer[] , int subTreeXor[]){
        inTime[node] = timer[0]++ ;

        subTreeXor[node]  = nums[node];

        for(int nbr : list.get(node)){
            if(parent != nbr){
                dfs(nbr , node , list , nums , inTime , outTime , timer , subTreeXor);
                subTreeXor[node] ^= subTreeXor[nbr];
            }
        }

        outTime[node] = timer[0]++ ;
    }
    private boolean isAncestor(int u , int v , int inTime[] , int outTime[]){
        return inTime[u] < inTime[v] && outTime[v] < outTime[u];
    }
    private int helper(int a , int b , int c){
        int x = Math.max(a , Math.max(b , c));
        int y = Math.min(a , Math.min(b , c));
        return x - y;
    }
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        int m = edges.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) list.add(new ArrayList<>());
        for(int edge[] : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        int subTreeXor[] = new int[n];
        int inTime[] = new int[n];
        int outTime[] = new int[n];

        int timer[] = {0};
        dfs(0 , -1 , list , nums , inTime , outTime , timer , subTreeXor);
        int ans = Integer.MAX_VALUE;
        for(int u = 1 ; u < n ; u++){
            for(int v = u + 1 ; v < n ; v++){
                int xor1 , xor2 , xor3;
                if(isAncestor(u , v , inTime , outTime)){
                    xor1 = subTreeXor[v];
                    xor2 = subTreeXor[u] ^ subTreeXor[v];
                    xor3 = subTreeXor[0] ^ xor1 ^ xor2;
                }else if(isAncestor(v , u , inTime , outTime)){
                    xor1 = subTreeXor[u];
                    xor2 = subTreeXor[v] ^ subTreeXor[u];
                    xor3 = subTreeXor[0] ^ xor1 ^ xor2;
                }else{
                    xor1 = subTreeXor[u];
                    xor2 = subTreeXor[v];
                    xor3 = subTreeXor[0] ^ xor1 ^ xor2;
                }

                ans = Math.min(ans , helper(xor1 , xor2 , xor3));
            }
        }
        return ans;
    }
}