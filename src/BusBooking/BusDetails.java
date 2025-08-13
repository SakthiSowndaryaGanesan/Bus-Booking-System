package BusBooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record BusInfo(int id , String busName , String registrationNumber, String departure , String destination , int fare ,int totalSeats, int availableSeats ) {
}
	public class BusDetails{
		
		List<BusInfo> busd = new ArrayList<>();
		
		public void loadBus() {
		
				busd.add(new BusInfo(1,"Krishna Travels" , "TN45CH7654","Chennai","Salem",1200,30,30));
				busd.add(new BusInfo(2,"Ayali Travels" , "TN30SL5673","Salem","Chennai",1000,30,30));
				busd.add(new BusInfo(3,"Ramani Travels" , "TN30SL9368","Salem","Chennai",1100,30,30));
				busd.add(new BusInfo(4,"Surya Travels" , "TN41CH4589","Chennai","Erode",1400,30,30));
				busd.add(new BusInfo(5,"Sakthi Travels" , "TN42CH3913","Chennai","Erode",1400,30,30));
				busd.add(new BusInfo(6,"Sundar Travels" , "TN50CH8865","Chennai","Namakkal",1100,30,30));
				busd.add(new BusInfo(7,"Sai Travels" , "TN50NM6893","Namakkal","Chennai",1200,30,30));
				busd.add(new BusInfo(8,"Velan Travels" , "TN50CH3678","Chennai","Nagercoil",1500,30,30));
				busd.add(new BusInfo(9,"Kathir Travels" , "TN65NH3568","Nagercoil","Chennai",1200,30,30));

		}
		
		public void displayBus() {
			for(BusInfo b : busd) {
				System.out.print(b.id()+ ". ");
				System.out.println(b.busName());
				System.out.print("Route : "+b.departure()+ "  ->  ");
				System.out.println(b.destination());
				System.out.println("Price : ₹"+b.fare());
				System.out.println("Available seats : "+b.availableSeats());
				System.out.println();
			}
			
		}
	}

