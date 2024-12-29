class Solution {
    public String countAndSay(int n) {
        return helper2(n , 1 , new StringBuilder("1"));
    }
    private String helper2(int n , int x , StringBuilder sb){
        if(x == n) return sb.toString( );
        sb = helper(sb);
        return helper2(n , x + 1 , sb);
    }
    private StringBuilder helper(StringBuilder s){
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < n){
            int cnt = 0;
            char c = s.charAt(i);
            while(i < n && s.charAt(i) == c){
                cnt++;
                i++;
            }
            sb.append(cnt);
            sb.append(c);
        }
        return sb;
    }
}