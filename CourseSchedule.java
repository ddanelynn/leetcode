import java.util.ArrayList;
import java.util.HashSet;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][] {{0,1}};
        System.out.println(canFinish(2, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            ArrayList<Integer> neighbours = new ArrayList<>();
            adjList.add(neighbours);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            adjList.get(course).add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjList, visited, i)) {
                return false;
            }
        }
        return true;
        
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adjList, HashSet<Integer> visited, int start) {
        
        if (visited.contains(start)) {
            return false;
        }
        if (adjList.get(start).size() == 0) {
            return true;
        }
        visited.add(start);
        ArrayList<Integer> preReqs = adjList.get(start);
        for(int pre: preReqs){
            if(!dfs(adjList, visited, pre))
                return false;
        }
        visited.remove(start);
        adjList.get(start).clear();
        return true;
    }
}
