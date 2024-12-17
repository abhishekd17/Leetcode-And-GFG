class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int freq[] = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        int i = 25 ;
        StringBuilder sb = new StringBuilder();
        while(i >= 0){
            if(freq[i] == 0){
                i--;
                continue;
            }

            char ch = (char)(i + 'a');
            int f = Math.min(freq[i] , repeatLimit);

            sb.append(String.valueOf(ch).repeat(f));
            freq[i] -= f;
            if(freq[i] > 0){
                int j = i - 1;
                while(j >= 0 && freq[j] == 0){
                    j--;
                }
                if(j < 0 ) break;
                sb.append((char) ('a' + j));
                freq[j]--; 
            }
        }
        return sb.toString();
    }
}

/*class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> pq1 = new PriorityQueue<>((x , y) -> y- x);
        PriorityQueue<Character> pq2 = new PriorityQueue<>((x , y) -> y - x);
        for(char ch : s.toCharArray()){
            pq1.offer(ch);
        }

        char prev = pq1.peek();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while(!pq1.isEmpty()){
            // System.out.println(sb);
            int x = 0;
            while(!pq2.isEmpty() && prev != pq2.peek() &&  x < repeatLimit){
                sb.append(pq2.poll());
                x++;
                cnt = 0;
            }
            char ch = pq1.poll();
            if(cnt  < repeatLimit && prev == ch){
                sb.append(ch);
                cnt++;
            }else if(prev != ch){
                sb.append(ch);
                cnt = 1;
                prev = ch;
            }
            else if(cnt >= repeatLimit){
                pq2.offer(ch);
            }
        }
        int y = 0;
        while(!pq2.isEmpty()){
            if(prev != pq2.peek() && y < repeatLimit){
                sb.append(pq2.poll());
                y++;
            }else{
                break;
            }
        }
        return sb.toString();
    }
} */