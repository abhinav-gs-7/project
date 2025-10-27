import java.util.*;
public class Main
{
	static Scanner sc=new Scanner (System.in);
	static ArrayList<AccountDetails> data=new ArrayList<>();
	public static class AccountDetails {
		String name;
		int accno;
		float balance;

		AccountDetails(String name, int accno) {
			this.name = name;
			this.accno = accno;
			this.balance = 0.0f;
		}
		public String getname() {
			return name;
		}
		public int getaccno() {
			return accno;
		}
		public float getbalance() {
			return balance;
		}
		public void display() {
			System.out.println("Account Holder Name : "+name);
			System.out.println("Account Number : "+accno);
			System.out.println("Balance : "+balance);
		}
		public void deposit(int amt) {
			if(amt>0) {
				balance+=amt;
				System.out.println("Money Deposited");
			}
			else {
				System.out.print("Vaild Money");
			}
		}
		public void withdraw(int amt) {
			if(amt>0) {
				balance-=amt;
				System.out.println("Money Withdrawed");

			}
			else {
				System.out.println("Enter valid money");

			}
		}
	}
	public static void main(String[] args) {

		int z=1;
		while(z!=0) {
			System.out.println("------Login-----");
			System.out.println("1.Manager");
			System.out.println("2.Employe");
			System.out.println("3.Exit");
			int n=sc.nextInt();
			switch(n) {
			case 1 -> {
					System.out.println("Enter your password");
					int pass=sc.nextInt();
					if(pass==123) {
						manager();
					}
				}
			case 2 -> employe();
			case 3 -> {
					System.out.println("----Thank You----");
					z=0;
					break;
				}

			}
		}
	}
	public static void manager() {
		int m=1;
		while(m!=0) {

			System.out.println("Enetr a choice");
			System.out.println("1.Create a Account : ");
			System.out.println("2.Delete a Account : ");
			System.out.println("3.Display all accounts : ");
			System.out.println("4.Logout : ");
			int choice1=sc.nextInt();
			switch(choice1) {
			case 1 -> acccreate();
			case 2 -> accdelete();
			case 3 ->
			{	System.out.println("------All accoount Details------");
				for(int i=0; i<data.size(); i++) {
					data.get(i).display();
				}
				System.out.println("------End of Details------");
				break;
			}
			case 4 ->
			{	System.out.println("------Logining out thank you------");
				m=0;
				break;
			}
			}

		}

	}
	public static void acccreate() {
		sc.nextLine();
		System.out.println("Enter Account holder Name: ");
		String name=sc.nextLine();
		System.out.println("Enter Account Number: ");
		int accno=sc.nextInt();
		int y=0;
		for(int i=0; i<data.size(); i++) {
			y=data.get(i).getaccno();
		}
		if(y==accno) {
			System.out.println("Account Already exits");
		}
		else {
			data.add(new AccountDetails(name,accno));
			System.out.println("Account Created");
		}

	}
	public static void accdelete() {
		sc.nextLine();
		System.out.println("Account number to be deleted");
		int accno=sc.nextInt();
		boolean f=true;
		for(int i=0; i<data.size(); i++) {
			if(data.get(i).getaccno()==accno) {
				data.remove(i);
				f=false;
			}
		}
		if(f) {
			System.out.println("Account does Not Exsist");
		}
		else {
			System.out.println("Account Removed");
		}

	}
	public static AccountDetails accountfind(int num) {

		for(int i=0; i<data.size(); i++) {

			if(data.get(i).getaccno()==num) {
				return data.get(i);
			}
		}
		return null;
	}

	public static void employe() {
		int e=1;
		while(e!=0) {
			System.out.println("Enter a choice");
			System.out.println("1.Deposit");
			System.out.println("2.withdraw");
			System.out.println("3.transfer");
			System.out.println("4.exit");
			int choice2=sc.nextInt();
			switch(choice2) {
			case 1 ->depositMoney();
			case 2 ->withdrawMoney();
			case 3 ->transfer();
			case 4 ->
			{	System.out.println("Thank You");
				e=0;
				break;
			}
			}

		}
	}
	public static void depositMoney() {
		System.out.print("enter account Number");
		int accno=sc.nextInt();
		for(int i=0; i<data.size(); i++) {
			if(data.get(i).getaccno()==accno) {
				System.out.print("Enter amount");
				int am=sc.nextInt();
				AccountDetails acc=accountfind(accno);
				acc.deposit(am);
				break;
			}
		}
	}
	public static void withdrawMoney() {
		System.out.print("enter account Number");
		int accno=sc.nextInt();
		for(int i=0; i<data.size(); i++) {
			if(data.get(i).getaccno()==accno) {
				System.out.print("Enter amount");
				int am=sc.nextInt();
				AccountDetails acc=accountfind(accno);
				acc.withdraw(am);
				break;
			}
		}
	}

	public static void transfer() {
		System.out.println("Enter sender account number");
		int sendno=sc.nextInt();
		System.out.println("Enter reciver account number ");
		int resno=sc.nextInt();
		System.out.println("Enter amount ");
		int amt=sc.nextInt();
		int count=0;
		for(int i=0; i<data.size(); i++) {
			if(data.get(i).getaccno()==sendno) {
				data.get(i).withdraw(amt);
				count++;
			}
			else if(data.get(i).getaccno()==resno) {
				data.get(i).deposit(amt);
				count++;
			}
		}
		if(count!=2) {
			System.out.println("enter correct account numbers");
		}
	}

}
