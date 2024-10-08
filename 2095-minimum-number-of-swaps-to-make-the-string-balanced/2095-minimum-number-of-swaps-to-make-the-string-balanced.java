class Solution {
    public int minSwaps(String s) {
        int ans = 0;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '[') st.push(c);
            else{
                if(!st.isEmpty()) st.pop();
                else ans++;
            }
        }
        return (ans + 1) / 2;

    }
}

/*class Solution {
    public int minSwaps(String s) {
     int n = s.length();
     int ans = 0;
     int closing = 0;
     int opening = 0;
     for(int i = 0 ; i < n ; i++){
        if(s.charAt(i) == '['){
            opening++;
        }else{
            closing++;
        }
        if(closing > opening){
            ans++;
            closing--;
            opening++;
        }
     }   
     return ans;
    }
} */