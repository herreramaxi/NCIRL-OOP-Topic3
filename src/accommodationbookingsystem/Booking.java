/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodationbookingsystem;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Maximiliano Herrera
 */
public abstract class Booking implements IBooking {
    
    private final String clientName;
    private final String bookingReference;
    private final Date startDate;
    private final int nights;
    
    public String getClientName() {
        return clientName;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getNights() {
        return nights;
    }
    
    //Static polymorphism: constructor overloading
    public Booking(String clientName, String bookingReference, Date startDate, int nights) {
        this.clientName = clientName;
        this.bookingReference = bookingReference;
        this.startDate = startDate;
        this.nights = nights;
    }

    //Template method calculateCost
    //Dynamic polymorphism. Methods involved: calculateCost, calculateCostPerNights and calculateExtraCosts
    @Override
    public int calculateCost() {
        return this.calculateCostPerNights() + this.calculateExtraCosts();
    }

    protected abstract int calculateCostPerNights();

    protected abstract int calculateExtraCosts();

    protected abstract String getBookingTypeName();

    //Template method print
    @Override
    public void print() {

        StringBuilder sb = new StringBuilder();
        sb.append("Booking type: ").append(this.getBookingTypeName()).append("\n");
        sb.append("Client name: ").append(this.getClientName()).append("\n");
        sb.append("Booking reference: ").append(this.getBookingReference()).append("\n");
        sb.append("StartDate: ").append(new SimpleDateFormat("yyyy-MM-dd").format(this.getStartDate())).append("\n");
        sb.append("Nights: ").append(this.getNights()).append("\n");

        System.out.print(sb.toString());

        this.printDetails();

        System.out.println("Total Cost: " + this.calculateCost());
    }

    protected abstract void printDetails();
}
