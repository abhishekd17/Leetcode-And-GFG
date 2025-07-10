class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0) continue;
            int slow = i , fast = i;
            boolean isForward = nums[i] > 0;

            while(true){
                slow = f(nums , slow , isForward);
                fast = f(nums , fast , isForward);
                if(fast != -1) fast = f(nums , fast , isForward);
                if(slow == -1 || fast == -1 || slow == fast) break;
            }

            if(slow != -1 && slow == fast) return true;

            int ind = i;
            while(f(nums , ind , isForward) != -1){
                int next = f(nums , ind , isForward);
                nums[ind] = 0;
                ind = next;
            }
        }

        return false;
    }

    private int f(int nums[] , int i , boolean isForward){
        boolean dir = nums[i] > 0;
        int n = nums.length;
        if(dir != isForward || nums[i] % n == 0) return -1;
        int next = ((i + nums[i]) % n + n) % n;
        if(next == i) return -1;
        return next; 
    }
}