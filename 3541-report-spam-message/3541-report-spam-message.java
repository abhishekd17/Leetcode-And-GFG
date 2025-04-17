class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>();
        for(String s : bannedWords){
            set.add(s);
        }
        int cnt = 0;
        for(int i = 0 ; i < message.length ; i++){
            if(set.contains(message[i])) cnt++;
            if(cnt >= 2) return true;
        }
        return false;
    }
}