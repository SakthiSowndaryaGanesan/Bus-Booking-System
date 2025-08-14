package BusBooking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
	
	BusDetails busdetails = new BusDetails();

	Map< String , String > userDetails = new HashMap<>();
	
	Scanner scan = new Scanner (System.in);
	
	public void userSignin() {
		System.out.println();
		System.out.println(" ============ User Login ============");
		System.out.println();
		
		System.out.print("Enter the User Name : ");
		String userName = scan.next();
		
		if(userDetails.containsKey(userName)) {
			System.out.print("Enter the Password : ");
			String userPassword = scan.next();
			if(userDetails.get(userName).equals(userPassword)) {
				
				
				System.out.println("Login success");
				homepage();
			}
			else {
				System.out.println("Entered Password is wrong. Enter the correct password");
				userSignin();
		}
		
		}
		else {
			System.out.println("User name not found");
			userSignin();
			
		}
		
	}
	public void homepage() {
		System.out.println();
		System.out.println("=========== Home page ===========");
		System.out.println();
		System.out.println("1.Bus Booking");
		System.out.println("2.Cancel Ticket");
		System.out.println("3.Booking History");
		System.out.println("4.Exit");
		System.out.print("Select the option : ");
				
				int option=0;
				try {
				option = scan.nextInt();
				}
				catch(Exception e) {
					System.out.println("Enter a valid input not string");
					scan.nextLine();
					homepage();
					
				}
				
				if(option>0 && option<5) {
				switch(option) {
				case 1:
					busdetails.loadBus();
					busdetails.displayBus();
					break;
				case 2:
					System.out.println("Cancel");
					break;
				case 3:
					System.out.println("History");
					break;
				case 4:
					System.out.println("Exit");
					break;
				}
				
				}
				else {
					System.out.println("Please enter the valid option ( Only numbers between 1-4 )");
					homepage();
				}
			}
	
	
	public void userRegister() {
		
		System.out.println();
		System.out.println(" ============ User Register ============");
		System.out.println();
		
		System.out.print("Enter the User Name : ");
		String correctUserName = scan.next();
		
		if(userDetails.containsKey(correctUserName)) {
			System.out.println("User already exist");
			userRegister();
		}
		
		System.out.print("Enter the Password : ");
		String correctUserPassword = scan.next();
		
		if((correctUserName.equals(correctUserPassword))){
			System.out.println();
			System.out.println("Please enter a different password. Password shouldn't same as User name. ");
			userRegister();
		
		}
		else {
		System.out.print("Confirm your Password :");
		String confirmPassword = scan.next();
		
		if(correctUserPassword.equals(confirmPassword)) {
			
			userDetails.put(correctUserName, correctUserPassword);
			System.out.println("You have registered successfully !");
			userSignin();
		}
		else {
			System.out.println("Password Mismatch. Please check the details");
			userRegister();
		}
		}
	}
		
		

	}

