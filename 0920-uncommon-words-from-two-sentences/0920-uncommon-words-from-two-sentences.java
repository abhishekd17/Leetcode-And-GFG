class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] first = s1.split(" ");
        String[] second = s2.split(" ");
       Map<String , Integer> map=new HashMap<>();

       for(String s : first){
        map.put(s , map.getOrDefault(s , 0) + 1);
       }
       for(String s : second){
        map.put(s , map.getOrDefault(s , 0) + 1);
       }

       List<String> list = new ArrayList<>();

       for(String  s : map.keySet()){
        if(map.get(s) == 1){
            list.add(s);
        }
       }

       return list.toArray(new String[0]);
    }
}