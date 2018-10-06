package miraj.pack.domain;
import javax.persistence.*;

@Entity
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String sms;
    @Column
    private int readd;
    public Contacts() {
    }
    public Contacts(String name, String email, String phone, String sms) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sms = sms;
    }
    public Contacts(String name, String email, String phone, String sms,int readd) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sms = sms;
        this.readd = readd;
    }

    public Contacts(int id, String name, String email, String phone, String sms) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sms = sms;
    }
    public Contacts(int id, String name, String email, String phone, String sms,int readd) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sms = sms;
        this.readd = readd;
    }

    public Contacts(int id) {
        this.id = id;
    }

    public int getReadd() {
        return readd;
    }

    public void setReadd(int readd) {
        this.readd = readd;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
