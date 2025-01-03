class Solution {
    public int repeatedStringMatch(String a, String b) {
        int cnt = 1;
        String s = a;
        while (a.length() < b.length()) {
            cnt++;
            a += s;
        }
        if(a.contains(b)) return cnt;
        a += s;
        if(a.contains(b)) return ++cnt;
        return -1;
    }
}
/*class Solution {
    public int repeatedStringMatch(String a, String b) {
        int cnt = 1;
        String s = a;
        while (!a.contains(b)) {
            if (a.length() >= Math.pow(10,4)) { 
                return -1; 
            }
            cnt++;
            a += s;
        }

        return cnt;
    }
} */