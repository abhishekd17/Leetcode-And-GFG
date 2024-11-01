class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        sb.append(s.charAt(0));
        char prev = s.charAt(0);
        for(int i = 1 ; i <  n ; i++){
           if(s.charAt(i) == prev){
            cnt++;
           }else{
            prev = s.charAt(i);
            cnt = 1;
           }
           if(cnt < 3){
            sb.append(s.charAt(i));
           }
        }
        return sb.toString();
    }
}