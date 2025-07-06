class FindSumPairs {
    int nums1[];
    int nums2[];
    int n , m;
    HashMap<Integer , Integer> map1 ;
    HashMap<Integer , Integer> map2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.n = nums1.length;
        this.m = nums2.length;

        map1 = new HashMap<>();
        map2 = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++) map1.put(nums1[i] , map1.getOrDefault(nums1[i] , 0) + 1);
        for(int i = 0 ; i < m ; i++) map2.put(nums2[i] , map2.getOrDefault(nums2[i] , 0) + 1);
    }
    
    public void add(int index, int val) {
        int old = nums2[index];
        nums2[index] += val;
        int newVal = nums2[index];
        map2.put(old , map2.get(old) - 1);
        if(map2.get(old) == 0) map2.remove(old);
        map2.put(newVal , map2.getOrDefault(newVal , 0) + 1);
    }
    
    public int count(int tot) {
        int cnt = 0;
        for(int a : map1.keySet()){
            int b = tot - a;
            if(map2.containsKey(b)){
                cnt += (map1.get(a) * map2.get(b));
            }
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */