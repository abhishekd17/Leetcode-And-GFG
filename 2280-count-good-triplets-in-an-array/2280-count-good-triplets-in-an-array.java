class Solution {
    int[] CT(int nums[], int n) {
        int st[] = new int[4 * n];
        buildSt(0, 0, n - 1, nums, st);
        return st;
    }

    void buildSt(int node, int l, int r, int nums[], int st[]) {
        if (l == r) {
            st[node] = 0;
            return;
        }

        int mid = l + (r - l) / 2;
        buildSt(2 * node + 1, l, mid, nums, st);
        buildSt(2 * node + 2, mid + 1, r, nums, st);
        st[node] = st[2 * node + 1] + st[2 * node + 2];
    }

    int query(int node, int l, int r, int ql, int qr, int[] st) {
        if (l > qr || r < ql) return 0;
        if (l >= ql && r <= qr) return st[node];
        int mid = l + (r - l) / 2;
        return query(2 * node + 1, l, mid, ql, qr, st) + query(2 * node + 2, mid + 1, r, ql, qr, st);
    }

    void update(int node, int l, int r, int idx, int st[]) {
        if (l == r) {
            st[node] = 1;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            update(2 * node + 1, l, mid, idx, st);
        } else {
            update(2 * node + 2, mid + 1, r, idx, st);
        }
        st[node] = st[2 * node + 1] + st[2 * node + 2];
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long ans = 0;

        // Mapping nums2 values to indices
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }

        int[] st = CT(nums2, n);
        int[] leftCommon = new int[n];

        // First pass: left to right
        for (int i = 0; i < n; i++) {
            int idx = map.get(nums1[i]);
            leftCommon[i] = query(0, 0, n - 1, 0, idx - 1, st);
            update(0, 0, n - 1, idx, st);
        }

        // Reset segment tree for right pass
        st = new int[4 * n]; // zero-initialized

        // Second pass: right to left
        for (int i = n - 1; i >= 0; i--) {
            int idx = map.get(nums1[i]);
            int rightCommon = query(0, 0, n - 1, idx + 1, n - 1, st);
            ans += (long) leftCommon[i] * rightCommon;
            update(0, 0, n - 1, idx, st);
        }

        return ans;
    }
}



/*class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long ans = 0;
        
        // Create a map from value to its index in nums2
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }
        
        // Check all possible triplets in nums1
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Get the indices in nums2 of the three elements
                    int i1 = map.get(nums1[i]);
                    int i2 = map.get(nums1[j]);
                    int i3 = map.get(nums1[k]);
                    
                    // Check if they appear in the same order in nums2
                    if (i1 < i2 && i2 < i3) {
                        ans++;
                    }
                }
            }
        }
        
        return ans;
    }
} */