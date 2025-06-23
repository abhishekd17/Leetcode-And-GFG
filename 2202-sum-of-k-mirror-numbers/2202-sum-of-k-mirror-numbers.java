class Solution {
    public long kMirror(int k, int n) {
        int l = 1;
        long ans = 0;
        while (n > 0) {
            int half = (l + 1) / 2;
            long mini = (long) Math.pow(10, half - 1);
            long maxi = (long) Math.pow(10, half) - 1;
            // System.out.print(mini + " " + maxi);
            // System.out.println();

            for (long i = mini; i <= maxi; i++) {
                String pal = "";
                String first = i + "";
                String second = new StringBuilder(first).reverse().toString();
                if (l % 2 == 0) {
                    pal = first + second;
                } else {
                    pal = first + second.substring(1);
                }

                long num = Long.parseLong(pal);
                String baseK = base(num, k);
                if (ispal(baseK)) {
                    // System.out.print(num + " ");
                    ans += num;
                    n--;
                    if (n == 0)
                        return ans;
                }
            }
            l++;
        }
        return ans;
    }

    private String base(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.toString();
    }

    private boolean ispal(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}