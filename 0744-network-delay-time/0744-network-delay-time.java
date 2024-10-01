class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> list =new ArrayList<>();
        for(int i = 0 ; i <= n ; i++ ){
            list.add(new ArrayList<>());
        }

        for(int[] edge : times ){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            list.get(u).add(new Pair(v , t));
        }

        int time[]  = new int[n + 1];
        Arrays.fill(time , Integer.MAX_VALUE);
        time[k] = 0;
        Queue<Pair2> q = new LinkedList<>();
        q.add(new Pair2(k , 0));

        while(!q.isEmpty()){
            Pair2 pair = q.poll();
            int u = pair.u;
            int t = pair.t;

            for(Pair pp : list.get(u)){
                int vv = pp.v;
                int tt = pp.t;
                if(tt + t < time[vv]){
                    time[vv] = tt + t;
                    q.add(new Pair2(vv , time[vv]));
                }
            }
        }
        boolean ans = true;
        int maxi = 0;
        for(int i = 1  ;i <= n ; i++){
            if(time[i] == Integer.MAX_VALUE) ans = false;
            maxi = Math.max(maxi , time[i]);
        }

        return ans == true ? maxi : -1;
    }
}

class Pair{
    int v ;
    int t;
    Pair(int v , int t){
        this.v = v;
        this.t = t;
    }
}

class Pair2 {
    int u ;
    int t ;
    Pair2(int u , int t){
        this.u = u;
        this.t = t;
    }
}