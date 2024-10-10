/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_PBO;

import java.util.List;

public abstract class User {
    protected String nama;
    protected String id;

    public User(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    public String getNama() { return nama; }
    public String getId() { return id; }

    public abstract List<Booking> tampilanBooking();
}