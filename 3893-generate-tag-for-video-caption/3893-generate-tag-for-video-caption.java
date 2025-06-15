class Solution {
    public String generateTag(String s) {
        s = s.trim();
        System.out.println(s);

        StringBuilder sb = new StringBuilder();
        sb.append("#");

        boolean capitalizeNext = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                if (sb.length() == 1) {
                    sb.append(Character.toLowerCase(c)); 
                } else if (capitalizeNext) {
                    sb.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true; 
            }
        }

        if (sb.length() > 100) {
            return sb.substring(0, 100);
        }

        return sb.toString();
    }
}
