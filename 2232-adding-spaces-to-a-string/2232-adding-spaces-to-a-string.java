class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int m = spaces.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < m ; i++){
            set.add(spaces[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            if(set.contains(i)) sb.append(" ");
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

/*class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        for(int i =  0 ; i < s.length() ; i++){
            for(int j = 0 ; j < spaces.length ; j++){
                if(i == spaces[j]){
                    sb.append(" ");
                }
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
} */