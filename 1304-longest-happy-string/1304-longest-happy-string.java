class Solution {
    public String longestDiverseString(int a, int b, int c) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> Integer.compare(q[1], p[1]));
        if(a > 0 ) pq.offer(new int[]{0 , a});
        if(b > 0 ) pq.offer(new int[]{1 , b});
        if(c > 0 ) pq.offer(new int[]{2 , c});
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1){
            int top1[] = pq.poll();
            int top2[] = pq.poll();
            if(top1[1] >= 2){
                sb.append(String.valueOf((char)('a' + top1[0])).repeat(2));
                top1[1] -= 2;
            }else{
                sb.append((char)('a' + top1[0]));
                top1[1] -= 1;
            }
            if(top2[1] >= 2 && top1[1] < top2[1]){
                sb.append((char)('a' + top2[0]));
                sb.append((char)('a' + top2[0]));
                top2[1] -= 2;
            }else{
                sb.append((char)('a' + top2[0]));
                top2[1] -= 1;
            }

            if(top1[1] > 0) pq.offer(top1);
            if(top2[1] > 0) pq.offer(top2);
        }

        if(!pq.isEmpty()){
            int top[] = pq.peek();
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) != (char)('a' + top[0])){
                if(top[1] >= 2){
                sb.append((char)('a' + top[0]));
                sb.append((char)('a' + top[0]));
                }else{
                sb.append((char)('a' + top[0]));
                }
            }else if(sb.length() == 0){
                if(top[1] >= 2){
                sb.append((char)('a' + top[0]));
                sb.append((char)('a' + top[0]));
                }else{
                sb.append((char)('a' + top[0]));
                }
            }
        }
        return sb.toString();
    }
}