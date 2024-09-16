import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 }; // No solution found
    }
}


/*class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        ans[0]=ans[1]=-1;
        int n=nums.length;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=nums[i];
            int more=target-num;
            if(mpp.containsKey(more)){
                ans[0]=mpp.get(more);
                ans[1]=i;
            }
            mpp.put(nums[i],i);
        }
        return ans;
    }
}*/
/*class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] ans = new int[2];
        int n=arr.length;
        ans[0] = ans[1] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
} */