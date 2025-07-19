class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int m = words.length;
        int x = words[0].length();
        int windowSize = m * x;

        Map<String , Integer> map1 = new HashMap<>();
        for(String a : words){
            map1.put(a , map1.getOrDefault(a , 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        if(n < windowSize) return list;

        for(int i = 0 ; i < x ; i++){
            int l = i;
            int r = i;
            int cnt = 0;

            Map<String , Integer> map = new HashMap<>();

            while(r + x <= n ){
                String word = s.substring(r , r + x);
                r += x;

                if(map1.containsKey(word)){
                    map.put(word , map.getOrDefault(word , 0) + 1);
                    cnt++;
                    while(map.get(word) > map1.get(word)){
                        String removeableString = s.substring(l , l + x);
                        map.put(removeableString ,map.get(removeableString) - 1);
                        cnt--;
                        l += x;
                    }
                    if(cnt == m) list.add(l);
                }else{
                    map.clear();
                    cnt = 0;
                    l = r;
                }
            }
        }
        return list;
    }
}