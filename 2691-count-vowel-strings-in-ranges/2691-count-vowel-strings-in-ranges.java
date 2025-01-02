class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int q = queries.length;
        int ans[] = new int[q];
        int pref[] = new int[n + 1];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for(int i = 0 ; i < n ; i++){
            pref[i + 1] = pref[i];
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                pref[i + 1]++;
            }
        }
        for(int i = 0 ; i < q ; i++){
            ans[i] = pref[queries[i][1] + 1] - pref[queries[i][0]]; 
        }
        return ans;
    }
}

/*class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;
        int ans[] = new int[m];
        int p = 0;
        for(int query[] : queries){
            int start = query[0];
            int end = query[1];
            int cnt = 0;
            for(int i = start ; i <= end ; i++){
                String s = words[i];
                char first = s.charAt(0);
                char last = s.charAt(s.length() - 1);
                if(check(first) && check(last)) cnt++;
            } 
            ans[p++] = cnt;
        }
        return ans;
    }

    private boolean check(char c){
        return c =='a' || c == 'e'|| c == 'i' || c == 'o' || c=='u';
    }
} */