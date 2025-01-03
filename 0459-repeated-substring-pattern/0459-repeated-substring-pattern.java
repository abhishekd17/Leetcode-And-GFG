class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int  n = s.length();

        for(int l = 1 ;  l <= n / 2 ; l++){
            if(n % l == 0){
                int times = n / l ;
                String str = s.substring(0 , l);
                String x = "";
                while(times-- > 0){
                    x += str;
                } 
                if(x.equals(s)) return true;
            }
        }
        return false;
    }
}