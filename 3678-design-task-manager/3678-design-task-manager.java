class TaskManager {

    class task{
        int uid;
        int tid;
        int pri;
        task(int uid,  int tid , int pri){
            this.uid = uid;
            this.tid = tid;
            this.pri = pri;
        }
    }
    
    TreeSet<task> pq;
    Map<Integer, task> map;

    public TaskManager(List<List<Integer>> tasks) {
        
        map = new HashMap<>();
        
        pq = new TreeSet<>((a,b) -> {
           if(b.pri == a.pri) return b.tid - a.tid;
            return b.pri - a.pri;
        });
        
        for(List<Integer> list : tasks){
            add(list.get(0) , list.get(1) , list.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        task newtask = new task(userId , taskId , priority);
        pq.add(newtask);
        map.put(taskId , newtask);
    }
    
    public void edit(int taskId, int newPriority) {
        task t = map.get(taskId);
            pq.remove(t);
            t.pri = newPriority;
            pq.add(t);
    }
    
    public void rmv(int taskId) {
        task t = map.get(taskId);
        if(t != null){
            map.remove(t);
            pq.remove(t);
        }
    }
    
    public int execTop() {
        if(pq.isEmpty()){
            return -1; 
        }
        task  t = pq.first();
        map.remove(t.tid);
        pq.remove(t);
        return t.uid;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */