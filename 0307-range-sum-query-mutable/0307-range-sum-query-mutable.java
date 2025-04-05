class NumArray {
    int nums[];
    int st[];
    int n ;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        st = new int[4 * n];
        buildTree(0 , 0, n - 1);    
    }
    
    public void update(int index, int val) {
        updateQuery(0 , 0 , n - 1 , index , val);
    }

    private void updateQuery(int node , int l , int r , int pos , int val){
        if(l == r) {
            nums[l] = val;
            st[node] = val;
            return;
        }

        int mid = l + (r - l ) / 2;
        if(pos <= mid){
            updateQuery(node * 2 + 1 , l ,mid , pos , val);
        }else{
            updateQuery(node * 2 + 2 , mid + 1 , r , pos , val);
        }

        st[node] = st[node * 2 + 1 ] + st[node * 2 + 2];
    }
    
    public int sumRange(int left, int right) {
        return querySum(0 , 0 , n - 1 , left , right);
    }
    
    private int querySum(int node , int nodeL , int nodeR , int l , int r){
        if(nodeR < l || nodeL > r ) return 0;
        if(nodeL >= l && nodeR <= r) return st[node];
        int mid = nodeL + (nodeR - nodeL) / 2;
        int leftSum = querySum(node * 2 + 1 , nodeL , mid , l , r);
        int rightSum = querySum(node * 2 + 2 , mid + 1 , nodeR , l , r);
        return leftSum + rightSum;
    }

    private void buildTree(int node , int l , int r){
        if(l == r){
            st[node] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildTree(node * 2 + 1 , l , mid);
        buildTree(node * 2 + 2 , mid + 1 , r);
        st[node] = st[node * 2 + 1] + st[node * 2 + 2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */