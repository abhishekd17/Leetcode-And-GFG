class Solution {
    public int countHighestScoreNodes(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int i = 1; i < n; i++)
            list.get(nums[i]).add(i);

        int size[] = new int[n];
        boolean vis[] = new boolean[n];
        helper(0, vis, size, list);

        // for(int i = 0 ; i < n ; i++) System.out.print(size[i] + " ");System.out.println();
        List<Long> scores = new ArrayList<>();
        long maxi = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long score;
            if (i == 0) {
                score = 1;
            } else {
                score = size[0] - size[i];
            }
            for (int x : list.get(i)) {
                score *= size[x];
            }
            maxi = (long)Math.max(maxi, score);
            scores.add(score);
        }
        int cnt = 0;
        for(int i = 0 ; i < scores.size() ; i++){
            // System.out.print(scores.get(i) + " ");
            if(maxi == scores.get(i)){
                cnt++;
            } 
        }
        return cnt;
    }

    private int helper(int node, boolean vis[], int size[], List<List<Integer>> list) {
        vis[node] = true;
        size[node] = 1;

        for (int nbr : list.get(node)) {
            if (!vis[nbr]) {
                size[node] += helper(nbr, vis, size, list);
            }
        }
        return size[node];
    }

}