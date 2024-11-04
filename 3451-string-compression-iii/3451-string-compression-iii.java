class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();

        int cnt = 1;
        int n = word.length();
        char ch = word.charAt(0);

        for(int i = 1 ; i < n ; i++){
            if(word.charAt(i) == ch && cnt < 9){
                cnt++;
            }else{
                ans.append(cnt).append(ch);
                ch = word.charAt(i);
                cnt = 1;
            }
        }
        ans.append(cnt).append(ch);
        return ans.toString();
    }
}

/*class Solution {
    public String compressedString(String word) {
        int n = word.length();
        StringBuilder sb =new StringBuilder();
        for(int i = 0; i < n ;){
            int cnt = 1;
            char ch = word.charAt(i);
             while (i + cnt < n && word.charAt(i + cnt) == ch && cnt < 9) {
                cnt++;
            }
            sb.append(cnt);
            sb.append(ch);
            i += cnt;
        }
        return sb.toString();
    }
} */