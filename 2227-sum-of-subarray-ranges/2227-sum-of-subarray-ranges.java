class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;

        // Subarray min contribution
        long minSum = 0;
        Stack<Integer> st = new Stack<>();
        int[] ple = new int[n];
        int[] nle = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            ple[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nle[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            minSum += (long) arr[i] * left * right;
        }

        // Subarray max contribution
        st.clear();
        long maxSum = 0;
        int[] pge = new int[n];
        int[] nge = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            maxSum += (long) arr[i] * left * right;
        }

        return maxSum - minSum;
    }
}



// jai maa saraswati
// brute force 
/*class Solution {
    public long subArrayRanges(int[] arr) {
         int n = arr.length;
         long total = 0;
        int mod=1000000007;
        for (int i = 0; i < n; i++) {
            int mini = Integer.MAX_VALUE;
            int maxi=Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                mini = Math.min(mini, arr[j]);
                maxi= Math.max(maxi, arr[j]);

                total = total + (maxi-mini);
            }
        }
        return total;
    }
}*/