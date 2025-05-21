//TC == O(q * logN * logN)
class Solution {
    void buildST(int i, int l, int r, int ST[], int heights[]) {
        if (l == r) {
            ST[i] = l;
            return;
        }
        int mid = l + (r - l) / 2;
        buildST(2 * i + 1, l, mid, ST, heights);
        buildST(2 * i + 2, mid + 1, r, ST, heights);
        int li = ST[2 * i + 1];
        int ri = ST[2 * i + 2];
        if (heights[li] >= heights[ri]) {
            ST[i] = li;
        } else {
            ST[i] = ri;
        }
    }

    int[] CT(int heights[], int n) {
        int ST[] = new int[4 * n];
        buildST(0, 0, n - 1, ST, heights);
        return ST;
    }

    int query(int start, int end, int i, int l, int r, int ST[], int heights[]) {
        if (l > end || r < start)
            return -1;
        if (l >= start && r <= end)
            return ST[i];

        int mid = l + (r - l) / 2;

        int left = query(start, end, 2 * i + 1, l, mid, ST, heights);
        int right = query(start, end, 2 * i + 2, mid + 1, r, ST, heights);

        if (left == -1)
            return right;
        if (right == -1)
            return left;
        if (heights[left] >= heights[right]) {
            return left;
        } else {
            return right;
        }
    }

    int RMIQ(int ST[], int heights[], int n, int start, int end) {
        return query(start, end, 0, 0, n - 1, ST, heights);
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int q = queries.length;

        int ST[] = CT(heights, n);
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            maxi = Math.max(maxi, heights[i]);

        int ans[] = new int[q];
        Arrays.fill(ans, -1);
        for (int i = 0; i < q; i++) {
            int l = Math.min(queries[i][0], queries[i][1]);
            int r = Math.max(queries[i][0], queries[i][1]);

            if (l == r || heights[r] > heights[l]) {
                ans[i] = r;
                continue;
            }
            // for(int j = Math.max(l , r) ; j < n ; j++){
            //     if(heights[j] > heights[l] && heights[j] > heights[r]){
            //         ans[i] = j;
            //         break;
            //     }
            // }

            int left = r + 1, right = n - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int idx = RMIQ(ST, heights, n, left, mid);
                if (heights[idx] > Math.max(heights[l], heights[r])) {
                    ans[i] = idx;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return ans;
    }
}