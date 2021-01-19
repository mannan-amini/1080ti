package DSProject;

public class Person extends Node
{
    String firstname , lastname;
    String kode;
    String birthplace , job , birthday;
    public Person(String firstname, String lastname, String kode, String birthday, String birthplace, String job) {
        super(kode);
        this.firstname = firstname;
        this.lastname = lastname;
        this.kode = kode;
        this.birthplace = birthplace;
        this.job = job;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return (firstname + " " + lastname + " : " + job);
    }
}