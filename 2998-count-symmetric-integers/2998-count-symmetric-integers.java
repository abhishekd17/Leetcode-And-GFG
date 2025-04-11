class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        for(int i = low ; i <= high ; i++){
            String s = Integer.toString(i);
            if(s.length() % 2 == 0){
                String s1 = s.substring(0 , s.length() / 2);
                String s2 = s.substring(s.length() / 2);
                int cnt1 = 0;
                int cnt2 = 0;
                for(int j = 0 ; j < s1.length() ; j++){
                    cnt1 += s1.charAt(j);
                    cnt2 += s2.charAt(j);
                }
                if(cnt1 == cnt2) ans++;
            }
        }
        return ans;
    }
}