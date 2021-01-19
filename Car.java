package DSProject;

public class Car extends Node
{
    String pelak , kode;
    String Model , color;

    public Car(String pelak, String kode, String model, String color) {
        super(pelak);
        this.pelak = pelak;
        this.kode = kode;
        Model = model;
        this.color = color;
    }
}