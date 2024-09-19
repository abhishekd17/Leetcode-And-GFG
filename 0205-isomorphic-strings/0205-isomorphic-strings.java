class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int smap[]=new int[256];
        int tmap[]=new int[256];
        for(int i=0;i<s.length();i++){
            char sChar=s.charAt(i);
            char tChar=t.charAt(i);
            if(smap[sChar]!=tmap[tChar]) return false;
            smap[sChar]=i+1;
            tmap[tChar]=i+1;
        }
        return true;
    }
}


/*class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Character> smap=new HashMap<>();
        HashMap<Character,Boolean> used=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char sChar=s.charAt(i);
            char tChar=t.charAt(i);
            if(smap.containsKey(sChar)){
                if(smap.get(sChar)!=tChar) return false;//Existing mapping does not match
            }
            else{
                if(used.containsKey(tChar) && used.get(tChar)) return false; // tChar is already used for another mapping
                smap.put(sChar,tChar);
                used.put(tChar,true);
            }
        }
        return true;
    }
}*/