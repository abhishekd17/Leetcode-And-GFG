import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); // holds heights, monotonic decreasing (top = nearest)

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            // pop all shorter people: each popped person is visible to i
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                count++;
            }
            // if any person remains, that person is taller/equal and visible (one more)
            if (!stack.isEmpty()) count++;
            res[i] = count;
            // push current person to be a candidate for left-side people
            stack.push(heights[i]);
        }

        return res;
    }
}
