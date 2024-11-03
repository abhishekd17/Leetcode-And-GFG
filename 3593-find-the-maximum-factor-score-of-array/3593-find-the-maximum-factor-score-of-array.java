class Solution {
    public long maxScore(int[] nums) {
        int n = nums.length;
        List<Long> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            list.add((long)nums[i]);
        }

        return factorScore(list);
    }

    private long lcm(long a , long b){
        return (a / gcd(a , b)) * b;
    }

    private long gcd(long a  , long b){
        if(b == 0) return a;
        return gcd(b , a % b);
    }

    private long lcmOfList(List<Long> list){
        if (list.isEmpty()) return 0;
        long lc = list.get(0);
        for(int i = 1 ;i < list.size(); i++){
            lc = lcm(lc , list.get(i));
        }
        return lc;
    }

    private long gcdOfList(List<Long> list){
        if(list.isEmpty()) return 0;
        long gc = list.get(0);
        for(int i = 1 ; i < list.size() ; i++){
            gc = gcd(gc , list.get(i));
        }
        return gc;
    }

    private long factorScore(List<Long> list){
        long maxi = gcdOfList(list) * lcmOfList(list);
        for(int i = 0 ; i < list.size() ;  i++){
            List<Long> temp = new ArrayList<>(list);
            temp.remove(i);

            long lc = 1;
            if(!temp.isEmpty()){
                lc = lcmOfList(temp);
            }
            long gc = 1;
            if(!temp.isEmpty()){
                gc = gcdOfList(temp);
            }
            maxi = Math.max(maxi , lc * gc);

        }
        return maxi;
    }
}