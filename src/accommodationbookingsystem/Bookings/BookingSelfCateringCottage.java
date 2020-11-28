/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodationbookingsystem.Bookings;

import java.util.Date;

/**
 *
 * @author Maximiliano Herrera
 */
public class BookingSelfCateringCottage extends Booking {
    //Bookings for the Cottages will have an address and a keyCollectionPoint which is represented by a single letter. 

    private final String address;
    private final char keyCollectingPoint;

    //Static polymorphism: constructor overloading
    public BookingSelfCateringCottage(String clientName, String bookingReference, Date startDate, int nights, String address, char keyCollectionPoint) {
        super(clientName, bookingReference, startDate, nights);

        this.address = address;
        this.keyCollectingPoint = keyCollectionPoint;
    }

    @Override
    protected int calculateCostPerNights() {
        return this.getNights() * 60;
    }

    @Override
    protected int calculateExtraCosts() {
        return 50;
    }

    @Override
    protected String getBookingTypeName() {
        return "Self catering cottage";
    }

    @Override
    protected void printDetails() {
        System.out.println("Address: " + address);
        System.out.println("Key collecting point: " + keyCollectingPoint);
    }
}
