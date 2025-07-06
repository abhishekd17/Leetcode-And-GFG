class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.x != b.x)
                return Integer.compare(a.x, b.x);
            return a.s.compareTo(b.s); 
        });
        for (int i = 0; i < n; i++) {
            if (isActive[i] && code[i].matches("[A-Za-z0-9_]+")) {
                if (businessLine[i].equals("electronics"))
                    pq.offer(new Pair(code[i], 0));
                else if (businessLine[i].equals("grocery"))
                    pq.offer(new Pair(code[i], 1));
                else if (businessLine[i].equals("pharmacy"))
                    pq.offer(new Pair(code[i], 2));
                else if (businessLine[i].equals("restaurant"))
                    pq.offer(new Pair(code[i], 3));
                else
                    continue;
            }
        }
        List<String> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            String s = pair.s;
            list.add(s);
        }
        return list;
    }
}

class Pair {
    String s;
    int x;

    Pair(String s, int x) {
        this.s = s;
        this.x = x;
    }
}