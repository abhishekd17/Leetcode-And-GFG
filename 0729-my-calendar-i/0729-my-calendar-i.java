class MyCalendar {
    Map<Integer , Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int sum = 0;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            sum += entry.getValue();
            if(sum > 1){
                map.put(start , map.get(start) - 1);
                map.put(end , map.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}
/*class MyCalendar {
    List<int[]> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] l : list){
            if(Math.max(start , l[0]) < Math.min(end , l[1])) return false;
        }
        list.add(new int[]{start , end});
        return true;
    }
}*/

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */ 