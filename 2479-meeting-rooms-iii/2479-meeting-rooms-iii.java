class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int x = meetings.length;
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // PriorityQueue: [endTime (long), roomIndex]
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return Long.compare(a[0], b[0]);
                return Long.compare(a[1], b[1]);
            }
        );

        int[] freq = new int[n];
        Set<Integer> usedRoom = new HashSet<>();

        for (int i = 0; i < x; i++) {
            long start = meetings[i][0];
            long end = meetings[i][1];

            // Free up rooms that have completed before this meeting starts
            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                long[] finished = pq.poll();
                usedRoom.remove((int) finished[1]);
            }

            // Try to assign meeting to a free room
            boolean assigned = false;
            for (int j = 0; j < n; j++) {
                if (!usedRoom.contains(j)) {
                    pq.offer(new long[]{end, j});
                    freq[j]++;
                    usedRoom.add(j);
                    assigned = true;
                    break;
                }
            }

            // If no room is free, wait for the earliest one to finish
            if (!assigned) {
                long[] nextAvailable = pq.poll();
                long delay = nextAvailable[0];
                int room = (int) nextAvailable[1];
                long newEnd = delay + (end - start); // Use long for safety
                pq.offer(new long[]{newEnd, room});
                freq[room]++;
                usedRoom.add(room); // also add back to usedRoom
            }
        }

        int maxi = 0, maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] > maxCount ) {
                maxCount = freq[i];
                maxi = i;
            }
        }

        return maxi;
    }
}
