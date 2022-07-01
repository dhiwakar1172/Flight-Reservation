package com.flight.booking.runner;

import java.util.ArrayList;
import java.util.Scanner;

import com.flight.booking.DAO.BookingDAO;
import com.flight.booking.DAO.FlightDAO;
import com.flight.booking.model.Flight;

public class Booking {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		FlightDAO flightDAO = new FlightDAO(50,5000);
		ArrayList<Flight> avaliableFlights = flightDAO.avaliableFlights();
		boolean bool = true;
		while(bool) {
		System.out.println("Enter the below options:");
		System.out.println("1 - Booking, 2 - Cancel, 3 - Exit");

		int option = scan.nextInt();
		if (option == 1) {

			System.out.println("Available flights are: ");
			for (Flight flight : avaliableFlights) {
				System.out.print(flight.getId() + " ");
			}
			System.out.println();
			System.out.println("Enter Flight ID to check Capacity and Ticket price");
			int flightID = scan.nextInt();
			for (Flight flight : avaliableFlights) {
				if (flightID == flight.getId())
					System.out.print("Number of seats available - " + flight.getRemainingSeats() + "\n"
							+ "Current Ticket Price - " + flight.getCurrentPrice() + "\n");
			}

			System.out.println("Enter flight id to start Booking");
			int optedFlightid = scan.nextInt();
			System.out.println("You are booking in flight " + optedFlightid);
			//System.out.print("Enter passenger ID to start booking:");
			//int passengerId = scan.nextInt();
			System.out.print("Enter number of tickets:");
			int numberOfTickets = scan.nextInt();
			
			BookingDAO dao = new BookingDAO();
			int passengerId = 0;
			flightDAO.bookTicket(++passengerId, optedFlightid,numberOfTickets);
			bool = true;
		}
		if(option==2) {
			System.out.print("Enter Passenger ID:");
			int passengerId = scan.nextInt();
			System.out.print("Enter number of tickets to cancel:");
			int noOfTicketsToCancel = scan.nextInt();
			System.out.print("Enter Flight Booked:");
			int optedFlightid = scan.nextInt();
			flightDAO.cancelTicket(optedFlightid,passengerId,noOfTicketsToCancel);
			
		}
		if(option==3) {
			bool = false;
		}
		}
	}

	

}
