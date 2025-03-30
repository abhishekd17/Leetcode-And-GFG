class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer , Integer> map1 = new HashMap<>();
        Map<Integer , Integer> map2 = new HashMap<>();

        for(int x : nums){
            map2.put(x , map2.getOrDefault(x , 0) + 1);
        }

        for(int i = 0 ; i < n ; i++){
            map1.put(nums.get(i) , map1.getOrDefault(nums.get(i) , 0) + 1);
            map2.put(nums.get(i) , map2.getOrDefault(nums.get(i) , 0) - 1);
            if(map1.get(nums.get(i)) > (i + 1) / 2 && map2.get(nums.get(i)) > (n - i -1) / 2) return i;
        }
        return -1;
    }
}