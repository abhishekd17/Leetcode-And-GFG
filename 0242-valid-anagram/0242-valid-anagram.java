/*import java.util.*;
class Solution {
    static HashMap<Character,Integer>freq(String str){
        HashMap<Character,Integer> mp=new HashMap<>();

        for(int i=0;i<str.length();i++){
            Character ch=str.charAt(i);
            if(!mp.containsKey(ch)){
                mp.put(ch,1);
            }else{
                mp.put(ch,mp.getOrDefault(ch,0)+1);
            }
        }
        return mp;
        
    }

    public boolean isAnagram(String s,String t){
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> mp=freq(s);

        for(int i=0;i<t.length();i++){
            Character ch=t.charAt(i);
            if(!mp.containsKey(ch)){
                return false;
            }
            int freq=mp.get(ch);
            if(freq==0){
                return false;
            }
            mp.put(ch,freq-1);
        }

        // for(Integer i:mp.values()){
        //     if(i!=0)return false;
        // }
        return true;
    }
}*/
    /*public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

          HashMap<Character,Integer> mp1=freq(s);
          HashMap<Character,Integer> mp2=freq(t);

          return mp1.equals(mp2);
    }*/

/*import java.util.HashMap;

class Solution {
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counts = new int[26]; // Assuming input contains only lowercase English letters

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}*/


/*import java.util.HashMap;

class Solution {
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> counts = new HashMap<>();

        // Count occurrences of characters in string s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        // Decrement occurrences of characters in string t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!counts.containsKey(ch)) {
                return false;
            }
            int count = counts.get(ch);
            if (count == 1) {
                counts.remove(ch); // Remove entry if count becomes 0
            } else {
                counts.put(ch, count - 1);
            }
        }

        return counts.isEmpty(); // If counts is empty, all characters cancelled out
    }
}*/

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
}

