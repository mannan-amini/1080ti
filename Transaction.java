package DSProject;

public class Transaction extends Edge
{
    String time, price;
    String shomare;
    public Transaction(Node from, Node to, String shomare , String time , String price) {
        super(shomare, from, to);
        this.time = time;
        this.price = price;
        this.shomare = shomare;
    }
}