import java.util.*;

public class CloneGraph {
  public static void main(String[] args) {
    Node nodeOne = new Node(1);
    Node nodeTwo = new Node(2);
    Node nodeThree = new Node(3);
    Node nodeFour = new Node(4);

    ArrayList<Node> arrOne = new ArrayList<>();
    arrOne.add(nodeTwo);
    arrOne.add(nodeThree);

    nodeOne.neighbors = arrOne;

    ArrayList<Node> arrTwo = new ArrayList<>();
    arrTwo.add(nodeFour);
    arrTwo.add(nodeOne);

    nodeTwo.neighbors = arrTwo;

    ArrayList<Node> arrThree = new ArrayList<>();
    arrThree.add(nodeFour);
    arrThree.add(nodeOne);

    nodeThree.neighbors = arrThree;

    ArrayList<Node> arrFour = new ArrayList<>();
    arrFour.add(nodeTwo);
    arrFour.add(nodeThree);

    nodeFour.neighbors = arrFour;

    cloneGraph(nodeOne);

  }

  public static Node cloneGraph(Node node) { 
    
    if (node == null) {
      return null;
    }

    Queue<Node> q = new LinkedList<>();
    HashMap<Node, Node> visited = new HashMap<>();

    q.add(node);
    visited.put(node, new Node(node.val));
    while (!q.isEmpty()) {
      Node curr = q.poll();
      
      for (Node neighbourNode: curr.neighbors) {
        if (!visited.containsKey(neighbourNode)) {
          visited.put(neighbourNode, new Node(neighbourNode.val));
          q.add(neighbourNode);
        }
        visited.get(curr).neighbors.add(visited.get(neighbourNode));
      } 
    }
    return visited.get(node);
  }

  static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
  }
}


