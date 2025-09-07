class Solution {
    public int minOperations(String s) {
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a') continue;
            ans = Math.max(ans , 25 - (ch - 'a') + 1);
        }
        return ans;
    }
}