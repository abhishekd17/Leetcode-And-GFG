class Solution {
    public long calculateScore(String s) {
        int n = s.length();
        HashMap<Character , List<Integer>> map = new HashMap<>();

        long ans = 0;

        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            int position = c - 'a' + 1;
            int mirror_position = 27 - position;
            char mirror_char = (char)('a' + mirror_position - 1);

            if(map.containsKey(mirror_char)){
                List<Integer> temp = map.get(mirror_char);
                ans += (i - temp.get(temp.size() - 1));
                temp.remove(temp.size() - 1);
                if(temp.size() == 0) map.remove(mirror_char);
            }else{
                map.putIfAbsent(c, new ArrayList<>());
                map.get(c).add(i);
            }
        }
        return ans;
    }
}