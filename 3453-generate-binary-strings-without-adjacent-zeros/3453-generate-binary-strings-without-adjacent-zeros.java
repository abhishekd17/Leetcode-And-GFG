class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        helper(n , ans , -1 , new StringBuilder());
        return ans;
    }
    private void helper(int n , List<String> ans , int prev , StringBuilder sb){
        if(n == 0){
            ans.add(sb.toString());
            return;
        }
        sb.append("1");
        helper(n - 1 , ans , 1 , sb);
        sb.deleteCharAt(sb.length() - 1);

        if(prev != 0){
            sb.append("0");
            helper(n - 1 , ans , 0 , sb );
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}