package BusBooking;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class BookingProcess {
	
	Scanner scan =new Scanner(System.in);
	
	User user = new User();
	
	public void bookTickets(List <BusDetails> listbusdetails, int enteredBusId) {
		
	for(int selectedbusid = 1; selectedbusid < 11 ; selectedbusid ++) {
		if(selectedbusid == enteredBusId) {
		System.out.println(listbusdetails.get(selectedbusid - 1).getBusName()+"\n");
		System.out.println("Departure from " + listbusdetails.get(selectedbusid - 1).getDeparture()+" is at "+listbusdetails.get(selectedbusid-1).getDepatureTime()+" and reachs "+ listbusdetails.get(selectedbusid-1).getDestination()+" by " +listbusdetails.get(selectedbusid-1).getArrivalTime());
		System.out.println("Price : ₹" + listbusdetails.get(selectedbusid-1).getFare());
	    System.out.println("Available seats : " + listbusdetails.get(selectedbusid - 1).getAvailableSeats());
	    System.out.println();
	    System.out.print("Enter the number of tickets to book : ");
	    int enteredSeats = scan.nextInt();
	    System.out.println();
	    
	    if(enteredSeats <= listbusdetails.get(selectedbusid-1).getAvailableSeats()) {
	    	
	    int updatedSeats = listbusdetails.get(selectedbusid-1).getAvailableSeats() - enteredSeats;
	    listbusdetails.get(selectedbusid-1).setAvailableSeats(updatedSeats);
	    	
	    System.out.println("Number of tickets selected :" + enteredSeats);
	    int totalTicketFare = enteredSeats*listbusdetails.get(selectedbusid-1).getFare();
	    	
	    System.out.println("Total amount :₹" + totalTicketFare + "\n");
	    confirmBooking();
	    }
		}
	}
}
	public void confirmBooking() {
		System.out.print("Type 'Ok' to confirm booking : ");
	    String confirmkey = scan.next();
	    String okconfirmkey ="Ok";
	    	
	    
	    if(confirmkey.equalsIgnoreCase(okconfirmkey)) {
	    	System.out.println("Successfully bus tickets booked !");
	    	}
	    else {
	    	System.out.println("Something went wrong. Please resume the booking");
	    	confirmBooking();
	    	}
	    
	    }
	    
	    public void cancelBooking(List <BusDetails> listbusdetails , int cancellingTicket) {
	    	
	    	System.out.println("Press '1' to cancel your booking");
	    	String cancelkey = scan.next();
	    	String confirmcancelkey = "1";
	    	
	    	System.out.println("Enter the ");
	    	
	    	if(cancelkey.equals(confirmcancelkey)) {
	    		
	    		//int cancelledTicket = listbusdetails.get() - cancellingTicket ; 
	    	    		
	   
	    	//	System.out.println("Your ticket has been cancelled.");
	    		
	    		
	    		
	    	}
	    	
	    	
	    }
	}

	
	
	

		
	
