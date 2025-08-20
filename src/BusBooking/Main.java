package BusBooking;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		User user = new User();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println( );
		System.out.println("============= Welcome to Bus Ticket Booking System =============");
		System.out.println( );
		System.out.println("1. Login ");
		System.out.println("2. Register ");
		System.out.println();
		System.out.print("Select your choice : " );
		
		int variable = 0;
		
		try {
		variable = scan.nextInt();
		System.out.println();
		}
		catch(Exception e) {
			System.out.println("Enter valid input");
			Main.main(args);
		}
		
		switch(variable) { 
		case 1:
			user.userSignin();
			break;
		case 2: 
			user.userRegister();
			break;
			
		}
		
		
		
	}
	
	

}