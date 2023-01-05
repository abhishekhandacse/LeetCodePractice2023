public class LC_944 {

    //Accepted Solution
    public int minDeletionSize(String[] strs) {
        int counter=0;

        for(int i=0;i<strs[0].length();i++){
            int prev_ascii=Integer.MAX_VALUE;
            for(int j=0;j<strs.length;j++){
                if(j==0){
                    prev_ascii=(int)strs[j].charAt(i);
                }else{
                    if(prev_ascii<=(int)strs[j].charAt(i)){
                        prev_ascii=(int)strs[j].charAt(i);
                    }else{
                        counter++;
                        break;
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        LC_944 lc_944=new LC_944();
        System.out.println(lc_944.minDeletionSize(new String[]{"cba","daf","ghi"}));
//        System.out.println(lc_944.minDeletionSize(new String[]{"abc","bce","cae"}));
//        System.out.println(lc_944.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
    }
}
