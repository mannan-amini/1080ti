package DSProject;

public class Mobile extends Node
{
    long kode;
    String number , operator;
    public Mobile(long kode, String number, String operator) {
        super(number);
        this.kode = kode;
        this.number = number;
        this.operator = operator;
    }
}