class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n = nums1.length , m = nums2.length;
        long l = -10000000000L;
        long r = 10000000000L;

        while(l < r){
            long mid = l + (r - l) / 2;
            if(helper(mid , nums1 , nums2) >= k ) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private long helper(long tar , int nums1[] , int nums2[]){
        long cnt = 0;
        for(int num : nums1){
            if(num == 0){
                if(tar >= 0) cnt += nums2.length;
                continue;
            }

            int l = 0 , r = nums2.length;
            while(l < r){
                int mid = l + (r - l) / 2;
                long pro = (long) num * nums2[mid];
                if(pro <= tar){
                    if(num < 0) r = mid;
                    else l = mid + 1;
                }else{
                    if(num > 0) r = mid;
                    else l = mid + 1;
                }
            }

            cnt += (num > 0) ? l :  nums2.length - l;
        }
        return cnt;
    }
}

/*class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n = nums1.length , m = nums2.length;
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> Long.compare(b,a));

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                long x = (long)nums1[i] * nums2[j];
                if(pq.size() >= k && pq.peek() > x) pq.poll();
                if(pq.size() < k ) pq.offer(x);
                System.out.println(pq.peek());
            }
        }
        return pq.peek();
    }
} */