import java.util.Arrays;

public class LC_1833 {

    public int maxIceCream(int[] costs, int coins) {
        if(costs==null || costs.length==0)return 0;
        Arrays.sort(costs);
        int items=0;
        for(int i=0;i<costs.length;i++){
            if(coins<=0)
                break;
            if(coins>=costs[i]){
                items++;
                coins-=costs[i];
            }
        }
        return items;
    }
    public static void main(String[] args) {

    }
}
