class MyCalendarTwo {
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
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */