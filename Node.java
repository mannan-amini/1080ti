package DSProject;

import java.util.HashMap;

public class Node
{
    String key;
    HashMap<String, Node> connected = new HashMap<>();
    HashMap<String, Edge> edges = new HashMap<>();
    public Node(String key) {
        this.key = key;
    }
    void connect(Node to, Edge edge)
    {
        connected.put(to.key , to);
        edges.put(edge.key , edge);
    }
}
