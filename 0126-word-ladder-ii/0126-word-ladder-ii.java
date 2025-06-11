import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!wordSet.contains(endWord)) return result;

        // Map to store predecessors
        Map<String, List<String>> predecessors = new HashMap<>();
        Map<String, Integer> visitedLevels = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visitedLevels.put(beginWord, 0);

        int level = 0;
        boolean foundEndWord = false;

        while (!queue.isEmpty() && !foundEndWord) {
            int size = queue.size();
            level++;
            Set<String> visitedThisLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                char[] arr = word.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String nextWord = new String(arr);

                        if (!wordSet.contains(nextWord)) continue;

                        if (!visitedLevels.containsKey(nextWord)) {
                            visitedThisLevel.add(nextWord);
                            queue.add(nextWord);
                            visitedLevels.put(nextWord, level);
                        }

                        if (visitedLevels.get(nextWord) == level) {
                            predecessors.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(word);
                        }

                        if (nextWord.equals(endWord)) {
                            foundEndWord = true;
                        }
                    }
                    arr[j] = original;
                }
            }
        }

        if (foundEndWord) {
            List<String> path = new ArrayList<>();
            backtrack(endWord, beginWord, predecessors, path, result);
        }

        return result;
    }

    private void backtrack(String current, String beginWord, Map<String, List<String>> predecessors,
                           List<String> path, List<List<String>> result) {
        path.add(current);
        if (current.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
        } else if (predecessors.containsKey(current)) {
            for (String prev : predecessors.get(current)) {
                backtrack(prev, beginWord, predecessors, path, result);
            }
        }
        path.remove(path.size() - 1);
    }
}
