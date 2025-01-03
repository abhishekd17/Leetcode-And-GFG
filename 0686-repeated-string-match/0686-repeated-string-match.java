class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = b.length() / a.length();
        int cnt = n;
        StringBuilder sb = new StringBuilder();

        while(cnt-- > 0){
            sb.append(a);
        }

        if(sb.toString().contains(b)) return n;
        sb.append(a);
        if(sb.toString().contains(b)) return n + 1;
        sb.append(a);
        if(sb.toString().contains(b)) return n + 2;
        return -1;
    }
}

// class Solution {
//     public int repeatedStringMatch(String a, String b) {
//         int cnt = 1;
//         String s = a;
//         while (a.length() < b.length()) {
//             cnt++;
//             a += s;
//         }
//         if(a.contains(b)) return cnt;
//         a += s;
//         if(a.contains(b)) return ++cnt;
//         return -1;
//     }
// }
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