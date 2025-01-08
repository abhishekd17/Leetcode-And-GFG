// ~O(N^2 * M)
/*class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        // Arrays.sort(words, Comparator.reverseOrder());
        for(int i = 0 ;i < n; i++){ // O(N)
            String s1 = words[i];
            for(int j = i + 1 ; j < n ; j++){ // O(N)
                String s2 = words[j];
                if(isPrefAndSuff(s1, s2)){ // O(M) -- > M -- > size of string
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isPrefAndSuff(String s1 , String s2){
        return s2.startsWith(s1) && s2.endsWith(s1) ; // (m)
    }
}*/

import java.util.*;
class Trie {
    class Node{
        Node[] links = new Node[26];
        boolean flag = false;

        boolean containsKey(char ch){
            return links[ch -'a'] != null;
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

        void setEndAtTheTimeOfDeletion(boolean isEnd){
            flag = isEnd;
        }

        boolean isEnd(){
            return flag;
        }

        void removeLink(char ch){
            links[ch - 'a'] = null;
        }

        boolean isEmpty(){
            for(Node link : links){
                if(link != null) return false;
            }
            return true;
        }
    }

    Node root;

    Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node node = root;
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch , new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word){
        Node node = root;
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWithPrefix(String prefix){
        Node node = root;
        for(int i = 0 ; i < prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return true;
    }

    public boolean isEmpty(){
        return root.isEmpty();
    }

    public boolean delete(String word){
        return deleteHelper(root , word , 0);
    }

    public boolean deleteHelper(Node node , String word , int depth){
        if(node == null ) return false;

        // if we have reached the end of the word
        if(depth == word.length()){
            if(!node.isEnd()) return false;
            node.setEndAtTheTimeOfDeletion(false);
            return node.isEmpty();
        }

        // recursive case : delete the next char
        char ch = word.charAt(depth);
        Node childNode = node.get(ch);
        if(deleteHelper(childNode, word, depth + 1)){
            node.removeLink(ch);
            node.removeLink(ch);
            return !node.isEnd() && node.isEmpty();
        }
        return false;
    }

}
class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;

        int ans = 0;
        for (int j = 0; j < n; j++) {
            Trie prefixTrie = new Trie();
            Trie suffixTrie = new Trie();

            prefixTrie.insert(words[j]);
            String reversed = new StringBuilder(words[j]).reverse().toString();
            suffixTrie.insert(reversed);

            for (int i = 0; i < j; i++) {
                if (words[i].length() > words[j].length()) {
                    continue;
                }

                String rev = new StringBuilder(words[i]).reverse().toString();

                if (prefixTrie.startsWithPrefix(words[i]) && suffixTrie.startsWithPrefix(rev)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}