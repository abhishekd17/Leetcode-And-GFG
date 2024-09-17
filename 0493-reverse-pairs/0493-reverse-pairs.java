class Solution {
    private static void merge(int[] nums,int low , int mid , int high){
        ArrayList<Integer> temp=new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }

        while(left<=mid){
            temp.add(nums[left]);
            left++;
        }
        while(right<=high){
            temp.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=temp.get(i-low);
        }
    }

    public static int countPairs(int nums[] ,int low , int mid ,int high){
        int right=mid+1;
        int count=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)nums[i]>2* (long)nums[right]) right++;
            count+=(right-(mid+1));
        }
        return count;
    }

    public static int mergeSort(int nums[] ,int low ,int high){
        int count=0;
        if(low>=high) return count;
        int mid=(low+high)/2;
        count +=mergeSort(nums,low,mid);
        count +=mergeSort(nums,mid+1 ,high);
        count +=countPairs(nums, low, mid, high);
        merge(nums,low,mid,high);
        return count;
    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        return mergeSort(nums,0,n-1);
    }
}


//brute force approch
/*class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]>2*nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
}*/


