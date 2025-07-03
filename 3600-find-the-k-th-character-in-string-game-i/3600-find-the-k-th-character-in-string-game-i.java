class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        while(sb.length() < k){
            String s = "";
            for(int i = 0 ; i < sb.length() ; i++){
                s += (char)((int)sb.charAt(i) + 1);
            }
            sb.append(s);
        }

        return sb.charAt(k - 1);
    }
}