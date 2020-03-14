package problems.cloneGraph;


import java.util.*;

// Definition for a Node.


class Solution {
    // <origin Node, clone Node>
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList()));

        while (!queue.isEmpty()) {

            Node nextNode = queue.poll();

            for (Node neighbor : nextNode.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(nextNode).neighbors.add(visited.get(neighbor));
            }

        }
        return visited.get(node);
    }
}