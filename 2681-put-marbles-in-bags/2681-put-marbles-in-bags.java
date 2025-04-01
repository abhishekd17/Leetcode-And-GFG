class Solution {
    public long putMarbles(int[] nums, int k) {
        int n = nums.length;
        
        int pairSum[] = new int[n - 1];
        for(int i = 0 ; i < n - 1 ; i++){
            pairSum[i] = nums[i] + nums[i + 1];
        }

        Arrays.sort(pairSum);
        long mini = 0;
        for(int i = 0 ; i < k - 1 ; i++){
            mini += pairSum[i];
        } 
        long maxi = 0;
        for(int i = n - 2 ; i >= n - k  ; i--){
            maxi += pairSum[i];
        }
        return maxi - mini;
    }
}

// memory Limit exceed 
/*class Solution {
    public long putMarbles(int[] nums, int k) {

        List<List<List<Integer>>> list = partition(nums, k);

        long minCost = Integer.MAX_VALUE;
        long maxCost = Integer.MIN_VALUE;

        for (List<List<Integer>> partition : list) {
            long totalCost = 0;
            for (List<Integer> sub : partition) {
                if (sub.isEmpty())
                    continue;
                long first = sub.get(0);
                long last = sub.get(sub.size() - 1);
                totalCost += first + last;
            }

            minCost = Math.min(minCost, totalCost);
            maxCost = Math.max(maxCost, totalCost);
        }
        return maxCost - minCost;
    }

    private List<List<List<Integer>>> partition(int nums[], int k) {
        List<List<List<Integer>>> result = new ArrayList<>();
        backtrack(nums, k, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int nums[], int k, int start, List<List<Integer>> current ,List<List<List<Integer>>> result) {
        if (k == 1) {
            List<Integer> lastPart = new ArrayList<>();
            for (int i = start; i < nums.length; i++) {
                lastPart.add(nums[i]);
            }
            current.add(lastPart);
            result.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
            return;
        }

        for (int i = start; i <= nums.length - k; i++) {
            List<Integer> part = new ArrayList<>();
            for (int j = start; j <= i; j++) {
                part.add(nums[j]);
            }
            current.add(part);
            backtrack(nums, k - 1, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
} */