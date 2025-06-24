class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int r = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == key){
                int l = Math.max(i - k , r);
                r = Math.min(i + k , n - 1) + 1;
                for(int j = l ; j < r ; j++){
                    list.add(j);
                }
            }
        }
        return list;
    }
}