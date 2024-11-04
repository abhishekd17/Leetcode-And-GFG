class Solution {
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
}