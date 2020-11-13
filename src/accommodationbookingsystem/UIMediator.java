/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodationbookingsystem;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Maximiliano Herrera
 */
public class UIMediator {

    private final JFrameMain mainFrame;
    private final ArrayList<IBooking> bookings = new ArrayList<>();

    UIMediator(JFrameMain main) {
        mainFrame = main;
    }

    void addBooking() {
        IBooking booking = createBooking();
        bookings.add(booking);

        mainFrame.showMessage("Booking added");
        mainFrame.resetControlValues();
    }

    void cancel() {
        mainFrame.resetControlValues();
    }

    void printAllBookings() 
    {
        mainFrame.cleanOutputTextArea();
        bookings.forEach((booking) -> {
            booking.print();
            System.out.println("------------------------------------------------");
        });
    }

    void calculateCost() {
        IBooking booking = createBooking();

        mainFrame.showMessage("Cost: " + booking.calculateCost());
    }

    void cleanBookings() {
        bookings.clear();
    }

    void selectBooking(String bookingType) {
        if (bookingType == "Hotel room") {
            mainFrame.setEnabledRoomNumber(true);
            mainFrame.setBreakfastIncluded(true);
            mainFrame.setEnabledAddress(false);
            mainFrame.setEnabledKeyCollectionPoint(false);
        } else if (bookingType == "Self catering cottage") {
            mainFrame.setEnabledRoomNumber(false);
            mainFrame.setBreakfastIncluded(false);
            mainFrame.setEnabledAddress(true);
            mainFrame.setEnabledKeyCollectionPoint(true);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private IBooking createBooking() {
        String bookingType = mainFrame.getBookingType();
        String clientName = mainFrame.getClientName();
        String bookingReference = mainFrame.getBookingReference();
        Date startDate = mainFrame.getStartDate();
        int nights = mainFrame.getNights();
        IBooking booking;

        if (bookingType == "Hotel room") {
            int room = mainFrame.getRoomNumber();
            Boolean breakfastIncluded = mainFrame.getBreakfastIncluded();
            booking = BookingFactory.CreateHotelRoomBooking(clientName, bookingReference, startDate, nights, room, breakfastIncluded);
        } else if (bookingType == "Self catering cottage") {
            String address = mainFrame.getAddress();
            Character keyCollectionPoint = mainFrame.getKeyCollectingPoint();
            booking = BookingFactory.CreateSelfCateringCottageBooking(clientName, bookingReference, startDate, nights, address, keyCollectionPoint);
        } else {
            throw new IllegalArgumentException();
        }

        return booking;
    }
}
