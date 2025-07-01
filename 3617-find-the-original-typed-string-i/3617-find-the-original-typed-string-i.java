class Solution {
    public int possibleStringCount(String s) {
        int n = s.length();
        int ans = 1;
        char prev = '#';
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(prev == ch){
                ans++;
            }else{
                prev = ch;
            }
            System.out.println(prev);
        }
        return ans;
    }
}