class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int minOpe = 0;
        int sum = 0 , target = n;
        for(int a : nums){
            sum += a;
        }

        for(int i = 0 ; i < n - 2 ; i++){
            if(nums[i] == 0){
                sum++;
                minOpe++;
                if(nums[i + 1] == 0){
                    sum++;
                    nums[i + 1] = 1;
                }else{
                    sum--;
                    nums[i + 1] = 0;
                }
                if(nums[i + 2] == 0){
                    sum++;
                    nums[i + 2] = 1;
                }else{
                    sum--;
                    nums[i + 2] = 0;
                }
            }
            if(sum == target) return minOpe;
        }
        return -1;
    }
}

// brute force approch
/*class Solution {
    public int minOperations(int[] arr) {
        int n = arr.length;
        int min = 0;
        for(int i = 0 ; i < n - 2 ;i++){
            if(arr[i] == 0){
                min++;
                arr[i] = 1;
                arr[i + 1] = (arr[i + 1] == 0 ? 1 : 0);
                arr[i + 2] = (arr[i + 2] == 0 ? 1 : 0);
            }
            boolean flag = true;
            for(int j = 0 ; j < n ; j++){
                if(arr[j] == 0 ){
                    flag = false;
                    break;
                }
            }
            if(flag) return min;
        }
        return -1;
    }
} */