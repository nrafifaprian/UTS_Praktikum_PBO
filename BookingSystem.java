/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package UTS_PBO;

import java.util.Date;
import java.util.List;

public interface BookingSystem {
    void cekKetersediaan(Date checkIn, Date checkOut);
    void buatPesanan(String nomerKamar, String namaPengunjung, Date checkIn, Date checkOut);
    List<Booking> tampilanBooking();
}