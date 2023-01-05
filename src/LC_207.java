import java.util.*;

//Accepted Solution
public class LC_207 {
        enum STATE{
            UNVISITED,PROCESSING,VISITED;
        }

        private boolean dfs(HashMap<Integer,List<Integer>> adj,int source, HashMap<Integer,Integer> color){

            if(color.containsKey(source)){
                if(color.get(source)==STATE.VISITED.ordinal()){
                    return false;
                }
            }

            if(! adj.containsKey(source)){
                return false;
            }

            if(color.containsKey(source) && color.get(source).equals(STATE.PROCESSING.ordinal()) ){
                return true;
            }

            color.put(source,STATE.PROCESSING.ordinal());

            for(Integer child:adj.get(source)){
                boolean b= dfs(adj,child,color);
                color.put(child,STATE.VISITED.ordinal());
                if(b==true){
                    return true;
                }
            }
            color.put(source,STATE.UNVISITED.ordinal());
            return false;
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            HashMap<Integer,List<Integer>> adj=new HashMap<>();
            HashMap<Integer,Integer> hm=new HashMap<>();// this hashmap is used for graph coloring

            for(int i=0;i<prerequisites.length;i++){
                hm.put(prerequisites[i][0],STATE.UNVISITED.ordinal());
                if(adj.containsKey(prerequisites[i][0])){
                    List<Integer> list=adj.get(prerequisites[i][0]);
                    list.add(prerequisites[i][1]);
                    adj.put(prerequisites[i][0],list);
                }else{
                    List<Integer> list=new ArrayList<>();
                    list.add(prerequisites[i][1]);
                    adj.put(prerequisites[i][0],list);
                }
            }

            for(Map.Entry<Integer,List<Integer>> iterate:adj.entrySet()){
                if(dfs(adj,iterate.getKey(),hm)){
                    return false;//cycle exists
                }
            }

            return true;
        }
    public static void main(String[] args) {}
}
/*
*   We are given directed cyclic or Acyclic graph, our goal is to make
*   find out weather cycle is present in the graph or not
*   Just make the adjacency list from the given edges
*   Perform simple DFS to know whether cycle is present or not
*/