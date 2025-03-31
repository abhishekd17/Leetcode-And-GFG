class Solution {
    final int mod = (int) 1e9 + 7;
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int score[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            score[i] = primeScore(nums.get(i));
        }

        int nextGreater[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && score[st.peek()] <= score[i]){
                st.pop();
            }
            nextGreater[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        int prevGreater[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && score[st.peek()] < score[i]){
                st.pop();
            }
            prevGreater[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        long sub[] = new long[n];

        for(int i = 0 ; i < n ; i++){
            sub[i] = (long)(nextGreater[i] - i) * (i - prevGreater[i]);
        }

        int sortNums[][] = new int[n][2];

        for(int i = 0 ; i < n ; i++){
            sortNums[i][0] = nums.get(i);
            sortNums[i][1] = i;
        }

        Arrays.sort(sortNums , (a,b) -> b[0] - a[0]);

        long ans = 1;
        int idx = 0;
        while(k > 0 && idx < n){
            int val = sortNums[idx][0];
            int ind = sortNums[idx][1];
            long operations = Math.min((long) k , sub[ind]);
            ans = (ans * pow(val , operations)) % mod;
            k -= operations;
            idx++;
        }
        return (int)ans % mod;
    }
    private int primeScore(int x) {
        if (x <= 1) return 0;
        Set<Integer> primes = new HashSet<>();
        while (x % 2 == 0) {
            primes.add(2);
            x /= 2;
        }
        for (int i = 3; i <= Math.sqrt(x); i += 2) {
            while (x % i == 0) {
                primes.add(i);
                x /= i;
            }
        }
        if (x > 2) primes.add(x);
        return primes.size();
    }

    private long pow(long x , long n){
        if(n == 0 ) return 1;
        long ans = 1;
        while(n > 0){
            if(n % 2 == 1){
                ans = (ans * x) % mod;
                n--;
            }else{
                x = (x * x) % mod;
                n /= 2;
            }
        }
        return ans;
    }
}

// brute force but somewhat wrong
/*class Solution {
    int mod = 1000000007;
    
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] score = new int[n];
        
        for (int i = 0; i < n; i++) {
            score[i] = primeScore(nums.get(i));
            System.out.println(score[i]);
        }
        
        int[][] elements = new int[n][2];
        for (int i = 0; i < n; i++) {
            elements[i][0] = nums.get(i);  
            elements[i][1] = i;            
        }
        
        Arrays.sort(elements, (a, b) -> b[0] - a[0]);
        
        int ans = 1;
        int operations = 0;
        
        for (int i = 0; i < k && operations < k; i++) {
            int val = elements[i][0];
            int idx = elements[i][1];
            int currentPrime = score[idx];
            
            int left = idx;
            while (left > 0 && score[left-1] < currentPrime) {
                left--;
            }
            
            int right = idx;
            while (right < n-1 && score[right+1] <= currentPrime) {
                right++;
            }
            
            // ans = (ans * val) % mod;
            // operations++;
            
            if (operations < k) {
                for (int j = left ; j <= right && operations < k; j++) {
                    if (score[j] >= currentPrime) {
                        ans = (ans * val) % mod;
                        operations++;
                    }
                }
            }
        }
        
        return ans % mod;
    }
    
    private int primeScore(int x) {
        if (x <= 1) return 0;
        Set<Integer> primes = new HashSet<>();
        while (x % 2 == 0) {
            primes.add(2);
            x /= 2;
        }
        for (int i = 3; i <= Math.sqrt(x); i += 2) {
            while (x % i == 0) {
                primes.add(i);
                x /= i;
            }
        }
        if (x > 2) primes.add(x);
        return primes.size();
    }
} */