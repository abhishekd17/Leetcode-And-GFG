class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0 ;

        for(int i = 0 ; i < n ; i++) sum += nums[i];
        if(sum % p == 0) return 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , -1);
        int mini = n;
        int target =(int) (sum % p) ;
        long prefix = 0;
        for(int i = 0 ; i < n ;i++){
            prefix += nums[i];
            int rem  = (int)(prefix % p);
            int need = (rem - target + p) % p;
            if(map.containsKey(need)){
                mini = Math.min(mini , i - map.get(need));
            }
            map.put(rem , i);
        }
        return mini == n ? -1 : mini;
    }
}

/*class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int mini = n;
        long sum = 0;
        for(int i = 0 ; i < n ;i++) sum+= nums[i];
        if(sum % p == 0) return 0;

        for(int i = 0 ; i < n ; i++){
            long x = 0;
            for(int j = i ; j < n ; j++){
                x += nums[j];

                if((sum - x ) % p == 0 ){
                    mini = Math.min(mini , j - i + 1);
                }
            }
        }
        return mini == n ? -1 : mini ;
    }
} */