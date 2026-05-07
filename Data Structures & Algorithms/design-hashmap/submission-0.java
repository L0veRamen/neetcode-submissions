class MyHashMap {
    class Node{
        int key = -1;
        int val = -1;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

     private static final int MX = 1000;     // 有多少个位置
    private List<Node>[] vt;		        // vt[i]是一条链表，存放MEMBER个数，每个链表节点记录实际的key和value
    
    private int hash(int key){
        return key % MX;    // 根据取模确定位置
    }

    public MyHashMap() {
        vt = new LinkedList[MX];
        for(int i = 0; i < MX; i++){
            vt[i] = new LinkedList<>();
        } 
    }
    
    public void put(int key, int value) {
        int h = hash(key);
        for(Node node: vt[h]){
            if(node.key == key){
                // key已存在，更新value
                node.val = value;
                return;
            }
        }
        vt[h].add(new Node(key, value));    // key不存在，新建一个
    }
    
    public int get(int key) {
        for(Node node: vt[hash(key)]){
            if(node.key == key){
                // key存在，返回value
                return node.val;
            }
        }
        return -1;  // key不存在，返回-1
    }
    
    public void remove(int key) {
        int h = hash(key);
        int i = 0;
        for(Node node: vt[h]){
            if(node.key == key){
                // key存在，移除
                vt[h].remove(i);
                return;
            }
            i++;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */