class Solution {
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
}