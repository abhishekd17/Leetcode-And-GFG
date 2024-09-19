// brute force
class Solution {
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

//optimal
/*class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        if(s.length() != goal.length()) return false;
        String conc=s + s;
        if(conc.contains(goal)) return true;
        return false; 
    }
}*/