class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        String s = new String(digits);

        Set<String> power_of_two = helper();
        return power_of_two.contains(s);
    }

    private Set<String> helper(){
        Set<String> set = new HashSet<>();
        int n = 1;
        while(n > 0){
            char[] digits = String.valueOf(n).toCharArray();
            Arrays.sort(digits);
            String s = new String(digits);
            n = n * 2;
            set.add(s);
        }
        return set;
    }
}