class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        HashMap<String , Integer> map = new HashMap<>();
        int p = s.length() / k;
        for(int i = 0 ; i  < s.length() ; i += p){
            String x = s.substring(i , p + i);
            map.put(x , map.getOrDefault(x , 0) + 1);
        }

        // for(Map.Entry<String , Integer> entry : map.entrySet()){
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // }
        for(int i = 0 ; i < t.length() ; i += p){
            String x = t.substring(i , i + p);
            // System.out.println(x);
            if(!map.containsKey(x)) return false;
            else{
                map.put(x , map.getOrDefault(x , 0) - 1);
                if(map.get(x) == 0) map.remove(x);
            }
        }

        return true;
    }
}