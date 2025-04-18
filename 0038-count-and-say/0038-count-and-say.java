class Solution {
    public String countAndSay(int n) {

        if (n == 1)
            return "1";
        
        StringBuilder sb = new StringBuilder("1");

        for(int i = 2 ; i <= n ; i++){
            String s = sb.toString();
            int cnt = 1;
            sb = new StringBuilder();

            for(int j = 0 ; j < s.length() ; j++){
                if(j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) cnt++;
                else{ sb.append(cnt).append(s.charAt(j)); cnt = 1; }
            }
        }
        return sb.toString();
    }
}