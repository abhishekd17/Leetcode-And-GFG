class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= 9 ; i++){
            helper(i , n , list);
        }
        return list;
    }

    private void helper(int curr , int n , List<Integer> list){
        if(curr > n) return;
        list.add(curr);
        for(int i = 0 ; i < 10 ; i++){
            int next = curr * 10 + i;
            if(next <= n){
                helper(next , n , list);
            }
        }
    }
}