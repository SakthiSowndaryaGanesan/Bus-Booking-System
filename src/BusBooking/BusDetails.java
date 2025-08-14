package BusBooking;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class BusDetails {
	
	private int busId ;
	private String busName;
	private String registrationNumber;
	private String departure;
	private String destination;
	private int fare;
	private int totalSeats;
	private int availableSeats;
	private LocalTime depatureTime;
	private LocalTime arrivalTime;
	
	
	
	public BusDetails(int busId, String busName, String registrationNumber, String departure, String destination, int fare, int totalSeats, int availableSeats, LocalTime depatureTime, LocalTime arrivalTime) {
		this.busId = busId;
		this.busName = busName;
		this.registrationNumber = registrationNumber;
		this.departure = departure;
		this.destination = destination;
		this.fare = fare;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
	}

	public BusDetails() {} //Default constructor

	
	public int getId() {
		return busId;}
	public void setId(int id) {
		this.busId = id;}
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
	public String getDestination() {
		return destination;}
	public void setDestination(String destination) {
		this.destination = destination;}
	public int getFare() {
		return fare;}
	public void setFare(int fare) {
		this.fare = fare;}
	public int getTotalSeats() {
		return totalSeats;}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;}
	public int getAvailableSeats() {
		return availableSeats;}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;}
	public LocalTime getDepatureTime() {
		return depatureTime;}
	public void setDepatureTime(LocalTime depatureTime) {
		this.depatureTime = depatureTime;}
	public LocalTime getArrivalTime() {
		return arrivalTime;}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;}
	
	
	@Override
	public String toString() {
		return "BusDetails [busId=" + busId + ", busName=" + busName + ", registrationNumber=" + registrationNumber
				+ ", departure=" + departure + ", destination=" + destination + ", fare=" + fare + ", totalSeats="
				+ totalSeats + ", availableSeats=" + availableSeats + ", depatureTime=" + depatureTime
				+ ", arrivalTime=" + arrivalTime + "]";
	}


	List<BusDetails> listbusdetails = new ArrayList<>();
	
	Scanner scan = new Scanner (System.in);
	
	BookingProcess bookingprocess =new BookingProcess();
	
	public void loadBus() {
		listbusdetails.add(new BusDetails(1,"Krishna Travels" , "TN45CH7654","Chennai","Salem",1200,30,30,LocalTime.of(22, 30),LocalTime.of(5, 30)));
		listbusdetails.add(new BusDetails(2,"Ayali Travels" , "TN30SL5673","Salem","Chennai",1000,30,30,LocalTime.of(23, 30),LocalTime.of(7, 30)));
		listbusdetails.add(new BusDetails(3,"Ramani Travels" , "TN30SL9368","Salem","Chennai",1100,30,30,LocalTime.of(20, 00),LocalTime.of(6, 30)));
		listbusdetails.add(new BusDetails(4,"Surya Travels" , "TN41CH4589","Chennai","Erode",1400,30,30,LocalTime.of(19, 30),LocalTime.of(4, 30)));
		listbusdetails.add(new BusDetails(5,"Sakthi Travels" , "TN42CH3913","Chennai","Erode",1400,30,30,LocalTime.of(20, 30),LocalTime.of(6, 30)));
		listbusdetails.add(new BusDetails(6,"Sundar Travels" , "TN50CH8865","Chennai","Namakkal",1100,30,30,LocalTime.of(22, 30),LocalTime.of(5, 30)));
		listbusdetails.add(new BusDetails(7,"Sai Travels" , "TN50NM6893","Namakkal","Chennai",1200,30,30,LocalTime.of(20, 0),LocalTime.of(5, 30)));
		listbusdetails.add(new BusDetails(8,"Velan Travels" , "TN50CH3678","Chennai","Nagercoil",1500,30,30,LocalTime.of(22, 30),LocalTime.of(5, 30)));
		listbusdetails.add(new BusDetails(9,"Kathir Travels" , "TN65NH3568","Nagercoil","Chennai",1200,30,30,LocalTime.of(22, 30),LocalTime.of(5, 30)));
		listbusdetails.add(new BusDetails(10,"Kumaran Travels" , "TN45NH9865","Nagercoil","Chennai",1300,30,30,LocalTime.of(22, 30),LocalTime.of(5, 30))); 
		
		System.out.println("\nChoose any of the bus to book your tickets");
		System.out.println();
				
		}
	
	public void displayBus() {
		
		for(BusDetails busdispaly : listbusdetails) {
				System.out.print(busdispaly.busId + ". ");
				System.out.println(busdispaly.busName);
				System.out.print("Route : "+busdispaly.departure+ "  ->  ");
				System.out.println("Departs at: " +busdispaly.depatureTime);
				System.out.println("Arrives at: "+busdispaly.arrivalTime);
			    System.out.println(busdispaly.destination);
				System.out.println("Price : ₹"+busdispaly.fare);
				System.out.println("Available seats : "+busdispaly.getAvailableSeats());
				System.out.println();
			}

				System.out.print("Select the bus ID to book your seats : ");				
				int enteredBusId = scan.nextInt();
				System.out.println();
				
				bookingprocess.bookTickets(listbusdetails , enteredBusId);
				
				
		}						
			}
			
			
			

	

