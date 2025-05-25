class Solution {
    public int longestPalindrome(String[] words) {
        int n = words.length;

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int ans = 0;
        boolean flag = true;

        for (String word : words) {
            String s = new StringBuilder(word).reverse().toString();
            int cnt = Math.min(map.getOrDefault(word, 0), map.getOrDefault(s, 0));

            if (!word.equals(s)) {
                ans += cnt * 4;
                map.put(word, map.getOrDefault(word, 0) - cnt);
                map.put(s, map.getOrDefault(s, 0) - cnt);
                if (map.get(word) == 0)
                    map.remove(word);
                if (map.get(s) == 0)
                    map.remove(s);

            } else if (map.getOrDefault(word, 0) > 0) {
                // word is a palindrome like "aa"
                int count = map.get(word);
                ans += (count / 2) * 4;
                if (count % 2 == 1 && flag) {
                    ans += 2;
                    flag = false;
                }
                map.put(word, 0);
            }
        }

        return ans;
    }
}
