class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (String s : folder) {
            set.add(s);
        }

        for (String s : folder) {
            String temp = s;
            boolean isSubFolder = false;
            while (!s.isEmpty()) {
                int ind = 0;
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (s.charAt(i) == '/') {
                        ind = i;
                        break;
                    }
                }
                System.out.println(ind);
                s = s.substring(0, ind);
                System.out.println(s);
                if (set.contains(s)) {
                    isSubFolder = true;
                    break;
                }
            }
            if (isSubFolder == false) {
                list.add(temp);
            }
        }

        return list;
    }
}