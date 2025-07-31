class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> ans = new HashSet<>();
        Set<Integer> curr = new HashSet<>();

        for(int x : arr){
            Set<Integer> next = new HashSet<>();
            next.add(x);
            for(int y : curr){
                next.add(x | y);
            }
            curr = next;
            ans.addAll(curr);
        }
        return ans.size();
    }
}