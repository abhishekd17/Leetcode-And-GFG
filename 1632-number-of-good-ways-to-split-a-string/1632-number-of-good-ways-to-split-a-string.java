class Solution {
    public int numSplits(String s) {
        HashMap<Character , Integer> map1 = new HashMap<>();
        HashMap<Character , Integer> map2 = new HashMap<>();

        for(char c : s.toCharArray()){
            map2.put(c , map2.getOrDefault(c , 0) + 1);
        }

        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map1.put(ch , map1.getOrDefault(ch , 0) + 1);
            map2.put(ch , map2.getOrDefault(ch , 0) - 1);
            if(map2.get(ch) <= 0) {
                map2.remove(ch);
            }
            if(map1.size() == map2.size()) ans++;
        }
        return ans;
    }
}