import java.util.*;
class Admin{
    private int id=54321;
    private int p=2001;
    private double balance=5000;
    private double transactionhist;
    boolean checkpin(int id,int p)
    {
        if(this.id==id && this.p==p)
        return true;
        return false;
    }
    void checkbalance()
    {
        System.out.println("Your new balance is "+balance);
    }
    void transactionhist()
    {
        System.out.println("Your transaction history is "+transactionhist);
    }
    void withdrawl(int amount)
    {
        if(amount<=balance)
        {
        balance-=amount;
        transactionhist+=amount;
        System.out.println("Withdrawl of amount "+amount+" is successfull");
        checkbalance();
        }
        else
        System.out.println("Insufficient balance");
    }
    void deposit(int amount)
    {
        balance+=amount;
        transactionhist-=amount;
        System.out.println("Deposit of amount "+amount+" is successfull");
        checkbalance();
    }
    void transfer(int amount,int acc_no)
    {
        if(amount>balance)
        System.out.println("Insufficient balance transaction cancelled");
        else
        {
        balance-=amount;
        transactionhist+=amount;
        System.out.println("Amount of "+amount+" is transferred from your account to account no. "+acc_no);
        }
    }
}
class A{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        Admin obj=new Admin();
        System.out.println("Welcome to ATM interface\n");
        System.out.println("Enter account id");
        int id=sc.nextInt();
        System.out.println("Enter pin");
        int p=sc.nextInt();
        if(obj.checkpin(id, p))
        {
        System.out.println("Access granted\n");
        boolean exit=false;
        while(!exit)
        {
            System.out.println("1.Transaction history\n2.Withdraw\n3.Deposit\n4.Transfer\n5.Check balance\n6.Quit\nEnter your choice");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                obj.transactionhist();
                break;
                case 2:
                System.out.println("Enter amount to withdraw");
                int amount=sc.nextInt();
                obj.withdrawl(amount);
                break;
                case 3:
                System.out.println("Enter amount to deposit");
                int amount1=sc.nextInt();
                obj.deposit(amount1);
                break;
                case 4:
                System.out.println("Enter amount to transfer");
                int amount2=sc.nextInt();
                System.out.println("Enter account no. in which to transfer");
                int acc_no=sc.nextInt();
                obj.transfer(amount2, acc_no);
                break;
                case 5:
                obj.checkbalance();
                break;
                case 6:
                System.out.println("Quitting from ATM interface");
                exit=true;
            }
        }
}
}
}