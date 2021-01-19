package DSProject;

public class Call extends Edge
{
    String shomare;
    String time;
    String duration;
    public Call(Node from, Node to, String shomare, String time, String duration) {
        super(shomare, from, to);
        this.shomare = shomare;
        this.time = time;
        this.duration = duration;
    }
}