package com.flight.booking.DAO;

import java.util.ArrayList;
import java.util.Iterator;

import com.flight.booking.model.Flight;

public class FlightDAO {
	ArrayList<Flight> flights = new ArrayList<Flight>();
	BookingDAO dao= new BookingDAO();
	private int price;
	private int capacity;

	public FlightDAO(int capacity, int price) 
	{
		this.capacity = capacity;
		this.price=price;
	}
	
	public ArrayList<Flight> avaliableFlights() {
		Flight flight1 = new Flight();
		flight1.setId(1);
		flight1.setFlightName("UZ");
		flight1.setCurrentPrice(price);
		flight1.setRemainingSeats(capacity);

		flights.add(flight1);

		Flight flight2 = new Flight();
		flight2.setId(2);
		flight2.setFlightName("AVM");
		flight2.setCurrentPrice(price);
		flight2.setRemainingSeats(capacity);
		flights.add(flight2);

		return flights;
	}

	public void bookTicket(int passengerId, int optedFlightid, int numberOfTickets) {
		for (Flight flight : flights) {
			if (optedFlightid == flight.getId()) {
				int currentCap = flight.getRemainingSeats();
				int currentPrice = flight.getCurrentPrice();
				int ticketPrice = currentPrice*numberOfTickets;
				
				flight.setRemainingSeats(currentCap - numberOfTickets);
				flight.setCurrentPrice(currentPrice + (200 * numberOfTickets));
				
				dao.bookingDetails(passengerId,optedFlightid,numberOfTickets,ticketPrice);
				
			}

		}
	}

	public void cancelTicket(int optedFlightid,int passengerId, int noOfTicketsToCancel) {
		for (Flight flight : flights) {
			if (optedFlightid == flight.getId()) {
				int currentPrice = flight.getCurrentPrice();
				int remainingSeats = flight.getRemainingSeats();
				
				boolean status = dao.cancelTicket(passengerId,optedFlightid,noOfTicketsToCancel);
				if(status==true) {
					flight.setCurrentPrice(currentPrice-200*noOfTicketsToCancel);
					flight.setRemainingSeats(remainingSeats+noOfTicketsToCancel);
					
				}
				else {
					System.out.println("No Valid booking found to cancel");
				}
			}
		}
	}
}
