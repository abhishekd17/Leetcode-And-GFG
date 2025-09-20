class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for(int b[] : buildings){
            events.add(new int[]{b[0] , -b[2]});
            events.add(new int[]{b[1] , b[2]});
        }

        Collections.sort(events , (a , b) ->{
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int prev = 0;

        for(int e[] : events){
            int x = e[0];
            int h = e[1];

            if(h < 0){
                pq.add(-h);
            }else{
                pq.remove(h);
            }

            int currHeight = pq.peek();
            if(currHeight != prev){
                ans.add(Arrays.asList(x , currHeight));
                prev = currHeight;
            }
        }
        return ans;
    }
}