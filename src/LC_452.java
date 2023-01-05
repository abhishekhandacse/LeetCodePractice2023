import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
//Accepted (Good Problem, Must Revise)
public class LC_452 {
//    class Solution {
//        class Pair{
//            int x;
//            int y;
//            boolean isBurst=false;
//            Pair(int x,int y){
//                this.x=x;
//                this.y=y;
//            }
//        }
        //Optimized
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points,(a,b)->{
                        if(a[1]<b[1]){
                            return -1;
                        }else if(a[1]>b[1]){
                            return 1;
                        }else {
                            return 0;
                        }
                    }
            );

            int numberOfArrows=1;
            int arrowsAim=points[0][1];
            for(int i=1;i<points.length;i++){
                if(points[i][0]<=arrowsAim){
                    continue;
                }
                numberOfArrows++;
                arrowsAim=points[i][1];
            }
            return numberOfArrows;
        }

//        public int findMinArrowShots(int[][] points) {
//            ArrayList<Pair> ballons=new ArrayList<>();
//            for(int i=0;i<points.length;i++){
//                ballons.add(new Pair(points[i][0],points[i][1]));
//            }
//            ballons.sort((a,b)->{
//                if(a.y<b.y){
//                    return -1;
//                }else if(a.y>b.y){
//                    return 1;
//                }else return 0;
//            });
//            int arrowsRequired=0;
//            for(int i=0;i<ballons.size();i++){
//                if(ballons.get(i).isBurst)
//                    continue;
//                arrowsRequired++;
//               for(int j=i+1;j<ballons.size();j++){
//                   if(ballons.get(j).isBurst)
//                       continue;
//                   if( ballons.get(j).x <= ballons.get(i).y ){
//                      ballons.get(j).isBurst=true;
//                   }
//               }
//            }
//            return arrowsRequired;
//        }

//    }


}
