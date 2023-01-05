import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Accepted
public class LC_2244 {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<tasks.length;i++){
            hm.put(tasks[i],hm.getOrDefault(tasks[i],0)+1);
        }
        int rounds=0;
        for(Map.Entry<Integer,Integer> iterate:hm.entrySet()){
            if(iterate.getValue()==1){
                return -1;
            }
            else if(iterate.getValue()==2){
                rounds+=1;
            }
            else if(iterate.getValue()==4){
                rounds+=2;
            }
            else if( ((iterate.getValue())%3) ==0){
                rounds+=((iterate.getValue())/3);
            }
            else{
                // For numbers like 5 8 11
                // You need to get greedy to minimize the number of rounds
                if(((iterate.getValue())%3)==2){
                    rounds+=((iterate.getValue())/3)+1;
                }else{
                    //For numbers like 7 10 ...
                    int remainder=((iterate.getValue())/3)-1;
                    int number=iterate.getValue()-(3*remainder);
                    rounds+=remainder+(number/2);
                }
            }
        }
        return rounds;
    }


    public static void main(String[] args) {
        LC_2244 lc_2244=new LC_2244();
        System.out.println(lc_2244.minimumRounds(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}));
    }
}
