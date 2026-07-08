import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Store non-zero digits and their original indices
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digits.add(d);
                indices.add(i);
            }
        }

        int m = digits.size();

        // prefix sum of digits
        long[] prefSum = new long[m + 1];

        // prefix number modulo MOD
        long[] prefNum = new long[m + 1];

        // powers of 10
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            prefSum[i + 1] = prefSum[i] + digits.get(i);
            prefNum[i + 1] = (prefNum[i] * 10 + digits.get(i)) % MOD;
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];

            int left = lowerBound(indices, l);
            int right = upperBound(indices, r) - 1;

            if (left > right) {
                ans[q] = 0;
                continue;
            }

            long sum = prefSum[right + 1] - prefSum[left];

            int len = right - left + 1;

            long x = (prefNum[right + 1]
                    - (prefNum[left] * pow10[len]) % MOD
                    + MOD) % MOD;

            ans[q] = (int) ((x * sum) % MOD);
        }

        return ans;
    }

    // First index with value >= target
    private int lowerBound(ArrayList<Integer> arr, int target) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr.get(mid) < target)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    // First index with value > target
    private int upperBound(ArrayList<Integer> arr, int target) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr.get(mid) <= target)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}