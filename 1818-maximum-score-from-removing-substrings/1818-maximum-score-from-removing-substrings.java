class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0;
        // ab - > x
        // ba - > y
        int ss = 0;
        char c1 = 'a' , c2 = 'b';
        Stack<Character> st = new Stack<>();
        if(x > y){
            c1 = 'a';
            c2 = 'b';
            ss = x;
        }else{
            c1 = 'b';
            c2 = 'a';
            ss = y;
        }

        for(char c : s.toCharArray()){
            if(!st.isEmpty() && c == c2 && st.peek() == c1 ){
                st.pop();
                score += ss;
            }
            else st.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        if(x > y){
            c1 = 'b';
            c2 = 'a';
            ss = y;
        }else{
            c1 = 'a';
            c2 = 'b';
            ss = x;
        }
        String sbb = sb.toString();
        for(char c : sbb.toCharArray()){
            if(!st.isEmpty() && c == c2 && st.peek() == c1){
                st.pop();
                score += ss;
            }
            else st.push(c);
        }
        return score;
    }
}

// cdbcbbaaabab
// cdbcbbaaab 5
// cdbcbaab   10
// cdbcab     15
// cdbc       19

// c
// d
// b
// c
// a
// b
// 


// aabbaaxybbaabb 
// abaaxybbaabb 5
// aaxybbaabb   10
// aaxybbab     15
// aaxybb       20

//a a x y b b 
// 5 + 5 + 5 + 5