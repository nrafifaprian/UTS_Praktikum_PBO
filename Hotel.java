/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_PBO;

import java.util.*;

public class Hotel implements BookingSystem {
    private List<Room> rooms;
    private List<Booking> bookings;

    public Hotel() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        tipeKamar();
    }

    private void tipeKamar() {
        rooms.add(new Room("101", "Single", 500000));
        rooms.add(new Room("102", "Single", 500000));
        rooms.add(new Room("103", "Single", 500000));
        rooms.add(new Room("201", "Double", 750000));
        rooms.add(new Room("202", "Double", 750000));
        rooms.add(new Room("203", "Double", 750000));
        rooms.add(new Room("301", "Suite", 1500000));
        rooms.add(new Room("401", "Family", 1700000));
        rooms.add(new Room("501", "Superior", 2000000));
    }

    public void tambahKamar(Room kamar) {
        rooms.add(kamar);
    }

    public void listSemuaKamar() {
        System.out.println("\n=== Daftar Semua Kamar ===");
        for (Room kamar : rooms) {
            System.out.println(kamar);
        }
        System.out.println("===========================");
    }

    @Override
    public void cekKetersediaan(Date checkIn, Date checkOut) {
        System.out.println("\n=== Kamar yang Tersedia ===");
        System.out.println("Dari " + checkIn + " sampai " + checkOut + ":");
        for (Room kamar : rooms) {
            if (kamarTersedia(kamar, checkIn, checkOut)) {
                System.out.println(kamar);
            }
        }
        System.out.println("===========================");
    }


    private boolean kamarTersedia(Room kamar, Date checkIn, Date checkOut) {
        for (Booking booking : bookings) {
            if (booking.getKamar().getnomerKamar().equals(kamar.getnomerKamar())) {
                if ((checkIn.before(booking.getCheckOut()) && checkOut.after(booking.getCheckIn()))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void buatPesanan(String nomerKamar, String namaPengunjung, Date checkIn, Date checkOut) {
        Room kamar = cariKamar(nomerKamar);
        if (kamar != null && kamarTersedia(kamar, checkIn, checkOut)) {
            Booking booking = new Booking(kamar, namaPengunjung, checkIn, checkOut);
            bookings.add(booking);
            System.out.println("Booking berhasil: " + booking);
        } else {
            System.out.println("Booking gagal. Kamar tidak tersedia.");
        }
    }

    private Room cariKamar(String nomerKamar) {
        return rooms.stream()
                    .filter(r -> r.getnomerKamar().equals(nomerKamar))
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public List<Booking> tampilanBooking() {
        return new ArrayList<>(bookings);
    }
}
