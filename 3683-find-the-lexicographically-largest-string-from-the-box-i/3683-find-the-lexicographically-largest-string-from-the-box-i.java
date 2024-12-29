class Solution {
    public String answerString(String word, int numFriends) {

        int n = word.length();
        if(numFriends == 1) return word;
        int maxLength = word.length() - numFriends + 1;
        String max = "";
        for(int i = 0 ; i < n ; i++){
            String temp = word.substring(i , Math.min(i + maxLength  , word.length()));
            if(temp.compareTo(max) > 0){
                max = temp;
            }
        }
        return max;
    }
}