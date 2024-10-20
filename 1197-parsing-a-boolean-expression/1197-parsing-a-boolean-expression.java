class Solution {
    public boolean parseBoolExpr(String e) {
        Stack<Character> stack = new Stack<>();
        
        
        for(char c : e.toCharArray()){
            if(c != ')' && c != ','){
                stack.push(c);
            }else if(c == ')'){
                Set<Character> set  = new HashSet<>();
                while(stack.peek() != '(' && !stack.isEmpty()){
                    set.add(stack.pop());
                }
                stack.pop();

                char op = stack.pop();

                if(op == '|'){
                    stack.push(set.contains('t') ? 't' : 'f');
                }else if(op == '&'){
                    stack.push(set.contains('f') ? 'f' : 't');
                }else if(op == '!' ){
                    stack.push(set.contains('t') ? 'f' : 't');
                }
                
            }
        }
        return stack.peek()=='t';
    }
}