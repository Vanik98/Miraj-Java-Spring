package miraj.pack.domain;
import javax.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String date;
    @Column
    private String lastname;
    @Column
    private String phone;
    @Column
    private String numberofpeople;
    @Column
    private int rread;

    public Reservation() {
    }

    public Reservation(String name, String date, String lastname, String phone, String numberofpeople) {
        this.name = name;
        this.date = date;
        this.lastname = lastname;
        this.phone = phone;
        this.numberofpeople = numberofpeople;
    }

    public Reservation(String name, String date, String lastname, String phone, String numberofpeople, int rread) {
        this.name = name;
        this.date = date;
        this.lastname = lastname;
        this.phone = phone;
        this.numberofpeople = numberofpeople;
        this.rread = rread;
    }

    public Reservation(int id, String name, String date, String lastname, String phone, String numberofpeople, int rread) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.lastname = lastname;
        this.phone = phone;
        this.numberofpeople = numberofpeople;
        this.rread = rread;
    }

    public Reservation(int id) {
        this.id = id;
    }

    public int getRread() {
        return rread;
    }

    public void setRread(int rread) {
        this.rread = rread;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumberofpeople() {
        return numberofpeople;
    }

    public void setNumberofpeople(String numberofpeople) {
        this.numberofpeople = numberofpeople;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
