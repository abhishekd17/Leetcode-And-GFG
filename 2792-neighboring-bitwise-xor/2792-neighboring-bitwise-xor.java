class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        if(isValid(derived , 0)) return true;
        if(isValid(derived , 1)) return true;
        return false;
    }
    private boolean isValid(int derived[] , int initial){
        int curr = initial ;
        int next ;

        for(int i = 0 ; i < derived.length ; i++){
            if(derived[i] == 0){
                next = curr;
            }else{
                next = curr ^ 1;
            }
            curr = next;
        }

        return curr == initial;
    }
    
}