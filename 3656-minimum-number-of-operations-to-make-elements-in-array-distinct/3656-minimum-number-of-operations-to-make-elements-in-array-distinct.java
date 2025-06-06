class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = n - 1 ; i >= 0 ; i--){
            if(map.containsKey(nums[i])){
                return (int)Math.ceil((i + 1) / 3.0 );
            }
            map.put(nums[i] , map.getOrDefault(nums[i] , 0 ) + 1);
        }
        
        return 0;
    }
}

/*class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int ans = 0;
        int i = 0;
        
        while(i <= n - 3) {

            boolean allDistinct = true;
            for(int count : map.values()) {
                if(count > 1) {
                    allDistinct = false;
                    break;
                }
            }
            
            if(allDistinct) {
                return ans;
            }
            
            ans++;
            for(int j = 0; j < 3; j++) {
                int num = nums[i + j];
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0) {
                    map.remove(num);
                }
            }
            i += 3;
        }
        
        boolean allDistinct = true;
        for(int count : map.values()) {
            if(count > 1) {
                allDistinct = false;
                break;
            }
        }
        
        if(!allDistinct && map.size() > 0) {
            ans++;
        }
        
        return ans;
    }
} */