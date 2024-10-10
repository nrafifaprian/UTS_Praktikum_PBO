/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_PBO;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
    private static Hotel hotel = new Hotel();
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        login();
        while (true) {
            tampilkanMenu();
            int pilihan = getIntInput("Pilih menu: ");
            switch (pilihan) {
                case 1:
                    cekKetersediaan();
                    break;
                case 2:
                    if (currentUser instanceof Customer) {
                        pesanKamar();
                    } else {
                        System.out.println("Hanya customer yang dapat memesan kamar.");
                    }
                    break;
                case 3:
                    currentUser.tampilanBooking();
                    break;
                case 4:
                    if (currentUser instanceof Admin) {
                        adminMenu();
                    } else {
                        System.out.println("Anda tidak memiliki akses untuk fitur ini.");
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi kami.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void login() {
        System.out.println("==================================");
        System.out.println("SELAMAT DATANG DI HOTEL ASTOR HILL");
        System.out.println("==================================");
        int userType = getIntInput("Masuk sebagai (1) Admin atau (2) Customer: ");
        String nama = getStringInput("Masukkan nama: ");
        String id = getStringInput("Masukkan ID Member: ");
        currentUser = (userType == 1) ? new Admin(nama, id, hotel) : new Customer(nama, id, hotel);
        System.out.println("==================================");
        System.out.println("Selamat datang, " + nama + "!");
        System.out.println("==================================");
    }

    private static void tampilkanMenu() {
        System.out.println("\n=========== Menu ===========");
        System.out.println("1. Cek Ketersediaan Kamar");
        System.out.println("2. Pesan Kamar");
        System.out.println("3. Lihat Booking");
        if (currentUser instanceof Admin) {
            System.out.println("4. Menu Admin");
        }
        System.out.println("5. Keluar");
        System.out.println("============================");
    }

    private static void cekKetersediaan() {
        Date checkIn = getDateInput("Masukkan tanggal check-in (dd/MM/yyyy): ");
        Date checkOut = getDateInput("Masukkan tanggal check-out (dd/MM/yyyy): ");
        hotel.cekKetersediaan(checkIn, checkOut);
    }

    private static void pesanKamar() {
        String nomerKamar = getStringInput("Masukkan nomor kamar yang ingin dipesan: ");
        Date checkIn = getDateInput("Masukkan tanggal check-in (dd/MM/yyyy): ");
        Date checkOut = getDateInput("Masukkan tanggal check-out (dd/MM/yyyy): ");
        hotel.buatPesanan(nomerKamar, currentUser.getNama(), checkIn, checkOut);
    }

    private static void adminMenu() {
        Admin admin = (Admin) currentUser;
        System.out.println("\n========= Menu Admin =========");
        System.out.println("1. Lihat Semua Kamar");
        System.out.println("2. Tambah Kamar Baru");
        System.out.println("3. Kembali ke Menu Utama");
        System.out.println("==============================");
        
        int pilihan = getIntInput("Pilih menu: ");
        switch (pilihan) {
            case 1:
                admin.aturKamar();
                break;
            case 2:
                String nomerKamar = getStringInput("Masukkan nomor kamar baru: ");
                String tipeKamar = getStringInput("Masukkan tipe kamar: ");
                double hargaKamar = getDoubleInput("Masukkan harga kamar per malam: ");
                admin.tambahKamar(nomerKamar, tipeKamar, hargaKamar);
                break;
            case 3:
                return;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Mohon masukkan angka.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Mohon masukkan angka.");
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static Date getDateInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String dateStr = scanner.nextLine().trim();
                return dateFormat.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("Format tanggal tidak valid. Gunakan format dd/MM/yyyy.");
            }
        }
    }
}