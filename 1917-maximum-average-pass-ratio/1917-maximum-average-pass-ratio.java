class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));
        for(int i = 0 ; i  < n ; i++){
            pq.offer(new double[]{(-(1.0* classes[i][0] / classes[i][1])+ (1.0 * (classes[i][0] + 1 ) / (classes[i][1] + 1))), (int)i});
        }
        while(extraStudents-- > 0){
            double top[] = pq.poll();
            // double delta = top[0];
            // System.out.println(delta);
            int idx = (int) top[1];
            classes[idx][0]++;
            classes[idx][1]++;
            pq.offer(new double[]{(-(1.0* classes[idx][0] / classes[idx][1]) +  (1.0 * (classes[idx][0] + 1 ) / (classes[idx][1] + 1))), (int)idx});
        }

        double result = 0.0;
        for(int i =  0 ; i < n ; i++){
            result += (1.0 * classes[i][0] / classes[i][1]);
        }
        return result / n;
    }
}

/*class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        double pr[] = new double[n];

        for(int i = 0 ; i < n ; i++){
            pr[i] = (double)classes[i][0] / classes[i][1];
        }

        while(extraStudents-- > 0){
            double upPr[] = new double[n];

            for(int i = 0 ; i < n ; i++){
                upPr[i] = (double) (classes[i][0] + 1)/ (classes[i][1]+1);
            }

            int bestClassIdx = 0;
            double bestDelta = 0.0;
            for(int i = 0 ; i < n ; i++){
                double delta = upPr[i] - pr[i];
                if(delta > bestDelta){
                    bestDelta = delta;
                    bestClassIdx = i;
                }
            }
            pr[bestClassIdx] = upPr[bestClassIdx];
            classes[bestClassIdx][0]++;
            classes[bestClassIdx][1]++;
        }

        double ans = 0.0;
        for(int i = 0 ; i <  n ; i++){
            ans += pr[i];
        }
        return ans / n;
    }
} */