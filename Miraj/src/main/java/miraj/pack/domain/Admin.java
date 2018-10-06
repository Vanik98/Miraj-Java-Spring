package miraj.pack.domain;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int adminid;
    @Column
    private String login;
    @Column
    private String password;

    public Admin() {
    }
    public Admin(int adminid)
    {
        this.adminid = adminid;
    }
    public Admin(int adminid,String login, String password) {
        this.adminid = adminid;
        this.login = login;
        this.password = password;
    }
    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
