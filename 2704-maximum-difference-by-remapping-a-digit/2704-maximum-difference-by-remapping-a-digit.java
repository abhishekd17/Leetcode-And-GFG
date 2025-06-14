class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char c = s.charAt(0); 
        
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != '9'){
                c = s.charAt(i);
                break;
            }
        }
        StringBuilder maxStr = new StringBuilder(s);
        for(int i = 0; i < maxStr.length(); i++) {
            if(maxStr.charAt(i) == c) {
                maxStr.setCharAt(i, '9');
            }
        }
        int a = Integer.parseInt(maxStr.toString());
        
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != '0'){
                c = s.charAt(i);
                break;
            }
        }
        StringBuilder minStr = new StringBuilder(s);
        for(int i = 0; i < minStr.length(); i++) {
            if(minStr.charAt(i) == c) {
                minStr.setCharAt(i, '0');
            }
        }
        int b = Integer.parseInt(minStr.toString());

        return a - b;
    }
}
