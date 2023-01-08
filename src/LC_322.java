public class LC_322 {

//    Below method gives TLE, so it's a standard recursion problem which
//    can be optimized via dynamic programming
int recur(int[] coins,int amount,int index,int[][] dp){
    if(amount==0)return 0;
    if(index==coins.length)return Integer.MAX_VALUE;
    if(amount<0)return Integer.MAX_VALUE;
    if(dp[amount][index]!=0)return dp[amount][index];
    //inclusion
    int incl=recur(coins,amount-coins[index],index,dp);
    //exclusion
    int excl=recur(coins,amount,index+1,dp);
    int answer;
    if(incl!=Integer.MAX_VALUE){
        answer= Math.min(incl+1,excl);
    }else answer= excl;

    dp[amount][index]=answer;
    return dp[amount][index];
}

    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        int[][] dp=new int[10009][20];
        int minNumberOfCoins=recur(coins,amount,0,dp);
        if(minNumberOfCoins==Integer.MAX_VALUE)return -1;
        return minNumberOfCoins;
    }
    public static void main(String[] args) {

        LC_322 lc_322=new LC_322();

//        TC-1
//        System.out.println(lc_322.coinChange(new int[]{1,2,5},11));
//        TC-2
//        System.out.println(lc_322.coinChange(new int[]{2},3));
//        TC-3
//        System.out.println(lc_322.coinChange(new int[]{1},0));
//        TC-4
        System.out.println(lc_322.coinChange(new int[]{4,5},23));
//        TC-5
    }
}
