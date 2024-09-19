//jai maa saraswati
//O(N)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs==null ) return "";
        int n=strs.length;
        String prefix=strs[0];
        for(int i=1;i<n;i++){
            int j=0;
            while(j<strs[i].length() && j<prefix.length() && strs[i].charAt(j)==prefix.charAt(j)){
                j++;
            }
            prefix=prefix.substring(0,j);
            if(prefix.isEmpty()) return "";
        }
        return prefix;
    }
}


//better O(N*Log(N));
/*class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length - 1];
        int idx=0;
        while(idx<s1.length() && idx < s2.length()){
            if(s1.charAt(idx)==s2.charAt(idx)){
                idx++;
            }else{
                break;
            }
        }
        return s1.substring(0,idx);
    }
}
*/

//brute force approch
//O(N^2)
/*class Solution {
    public String longestCommonPrefix(String[] s) {
        int n = s.length;
        int mini = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int k = 0;
            for (int j = 0; j < s[i].length() && j < s[0].length(); j++) {
                if (s[i].charAt(j) != s[0].charAt(j)) {
                    break;
                } else {
                    k++;
                }
            }
            mini = Math.min(mini, k);
        }
        StringBuilder st = new StringBuilder();
        mini = Math.min(s[0].length(), mini);
        for (int i = 0; i < mini; i++) {
            st.append(s[0].charAt(i));
        }
        return st.toString();
    }
}*/