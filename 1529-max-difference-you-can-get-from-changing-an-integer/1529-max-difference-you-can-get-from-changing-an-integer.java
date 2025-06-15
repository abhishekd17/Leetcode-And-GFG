class Solution {
    public int maxDiff(int num) {
        String ss = num + "";
        StringBuilder s = new StringBuilder(ss);

        // First: maximize the number by replacing one digit to 9
        char c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                c = s.charAt(i);
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c && c != 0) {
                s.setCharAt(i, '9');
            }
        }

        int x = Integer.parseInt(s.toString());

        // Second: minimize the number by replacing one digit to 0 (or 1 if it's the first digit)
        s = new StringBuilder(ss);
        c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) != '1') {
                c = s.charAt(i);
                break;
            }
            if (i != 0 && s.charAt(i) != '0' && s.charAt(i) != s.charAt(0)) {
                c = s.charAt(i);
                break;
            }
        }

        char replaceChar = (s.charAt(0) == c) ? '1' : '0';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c && c != 0) {
                s.setCharAt(i, replaceChar);
            }
        }

        int y = Integer.parseInt(s.toString());
        return x - y;
    }
}
