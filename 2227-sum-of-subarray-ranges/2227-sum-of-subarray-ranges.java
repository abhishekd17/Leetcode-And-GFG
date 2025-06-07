class Solution {
    private  int mod = 1000000007;

    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ple[] = new int[n];
        int nle[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            ple[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nle[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            long val = (arr[i] * left);
            val = (val * right);
            ans = ((ans + val));
        }

        int ple1[] = new int[n];
        int nle1[] = new int[n];
        st.clear();
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            ple1[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            nle1[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        long ans1 = 0;
        for (int i = 0; i < n; i++) {
            long left = i - ple1[i];
            long right = nle1[i] - i;
            long val = (arr[i] * left);
            val = (val * right);
            ans1 = ((ans1 + val));
        }
        return ans1 - ans;
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