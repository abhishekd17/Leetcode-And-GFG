//Jai Maa Saraswati
// class Solution {
//     public String reverseWords(String s) {
//         int n=s.length();
        
//     }
// }
// 1. reverse
// 2. reverseWordsInplce
// 3. cleanSpaces


class Solution {
    public String reverseWords(String s) {
        StringBuilder result=new StringBuilder();
        String[] words=s.trim().split("\\s+");
        for(int i=words.length - 1 ;i>=0 ;i--){
            result.append(words[i]);
            if(i>0){
                result.append(' ');
            }
        }
        return result.toString();
    }
}


/*class Solution {
    public String reverseWords(String s) {
        String str=s.trim();
        StringBuilder helper=new StringBuilder();
        StringBuilder result=new StringBuilder();

        int n=str.length();
        Stack<String> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(ch!=' '){
                helper.append(ch);
            }
            if(ch==' '){
                if(helper.length()>0){
                    st.push(helper.toString());
                    helper.setLength(0);
                }
            }
        }
        if(helper.length()>0){
            st.push(helper.toString());
        }
        while(!st.isEmpty()){
            result.append(st.pop());
            if(!st.isEmpty()){
                result.append(' ');
            }
        }
       return  result.toString();
    }
}*/