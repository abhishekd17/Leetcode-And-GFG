class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, maxLen = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n;j++) {
                int len = 2;
                int prev = arr[i];
                int curr = arr[j];
                while(true){
                    int next = prev + curr;
                    if (map.containsKey(next)) {
                        len++;
                        prev = curr;
                        curr = arr[map.get(next)];
                    }
                    else{
                        break;
                    }
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen >= 3 ? maxLen : 0;
    }
}