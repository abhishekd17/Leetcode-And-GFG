class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i =  0 ; i < n ; i++) pq.offer(nums[i]);
        while(k > 1){
            k--;
            pq.poll();
        }
        return pq.peek();
    }
}


/*class Solution {
    private void helper(int nums[] , int i , int n){
        int l=2*i + 1;
        int r=2*i + 2;
        int largest=i;
        if(l<n && nums[l]>nums[largest]) largest=l;
        if(r<n && nums[r]>nums[largest]) largest=r;
        if(largest!=i){
            nums[i]=nums[i]^nums[largest];
            nums[largest]=nums[i]^nums[largest];
            nums[i]=nums[i]^nums[largest];
            helper(nums , largest , n );
        }
    }
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        if(k>n) return -1;
        for(int i=n/2 - 1 ;i>=0 ;i--){
            helper(nums , i, n);
        }

        // extract kth element 
        for(int i=0;i<k-1;i++){
            int  temp=nums[0];
            nums[0]=nums[n-i-1];
            nums[n-i-1]=temp;
            helper(nums,0,n-i-1);
        }
        return nums[0];

    }
}*/


// brute force
/*class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
} */