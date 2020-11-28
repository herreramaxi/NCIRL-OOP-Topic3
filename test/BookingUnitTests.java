/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import accommodationbookingsystem.Bookings.Booking;
import accommodationbookingsystem.Bookings.BookingHotelRoom;
import accommodationbookingsystem.Bookings.BookingSelfCateringCottage;
import accommodationbookingsystem.Bookings.IBooking;
import java.util.Date;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maximiliano Herrera
 */
public class BookingUnitTests {

    public BookingUnitTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

     @Test
    public void WhenBookingAHotelRoomTheCostIs130EuroPerNight() {
        IBooking booking1Day = new BookingHotelRoom("Person a", "ABC-01", new Date(2020, 12, 01), 1, 507, false);
        IBooking booking10Days = new BookingHotelRoom("Person b", "ABC-02", new Date(2020, 12, 01), 10, 508, false);

        assertThat(130, is(booking1Day.calculateCost()));
        assertThat(1300, is(booking10Days.calculateCost()));      
    }
    
    @Test
    public void WhenAddingBreakfastToABookingHotelRoomTheCostIs10EuroExtraPerNight() {
        IBooking booking1DayNoBreakfastIncluded = new BookingHotelRoom("Person a", "ABC-01", new Date(2020, 12, 01), 1, 507, false);
        IBooking booking1DayBreakfastIncluded = new BookingHotelRoom("Person b", "ABC-02", new Date(2020, 12, 01), 1, 508, true);
        IBooking booking10DaysBookingBreakfastIncluded = new BookingHotelRoom("Person c", "ABC-03", new Date(2020, 12, 01), 10, 509, true);

        assertThat(130, is(booking1DayNoBreakfastIncluded.calculateCost()));
        assertThat(140, is(booking1DayBreakfastIncluded.calculateCost()));
        assertThat(1400, is(booking10DaysBookingBreakfastIncluded.calculateCost()));
    }

    @Test
    public void WhenBookingSelfCateringCottageThePricePerNightIs60Plus50EuroPerNight() {
        IBooking booking1Day = new BookingSelfCateringCottage("Person a", "ABC-02", new Date(2020, 12, 01), 1, "address2", 'B');
        IBooking booking10Days = new BookingSelfCateringCottage("Person b", "ABC-03", new Date(2020, 12, 01), 10, "address1", 'A');

        assertThat(110, is(booking1Day.calculateCost()));
        assertThat(650, is(booking10Days.calculateCost()));
    }
}
