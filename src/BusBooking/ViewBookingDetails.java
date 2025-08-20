package BusBooking;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewBookingDetails{

	private int busId;
	private String busName;
	private String registrationNumber;
	private String departure;
	private String destination;
	private int totalFare; 
    private LocalTime depatureTime;
	private LocalTime arrivalTime;
	private int numberoftickets;
	private int availableSeat;
	
	private User user;

	
	public ViewBookingDetails( int busId, String busName, String registrationNumber,
			String departure, String destination, int totalFare, LocalTime depatureTime, LocalTime arrivalTime,
			int numberoftickets, int availableSeat) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.registrationNumber = registrationNumber;
		this.departure = departure;
		this.destination = destination;
		this.totalFare = totalFare;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.numberoftickets = numberoftickets;
		this.availableSeat = availableSeat;
	}

	public ViewBookingDetails() { // No parameter 
		}
	
	public void setUser(User user) {
		this.user = user;
	}

	public int getBusId() {
		return busId;}
	public void setBusId(int busId) {
		this.busId = busId;}
	public String getBusName() {
		return busName;}
	public void setBusName(String busName) {
		this.busName = busName;}
	public String getRegistrationNumber() {
		return registrationNumber;}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;}
	public String getDeparture() {
		return departure;}
	public void setDeparture(String departure) {
		this.departure = departure;}
	public String getmDestination() {
		return destination;}
    public void setDestination(String destination) {
		this.destination = destination;	}
	public int getTotalFare() {
		return totalFare;	}
	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;}
	public LocalTime getDepatureTime() {
		return depatureTime;}
	public void setDepatureTime(LocalTime depatureTime) {
		this.depatureTime = depatureTime;}
	public LocalTime getArrivalTime() {
		return arrivalTime;}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;}
	public int getNumberoftickets() {
		return numberoftickets;}
	public void setNumberoftickets(int numberoftickets) {
		this.numberoftickets = numberoftickets;}
	public int getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}

	@Override
	public String toString() {
		return "ViewBookingDetails [busId=" + busId + ", busName=" + busName + ", registrationNumber="
				+ registrationNumber + ", departure=" + departure + ", destination=" + destination + ", totalFare="
				+ totalFare + ", depatureTime=" + depatureTime + ", arrivalTime=" + arrivalTime + ", numberoftickets="
				+ numberoftickets + ", availableSeat=" + availableSeat + "]";
	}


	List <ViewBookingDetails> viewbooking = new ArrayList <>();
	
	Scanner scan = new Scanner(System.in);
	int option = 0;
	
	public void bookingHistory(int busId, String busName, String registrationNumber,
			String departure, LocalTime departureTime, String destination, LocalTime arrivalTime,int totalFare
			,int availableSeat,int numberoftickets) {
		
		viewbooking.add(new ViewBookingDetails(busId, busName, registrationNumber,
			departure, destination, totalFare,departureTime,arrivalTime,numberoftickets,availableSeat));
		
		
		int index = viewbooking.size() - 1;
		
		System.out.println("\n-------- Your Booking Summary --------");
		
		System.out.println("Bus Id : "+viewbooking.get(index).busId);
		System.out.println("Bus Name : "+ viewbooking.get(index).busName);
		System.out.println("Bus Registration Number : " + viewbooking.get(index).registrationNumber);
		System.out.println("Departure from " + viewbooking.get(index).departure +" is at "+ viewbooking.get(index).depatureTime +" and reachs "+ viewbooking.get(index).destination +" by " + viewbooking.get(index).arrivalTime );
		System.out.println("Number of Tickets booked :  " + viewbooking.get(index).numberoftickets);
		System.out.println("Total amount paid :  " + viewbooking.get(index).totalFare);
		System.out.println("\nBooking successful and Have a safe journey !");
		
		bookingException();
		
	}
	public void bookingException() {
		
		System.out.print("\nPress 1 to view the all bookings or Press 2 for Exit : ");
		
		try {
		option = scan.nextInt();
		 switch (option) {
	        case 1 -> allBookingHistory(); 

	        case 2 -> {System.out.println("calling home page");
	        user.homepage();
	        }

	        default -> {
	        	System.out.println("Invalid input");
	        	bookingException();
	        	
	        }
	    }
		}
		catch(Exception e) {
			System.out.println("Enter a valid Option 1 or 2");
			scan.next();
			bookingException();
		}
	}

	public void allBookingHistory() {
		
		System.out.println("\n-------- All Booking Summary --------\n");
		int bookingcount = 1;
		
		for(ViewBookingDetails allbooking : viewbooking) {
			
			System.out.print(bookingcount+". ");

			System.out.println("Bus Name : "+ allbooking.busName);
			System.out.println("Bus Registration Number : " + allbooking.registrationNumber);
			System.out.println("Departure from " + allbooking.departure +" is at "+ allbooking.depatureTime +" and reachs "+ allbooking.destination +" by " + allbooking.arrivalTime );
			System.out.println("Number of Tickets booked :  " + allbooking.numberoftickets);
			System.out.println("Total amount paid :  " + allbooking.totalFare);
			bookingcount++;
			
			allBookingException();
		}
	}
	public void allBookingException() {
		
		System.out.println("\nPress 1 to Continue booking or 2 to Exit");
		
		try {
		int selectOption = scan.nextInt();
		switch (selectOption) {
        case 1 ->  allBookingHistory();

        case 2 -> {
        	System.out.println("Calling home page");
        	user.homepage();
        }

        default -> {
        	System.out.println("Invalid input");
        	bookingException();
        	}	
        }
	}
		catch(Exception e) {
			System.out.println("Enter a valid input 1 or 2");
			scan.next();
			allBookingException();
			
		}
	}
}



