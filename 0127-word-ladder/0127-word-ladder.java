class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        q.add(new Pair(beginWord , 1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair pair=q.poll();
            String word=pair.s;
            int steps=pair.step;

            if(word.equals(endWord)) return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedArray[]=word.toCharArray();
                    replacedArray[i]=ch;
                    String replacedWord=new String(replacedArray);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord , steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String s;
    int step;
    Pair(String s, int step){
        this.s=s;
        this.step=step;
    }
}