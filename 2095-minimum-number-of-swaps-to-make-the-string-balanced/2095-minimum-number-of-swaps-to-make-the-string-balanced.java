class Solution {
    public int minSwaps(String s) {
     int n = s.length();
     int ans = 0;
     int closing = 0;
     int opening = 0;
     for(int i = 0 ; i < n ; i++){
        if(s.charAt(i) == '['){
            opening++;
        }else{
            closing++;
        }
        if(closing > opening){
            ans++;
            closing--;
            opening++;
        }
     }   
     return ans;
    }
}