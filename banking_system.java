//Program to implement a Small Banking System.
//GROUP : A1.8
//Shivam  Kumar(Roll No: 13000117049)
//Sneha  Saha(Roll No: 13000117041)
//Swagata Baisnab(Roll No: 13000118003)
//Syed Aman Rahaman(Roll No: 13000117032)

import java.util.*;
import java.io.*;
class banking_system
{
		static String name[]=new String [50];		
		static String adhno[]=new String [50];
		static String acctype[]=new String [50];
		static String bal[]=new String [50];
		static String phnno[]=new String [50];
		static String balance;
		static int k=0,flag=0,x,num,i,ch,ac,g=1000; static int acno[]=new int[50];static int time[]=new int[50];
		static double amt,y,interest;
	
	//to deposit money in account	
	static void deposit(int p,double a)
	{
		double b = Double.parseDouble(bal[p])+ a;
		bal[p]=Double.toString(b);
		System.out.println("Amount deposited successfully\n");
		System.out.println("Current Balance= "+bal[p]+"rupees\n");
	}
	//to withdraw money from account
	static void withdraw(int p,double a)
	{
		double b = Double.parseDouble(bal[p])- a;
		bal[p]=Double.toString(b);
		System.out.println("Amount withdrawn successfully\n");
		System.out.println("Current Balance= "+bal[p]+"rupees\n");
	}
	
	//method to create savings account
	static int SavingsAcc(int k, String balance)
	{
		double bln = Double.parseDouble(balance);
		if(bln<2000.0)
		{
			System.out.println("Minimum opening balance has to be 2000 rupees. Savings account could not be created\n");
			return 0;
		}
		else
		{
			System.out.println("Welcome to our bank. Your Savings account is successfully created\n Your Acc No. is "+g+"\n");
			acno[k]=g;
			g++;
			return 1;
		}
	}
	
	//method to create student account
	static int StudentAccount(int k, String balance)
	{
		double bln = Double.parseDouble(balance);
		if(bln<1000.0)
		{
			System.out.println("Minimum opening balance has to be 1000 rupees. Student account could not be created\n");
			return 0;
		}
		else
		{
			System.out.println("Welcome to our bank. Your Student account is successfully created\n Your Acc No. is "+g+"\n");
			acno[k]=g;
			g++;
			return 1;
		}
	}

	//method to create FD account
	static int FDAccount(int k, String balance)
	{
		Scanner sc=new Scanner(System.in);
		double bln = Double.parseDouble(balance);
		if(bln<2000.0)
		{
			System.out.println("Minimum opening balance has to be 3000 rupees. FD account could not be created\n");
			return 0;
		}
		else
		{
			System.out.println("Enter time period of fixed deposit\n");
			time[k]=sc.nextInt();
			if(time[k]<=0)
			{
				System.out.println("FD Account could not be created. Please enter valid time of fixed deposit.\n");
				return 0;
			}
			else
			{
				System.out.println("Welcome to our bank. Your FD account is successfully created for "+time[k]+" years. \n Your Acc No. is "+g+"\n");
				acno[k]=g;
				g++;
				return 1;
			}
		}
	}
		
