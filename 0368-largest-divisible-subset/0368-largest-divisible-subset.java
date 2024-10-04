class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int maxLen = 1;
        int endIndex = 0;

        int dp[] = new int[n];
        int parent[] = new int[n];

        for(int i = 0 ;i < n ; i++){
            dp[i] = 1;
            parent[i] = -1;
        }
        Arrays.sort(nums);
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ;j++){
                if((nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) && dp[i] < dp[j] + 1 ){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if(maxLen < dp[i]){
                maxLen = dp[i];
                endIndex = i;
            }
        }

        for(int i = endIndex ; i >= 0 ; i = parent[i] ){
            list.add(nums[i]);
            if(parent[i] == -1) break;
        }
        Collections.reverse(list);

        return list;
    }
}