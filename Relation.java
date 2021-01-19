package DSProject;

public class Relation extends Edge
{
    String role , time;
    public Relation(Node from, Node to, String role, String time) {
        super(from.key + to.key, from, to);
        this.role = role;
        this.time = time;
    }
}