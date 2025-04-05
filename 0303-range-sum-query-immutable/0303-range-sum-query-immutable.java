class NumArray {
    int st[];
    int nums[];
    public NumArray(int[] nums) {
        this.nums = nums;
        st = new int[4 * nums.length];
        buildTree(0 , 0 , nums.length - 1);
    }
    
    public int sumRange(int left, int right) {
        return query(0 , 0 , nums.length - 1 , left , right);
    }

    private int query(int node , int nodeL , int nodeR , int l , int r){
        if(nodeR < l || r < nodeL) return 0;
        if(nodeL >= l && nodeR <= r) return st[node];
        int mid = nodeL + (nodeR - nodeL) / 2;
        int leftSum = query(node * 2 + 1 , nodeL , mid , l , r);
        int rightSum = query(node * 2 + 2 , mid + 1 ,nodeR, l , r);
        return leftSum + rightSum;
    }

    private void buildTree(int node , int l , int r){
        if(l == r) {
            st[node] = nums[l];
            return;
        }
        int mid = l + (r - l ) / 2;
        buildTree(node * 2 + 1 , l , mid);
        buildTree(node * 2 + 2 , mid + 1 , r);
        st[node] = st[node * 2 + 1] + st[node * 2 + 2 ];
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */