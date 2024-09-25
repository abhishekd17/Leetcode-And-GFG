// class Solution {
//     public int[] sumPrefixScores(String[] words) {
//         int n = words.length;

//         int cnt = 0;
//         int ans[] = new int[n];
//         for(int i = 0 ; i  < n ; i++){
//             String s = words[i];
//             cnt = 0;
//             for(int j = 0 ; j < s.length(); j++){
//                 String ss = s.substring(0 , j + 1);
//                 for(int k = 0 ; k < n ;k++){
//                     String sss = words[k];
//                     if(sss.startsWith(ss)){
//                         cnt++;
//                     }
//                 }
//             }
//             ans[i] = cnt;
//         }
//         return ans ;
//     }
// }

class Trie {
    Trie[] ch = new Trie[26];
    int visited = 0;
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int[] ans = new int[words.length];
        int k = 0;
        for (String x: words) {
            Trie t = trie;
            for (int i = 0; i < x.length(); i++) {
                int c = x.charAt(i) - 'a';
                if (t.ch[c] == null) t.ch[c] = new Trie();
                t.ch[c].visited++;
                t = t.ch[c];
            }
        }
        for (String x: words) {
            Trie t = trie; int curr = 0;
            for (int i = 0; i < x.length(); i++) {
                int c = x.charAt(i) - 'a';
                curr += t.ch[c].visited;
                t = t.ch[c];
            }
            ans[k++] = curr;
        }
        return ans;
    }
}