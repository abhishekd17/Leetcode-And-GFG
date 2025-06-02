class Solution {
    public int candy(int[] nums) {
        int n=nums.length;
        int i=1;
        int sum=1;
        while(i<n){
            if(nums[i]==nums[i-1]){
                sum+=1;
                i++;
            System.out.println(sum);

                continue;
            }
            int peak=1;
            while(i<n && nums[i]>nums[i-1]){
                peak+=1;
                sum+=peak;
                i++;
            System.out.println(sum);

            }
            int down =1;
            while(i<n && nums[i]<nums[i-1]){
                sum+=down;
                i++;
                down++;
            System.out.println(sum);

            }

            if(down>peak){
                sum+=(down-peak);
            }
            System.out.println(sum);
        }
        return sum;
    }
}

/*class Solution {
    public int candy(int[] nums) {
        int n=nums.length;
        int left[]=new int[n];
        left[0]=1 ;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                left[i]=left[i-1]+1;
            }else {
                left[i]=1;
            }
        }
        int curr=1;
        int right=1;
        int sum=Math.max(1,left[n-1]);
        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                curr=right+1;
            }else{
                curr=1;
            }
            right=curr;
            sum+=Math.max(left[i] , curr);
        }
        return sum;
    }
}*/

/*class Solution {
    public int candy(int[] nums) {
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=1 ;
        right[n-1]=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                left[i]=left[i-1]+1;
            }else {
                left[i]=1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                right[i]=right[i+1]+1;
            }else{
                right[i]=1;
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+Math.max(left[i] , right[i]);
        }
        return sum;
    }
}*/