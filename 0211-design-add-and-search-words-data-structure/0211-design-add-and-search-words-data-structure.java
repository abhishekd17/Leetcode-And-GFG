class WordDictionary {
    private WordDictionary[] children;
    boolean isEndOfWord; 
    public WordDictionary() {
        children = new WordDictionary[26];
        isEndOfWord = false;
    }
    
    public void addWord(String word) {
        WordDictionary curr = this;
        for(char c  : word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c-'a'] = new WordDictionary();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        WordDictionary curr = this;
        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(c =='.'){
                for(WordDictionary ch : curr.children){
                    if(ch != null && ch.search(word.substring(i + 1))) return true;
                }
                return false;
            }
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr != null && curr.isEndOfWord;
    }
}


/*class WordDictionary {
    class Node{
        Node links[] = new Node[26];
        boolean flag = false;

        boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }
        void put(char ch , Node node){
             links[ch - 'a'] = node; 
        }
        Node get(char ch){
            return links[ch - 'a'];
        }
        void setEnd(){
            flag = true;
        }
        boolean isEnd(){
            return flag;
        }
    }
    private Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(int i = 0 ; i < word.length() ; i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i) , new Node());
            }
            node= node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        return helper(word , 0 , root);
    }

    private boolean helper(String word , int index , Node node){
        if(index == word.length()) return node.isEnd();

        char ch= word.charAt(index);
        if(ch == '.'){
            for(int i = 0 ; i < 26 ; i++){
                if(node.links[i] != null  && helper(word , index + 1 , node.links[i])){
                    return true;
                } 
            }
            return false;
        }else{
            if(!node.containsKey(ch)){
                return false;
            }
            return helper(word , index + 1 , node.get(ch));
        }
    }
}*/

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */ 

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */