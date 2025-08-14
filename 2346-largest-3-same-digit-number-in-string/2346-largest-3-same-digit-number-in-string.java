class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int maxi = -1;
        char curr = num.charAt(0);
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            char ch = num.charAt(i);
            if (ch == curr) {
                cnt++;
            } else {
                cnt = 1;
                curr = ch;
            }

            if (cnt == 3) {
                int a = curr - '0';
                int x = a * 100 + a * 10 + a;
                if (x > maxi) {
                    maxi = x;
                }
            }
        }
        if(maxi == -1) return "";
        return String.format("%03d", maxi);
    }
}