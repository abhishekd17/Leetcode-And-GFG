class Solution {
    public String largestTimeFromDigits(int[] a) {
        String ans = "";
        for(int i = 0 ;  i < 4 ; i++){ 
            for(int j = 0 ; j < 4 ; j++){
                for(int k = 0 ; k < 4 ; k++){
                    if(i == j || i == k || j == k || a[i] > 2 || a[k] > 5 || (a[j] > 3 && a[i] == 2)) continue;
                    String h = "" + a[i] + a[j] , m = "" + a[k] + a[6 - i - j - k] , t = h + ":" + m;
                    if(h.compareTo("24") < 0 && m.compareTo("60") < 0 && ans.compareTo(t) < 0){
                        ans = t;
                    }
                }
            } 
        }
        return ans;
    }
}