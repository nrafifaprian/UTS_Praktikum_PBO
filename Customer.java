/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_PBO;

import java.util.List;
import java.util.stream.Collectors;

public class Customer extends User {
    private Hotel hotel;

    public Customer(String nama, String id, Hotel hotel) {
        super(nama, id);
        this.hotel = hotel;
    }

    @Override
    public List<Booking> tampilanBooking() {
        System.out.println("\n=== Booking untuk " + nama + " ===");
        List<Booking> customerBookings = hotel.tampilanBooking().stream()
                    .filter(booking -> booking.getNamaPengunjung().equals(nama))
                    .collect(Collectors.toList());
        
        if (customerBookings.isEmpty()) {
            System.out.println("Tidak ada booking saat ini.");
        } else {
            customerBookings.forEach(System.out::println);
        }
        System.out.println("=============================");
        return customerBookings;
    }
}