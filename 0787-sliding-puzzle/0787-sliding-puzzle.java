class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sbb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sbb.append(board[i][j]);
            }
        }
        String s = sbb.toString();

        Queue<String> q = new LinkedList<>();
        q.offer(s);
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        map.put(0, new ArrayList<>(Arrays.asList(1, 3)));
        map.put(1, new ArrayList<>(Arrays.asList(0, 2, 4)));
        map.put(2, new ArrayList<>(Arrays.asList(1, 5)));
        map.put(3, new ArrayList<>(Arrays.asList(0, 4)));
        map.put(4, new ArrayList<>(Arrays.asList(3, 1, 5)));
        map.put(5, new ArrayList<>(Arrays.asList(2, 4)));

        HashSet<String> vis = new HashSet<>();
        vis.add(s);
        int level = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                String curr = q.poll();
                if (curr.equals(target)) {
                    return level;
                }
                int idx = curr.indexOf('0');
                for (int swapIdx : map.get(idx)) {
                    StringBuilder sb = new StringBuilder(curr);
                    char temp = curr.charAt(idx);
                    sb.setCharAt(idx, sb.charAt(swapIdx));
                    sb.setCharAt(swapIdx, temp);
                    String newCurr = sb.toString();
                    if (!vis.contains(newCurr)) {
                        q.offer(newCurr);
                        vis.add(newCurr);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}