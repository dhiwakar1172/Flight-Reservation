package com.flight.booking.model;

public class BookingInfo
{
	private int passengerId;
	private int optedFlightid;
	private int numberOfTickets;
	private int ticketPrice;
	
	public int getPassengerId() {
		return passengerId;
	}
	
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public int getOptedFlightid() {
		return optedFlightid;
	}
	public void setOptedFlightid(int optedFlightid) {
		this.optedFlightid = optedFlightid;
	}
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	@Override
	public String toString() {
		return "Passenger uniqe ID - " + passengerId + " Booked flight - " + optedFlightid
				+ " No of tickets - " + numberOfTickets + "Total ticket Price - "+ticketPrice;
	}
	
	
}
