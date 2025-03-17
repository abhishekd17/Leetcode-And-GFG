class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int a : nums){
            map.put(a , map.getOrDefault(a , 0) + 1);
        }

        for(Map.Entry<Integer , Integer > entry : map.entrySet()){
            int value = entry.getValue();
            if(value %2 != 0) return false;
        }        
        return true;
    }
}