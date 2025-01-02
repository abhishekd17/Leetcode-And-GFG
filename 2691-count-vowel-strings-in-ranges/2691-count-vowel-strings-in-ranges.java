class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int q = queries.length;
        int ans[] = new int[q];
        int pref[] = new int[n + 1];
        pref[0] = 0;
        for(int i = 0 ; i < n ; i++){
            String s = words[i];
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            int cnt = 0;
            if(check(first) && check(last)) cnt = 1;
            pref[i + 1] = pref[i] + cnt;
        }
        int p = 0;
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];
            String s = words[start];
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            ans[p++] = pref[end + 1] - pref[start + 1] + ((check(first) && check(last)) ? 1 : 0); 
        }
        return ans;
    }
    private boolean check(char c){
        return c =='a' || c == 'e'|| c == 'i' || c == 'o' || c=='u';
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