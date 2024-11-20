class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int ans = 0;
        int freq[] = new int[3];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        if(freq[0] < k || freq[1] < k || freq[2] < k)  return -1;

        int i = 0 , j = 0;

        while(i < n && j < n){
            freq[s.charAt(j) - 'a']--;
            j++;
            while(freq[0] < k || freq[1] < k || freq[2] < k) {
                freq[s.charAt(i) - 'a']++;
                i++;
            }
            if(freq[0] >= k && freq[1] >= k && freq[2] >= k){
                ans = Math.max(ans ,j - i + 1);
            }
        }
        return  n - ans + 1;
    }
}

/*class Solution {
    int result = Integer.MAX_VALUE;

    public int takeCharacters(String s, int k) {
        int n = s.length();
        int min = 0;
        int i = 0;
        int j = n - 1;

        // Pre-check: Count total occurrences of 'a', 'b', and 'c' in the string
        int[] count = new int[3];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        if (count[0] < k || count[1] < k || count[2] < k) {
            return -1; // Not possible to satisfy the condition
        }

        helper(s, k, 0, i, j, new int[3]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void helper(String s, int k, int min, int i, int j, int[] counts) {
        // Base case: If all counts satisfy the condition
        if (counts[0] >= k && counts[1] >= k && counts[2] >= k) {
            result = Math.min(min, result);
            return; // Stop further recursion
        }

        // Base case: Out of bounds
        if (i > j) return;

        // Recursive case: Take character from the left
        counts[s.charAt(i) - 'a']++;
        helper(s, k, min + 1, i + 1, j, counts);
        counts[s.charAt(i) - 'a']--; // Backtrack for next recursive call

        // Recursive case: Take character from the right
        counts[s.charAt(j) - 'a']++;
        helper(s, k, min + 1, i, j - 1, counts);
        counts[s.charAt(j) - 'a']--; // Backtrack for next recursive call
    }
}
 */