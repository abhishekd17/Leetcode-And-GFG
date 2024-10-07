class Solution {
    public int minLength(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && ((st.peek() == 'A' && ch == 'B') || (st.peek() == 'C' && ch == 'D'))){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        return st.size();
    }
}