class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] arr = new int[s.length() + 1];

        for(int[] shift : shifts){
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];

            if(dir == 1){
                arr[start]++;
                arr[end + 1]--;
            }else{
                arr[start]--;
                arr[end + 1]++;
            }
        }

        for(int i = 1 ; i < arr.length ; i++){
            arr[i] += arr[i - 1];
        }
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0 ; i < s.length() ; i++){
            int shift = (arr[i] % 26 + 26) % 26;
            sb.setCharAt(i , (char)('a' + (s.charAt(i) - 'a' + shift) % 26));
        }
        return sb.toString();
    }
}

/*class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        for(int[] shift : shifts){
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            for (int i = start; i <= end; i++) {
                if (direction == 0) {
                    chars[i] = (chars[i] == 'a') ? 'z' : (char) (chars[i] - 1);
                } else {
                    chars[i] = (chars[i] == 'z') ? 'a' : (char) (chars[i] + 1);
                }
            }
        }
        return new String(chars);
    }
} */