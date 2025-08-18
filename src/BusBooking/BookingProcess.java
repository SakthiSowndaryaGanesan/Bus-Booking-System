package BusBooking;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class BookingProcess {
	
	Scanner scan = new Scanner(System.in);
	
	ViewBookingDetails viewbookingdetails = new ViewBookingDetails();
	
	
	public void bookTickets(List <BusDetails> listbusdetails, int enteredBusId) {
		
	for(int selectedbusid = 1; selectedbusid < 11 ; selectedbusid ++) {
		if(selectedbusid == enteredBusId) {
			
		String busname = listbusdetails.get(selectedbusid - 1).getBusName();
		String departure = listbusdetails.get(selectedbusid - 1).getDeparture();
		LocalTime departureTime = listbusdetails.get(selectedbusid-1).getDepatureTime();
		String destination = listbusdetails.get(selectedbusid-1).getDestination();
		LocalTime arrivalTime = listbusdetails.get(selectedbusid-1).getArrivalTime();
		int price =listbusdetails.get(selectedbusid-1).getFare();
		int availableSeat =  listbusdetails.get(selectedbusid - 1).getAvailableSeats();
		String registrationnumber = listbusdetails.get(selectedbusid).getRegistrationNumber();
		
		System.out.println(busname+"\n");
		System.out.println("Departure from " + departure +" is at "+ departureTime +" and reachs "+ destination +" by " + arrivalTime);
		System.out.println("Price : ₹" + price);
	    System.out.println("Available seats : " + availableSeat );
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
	    confirmBooking(enteredBusId , busname , registrationnumber ,departure,  departureTime,destination, arrivalTime ,price,availableSeat,enteredSeats);
	    }
		}
	}
}
	public void confirmBooking(int enteredBusId, String busname , String registrationNumber, String departure, LocalTime departureTime,String destination, LocalTime arrivalTime, int price, int availableSeat,int enteredSeats) {
		System.out.print("Type 'Ok' to confirm booking : ");
	    String confirmkey = scan.next();
	    String okconfirmkey ="Ok";
	    	
	    
	    if(confirmkey.equalsIgnoreCase(okconfirmkey)) {
	    	System.out.println("Successfully bus tickets booked !");
	    	
	    	viewbookingdetails.bookingHistory(enteredBusId,busname,registrationNumber,departure,departureTime,destination,arrivalTime,price,availableSeat,enteredSeats);
	    
	    	}
	    else {
	    	System.out.println("Something went wrong. Please resume the booking");
	    	confirmBooking(enteredBusId , busname ,registrationNumber, departure, departureTime,destination,arrivalTime, price, availableSeat,enteredSeats);

	    	}
	    
	    }
	    
	    public void cancelBooking() {
	    
	    		
	    		viewbookingdetails.allBookingHistory();
	    		
	    		System.out.println("Enter booking id to cancel: ");
	    		int cancelId = scan.nextInt();
	    		
	    		viewbookingdetails.viewbooking.remove(cancelId);
	    		
	    		System.out.println("Your Booking is Cancelled for the id "+cancelId);
	    		
	    	
	    }
	}

	
	
	

		
	
