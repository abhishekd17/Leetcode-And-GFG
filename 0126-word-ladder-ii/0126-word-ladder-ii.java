class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Map<String , List<String>> pre = new HashMap<>();
        Map<String , Integer> visitedLevels = new HashMap<>();
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();

        // first case , if endword in not present in set
        if(!set.contains(endWord)) return ans;

        q.add(beginWord);
        visitedLevels.put(beginWord , 0);

        int level = 0;
        boolean foundEndWord = false;

        while(!q.isEmpty()){
            int size = q.size();
            level++;
            Set<String> visitedThisLevel = new HashSet<>();

            for(int i = 0 ; i < size ; i++){
                String word = q.poll();
                char arr[] = word.toCharArray();
                for(int j = 0 ; j < arr.length ; j++){
                    char original = arr[j];
                    for(char ch ='a' ; ch <= 'z' ; ch++){
                        arr[j] = ch;
                        String nextWord = new String(arr);
                        if(!set.contains(nextWord)) continue;

                        if(!visitedLevels.containsKey(nextWord)){
                            visitedThisLevel.add(nextWord);
                            q.add(nextWord);
                            visitedLevels.put(nextWord , level);
                        }

                        if(visitedLevels.get(nextWord) == level){
                            pre.computeIfAbsent(nextWord , k -> new ArrayList<>()).add(word);
                        }

                        if(nextWord.equals(endWord)) foundEndWord = true;
                    }
                    arr[j] = original;
                }
            }
        }

        if(foundEndWord){
            List<String> path = new ArrayList<>();
            backtrack(endWord , beginWord , pre , path , ans);
        }
        return ans;
    }

    private void backtrack(String curr , String beginWord ,Map<String , List<String>> pre, List<String> path ,List<List<String>> ans){
        path.add(curr);
        if(curr.equals(beginWord)){
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
        }else if(pre.containsKey(curr)){
            for(String p : pre.get(curr)){
                backtrack(p , beginWord , pre , path , ans);
            }
        }
        path.remove(path.size() - 1);
    }
}