	public static void main(String args[])
	{
		
		File s = new File("Javat.txt");
		if(s.length()==0)		//to check if file is empty
			System.out.println("File is empty\n");
		else{
		
		Scanner sc=new Scanner(System.in);
		try
		{
			Scanner ss = new Scanner(s);
			while(ss.hasNext())
			{
				acctype[k]=ss.nextLine();	//Reading data from file
				name[k]=ss.nextLine();		//Reading data from file	
				phnno[k]=ss.nextLine();		//Reading data from file
				adhno[k]=ss.nextLine();		//Reading data from file
				bal[k]=ss.nextLine();		//Reading data from file
				if(acctype[k].equals("SavingsAccount"))
				{
					x=SavingsAcc(k,bal[k]);
					if(x==1)
						k++;
				}
				else if(acctype[k].equals("StudentAccount"))
				{
					x=StudentAccount(k,bal[k]);
					if(x==1)
						k++;
				}
				else if(acctype[k].equals("FDAccount"))
				{
					x=FDAccount(k,bal[k]);
					if(x==1)
						k++;
				}
			}
			num=k;
			ss.close();
		}
		catch(FileNotFoundException e)			//checking for FileNotFoundException
		{
			System.out.println("File is not found");
		}
		//method to create accounts based on data taken input from file.
		for(i=0;i<num;i++)
		{
			if(acctype[i]=="SavingsAccount")
				SavingsAcc(i,bal[i]);
			if(acctype[i]=="StudentAccount")
				StudentAccount(i,bal[i]);
			if(acctype[i]=="FDAccount")
				FDAccount(i,bal[i]);
		}
		if(num==0)
			System.out.println("No Accounts could be created\n");
		else{
		do
		{	//main menu of program
			System.out.println("Main Menu\n1.Display all existing accounts\n2.Search by Account Number\n3.Interest earned\n4.Deposit\n5.Withdrawal\n6.Close Account\n7.Exit");
			System.out.println("Ur Choice :");
			ch=sc.nextInt();
			switch(ch)
			{ 
				case 1:	
						//to display details of all bank accounts
						System.out.println("Acc Number\t\tAcc Type\t\tName\t\tPhn No.\t\t\t Adhar Card No.\n");
						for(i=0;i<num;i++)
						{
							if(acctype[i].equals("AccountClosed"))
									System.out.println("***********Account Closed*************");
							else
									System.out.println(acno[i]+"\t\t\t"+acctype[i]+"\t\t"+name[i]+"\t\t"+phnno[i]+"\t\t\t"+adhno[i]+"\n");
						}
						break;
				case 2:
						//to display details and balance of a user desired account
						System.out.println("Enter Account number\n");
						ac=sc.nextInt();
						for(i=0;i<num;i++)
						{
							if(ac==acno[i])
							{
								flag=1;
								System.out.println("Acc Type\t\tName\t\tPhn No.\t\t\t Adhar Card No.\t\tBalance");
								if(acctype[i].equals("AccountClosed"))
									System.out.println("***********Account Closed*************");
								else
									System.out.println(acctype[i]+"\t\t"+name[i]+"\t\t"+phnno[i]+"\t\t\t"+adhno[i]+"\t\t\t"+bal[i]);
							}
						}
						if(flag==0)
								System.out.println("Invalid Account Number!!This Account does not exist.\n");
						flag=0;

						break;
				case 3:
						//to calculate the interest earned
						System.out.println("Enter Account number\n");
						ac=sc.nextInt();
						for(i=0;i<num;i++)
						{
							if(ac==acno[i])
							{
								
								flag=1;
								if(acctype[i].equals("AccountClosed"))
									System.out.println("***********Account Closed*************");
								else
								{
									System.out.println("Enter time periord(in years)\n");
									y=sc.nextDouble();
									interest=(Double.parseDouble(bal[i])*10*y)/100;
									System.out.println("Interest earned= "+interest+" rupees\n");
									System.out.println("Rate of interest is 10%\n");
									amt=Double.parseDouble(bal[i])+interest;
									bal[i]=Double.toString(amt);
								}
							}		
						}
						if(flag==0)
							System.out.println("Invalid Account Number!!This Account does not exist.\n");
						flag=0;
						break;
				case 4:
						//to deposit money into a user entered account
						System.out.println("Enter Account number\n");
						ac=sc.nextInt();
						for(i=0;i<num;i++)
						{
							if(ac==acno[i])
							{
								if(acctype[i].equals("FDAccount"))
								{
									System.out.println("Deposit into "+acctype[i]+" not possible\n");
									flag=1;
								}
								else
								{
									flag=1;
									if(acctype[i].equals("AccountClosed"))
										System.out.println("***********Account Closed*************");
									else
									{
										System.out.println("Enter amount to be deposited\n");
										amt=sc.nextDouble();
										deposit(i,amt);
									}
								}
							}
						}
						if(flag==0)
							System.out.println("Invalid Account Number!!This Account does not exist.\n");
						flag=0;
						break;
				case 5:
						//to withdraw money from a user entered account
						System.out.println("Enter Account number\n");
						ac=sc.nextInt();
						for(i=0;i<num;i++)
						{
							if(ac==acno[i])
							{
								if(acctype[i].equals("FDAccount"))
								{
									flag=1;
									System.out.println("Withdrawal from "+acctype[i]+" not possible before "+time[i]+" years\n");
								}
								else
								{
									flag=1;
									if(acctype[i].equals("AccountClosed"))
										System.out.println("***********Account Closed*************");
									else
									{
										System.out.println("Enter amount to be withdrawn\n");
										amt=sc.nextDouble();
										if((amt>Double.parseDouble(bal[i])) || (Double.parseDouble(bal[i])-amt<1000))
											System.out.println("Withdrawal cannot be performed!! Account balance not enough. Minimum account balance must be 1000 rupees.");
										else
											withdraw(i,amt);
									}
								}
							}
							
						}
						if(flag==0)
							System.out.println("Invalid Account Number!!This Account does not exist.\n");
						flag=0;
						break;
				case 6:
						//to close an account
						System.out.println("Enter Account number\n");
						ac=sc.nextInt();
						for(i=0;i<num;i++)
						{
							if(ac==acno[i])
							{
								if(acctype[i].equals("FDAccount"))
								{
									flag=1;
									System.out.println("Closing "+acctype[i]+" before "+time[i]+" years is not possible\n");
								}
								else
								{
									flag=1;
									acctype[i]="AccountClosed";
									
								}
							}
							
						}
						if(flag==0)
							System.out.println("Invalid Account Number!!This Account does not exist.\n");
						flag=0;
						break;
						
				case 7:
						System.out.println("Exited.....\n");
						break;
				default: 
						System.out.println("Wrong choice!! Please try again!!\n");
						break;
			}
		}while(ch!=7);
		}
		}
	}
}
						

								
								
						
						
							
						
			

				
			
