class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int right = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(') right++;
            else if(right > 0) right--;
            else left++;
        }
        return left + right;
    }  
}

/*class Solution {
    public int minAddToMakeValid(String s) {
        int cnt= 0;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c =='(') st.push(c);
            else if (!st.isEmpty() && c == ')') st.pop();
            else if(st.isEmpty() && c ==')') cnt++;
        }
        return cnt + st.size();
    }
} */