class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = order.length;
        Set<Integer> set = new HashSet<>();
        for(int friend : friends){
            set.add(friend);
        }
        int ans[] = new int[friends.length];
        int i = 0;
        for(int num : order){
            if(set.contains(num)){
                ans[i++] = num;
                set.remove(num); 
            }
        }
        return ans;
    }
}