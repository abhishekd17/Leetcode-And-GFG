class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sum += n % 10;
            if(n % 10 != 0) sb.append(n % 10);
            n /= 10;
        }

        sb.reverse();
        long number = Long.parseLong(sb.toString());

        return sum * number;
    }
}