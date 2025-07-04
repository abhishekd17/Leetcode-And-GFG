class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        
        int total_sum = Arrays.stream(nums).sum();

        HashMap<Integer , List<Integer>> left = new HashMap();
        HashMap<Integer , List<Integer>> right = new HashMap();
        
        left.put(0 , Arrays.asList(0));
        right.put(0 , Arrays.asList(0));

        helper(left , nums , 0 , n);
        helper(right , nums , n , n);

        int mini = Integer.MAX_VALUE;

        for(int i = 0 ; i <= n ; i++){
            List<Integer> l = left.get(i);
            List<Integer> r = right.get(n - i);

            Collections.sort(l);
            Collections.sort(r);

            int p1 = 0 , p2 = r.size() - 1;
            while(p1 < l.size() && p2 >= 0){
                int sum = l.get(p1) + r.get(p2);
                int rem = total_sum - sum;
                mini = Math.min(mini , Math.abs(rem - sum));
                if(sum > total_sum / 2) p2--;
                else p1++;
            }
        }
        return mini;
    }

    private void helper(HashMap<Integer, List<Integer>> map, int[] nums, int offset, int n) {
    int size = 1 << n;  // 2^n subsets
    for (int mask = 1; mask < size; mask++) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                sum += nums[offset + i];  // correctly access elements from left or right half
                count++;
            }
        }
        map.computeIfAbsent(count, k -> new ArrayList<>()).add(sum);
    }
}

}








/*
class Solution {
    public int minimumDifference(int[] nums) {
        int n=nums.length / 2;
        int total =Arrays.stream(nums).sum();
        HashMap<Integer , List<Integer>> leftMap=new HashMap<>();
        HashMap<Integer , List<Integer>> rightMap=new HashMap<>();

        createMappings(0 , leftMap , nums , n);
        createMappings(n , rightMap ,  nums, n);
        leftMap.put( 0 , Arrays.asList(0));
        rightMap.put(0 , Arrays.asList(0));

        int min=Integer.MAX_VALUE;

        for(int i=0;i<=n;i++){
            List<Integer> left=leftMap.get(i);
            List<Integer> right=rightMap.get(n-i);
            Collections.sort(left);
            Collections.sort(right);

            int p1=0 ;
            int p2=right.size()-1;
            while(p1<left.size() && p2>=0){
                int sum=left.get(p1) + right.get(p2);
                int rem=total - sum;
                int diff = Math.abs(rem - sum);
                min=Math.min(min , diff);
                if(sum> total / 2) p2--;
                else p1++;
            }
        }
        return min;

    }

    public void createMappings(int offset ,HashMap<Integer , List<Integer>> map , int nums[] , int n ){
        for(int i=1;i<= Math.pow(2,n) - 1; i++){
            String binary = Integer.toBinaryString(i);
            int sum=0;
            int setbits = 0;
            for(int j = binary.length() - 1 , index = nums.length - 1 ; j>=0 ; j-- , index--){
                if(binary.charAt(j)=='1') {
                    setbits++;
                    sum+=nums[index - offset];
                }
            }
            if(!map.containsKey(setbits)) map.put(setbits , new ArrayList());
            map.get(setbits).add(sum);
        }
    }
}
*/




/*class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        
        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        int target = totalSum / 2;
        int minDifference = Integer.MAX_VALUE;

        // Generate all possible subsets of size n using bitmasking
        int totalSubsets = 1 << (2 * n);
        for (int mask = 0; mask < totalSubsets; mask++) {
            if (Integer.bitCount(mask) == n) { // Check if the subset has exactly n elements
                int subsetSum = 0;
                for (int i = 0; i < 2 * n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        subsetSum += nums[i];
                    }
                }
                int otherSubsetSum = totalSum - subsetSum;
                minDifference = Math.min(minDifference, Math.abs(subsetSum - otherSubsetSum));
            }
        }
        
        return minDifference;
    }
}
 */