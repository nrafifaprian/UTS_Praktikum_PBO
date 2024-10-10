package UTS_PBO;
import java.util.List;

public class Admin extends User {
    private Hotel hotel;

    public Admin(String nama, String id, Hotel hotel) {
        super(nama, id);
        this.hotel = hotel;
    }

    @Override
    public List<Booking> tampilanBooking() {
        System.out.println("\n=== Admin " + nama + " melihat semua booking ===");
        return hotel.tampilanBooking();
    }

    public void aturKamar() {
        System.out.println("\n=== Admin " + nama + " mengelola kamar ===");
        hotel.listSemuaKamar();
    }

    public void tambahKamar(String nomerKamar, String type, double harga) {
        hotel.tambahKamar(new Room(nomerKamar, type, harga));
        System.out.println("\n=== Kamar Baru Ditambahkan ===");
        System.out.println("Nomor: " + nomerKamar);
        System.out.println("Tipe: " + type);
        System.out.println("Harga: Rp " + String.format("%.2f", harga) + " per malam");
        System.out.println("===============================");
    }
}