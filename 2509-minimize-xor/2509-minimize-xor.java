class Solution {
    public int minimizeXor(int num1, int num2) {
        int x = Integer.bitCount(num1);
        int y = Integer.bitCount(num2);

        if(x == y) return num1;

        // convert num1 into binary rep
       StringBuilder sb = new StringBuilder(Integer.toBinaryString(num1));

        while (sb.length() < 32) {
            sb.insert(0, '0'); // Add leading zeros at the start
        }

        // x > y
        int i = sb.length() - 1 ;
        while(x > y){
            if(sb.charAt(i) == '1'){
                sb.setCharAt(i , '0');
                 x--;
            }
            i--;
        }
        // x < y
        i = sb.length() - 1 ;
        while(x < y){
            if(sb.charAt(i) == '0'){
                sb.setCharAt(i , '1');
                y--;    
            }
            i--;
        }

        int ans = Integer.parseInt(sb.toString() , 2);
        return ans;
    }
}