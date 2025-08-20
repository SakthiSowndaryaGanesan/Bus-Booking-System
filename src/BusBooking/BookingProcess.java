package BusBooking;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class BookingProcess {
	
	Scanner scan = new Scanner(System.in);
	
	ViewBookingDetails viewbookingdetails ;
	
	public BookingProcess(ViewBookingDetails viewBookingDetails){
		this.viewbookingdetails = viewBookingDetails;
	}
	
	String busname;
	String departure;
	LocalTime departureTime;
	String destination;
	LocalTime arrivalTime;
	int price;
	int availableSeat;
	String registrationnumber;
	
	int selectedbusid;

	
	public void bookTickets(List <BusDetails> listbusdetails, int enteredBusId) {
		
	for(selectedbusid = 1; selectedbusid < 11 ; selectedbusid ++) {
		if(selectedbusid == enteredBusId) {
		
		 busname = listbusdetails.get(selectedbusid - 1).getBusName();
		 departure = listbusdetails.get(selectedbusid - 1).getDeparture();
		 departureTime = listbusdetails.get(selectedbusid-1).getDepatureTime();
		 destination = listbusdetails.get(selectedbusid-1).getDestination();
		 arrivalTime = listbusdetails.get(selectedbusid-1).getArrivalTime();
		 price =listbusdetails.get(selectedbusid-1).getFare();
		 availableSeat =  listbusdetails.get(selectedbusid - 1).getAvailableSeats();
		 registrationnumber = listbusdetails.get(selectedbusid).getRegistrationNumber();
		
		System.out.println("\n"+busname+"\n");
		System.out.println("Departure from " + departure +" is at "+ departureTime +" and reachs "+ destination +" by " + arrivalTime);
		System.out.println("Price : ₹" + price);
	    System.out.println("Available seats : " + availableSeat +"\n" );
	    
	   
	    bookTicketsMethod(listbusdetails, enteredBusId);
	    
		}
	}
	}
	public void bookTicketsMethod(List<BusDetails> listbusdetails , int enteredBusId) {
		
		int enteredSeats=0;
		
		System.out.print("Enter the number of tickets to book : ");
		
		try {
			enteredSeats = scan.nextInt();
			if(enteredSeats <= availableSeat) {
				int updatedSeats = availableSeat - enteredSeats;
		    	listbusdetails.get(selectedbusid-1).setAvailableSeats(updatedSeats); //Setting the updated seats
		    	System.out.println("Number of tickets selected :" + enteredSeats);
		    	int totalTicketFare = enteredSeats*listbusdetails.get(selectedbusid-1).getFare(); 
		    	System.out.println("Total amount :₹" + totalTicketFare + "\n");
		    	
		    	confirmBooking(enteredBusId , busname , registrationnumber ,departure,  departureTime,destination, arrivalTime ,price,availableSeat,enteredSeats);
		    	    
				}
			else{
				System.out.println("Current available seats : "+ availableSeat);
				System.out.println("Please check the entered seats");
				bookTicketsMethod(listbusdetails, enteredBusId);				
			}
			
		}
		catch(Exception e) {
			System.out.println("Enter a valid input. Numbers only.\n"); 
			scan.next();
			bookTicketsMethod(listbusdetails, enteredBusId);
			}
		}
	
	public void confirmBooking(int enteredBusId, String busname , String registrationNumber, String departure, LocalTime departureTime,String destination, LocalTime arrivalTime, int price, int availableSeat,int enteredSeats) {
		System.out.print("Type 'Ok' to confirm booking : ");
	    String confirmkey = scan.next();
	    String okconfirmkey ="Ok";
	    	
	    
	    if(confirmkey.equalsIgnoreCase(okconfirmkey)) {
	    	System.out.println("\nSuccessfully bus tickets booked !");
	    	
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
		
		System.out.println("Your Booking is Cancelled for the id "+ cancelId);
	    	
	    }
	}

	
	
	

		
	
