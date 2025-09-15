class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" "); // Splits the input text into an array of words
        int typeableWordCount = words.length; // Initialize with the total number of words

        // Convert brokenLetters to a Set for efficient lookup (O(1) average time complexity)
        // Alternatively, a boolean array of size 26 can be used for lowercase English letters.
        java.util.Set<Character> brokenChars = new java.util.HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            brokenChars.add(c);
        }

        for (String word : words) { // Iterates through each word
            boolean wordIsBroken = false;
            for (char c : word.toCharArray()) { // Iterates through each character in the current word
                if (brokenChars.contains(c)) { // Checks if the character is a broken letter
                    wordIsBroken = true;
                    break; // If a broken letter is found, the word cannot be typed, so break and move to the next word
                }
            }
            if (wordIsBroken) {
                typeableWordCount--; // Decrement if the word contains a broken letter
            }
        }
        return typeableWordCount;
    }
}