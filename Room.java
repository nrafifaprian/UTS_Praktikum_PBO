/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_PBO;

public class Room {
    private String nomerKamar;
    private String tipe;
    private double harga;

    public Room(String nomerKamar, String tipe, double harga) {
        this.nomerKamar = nomerKamar;
        this.tipe = tipe;
        this.harga = harga;
    }

    public String getnomerKamar() { return nomerKamar; }
    public String getTipe() { return tipe; }
    public double getHarga() { return harga; }

    @Override
    public String toString() {
        return String.format("Room %s (%s) - Rp %.2f per malam", nomerKamar, tipe, harga);
    }
}