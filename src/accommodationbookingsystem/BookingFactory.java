/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodationbookingsystem;

import accommodationbookingsystem.Bookings.BookingSelfCateringCottage;
import accommodationbookingsystem.Bookings.BookingHotelRoom;
import accommodationbookingsystem.Bookings.IBooking;
import java.util.Date;

/**
 *
 * @author Maximiliano Herrera
 */

//Abstract factory
public class BookingFactory {

    //Polymorphism: method overloading
    public static IBooking CreateHotelRoomBooking(String clientName, String bookingReference, Date startDate, int nights, int roomNumber, boolean breakfastIncluded) {
        return new BookingHotelRoom(clientName, bookingReference, startDate, nights, roomNumber, breakfastIncluded);
    }

    public static IBooking CreateSelfCateringCottageBooking(String clientName, String bookingReference, Date startDate, int nights, String address, char keyCollectionPoint) {
        return new BookingSelfCateringCottage(clientName, bookingReference, startDate, nights, address, keyCollectionPoint);
    }
}
