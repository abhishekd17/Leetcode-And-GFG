class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = (int) Math.ceil((double) n / k);
        String st[] = new String[size];

        int x = 0;
        
        for(int i = 0 ; i < n ; i += k){
            String ss = s.substring(i , Math.min(i + k , n));
            if(ss.length() < k){
                for(int j = 0 ; ss.length() < k ; j++) ss = ss + fill;
            }
            st[x] = ss;
            x++;
        }
        return st;
    }
}

// abc defghij