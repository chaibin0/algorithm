package leetcode.problems.cloneGraph;

import java.util.*;

class Solution2 {

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Map<Node, Node> cache = new HashMap<>();

        if (cache.containsKey(node)) {
            return node;
        }

        Node clone = new Node(node.val, new ArrayList<>());
        cache.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}