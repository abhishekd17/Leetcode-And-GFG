class Solution {
    public List<Integer> partitionLabels(String s) {

        int n = s.length();
        List<Integer> ans = new ArrayList<>();

        Map<Character , Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map.put(s.charAt(i) , i);
        }

        int start = 0 , end = 0;

        for(int i = 0 ; i < n ; i++){
            end = Math.max(end , map.get(s.charAt(i)));
            if(end == i){
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}