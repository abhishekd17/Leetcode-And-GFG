class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> set = new HashSet<>();
        
        for(String s : startWords){
            int mask = 0;
            for(char c : s.toCharArray()){
                mask |= 1 << (c - 'a'); 
            }
            set.add(mask);
        }

        int cnt = 0;

        for(String s : targetWords){
            int mask = 0;
            for(char c : s.toCharArray()){
                mask |= 1 << (c - 'a'); 
            }

            for(char c : s.toCharArray()){
                int newMask = (1 << (c - 'a')) ^ mask;
                if(set.contains(newMask)){
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}