class DisjointSet{
    int parent[];
    int rank[];
    int size[];
    public DisjointSet(int n ){
        this.parent = new int[n];
        this.rank = new int[n];
        this.size =new int[n];
        
        for(int i = 0 ; i < n ; i++){
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }
    }
    int findParent(int node){
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }
    
    void unionByRank(int u , int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v) return;
        if(rank[ulp_u] > rank[ulp_v]){
            parent[ulp_v] = ulp_u;
        }else if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }else{
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
    }
    
    void unionBySize(int u , int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v) return ;
        
        if(size[ulp_u] > size[ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
    }
    
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String , Integer> map = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        for(int i =  0 ; i < n  ;i++){
            for(int j = 1 ; j < accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail , i);
                }else{
                    ds.unionBySize(i , map.get(mail));
                }
            }
        }

        List<List<String>> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }

        for(Map.Entry<String , Integer> it : map.entrySet()){
            String mail = it.getKey();
            int node = ds.findParent(it.getValue());
            list.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(list.get(i).size() == 0) continue;
            Collections.sort(list.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : list.get(i)){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}