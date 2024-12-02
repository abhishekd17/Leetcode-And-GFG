class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String word[] = sentence.split(" ");
        for(int i = 1 ; i <= word.length ; i++){
            if(word[i - 1].startsWith(searchWord)){
                return i;
            }
        }
        return -1;
    }
}