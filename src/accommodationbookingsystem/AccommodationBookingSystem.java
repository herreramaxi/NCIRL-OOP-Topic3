/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accommodationbookingsystem;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Maximiliano Herrera
 */
public class AccommodationBookingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Show input dialog in order to select execution mode       
        String selectedValue = selectExecutionMode();

        if (selectedValue == "Console example") {
            ArrayList<IBooking> bookings = new ArrayList<>();

            bookings.add(BookingFactory.CreateHotelRoomBooking("Garry Kasparov", "ABC-00", new Date(), 1, 507, true));
            bookings.add(BookingFactory.CreateHotelRoomBooking("Magnus Carlsen", "ABC-01", new Date(), 10, 508, true));
            bookings.add(BookingFactory.CreateHotelRoomBooking("Hou Yifan", "ABC-02", new Date(), 10, 702, false));
            bookings.add(BookingFactory.CreateSelfCateringCottageBooking("Hikaru Nakamura", "ABC-03", new Date(), 10, "address1", 'A'));
            bookings.add(BookingFactory.CreateSelfCateringCottageBooking("Vishy Anand,", "ABC-04", new Date(), 2, "address2", 'B'));

            bookings.forEach(
                    (booking) -> {
                        booking.print();
                        System.out.println("------------------------------------------------");
                    }
            );
        } else if (selectedValue == "UI") {
            new JFrameMain().show();
        }
    }

    private static String selectExecutionMode() {
        Object[] possibleValues = {"Console example", "UI"};
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Select execution mode", "Execution mode selection",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);

        return selectedValue == null ? "" : selectedValue.toString();
    }
}
