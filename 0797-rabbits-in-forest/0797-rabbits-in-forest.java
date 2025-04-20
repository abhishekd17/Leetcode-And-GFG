class Solution {
    public int numRabbits(int[] nums) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x , map.getOrDefault(x , 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            int x = (value + key) / (key + 1);
            ans = ans + (x * (key + 1));
            // System.out.println(key + " " + value + " " + x + " " + ans);
        }
        return ans;
    }
}