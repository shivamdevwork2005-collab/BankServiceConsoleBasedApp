package AtmMachineProject;

public interface BankService {

    void BankMenu();

    void visitBank();

    void withdraw(int amount,String accountNo);

    void deposit(int amount,String accountNo);

    String openAccount(String name , double AdharNo , int balance );

    Customer CloseAccount(String name , String accountNo);

    String  UpiTransaction(float amount , String upiId , String accountNo);

    String loan(double AdharNo , float amount , int time , float intrest , float rate , String accountNo);

    String insurance(double AdharNo , String accountNo , float amount , int time , float intrest , float rate , String insuranceType , String insuranceId , String insuranceName , String insuranceNo , String insuranceStartDate , String insuranceEndDate);

    String creditCard( String accountNo , String cardNo , String cardHolderName , String cardType , String cardStartDate , String cardEndDate , String cardCvv , String cardPin , String cardStatus);

    Customer findAccount(String accountId);

}
