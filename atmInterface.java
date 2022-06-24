package task2atms;
import java.util.Scanner;
public class atmInterface {
	String name;
	String userName;
	String password;
	String accountNo;
	float balance=100000f;
	int transactions=0;
	String transactionsHistory="";
	public void register() {
		Scanner sc=new Scanner(System.in);
		System.out.print("\n Enter Your Name-");
		this.name=sc.nextLine();
		System.out.print("\n Enter Your Username-");
		this.userName=sc.nextLine();
		System.out.print("\n Enter Your Password-");
		this.password=sc.nextLine();
		System.out.print("\n Enter Your AccountNumber-");
		this.accountNo=sc.nextLine();
		System.out.println("\n Registration completed..Kindly login");
	}
	public boolean login() {
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		while (!isLogin) {
			System.out.print("\n  Enter Your Username-");
			String Username=sc.nextLine();
			if (Username.equals(userName)) {
				while (!isLogin) {
					System.out.print("\n  Enter Your Password-");
					String Password=sc.nextLine();
					if (Password.equals(password)) {
						System.out.print("\n Login successful!!");
							isLogin=true;
					}
					else {
						System.out.print("\n Incorrect Password");
					}
				}
			}else {
				System.out.print("\n Username not found");
			}
				
				
			}
		return isLogin;
		}
		public void withdraw() {
			System.out.print("\n Enter amount to withdraw-");
			Scanner sc=new Scanner(System.in);
			float amount=sc.nextFloat();
			try {
				if (balance>=amount) {
					transactions++;
					balance-=amount;
					System.out.println("\n Withdraw Successfully");
					String str=amount+"Rs Withdrawed\n";
					transactionsHistory=transactionsHistory.concat(str);
					
				}
				else {
					System.out.println("\n Sorry ...Limit is 100000.00");
				}
				
			}
			catch(Exception e){
			}
		}
		public void deposit() {
			System.out.print("\n Enter amount to deposit-");
			Scanner sc=new Scanner(System.in);
			float amount=sc.nextFloat();
			try {
				if (amount<=100000f) {
					transactions++;
					balance+=amount;
					System.out.println("\n Successfully Deposited");
					String str=amount+"Rs deposited\n";
					transactionsHistory=transactionsHistory.concat(str);
				}
				else {
					System.out.println("\n Sorry ...Limit is 100000.00");
				}
			}
			catch(Exception e){
			}
		}
		public void transfer() {
			Scanner sc=new Scanner(System.in);
			System.out.print("\n Enter Recepient's Name-");
			String receipent=sc.nextLine();
			System.out.print("\n Enter amount to transfer-");
			
			float amount=sc.nextFloat();
			try {
				if (balance>=amount) {
					if (amount<=500000f) {
					transactions++;
					balance-=amount;
					System.out.println("\n Successfully Transfered to"+receipent);
					String str=amount+"Rs transfered to"+receipent+"\n";
					transactionsHistory=transactionsHistory.concat(str);
					
				}
				else {
					System.out.println("\n Sorry ...Limit is 100000.00");
				}
				
			}
			else {
					System.out.println("\n Insufficient Balance");
				}
			}
			catch(Exception e){
			}
			
		}
		public void checkBalance() {
			System.out.println("\n"+balance+"Rs");
		}
		public void transHistory() {
			if (transactions==0)
			{
				System.out.println("\n Empty");
			}
			else {
				System.out.println("\n"+transactionsHistory);
			}
		}
public class AtmInterfacess{
	public static int takeIntegerInput(int limit) {
		int input=0;
		boolean flag=false;
		while(!flag) {
			try {
				Scanner sc=new Scanner (System.in);
				input=sc.nextInt();
				flag=true;
				if (flag&&input>limit || input<1) {
					System.out.println("Choose the number between 1 to "+limit);
					flag=false;
				}
			}
			catch(Exception e) {
				System.out.println("Enter only integer value");
				flag=false;
			}
		}
		return input;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n ****Welcome to SBI atm system***\n");
		System.out.println("1.Register\n 2.Exit");
		System.out.println("Enter your choice");
		int choice =takeIntegerInput(2);
		if (choice==1) {
			atmInterface b=new atmInterface();
			b.register();
			while (true) {
				System.out.println("\n 1.Login\n 2.Exit ");
				System.out.print("Enter your choice-");
				int ch=takeIntegerInput(2);
				if (ch==1) {
					if (b.login()) {
						System.out.println("\n\n **WELCOME BACK"+b.name+"****\n");
						boolean isFinished=false;
						while (!isFinished) {
							System.out.println("\n 1.Withdraw \n 2.Deposit \n 3.Transfer \n 4.Check Balance\n 5.transactionsHistory\n 6.isFinished");
							System.out.print("\n Enter your choice-");
							int c=takeIntegerInput(6);
							switch(c) {
							case 1:
								b.withdraw();
								break;
							case 2:
								b.deposit();
								break;
							case 3:
								b.transfer();
								break;
							case 4:
								b.checkBalance();
								break;
							case 5:
								b.transHistory();
								break;
							case 6:
								isFinished=true;
								break;
							}
						}
					}
				}else {
					System.exit(0);
				}
			}
		}
			
		}

	}

}

				
			
		
		

	
	
	

	
