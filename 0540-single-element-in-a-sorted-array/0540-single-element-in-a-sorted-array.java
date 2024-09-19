class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans= 0 ;
        for(int i = 0 ; i < nums.length; i++){
            ans ^= nums[i];
        }
        return ans;
    }
}

/*class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        int low=1;
        int high=n-2;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1] ){
                return nums[mid];
            }
            //  left half
            if((mid%2==1 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid]==nums[mid+1] ) ){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}*/



/*class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == 0 || mid == n - 1 || (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])) {
                return nums[mid];
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    if((mid-low)%2==0){
                        high=mid-2;
                    }else{
                        low=mid+1;
                    }
                } else {
                    if((high-mid)%2==0){
                        low=mid+2;
                    }else{
                        high=mid-1;
                    }
                }
            }
        }
        return -1; // This should not be reachable
    }
}
*/

/*
 * class Solution {
 * public int singleNonDuplicate(int[] nums) {
 * int n=nums.length;
 * HashMap<Integer , Integer> mp=new HashMap<>();
 * for(int num : nums){
 * mp.put(num,mp.getOrDefault(num,0)+1);
 * }
 * 
 * for(int num:mp.keySet()){
 * if(mp.get(num)==1){
 * return num;
 * }
 * }
 * return -1;
 * }
 * }
 */