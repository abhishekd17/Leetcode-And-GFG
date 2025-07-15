class Solution {
    private Set<Character> set = new HashSet<>();

    public Solution() {
        for (char ch = 'A'; ch <= 'Z'; ch++) set.add(ch);
        for (char ch = 'a'; ch <= 'z'; ch++) set.add(ch);
        for (int i = 0; i <= 9; i++) set.add((char)('0' + i));
    }

    public boolean isValid(String word) {
        return length(word) && letters(word) && oneVowel(word) && hasConsonant(word);
    }

    private boolean length(String word) {
        return word.length() >= 3;
    }

    private boolean letters(String word) {
        for (char ch : word.toCharArray()) {
            if (!set.contains(ch)) return false;
        }
        return true;
    }

    private boolean oneVowel(String s) {
        for (char ch : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(ch) >= 0) return true;
        }
        return false;
    }

    private boolean hasConsonant(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch) && "aeiouAEIOU".indexOf(ch) == -1) {
                return true;
            }
        }
        return false;
    }
}
