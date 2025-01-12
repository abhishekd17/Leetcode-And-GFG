class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;
        
        int cnt1 = 0; // for )
        int cnt2 = 0; // for (

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '(' || locked.charAt(i) == '0') cnt1++;
            else if(c == ')') cnt2++;
            if(cnt2 > cnt1) return false;
        }

        cnt1 = 0;
        cnt2 = 0;

        for(int i = s.length() - 1 ; i >=0 ; i--){
            char c = s.charAt(i);
            if(c == ')' || locked.charAt(i) == '0') cnt1++;
            else if(c == '(') cnt2++;
            if(cnt1 < cnt2) return false;
        }

        return true;
    }
}