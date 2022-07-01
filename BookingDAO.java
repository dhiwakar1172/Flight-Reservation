package com.flight.booking.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.flight.booking.DAO.FlightDAO;
import com.flight.booking.model.BookingInfo;

public class BookingDAO {

	Map<Integer, BookingInfo> booked = new HashMap<Integer, BookingInfo>();
	BookingInfo booking = new BookingInfo();

	public void bookingDetails(int passengerId, int optedFlightid, int numberOfTickets, int ticketPrice) {
		booking.setPassengerId(passengerId);
		booking.setOptedFlightid(optedFlightid);
		booking.setNumberOfTickets(numberOfTickets);
		booking.setTicketPrice(ticketPrice);
		booked.put(passengerId, booking);
		System.out.println(booking);
	}

	public boolean cancelTicket(int passengerId, int optedFlightid, int noOfTicketsToCancel) {
		for (Map.Entry<Integer, BookingInfo> bookingInfo : booked.entrySet()) {
			if (passengerId == bookingInfo.getKey() && optedFlightid == bookingInfo.getValue().getOptedFlightid()
					&& noOfTicketsToCancel <= bookingInfo.getValue().getNumberOfTickets()) {
				int exactPriceWhenBooking = bookingInfo.getValue().getTicketPrice() / bookingInfo.getValue().getNumberOfTickets();
				bookingInfo.getValue().setNumberOfTickets(bookingInfo.getValue().getNumberOfTickets()-noOfTicketsToCancel);
				bookingInfo.getValue().setTicketPrice(bookingInfo.getValue().getTicketPrice()-exactPriceWhenBooking*noOfTicketsToCancel);
				
				System.out.println("Ticket cancelled");
				if(noOfTicketsToCancel<bookingInfo.getValue().getNumberOfTickets()) {
					System.out.println("Current Status");
					System.out.println(bookingInfo.getValue());					
				}
				return true;

			}
		}
		return false;
	}
}
