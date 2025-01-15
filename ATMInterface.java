package JavaProject;

import java.util.Scanner;

class BankAccount
{
	String name;
	String userName;
	String password;
	String accountNo;
	float balance = 10000f;
	int transactions = 0;
	String transactionHistory = "";

	public void register()
	{
		Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter your name:");
        this.name = sc.nextLine();
		System.out.println("\n Enter your Username:");
        this.userName = sc.nextLine();
		System.out.println("\n Enter your Password:");
        this.password = sc.nextLine();
		System.out.println("\n Enter your Account Number:");
        this.accountNo = sc.nextLine();
		System.out.println("\nRegistration Successful . Please Log in to your bank Account");
	}
	public boolean login()
	{
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while(! isLogin)
		{
			System.out.println("\nEnter your username:");
            String Username = sc.nextLine();
			if (Username.equals(userName))
			{
               while(!isLogin)
				{
					System.out.println("\nEnter your passoword:");
					String Password = sc.nextLine();
					if (Password.equals(password))
					{
						System.out.println("\nLogin Successful");
						isLogin = true;
					}
					else
					{
						System.out.println("\nIncorrect Password");
					}
				}
			}else
			{
				System.out.println("\nUsername not found");
			}

		}
		return isLogin;
	}

	public void withdraw()
	{
		System.out.println("\nEnter Amount to withdraw:"); 
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try{
			if (balance >= amount)
			{
				transactions++;
				balance -=amount;
				System.out.println("\nWithdral Successful.");
				String str = amount + "Rs Withdrawn\n";
				transactionHistory = transactionHistory.concat(str);
			}else{
				System.out.println("\nInsufficient Balance.");
			}
		}catch(Exception e)
		{
			
		}

	}

	public void deposit()
	{
		System.out.println("\nEnter Amount to Deposit:"); 
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try{
			if (amount <= 10000f)
			{
				transactions++;
				balance +=amount;
				System.out.println("\nDeposit Successful.");
				String str = amount + "Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}else{
				System.out.println("\nSorry. The limit is 10000.");
			}
		}catch(Exception e)
		{
			
		}

	}

	public void transfer()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter Amount to Receipent's Name:");
        String recipent = sc.nextLine();
		System.out.println("\nEnter Amount to transfer:");
		float amount = sc.nextFloat();
		try {
			if (balance>=amount){
			if (amount <= 50000f){
				transactions++;
				balance -= amount;
				System.out.println("\nSuccessful Transfered to"+ recipent);
				String str = amount + "Rs transferred to" + recipent +"\n";
				transactionHistory = transactionHistory.concat(str);
			}else{
				System.out.println("\nSorry. The limit is 50000.");
			}
		}else{
			System.out.println("\nInsufficient Balance.");
		}}catch(Exception e){
			
	  }
	}

public void checkBalance(){
	System.out.println("\n"+ balance+"Rs");
}



	public void transHistory()
	{
		if (transactions == 0)
		{
			System.out.println("No Transactions happened");
		}
		else
		{
			System.out.print("\n"+transactionHistory);
		}
	}

}

public class ATMInterface

{
 public static int takenIntegerInput(int limit)
{
   int input = 0;
   boolean flag = false;

   while(!flag){
	try{
		Scanner sc=new Scanner(System.in);
		input = sc.nextInt();
		flag = true;
		if (flag && input>limit || input<1)
		{
            System.out.println("Choose the number between 1 to "+ limit);
			flag = false;
		}
	} catch (Exception e){
		System.out.println("Enter only integer value.");
		flag =false;
	}

   } 
   return input;
}

public static void main(String[] args){
	System.out.println("\n ************* WELCOME TO GOVARDHAN ATM INTERFACE ************* ");
    System.out.println("\n1.Register \n2. Exit");
	System.out.println("Choose one option:");
	int choose = takenIntegerInput(2);
	
	if (choose == 1)
	{
		BankAccount b=new BankAccount();
		b.register();
		while(true)
			{
    System.out.println("\n1.Login \n 2. Exit");
	System.out.println("Enter your choice::");
	int ch = takenIntegerInput(2);
	if (ch==1)
	{
		if (b.login())
		{
           System.out.println("\n ************* WELCOME BACK"+b.name +" ************* ");
		   boolean isFinished = false;
		   while(! isFinished){
			System.out.println("\n1.withdraw \n 2. Deposit \n3.Transfer \n4.check balance \n5.Transaction History \n6.Exit");
	        System.out.println("Enter your choice::");
	        int c= takenIntegerInput(2);
			switch (c)
			{
			   case 1 :
				b.withdraw();
			   case 2: 
				b.deposit();
			   case 3:
				b.transfer();
			   case 4:
				b.checkBalance();
			   case 5:
				b.transHistory();
			   case 6:
				isFinished = true;
			    break;
			}
		   }
		}else{
			System.exit(0);
		 }
	   }else{
		System.exit(0);
     }	
     } 
   }
 }
}