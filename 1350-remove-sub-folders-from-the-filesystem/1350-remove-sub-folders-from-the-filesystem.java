class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (String s : folder)
            set.add(s);

        for (String s : folder) {
            String temp = s;
            boolean isFolder = false;

            int ind = 0;
            while (!s.isEmpty()) {
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (s.charAt(i) == '/') {
                        ind = i;
                        break;
                    }
                }

                s = s.substring(0, ind);
                if (set.contains(s)) {
                    isFolder = true;
                    break;
                }
            }

            if (!isFolder) {
                list.add(temp);
            }
        }
        return list;
    }
}