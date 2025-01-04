class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            set.add(s.charAt(i));
        }
        List<Character> list = new ArrayList<>(set);

        int ans = 0;
        for(int i = 0 ; i < list.size() ; i++){
            char ch = list.get(i);
            int l = 0 , r = n - 1;
            while(l < r){
                if(ch == s.charAt(l)){
                    if(s.charAt(l) == s.charAt(r)){
                        Set<Character> temp = new HashSet<>();  
                        for(int j = l + 1 ; j <= r - 1 ; j++){
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

/*class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
        int n = s.length();

        for(int i = 0 ; i <  n; i++){
            int l = i , r = n - 1;
            while(l < r){
                if(s.charAt(l) == s.charAt(r)){
                    for(int k = l + 1  ; k <= r - 1 ; k++){
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
} */