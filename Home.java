package DSProject;

public class Home extends Node
{
    long kode;
    String price , address;
    String postal;
    int metraj;
    public Home(long kode, String price , String postal , int metraj , String address) {
        super(postal);
        this.kode = kode;
        this.price = price;
        this.address = address;
        this.postal = postal;
        this.metraj = metraj;
    }
}