class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        List<Integer> prev = new ArrayList<>();
        for(int num : nums) prev.add(num);

        for(int i = 0 ; i < n ; i++){
            List<Integer> curr = new ArrayList<>();
            if(prev.size() == 1) return prev.get(0) % 10;
            for(int j = 0 ; j < prev.size() - 1 ; j++){
                curr.add(prev.get(j) + prev.get(j + 1) % 10);
            }
            prev = curr;
        }
        return 0;
    }
}

// prev
// [1,2,3,4,5]
// 3 , 5 , 