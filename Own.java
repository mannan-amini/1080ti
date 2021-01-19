package DSProject;

public class Own extends Edge
{
    String shomare;
    String time, price;

    public Own(Node from, Node to, String shomare, String time, String price) {
        super(shomare, from, to);
        this.shomare = shomare;
        this.time = time;
        this.price = price;
    }
}