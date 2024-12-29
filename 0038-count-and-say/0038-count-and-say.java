class Solution {
    public String countAndSay(int n) {
        StringBuilder current = new StringBuilder("1");

        for(int i = 1 ; i < n ; i++){
            StringBuilder next = new StringBuilder();
            int length = current.length();
            int j = 0; 
            while(j < length){
                int cnt = 0;
                char ch = current.charAt(j);
                while(j < length && ch == current.charAt(j)){
                    j++;
                    cnt++;
                }
                next.append(cnt);
                next.append(ch);
            }
            current = next;
        }
        return current.toString();
    }
}

/*class Solution {
    public String countAndSay(int n) {
        String s ="1";
        for(int i = 1 ; i < n ; i++){
            s = helper(s);
        }
        return s;
    }

    private String helper(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int cnt = 1;
        for(int i = 1 ; i < s.length(); i++){
            if(c == s.charAt(i)){
                cnt++;
            }else{
                sb.append(cnt);
                sb.append(c);
                c = s.charAt(i);
                cnt = 1;
            }
        }
        sb.append(cnt);
        sb.append(c);
        return sb.toString();
    }

}*/

/*class Solution {
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
} */