import java.util.*;

public class UnitConversion {

    // ["m", "1.23", "inch"]
    public static HashMap<String, ArrayList<String[]>> storeFacts(String[][] facts) {

        HashMap<String, ArrayList<String[]>> adjList = new HashMap<>();
        for (String[] fact : facts) {
            if (adjList.containsKey(fact[0])) {
                adjList.get(fact[0]).add(new String[] { fact[2], fact[1] });
            } else {
                ArrayList<String[]> arr = new ArrayList<>();
                arr.add(new String[] { fact[2], fact[1] });
                adjList.put(fact[0], arr);
            }
            if (adjList.containsKey(fact[2])) {
                adjList.get(fact[2]).add(new String[] { fact[0], String.valueOf(1f / Float.parseFloat(fact[1])) });
            } else {
                ArrayList<String[]> arr = new ArrayList<>();
                arr.add(new String[] { fact[0], String.valueOf(1f / Float.parseFloat(fact[1])) });
                adjList.put(fact[2], arr);
            }
        }

        return adjList;
    }

    // ["2", "m", "inch"]
    public static Float unitConversion(HashMap<String, ArrayList<String[]>> factsMap, String[] query) {

        if (!factsMap.containsKey(query[1])) {
            return -1f;
        }
        Queue<String[]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        visited.add(query[1]);
        q.add(new String[] { query[1], "1" });

        while (!q.isEmpty()) {
            String[] currUnit = q.poll();
            for (String[] neighbour : factsMap.get(currUnit[0])) {
                if (neighbour[0].equals(query[2])) {
                    Float converted = Float.parseFloat(query[0]) * Float.parseFloat(currUnit[1])
                            * Float.parseFloat(neighbour[1]);
                    return converted;
                }
                if (!visited.contains(neighbour[0])) {
                    visited.add(neighbour[0]);
                    q.add(new String[] { neighbour[0],
                            String.valueOf(Float.parseFloat(currUnit[1]) * Float.parseFloat(neighbour[1])) });
                }
            }
        }

        return -1f;

    }

    public static void main(String[] args) throws Exception {
        String[][] facts = {
                { "m", "1.222", "inch" },
                { "inch", "2", "cm" },
                { "m", "1.1", "hi" },
                { "hi", "3", "bye" },
        };
        HashMap<String, ArrayList<String[]>> factsMap = storeFacts(facts);
        String[] query = { "2", "bye", "m" };
        System.out.println(unitConversion(factsMap, query));
        System.out.println(2f / 3f / 1.1);
    }
}
