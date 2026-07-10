import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> Integer.compare(nums[a], nums[b]));

        long[] val = new long[n];
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = nums[order[i]];
            pos[order[i]] = i;
        }

        int[] next = new int[n];
        int r = 0;

        for (int i = 0; i < n; i++) {
            r = Math.max(r, i);

            while (r + 1 < n && val[r + 1] - val[i] <= maxDiff) {
                r++;
            }

            next[i] = r;
        }

        int log = 1;

        while ((1L << log) <= n) {
            log++;
        }

        int[][] jump = new int[log][n];

        for (int i = 0; i < n; i++) {
            jump[0][i] = next[i];
        }

        for (int j = 1; j < log; j++) {
            for (int i = 0; i < n; i++) {
                jump[j][i] = jump[j - 1][jump[j - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = pos[queries[i][0]];
            int v = pos[queries[i][1]];

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            int cur = u;
            int dist = 0;

            for (int j = log - 1; j >= 0; j--) {
                if (jump[j][cur] < v) {
                    int nxt = jump[j][cur];

                    if (nxt != cur) {
                        cur = nxt;
                        dist += 1 << j;
                    }
                }
            }

            if (next[cur] >= v) {
                ans[i] = dist + 1;
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }
}