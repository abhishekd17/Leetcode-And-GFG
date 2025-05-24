class Solution {
    int[] segTree;
    int n;

    public int[] xorQueries(int[] arr, int[][] queries) {
        n = arr.length;
        segTree = new int[4 * n]; // Segment tree size
        build(arr, 0, 0, n - 1);

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            res[i] = query(0, 0, n - 1, left, right);
        }
        return res;
    }

    // Build segment tree
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            segTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            segTree[node] = segTree[2 * node + 1] ^ segTree[2 * node + 2];
        }
    }

    // Query for XOR in range [l, r]
    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0; // No overlap
        }
        if (l <= start && end <= r) {
            return segTree[node]; // Total overlap
        }
        int mid = (start + end) / 2;
        int leftXor = query(2 * node + 1, start, mid, l, r);
        int rightXor = query(2 * node + 2, mid + 1, end, l, r);
        return leftXor ^ rightXor; // Partial overlap
    }
}



/*class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        for(int i = 1 ;i < n ; i++){
            arr[i] = arr[i] ^ arr[i - 1];
        }
        int ans[] = new int[m];
        for(int i = 0 ; i < m ; i++){
            int a = queries[i][0];
            int b = queries[i][1];

            if(a==0){
                ans[i] = arr[b];
            }else{
                ans[i] = arr[b] ^ arr[a - 1];
            }
        }
        return ans;
    }
}*/

// brute force 
/*class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n =arr.length;
        int m = queries.length;

        int ans[] = new int[m];
        int p=0;
        for(int i = 0 ; i < m ; i++){
            int xor=0;
            for(int j = queries[i][0] ; j <= queries[i][1] ; j++){
                xor ^= arr[j];
            }
            ans[p++] = xor;
        }
        return ans;
    }
} */