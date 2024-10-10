/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_PBO;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Booking {
    private Room kamar;
    private String namaPengunjung;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Booking(Room kamar, String namaPengunjung, Date checkIn, Date checkOut) {
        this.kamar = kamar;
        this.namaPengunjung = namaPengunjung;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Room getKamar() { return kamar; }
    public String getNamaPengunjung() { return namaPengunjung; }
    public Date getCheckIn() { return checkIn; }
    public Date getCheckOut() { return checkOut; }

    @Override
    public String toString() {
        return String.format("Booking: %s atas nama %s dari %s sampai %s - Total: Rp %.2f",
                kamar, namaPengunjung, dateFormat.format(checkIn), dateFormat.format(checkOut), hitungTotalHarga());
    }

    private double hitungTotalHarga() {
        long diffInMillies = Math.abs(checkOut.getTime() - checkIn.getTime());
        long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);
        return kamar.getHarga() * diffInDays;
    }
}