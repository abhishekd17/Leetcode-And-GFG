class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int dp[] = new int[n];
        int prev[] = new int[n];

        Arrays.fill(dp , 1);
        Arrays.fill(prev , -1);
        
        int maxi = 1 , end = 0;
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if((nums[i] % nums[j]) == 0 && dp[i] < dp[j] + 1 ){
                    dp[i] = dp[j] + 1;
                    prev[i] =j;
                }
            }
            if(maxi < dp[i]){
                maxi = dp[i];
                end = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        
        for(int i = end ; i >= 0 ; i = prev[i]){
            list.add(nums[i]);
            if(prev[i] == -1) break;
        }

        Collections.reverse(list);
        return list;
    }
}


/*class Solution {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        helper(nums , 0 , new ArrayList<>() , -1);
        
        return res;
    }

    private void helper(int nums[] , int ind , List<Integer> temp , int prev){
        // base case
        if(ind >= nums.length){
            if(temp.size() > res.size()){
                res = new ArrayList<>(temp);
            }
            return;
        }
        // take
        if(prev == -1 || ( nums[ind] % prev )== 0){
            temp.add(nums[ind]);
            helper(nums , ind + 1 , temp , nums[ind]);
            temp.remove(temp.size() - 1);
        }

        // not take
        helper(nums , ind + 1 , temp , prev);
    }
}*/



/*class Solution {
    private List<Integer> maxSubSet = new ArrayList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums , 0 , new ArrayList<>());
        return maxSubSet;
    }

    private void backtrack(int nums[] , int start , List<Integer> curr ){
        if(curr.size() > maxSubSet.size()){
            maxSubSet = new ArrayList<>(curr);
        }

        for(int i = start ; i < nums.length ; i++){
            if(curr.isEmpty() || nums[i] % curr.get(curr.size() - 1) == 0){
                curr.add(nums[i]);
                backtrack(nums , i + 1 , curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}

*/
















/*class Solution {
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
} */