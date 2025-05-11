class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int l = 0 , r = 0;
        for(char c : s.toCharArray()){
            if(c == '(') l++;
            else if(l > 0) l--;
            else r++;
        }
        return l + r;
    }
}