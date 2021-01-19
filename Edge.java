package DSProject;

public class Edge
{
   String key;
   Node from, to;
   public Edge(String key, Node from, Node to) {
       this.key = key;
       this.from = from;
       this.to = to;
   }
}
