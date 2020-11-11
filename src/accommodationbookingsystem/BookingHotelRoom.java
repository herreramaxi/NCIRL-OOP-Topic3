/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodationbookingsystem;

import java.util.Date;

/**
 *
 * @author Maximiliano Herrera
 */
public class BookingHotelRoom extends Booking {
    //Bookings for the Hotel Rooms will also then have a roomNumber and whether or not breakfast is included.   

    private final int roomNumber;
    private final boolean breakfastIncluded;

    //Static polymorphism: constructor overloading
    public BookingHotelRoom(String clientName, String bookingReference, Date startDate, int nights, int roomNumber, boolean breakfastIncluded) {
        super(clientName, bookingReference, startDate, nights);

        this.roomNumber = roomNumber;
        this.breakfastIncluded = breakfastIncluded;
    }

    @Override
    protected int calculateCostPerNights() {
        return this.getNights() * 130;
    }

    @Override
    protected int calculateExtraCosts() {
        return breakfastIncluded ? this.getNights() * 10 : 0;
    }

    @Override
    protected String getBookingTypeName() {
        return "Hotel room";
    }

    @Override
    protected void printDetails() {
        System.out.println("Room number: " + roomNumber);
        System.out.println("Include breakfast: " + (breakfastIncluded ? "yes": "no"));
    }
}
