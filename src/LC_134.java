import java.util.stream.IntStream;

public class LC_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0,totalCost=0;

        totalGas= IntStream.of(gas).sum();
        totalCost=IntStream.of(cost).sum();

        if(totalCost>totalGas)return -1;

        int currentGas=0,index=-1;

        for(int i=0;i<gas.length;i++){
            currentGas+=gas[i]-cost[i];
            if(currentGas<0){
                currentGas=0;
                index=i;
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
//      Note-: Do enable the assertions
        LC_134 lc_134=new LC_134();
//        TC-1
        assert  (lc_134.canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}) == 3):"1st TC Failed";
//        TC-2
        assert  (lc_134.canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3}) == -1):"2nd TC Failed";
//        TC-3
        assert  (lc_134.canCompleteCircuit(new int[]{5,4,3,2,1},new int[]{1,2,3,4,5}) == 0):"3rd TC Failed" ;
//        TC-4
        assert  (lc_134.canCompleteCircuit(new int[]{3,4,5,2,1},new int[]{1,2,3,4,5}) == 0):"4th TC Failed";

    }
}
