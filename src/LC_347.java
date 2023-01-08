import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC_347 {
    class Pair{
        int key;
        int value;
        Pair(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
//    public int[] topKFrequent(int[] nums, int k) {
//        HashMap<Integer,Integer> hm=new HashMap<>();
//        for(int i:nums){
//            hm.put(i,hm.getOrDefault(i,0)+1);
//        }
//        ArrayList<Pair> arr=new ArrayList<Pair>();
//        for(Map.Entry<Integer,Integer> iterate:hm.entrySet()){
//            arr.add(new Pair(iterate.getKey(),iterate.getValue()));
//        }
//        Collections.sort(arr,(a,b)->b.value-a.value);
//        int[] ans=new int[k];
//        for(int i=0;i<arr.size();i++){
//            if(i==k)break;
//            ans[i]=arr.get(i).key;
//        }
//        return ans;
//    }
//    Alternate approach using heap
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((p1,p2)->p2.value-p1.value);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> iterate:hm.entrySet()){
            pq.add(new Pair(iterate.getKey(),iterate.getValue()));
        }
        int[] ans=new int[k];

        for(int i=0;i<k;i++){
            ans[i]=pq.poll().key;
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
