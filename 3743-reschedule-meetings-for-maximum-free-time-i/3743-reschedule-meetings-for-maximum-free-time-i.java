class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> list = new ArrayList<>();
        int n = startTime.length;
        if(startTime[0] != 0) list.add(startTime[0]);
        for(int i = 1 ; i < n ; i++){
            list.add((startTime[i] - endTime[i - 1]));
        }
        if((eventTime - endTime[n - 1] )!= 0) list.add(eventTime - endTime[n - 1] );

        int i = 0 , j = 0;
        int maxi = 0 , sum = 0;
        while(j < list.size()){
            sum += list.get(j);
            if(j - i + 1 > k + 1){
                sum -= list.get(i);
                i++;
            }
            maxi = Math.max(maxi , sum);
            j++;
        }
        return maxi;
    }
}