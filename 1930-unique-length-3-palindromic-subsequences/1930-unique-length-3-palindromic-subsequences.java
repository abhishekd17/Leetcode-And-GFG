class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        Set<Character> set = new HashSet<>(); //O(26)

        for(int i = 0 ; i < n ; i++){  
            set.add(s.charAt(i));
        }

        int[][] idx = new int[26][2];

        for(int[] a : idx){
            Arrays.fill(a , -1);
        }

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            if(idx[ch - 'a'][0] == -1 )idx[ch-'a'][0] = i;
            idx[ch - 'a'][1] = i;

        }

        int ans = 0;

        for(char ch : set){
            int first = idx[ch - 'a'][0];
            int last = idx[ch - 'a'][1];

            if(first == -1) continue;

            Set<Character> temp = new HashSet<>();

            for(int i = first + 1 ; i <= last - 1 ; i++){
                temp.add(s.charAt(i));
            }
            ans += temp.size();
        }
        return ans;
    }
}

/*class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>(); //O(26)
        for(int i = 0 ; i < n ; i++){  O(N)
            set.add(s.charAt(i));
        }
        List<Character> list = new ArrayList<>(set); //O(26)

        int ans = 0;
        for(int i = 0 ; i < list.size() ; i++){ // O(26)
            char ch = list.get(i);
            int l = 0 , r = n - 1;
            while(l < r){ // O(N)
                if(ch == s.charAt(l)){
                    if(s.charAt(l) == s.charAt(r)){
                        Set<Character> temp = new HashSet<>();   // O(26)
                        for(int j = l + 1 ; j <= r - 1 ; j++){ // O(N)
                            temp.add(s.charAt(j));
                        }
                        ans += temp.size();
                        break;
                    }else{
                        r--;
                    }
                }else{
                    l++;
                }  
            }
        }
        return ans;
    }
}
*/
/*class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
        int n = s.length();

        for(int i = 0 ; i <  n; i++){ // O(N)
            int l = i , r = n - 1;
            while(l < r){ // O(N)
                if(s.charAt(l) == s.charAt(r)){
                    for(int k = l + 1  ; k <= r - 1 ; k++){ // O(N)
                        StringBuilder a = new StringBuilder();
                        a = a.append(s.charAt(l)).append(s.charAt(k)).append(s.charAt(r));
                        set.add(a.toString());
                    }
                    l++;
                }else{
                    r--;
                }
            }
        }
        return set.size();
    }
} 
// O(N^3)
*/