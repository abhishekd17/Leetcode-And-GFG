// brute force
/*class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        for(int i=0;i<s.length();i++){
            String Rotated=s.substring(i) + s.substring(0,i);
            if(Rotated.equals(goal)){
                return true;
            }
        }
        return false;
    }
}
*/
//optimal
class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        if(s.length() != goal.length()) return false;
        // String conc=s + s;
        // if(conc.contains(goal)) return true;
        // return false; 
        int[] z = calculateZ(goal + "$" + s + s);
        for(int i =  0 ; i < z.length; i++){
            if(z[i] == goal.length()) return true;
        }
        return false;
    }
    private static int[] calculateZ(String s){
        int n = s.length();
        int z[] = new int[n];
        int left = 0;
        int right = 0;
        for(int i = 0 ; i < n ; i++){
            if(i > right){
                left = right = i;
                while(right < n && s.charAt(right) == s.charAt(right - left)){
                    right++;
                }
                z[i] = right - left;
                right--;
            }else{
                // we are operating inside the box
                int k1 = i - left;
                // if value does not stretches till right bound then just copy it
                if(z[k1] < right - i + 1){
                    z[i] = z[k1];
                }else{ // try to see if there are more matches
                    left  = i;
                    while(right < n  && s.charAt(right) == s.charAt(right - left)){
                        right++;
                    }
                    z[i] = right - left;
                    right--;
                }
            }
        }
        return z;
    }
}