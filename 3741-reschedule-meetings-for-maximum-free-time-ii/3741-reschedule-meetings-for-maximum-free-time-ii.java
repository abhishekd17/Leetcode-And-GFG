class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> list = new ArrayList<>();
        list.add(startTime[0]);
        for(int i = 0 ; i < n - 1; i++){
            list.add(startTime[i + 1] - endTime[i]);
        }
        list.add(eventTime - endTime[n - 1]);

        int leftMax[] = new int[list.size()];
        int rightMax[] = new int[list.size()];
        int size = list.size();
        
        for(int i = 1 ; i < size ; i++){
            leftMax[i] = Math.max(list.get(i - 1) , leftMax[i - 1]);
        }
        for(int i = size - 2 ; i >= 0 ; i--){
            rightMax[i] = Math.max(rightMax[i + 1] , list.get(i + 1));
        }

        for(int i = 0 ; i < size ; i++) System.out.println(list.get(i) + " " + leftMax[i] + " " + rightMax[i]);
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int req = endTime[i] - startTime[i];
            if(req <= Math.max(leftMax[i] , rightMax[i + 1])){
                ans = Math.max(ans , list.get(i) + req + list.get(i + 1));
            }
            ans = Math.max(ans ,list.get(i) + list.get(i + 1));
        }
        return ans;
    }
}