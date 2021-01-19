package DSProject;

public class BankAccount extends Node
{
    long kode;
    String bankName , shaba;
    String accountNumber;
    public BankAccount(long kode, String bankName, String shaba, String accountNumber) {
        super(accountNumber);
        this.kode = kode;
        this.bankName = bankName;
        this.shaba = shaba;
        this.accountNumber = accountNumber;
    }
}