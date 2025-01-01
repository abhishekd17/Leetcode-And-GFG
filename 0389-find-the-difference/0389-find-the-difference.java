class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for(int i = 0 ; i < s.length(); i++){
            c ^= s.charAt(i);
        }
        for(int i = 0 ; i < t.length() ; i++){
            c ^= t.charAt(i);
        }
        return c;
    }
}

/*class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) ,0) + 1);
        }
        for(int i= 0 ;i < t.length() ; i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch , map.getOrDefault(ch , 0) - 1);
                if(map.get(ch) == 0 ) map.remove(ch);
            }else{
                return ch;
            }
        }
        return map.keySet().iterator().next();
    }
} */