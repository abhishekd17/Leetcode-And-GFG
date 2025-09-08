class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        Map<String , List<String>> map = new HashMap<>();
       
        for(int i = 0 ; i < n ; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(!map.containsKey(s)){
                map.put(s , new ArrayList<>());
            }
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }
        }

        for(Map.Entry<String , List<String>> entry: map.entrySet()){
            String key = entry.getKey();
            List<String> list = entry.getValue();
            ans.add(list);
        }
        return ans;
    }
}