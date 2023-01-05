import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//Not Complete Yet (Important Problem)
// Now Write TestCases and Dry Run against them
public class LC_146 {

    static class LRUCache {
        class Node{
            int key;
            int value;
            Node next;
            Node prev;
            Node(int key,int value,Node prev,Node next){
                this.key=key;
                this.value=value;
                this.next=next;
                this.prev=prev;
            }
        }

        Node head;
        Node tail;
        int capacity;
        HashMap<Integer,Node> hm;

        int count;
        public LRUCache(int capacity){
            this.capacity=capacity;
            hm=new HashMap<>();
            head=new Node(Integer.MAX_VALUE,Integer.MAX_VALUE,null,null);// Ignore the first node // It's like sentinel value
            tail=head;
            count=0;
        }

        public int get(int key) {
            if(hm.containsKey(key)==false){
                return -1;// key not present
            }
            // Move the node to the front of the list
            head.next=new Node(key,hm.get(key).value,head,head.next);
            if(head.next!=null) {
                head.next.next.prev = head.next;
            }

            if(head==tail){
                tail=tail.next;
            }
            Node pointer=hm.get(key);
            if(pointer==tail){
                tail=tail.prev;
            }
            // handle null conditions
            if(pointer.prev!=null) {
                pointer.prev.next = pointer.next;
            }
            if(pointer.next!=null) {
                pointer.next.prev = pointer.prev;
            }
            hm.remove(key);
            hm.put(key,head.next);
            return hm.get(key).value;
        }

        public void put(int key, int value) {

            if(hm.containsKey(key)){
                get(key);
                head.next.value=value;
                hm.put(key,head.next);
                return;
            }

            if(head.next==null){
                head.next=new Node(key,value,head,null);
            }else{
                head.next=new Node(key,value,head,head.next);
                head.next.next.prev=head.next;
            }
            if(head==tail){
                tail=tail.next;
            }

            // Handle cache eviction logic
            if(count==capacity){
                hm.remove(tail.key);
                tail=tail.prev;
                tail.next=null;
            }else{
                count++;
            }
            hm.put(key,head.next);
        }

        void debug(){
            System.out.println("----------");
            Node temp=head;
            while(temp!=null){
                System.out.print( ((temp.prev==null)?"NULL":temp.prev.key) +" | "+temp.key+" | "+((temp.next==null)?"NULL":temp.next.key) + "          ");
                temp=temp.next;
            }
            System.out.println();

            for(Map.Entry<Integer,Node> iterate:hm.entrySet()){
                System.out.println(iterate.getKey()+"   "+iterate.getValue().value);
            }
            System.out.println("----------");
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
//        lruCache.get(2);
//        lruCache.debug();
        lruCache.put(2,6);
        lruCache.debug();
//        lruCache.get(1);
//        lruCache.debug();
        lruCache.put(1,5);
        lruCache.debug();
        lruCache.put(1,2);
        lruCache.debug();
//        lruCache.get(1);
//        lruCache.debug();
//        lruCache.get(2);
//        lruCache.debug();
    }
}
