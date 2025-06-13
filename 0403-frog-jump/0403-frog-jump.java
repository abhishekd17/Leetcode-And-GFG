class Solution {
    public boolean canCross(int[] stones) {
        Set<Integer> set = new HashSet<>();
        Set<String> s = new HashSet<>();
        for(int num : stones) set.add(num);
        return helper(set , 1 , 1 , stones[stones.length - 1] , s);
    }

    private boolean helper(Set<Integer> set , int pos , int jump , int target , Set<String> s){
        if(!set.contains(pos) || jump <= 0 || pos > target) return false;
        if(pos == target) return true;
        String key = pos + "$" + jump;
        if(s.contains(key)) return false;
        boolean s1 = helper(set , pos + jump - 1 , jump - 1 , target , s);
        boolean s2 = helper(set , pos + jump , jump , target , s);
        boolean s3 = helper(set , pos + jump + 1 , jump + 1 , target , s);
        s.add(key);
        return s1 || s2 || s3;
    }
}
