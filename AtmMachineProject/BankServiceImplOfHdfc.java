package AtmMachineProject;

import java.util.ArrayList;
import java.util.Scanner;

public class BankServiceImplOfHdfc implements BankService{

    ArrayList<Customer> customers = new ArrayList<>(); // Acting here As Database

    Scanner sc = new Scanner(System.in);

    Atm atm ;

    private static String accountPref = "20760100081";


    @Override
    public void visitBank() {
        System.out.println("========== Welcome to 🏦 Hdfc Bank ==========");
        BankMenu();
    }

    @Override
    public void BankMenu() {

        while (true) {

            System.out.println();
            System.out.println("========== HDFC BANK MENU ==========");
            System.out.println("1. Withdraw 💵");
            System.out.println("2. Deposit 💵");
            System.out.println("3. Open Account");
            System.out.println("4. Close Account");
            System.out.println("5. UPI Transaction");
            System.out.println("6. Loan");
            System.out.println("7. Insurance");
            System.out.println("8. Credit Card");
            System.out.println("9. Find Account");
            System.out.println("10. Use Atm Service Of Hdfc Bank");
            System.out.println("11. Exit");
            System.out.println("====================================");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to withdraw 💵: ");
                    int withdrawAmount = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter account number: ");
                    String withdrawAccountNo = sc.nextLine();

                    withdraw(withdrawAmount, withdrawAccountNo);
                    break;


                case 2:
                    System.out.print("Enter amount 💵 to deposit: ");
                    int depositAmount = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter account number: ");
                    String depositAccountNo = sc.nextLine();

                    deposit(depositAmount, depositAccountNo);
                    break;


                case 3:
                    sc.nextLine();

                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Aadhar number: ");
                    double aadharNo = sc.nextDouble();

                    System.out.print("Enter initial balance: ");
                    int balance = sc.nextInt();

                    String accountNo = openAccount(name, aadharNo, balance);

                    System.out.println("Account created successfully.");
                    System.out.println("Account Number: " + accountNo);

                    BankMenu();
                    break;


                case 4:
                    sc.nextLine();

                    System.out.print("Enter customer name: ");
                    String closeName = sc.nextLine();

                    System.out.print("Enter account number: ");
                    String closeAccountNo = sc.nextLine();

                    Customer customer = CloseAccount(closeName, closeAccountNo);
                    if(customer!=null)
                        System.out.println("Account closed successfully. "+customer.accountNo);
                    else{
                        System.out.println("Account not found.");
                    }

                    BankMenu();
                    break;


                case 5:
                    System.out.print("Enter UPI amount: ");
                    float upiAmount = sc.nextFloat();

                    sc.nextLine();

                    System.out.print("Enter UPI ID: ");
                    String upiId = sc.nextLine();

//                    sc.nextLine();
                    System.out.print("Enter account number: ");
                    String acNo = sc.nextLine();

                    String upiResult = UpiTransaction(upiAmount, upiId, acNo);

                    if(upiResult != null)
                        System.out.println(upiResult);
                    else
                        System.out.println("Transaction 💵 failed.");

                    BankMenu();
                    break;


                case 6:
                    System.out.print("Enter Aadhar number: ");
                    double loanAadhar = sc.nextDouble();

                    System.out.print("Enter loan amount: ");
                    float loanAmount = sc.nextFloat();

                    System.out.print("Enter time (years): ");
                    int loanTime = sc.nextInt();

                    System.out.print("Enter interest: ");
                    float loanInterest = sc.nextFloat();

                    System.out.print("Enter rate: ");
                    float loanRate = sc.nextFloat();

                    sc.nextLine();

                    System.out.print("Enter account number: ");
                    String loanAccountNo = sc.nextLine();

                    String loanResult = loan(loanAadhar, loanAmount, loanTime, loanInterest, loanRate, loanAccountNo);

                    if(loanResult != null)
                        System.out.println(loanResult);

                    else
                        System.out.println("Loan failed.");

                    BankMenu();
                    break;


                case 7:
                    System.out.print("Enter Aadhar number: ");
                    double insuranceAadhar = sc.nextDouble();

                    sc.nextLine();

                    System.out.print("Enter account number: ");
                    String insuranceAccountNo = sc.nextLine();

                    System.out.print("Enter insurance amount: ");
                    float insuranceAmount = sc.nextFloat();

                    System.out.print("Enter time: ");
                    int insuranceTime = sc.nextInt();

                    System.out.print("Enter interest: ");
                    float insuranceInterest = sc.nextFloat();

                    System.out.print("Enter rate: ");
                    float insuranceRate = sc.nextFloat();

                    sc.nextLine();

                    System.out.print("Enter insurance type: ");
                    String insuranceType = sc.nextLine();

                    System.out.print("Enter insurance ID: ");
                    String insuranceId = sc.nextLine();

                    System.out.print("Enter insurance name: ");
                    String insuranceName = sc.nextLine();

                    System.out.print("Enter insurance number: ");
                    String insuranceNo = sc.nextLine();

                    System.out.print("Enter start date: ");
                    String startDate = sc.nextLine();

                    System.out.print("Enter end date: ");
                    String endDate = sc.nextLine();

                    String insuranceResult = insurance(
                            insuranceAadhar,
                            insuranceAccountNo,
                            insuranceAmount,
                            insuranceTime,
                            insuranceInterest,
                            insuranceRate,
                            insuranceType,
                            insuranceId,
                            insuranceName,
                            insuranceNo,
                            startDate,
                            endDate
                    );

                    if(insuranceResult != null)
                        System.out.println(insuranceResult);
                    else
                        System.out.println("Insurance failed.");

                    BankMenu();
                    break;


                case 8:
                    sc.nextLine();

                    System.out.print("Enter account number: ");
                    String cardAccountNo = sc.nextLine();

                    System.out.print("Enter card number: ");
                    String cardNo = sc.nextLine();

                    System.out.print("Enter card holder name: ");
                    String cardHolderName = sc.nextLine();

                    System.out.print("Enter card type: ");
                    String cardType = sc.nextLine();

                    System.out.print("Enter card start date: ");
                    String cardStartDate = sc.nextLine();

                    System.out.print("Enter card end date: ");
                    String cardEndDate = sc.nextLine();

                    System.out.print("Enter CVV: ");
                    String cardCvv = sc.nextLine();

                    System.out.print("Enter card PIN: ");
                    String cardPin = sc.nextLine();

                    System.out.print("Enter card status: ");
                    String cardStatus = sc.nextLine();

                    String cardResult = creditCard(
                            cardAccountNo,
                            cardNo,
                            cardHolderName,
                            cardType,
                            cardStartDate,
                            cardEndDate,
                            cardCvv,
                            cardPin,
                            cardStatus
                    );

                    if(cardResult != null)
                        System.out.println(cardResult);
                    else
                        System.out.println("Credit card failed.");

                    BankMenu();
                    break;


                case 9:
                    sc.nextLine();

                    System.out.print("Enter account ID: ");
                    String accountId = sc.nextLine();

                    Customer foundCustomer = findAccount(accountId);

                    if (foundCustomer != null) {
                        System.out.println("Account Found:");
                        System.out.println(foundCustomer.name);
                    } else {
                        System.out.println("Account not found.");
                    }

                    BankMenu();
                    break;

                case 10:
                    atm = new Atm();
                    atm.checkPin();
                    atm.menu();
                    break;

                case 11:
                    System.out.println("============= Thank you for visiting Hdfc Bank.==================");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 1-10.");
                    BankMenu();
            }
        }
    }

    @Override
    public void withdraw(int amount, String accountNo) {
        Customer c = findAccount(accountNo.trim());
        if(c == null){
            System.out.println("Account not found.");
            return;
        }
        System.out.println("Withdrawal amount: " + amount);
        if(amount <= c.balance){
            c.balance -= amount;
        }
        else {
            System.out.println("Insufficient 💵 balance.");
        }

        BankMenu();
    }

    @Override
    public void deposit(int amount, String accountNo) {
        Customer c = findAccount(accountNo.trim());
        if(c == null){
            System.out.println("Account not found.");
            return;
        }
        System.out.println("Deposit amount: " + amount);
        c.balance += amount;

        BankMenu();
    }

    @Override
    public String openAccount(String name, double AdharNo, int bal) {
        Customer c1 = new Customer();
        c1.name = name;
        c1.AdharNo = AdharNo;
        c1.balance = bal;
        c1.accountNo = accountPref + name.substring(0,3);
        customers.add(c1);
        return c1.accountNo;
    }

    @Override
    public Customer CloseAccount(String name, String accountNo) {
        Customer c1 = customers.stream()
                .filter(x -> x.accountNo.equals(accountNo.trim())).findFirst().orElse(null);
        customers.remove(c1);
        return c1;
    }

    @Override
    public String UpiTransaction(float amount, String upiId,String acountno) {
        Customer c = findAccount(acountno.trim());
        if(c != null && amount <= c.balance){
            c.balance -= amount;
            return "Transaction successful.";
        }
        else {
            return "Insufficient balance.";
        }
    }

    @Override
    public String loan(double AdharNo, float amount, int time, float intrest, float rate, String accountNo) {
        Customer c = customers.stream()
                .filter(x -> x.accountNo.equals(accountNo.trim())).findFirst().orElse(null);

        float si = amount * time * intrest / 100;
        float totalAmount = amount + si;
        if(c!=null){
            c.balance += totalAmount;
            return "Loan successful.";
        }else{
            return "Loan failed.";
        }
    }

    @Override
    public String insurance(double AdharNo, String accountNo, float amount, int time, float intrest, float rate,
                            String insuranceType, String insuranceId, String insuranceName,
                            String insuranceNo, String insuranceStartDate, String insuranceEndDate) {
        Customer c1 = customers.stream()
                .filter(x -> x.accountNo.equals(accountNo.trim())).findFirst().orElse(null);

        float si = amount * time * intrest / 100;
        float totalAmount = amount + si;
        if(c1 != null){
            c1.balance += totalAmount;
            return "Insurance successful.";
        }else{
            return "Insurance failed.";
        }
    }

    @Override
    public String creditCard(String accountNo, String cardNo, String cardHolderName, String cardType, String cardStartDate, String cardEndDate, String cardCvv, String cardPin, String cardStatus) {
        Customer c1 = customers.stream()
                .filter(x -> x.accountNo.equals(accountNo.trim())).findFirst().orElse(null);

        if(c1 != null){
            c1.upiId = cardNo;
            return "Credit card successful.";
        }
        else return "Credit Card Not Approved";
    }

    @Override
    public Customer findAccount(String accountId) {
        Customer c1 = null;
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).accountNo.equals(accountId.trim())){
                c1 = customers.get(i);
                break;
            }
        }
        return c1;
    }

}
