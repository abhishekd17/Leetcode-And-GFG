class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        int n1 = sentence1.length();
        int n2 = sentence2.length();
        String big = "";
        String sh = "";
        if(n1 > n2){
            big = sentence1;
            sh = sentence2;
        }else{
            big = sentence2;
            sh = sentence1;
        }

        String s[] = big.split(" ");
        String t[] = sh.split(" ");
        int i = 0;
        int j = 0;
        while(i < s.length && j < t.length && s[i].equals(t[j])){
            i++;
            j++;
        }

        if(j == t.length) return true;
        j = t.length - 1;
        int k = s.length - 1; 
        while(i >= 0 && j >= 0 && s[k].equals(t[j])){
            k--;
            j--;
        }
        return j < i;
    }
}