class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int maxi = 0;
        char curr = num.charAt(0);
        int cnt = 1;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            char ch = num.charAt(i);
            if (ch == curr) {
                cnt++;
            } else {
                if (cnt == 3) {
                    flag  = true;
                    int a = curr - '0';
                    int x = a * 100 + a * 10  + a;
                    if (x > maxi) {
                        maxi = x;
                    }
                }
                cnt = 1;
                curr = ch;
            }

            if (cnt == 3) {
                flag  = true;
                int a = curr - '0';
                int x = a * 100 + a * 10 + a;
                if (x > maxi) {
                    maxi = x;
                }
            }
        }
        if(!flag) return "";
        return String.format("%03d", maxi);
    }
}