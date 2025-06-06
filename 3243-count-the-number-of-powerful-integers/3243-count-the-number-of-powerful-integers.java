class Solution {
    private static final int MAX_DIGITS = 17;
    private long[][] dp;

    private boolean checkSubtract(String numStr, int numDigits, String suffix, int limit) {
        if (numDigits < suffix.length()) return false;

        String suffixOfNum = numStr.substring(numDigits - suffix.length());
        boolean subtract = Long.parseLong(suffixOfNum) < Long.parseLong(suffix);

        if (subtract) {
            for (int i = 0; i < numDigits - suffix.length(); ++i) {
                if ((numStr.charAt(i) - '0') > limit) {
                    subtract = false;
                    break;
                }
            }
        }
        return subtract;
    }

    private long countValidNumbers(String numberStr, int idx, int maxDigits, 
                                  boolean isTight, int limit, String suffix) {
        if (idx == maxDigits) return 1;
        if (dp[idx][isTight ? 1 : 0] != -1) return dp[idx][isTight ? 1 : 0];

        int low, high;
        int suffixLen = suffix.length();

        if (idx >= maxDigits - suffixLen) {
            int suffixIdx = idx - (maxDigits - suffixLen);
            low = high = suffix.charAt(suffixIdx) - '0';
        } else {
            high = isTight ? Math.min(limit, numberStr.charAt(idx) - '0') : limit;
            low = 0;
        }

        long total = 0;
        for (int digit = low; digit <= high; ++digit) {
            boolean newTight = isTight && (digit == numberStr.charAt(idx) - '0');
            total += countValidNumbers(numberStr, idx + 1, maxDigits, newTight, limit, suffix);
        }

        dp[idx][isTight ? 1 : 0] = total;
        return total;
    }

    private long solveUpTo(String numStr, int numDigits, int limit, String suffix) {
        dp = new long[MAX_DIGITS][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        long result = countValidNumbers(numStr, 0, numDigits, true, limit, suffix);
        if (checkSubtract(numStr, numDigits, suffix, limit)) {
            result--;
        }
        return result;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String suffix) {
        long suffixVal = Long.parseLong(suffix);
        String finishStr = Long.toString(finish);
        String startStr = Long.toString(start - 1);

        int finishDigits = finishStr.length();
        int startDigits = startStr.length();

        long uptoFinish = (finish >= suffixVal) ? solveUpTo(finishStr, finishDigits, limit, suffix) : 0;
        long uptoStart = (suffixVal < start) ? solveUpTo(startStr, startDigits, limit, suffix) : 0;

        return uptoFinish - uptoStart;
    }
}


/*class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        int x = Integer.parseInt(s);
        int a = numberOfDigits(finish);
        int b = numberOfDigits(x);

        int diff = a - b;
        if(diff <= 0) return 0;

        long l = (long) Math.pow(10 , diff) - 1;

        long ans = 0;
        // System.out.println(a + " " + b + " " + diff + " " + l);
        for(long i = 0 ; i <= l ; i++){
            String prefix = String.format("%0" + diff + "d" , i);
            String numStr = prefix + s;
            long num = Long.parseLong(numStr);
            // System.out.println(numStr + " " + num);
            if(num >= start && num <= finish && isValid(num , limit)){
                ans++;
            }
        }
        return ans;
    }

    private int numberOfDigits(long x){
        int cnt = 0;
        while(x > 0){
            x /= 10;
            cnt++;
        }
        return cnt;
    }

    private boolean isValid(long num , int limit){

        while(num > 0){
            int digit = (int)(num % 10);
            if(digit > limit) return false;
            num /= 10;
        }
        return true;
    }
} */