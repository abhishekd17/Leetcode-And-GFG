/*class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0] , b[0]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0] , a[0]));
        int i = 0;
        int j = 0;
        while(j < n ){
            minHeap.add(new int[]{nums[j] , j});
            maxHeap.add(new int[]{nums[j] , j});
            while (Math.abs(maxHeap.peek()[0] - minHeap.peek()[0]) > 2) {
                i++;

                while (!maxHeap.isEmpty() && maxHeap.peek()[1] < i) {
                    maxHeap.poll();
                }

                while (!minHeap.isEmpty() && minHeap.peek()[1] < i) {
                    minHeap.poll();
                }
            }

            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}*/

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;

        Deque<Integer> maxDeque = new ArrayDeque<>(); // Stores indices of max values
        Deque<Integer> minDeque = new ArrayDeque<>(); // Stores indices of min values

        int i = 0;
        for (int j = 0; j < n; j++) {
            // Maintain the max deque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[j]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(j);

            // Maintain the min deque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[j]) {
                minDeque.pollLast();
            }
            minDeque.addLast(j);

            // Shrink the window if condition is violated
            while (Math.abs(nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()]) > 2) {
                i++;
                if (maxDeque.peekFirst() < i) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < i) {
                    minDeque.pollFirst();
                }
            }

            // Add the number of valid subarrays ending at `j`
            ans += j - i + 1;
        }

        return ans;
    }
}



/*class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int i = 0;
        int j = 0;
        TreeMap<Integer , Integer> map = new TreeMap<>();
        while(j < n ){
            map.put(nums[j] , map.getOrDefault(nums[j] , 0 ) + 1);
            while(Math.abs(map.lastKey() - map.firstKey()) > 2) {
                map.put(nums[i] , map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}*/

/*class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = n;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - 1; j++) {
                boolean isValid = true;
                for (int k = i; k <= j; k++) {
                    if (Math.abs(nums[k] - nums[j + 1]) > 2) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
 */