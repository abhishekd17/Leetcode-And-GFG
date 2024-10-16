class Solution {
    public boolean isHappy(int n) {
        Set<Long> set = new HashSet<>();

        long nn = (long) n;

        while(nn != 1 && !set.contains(nn)){
            set.add(nn);
            long sum = 0;
            while(nn > 0){
                long digit = nn % 10;
                sum += (digit * digit);
                nn /= 10;
            }

            nn = sum;
        }

        if(nn == 1) return true;
        return false;
    }
}