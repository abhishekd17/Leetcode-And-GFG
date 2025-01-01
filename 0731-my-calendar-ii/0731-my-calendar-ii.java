class MyCalendarTwo {
    TreeMap<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int sum = 0;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            sum += entry.getValue();
            if(sum > 2){
                map.put(start , map.get(start) - 1);
                map.put(end , map.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */

 /*class MyCalendarTwo {
    private List<int[]> Single;
    private List<int[]> Double;
    public MyCalendarTwo() {
        Single = new ArrayList<>();
        Double = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] b : Double){
            if(Math.max(b[0] , start ) < Math.min(b[1] , end)) return false;
        }

        for(int[] b : Single){
            if(Math.max(b[0] , start ) < Math.min(b[1] , end)){
                Double.add(new int[]{Math.max(b[0] , start) , Math.min(b[1] , end)});
            }
        }
        Single.add(new int[]{start , end});
        return true;
    }
}*/

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */