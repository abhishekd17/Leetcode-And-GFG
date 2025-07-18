class Solution {
    public String convert(String s, int n) {
        if(n == 1 || s.length() <= n) return s;
        StringBuilder sb[] = new StringBuilder[n];
        for(int i = 0 ; i < n ; i++) sb[i] = new StringBuilder();
        boolean dir = false;
        int row = 0;
        for(char ch : s.toCharArray()){
            sb[row].append(ch);
            if(row == 0 || row == n - 1) dir = !dir;
            row += dir ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            ans.append(sb[i]);
        }
        return ans.toString();
    }
}