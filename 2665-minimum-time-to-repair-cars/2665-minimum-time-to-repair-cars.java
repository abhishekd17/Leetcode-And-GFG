class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long l = 0; 
        long r = (long)1e14;

        while(l < r){
            long mid = l + (r - l) / 2 , rep_cars = 0;
            for(int rr : ranks){
                rep_cars += Math.sqrt(mid / rr); 
            }
            if(rep_cars < cars){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}