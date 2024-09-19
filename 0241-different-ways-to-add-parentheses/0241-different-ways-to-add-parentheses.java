class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < expression.length() ; i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                String p1= expression.substring(0 , i );
                String p2 = expression.substring(i+1);
                List<Integer> l1 = diffWaysToCompute(p1);
                List<Integer> l2 = diffWaysToCompute(p2);
                for(Integer p : l1){
                    for(Integer q : l2){
                        int cc = 0;
                        switch (expression.charAt(i)){
                            case '+' :
                            cc = p + q;
                            break;

                            case '-':
                            cc = p - q;
                            break;

                            case '*':
                            cc = p * q;
                            break; 
                        }
                        res.add(cc);
                    }
                }
            }
        }

        if(res.size()==0){
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}