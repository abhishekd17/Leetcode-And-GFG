import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();

        // Neighbor indices for each position on the board
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Arrays.asList(1, 3));
        map.put(1, Arrays.asList(0, 2, 4));
        map.put(2, Arrays.asList(1, 5));
        map.put(3, Arrays.asList(0, 4));
        map.put(4, Arrays.asList(3, 1, 5));
        map.put(5, Arrays.asList(2, 4));

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.f));
        HashSet<String> visited = new HashSet<>();

        int h = heuristic(start, target); // Initial heuristic
        pq.offer(new State(start, 0, h)); // f = g + h
        visited.add(start);

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            // If we reach the target, return the number of moves (g)
            if (curr.board.equals(target)) {
                return curr.g;
            }

            int zeroIdx = curr.board.indexOf('0');
            for (int swapIdx : map.get(zeroIdx)) {
                StringBuilder nextBoard = new StringBuilder(curr.board);
                // Swap 0 with the neighboring position
                char temp = nextBoard.charAt(swapIdx);
                nextBoard.setCharAt(swapIdx, '0');
                nextBoard.setCharAt(zeroIdx, temp);
                String nextState = nextBoard.toString();

                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    int nextG = curr.g + 1; // Increment cost
                    int nextH = heuristic(nextState, target); // Compute heuristic
                    pq.offer(new State(nextState, nextG, nextG + nextH)); // Add to priority queue
                }
            }
        }
        return -1; // If the puzzle is unsolvable
    }

    // Heuristic function: Manhattan Distance
    private int heuristic(String state, String target) {
        int distance = 0;
        for (int i = 0; i < 6; i++) {
            if (state.charAt(i) != '0') { // Ignore the blank tile
                int val = state.charAt(i) - '1';
                distance += Math.abs(i / 3 - val / 3) + Math.abs(i % 3 - val % 3);
            }
        }
        return distance;
    }

    // State class to store board state, cost (g), and total cost (f)
    private static class State {
        String board;
        int g; // Cost to reach this state
        int f; // Total cost (g + h)

        State(String board, int g, int f) {
            this.board = board;
            this.g = g;
            this.f = f;
        }
    }
}
