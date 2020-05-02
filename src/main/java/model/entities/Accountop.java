package model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCOUNTOP")
public class Accountop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "OPDAY")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Date opdate;

    @Column(name = "OPCASH")
    private double opcash;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    @JsonIgnore
    private Account account;

    public Accountop(Date opdate, double opcash) {
        this.opdate = opdate;
        this.opcash = opcash;
    }

    public Accountop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOpdate() {
        return opdate;
    }

    public void setOpdate(Date opdate) {
        this.opdate = opdate;
    }

    public double getOpcash() {
        return opcash;
    }

    public void setOpcash(double opcash) {
        this.opcash = opcash;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Accountop{" +
                "id=" + id +
                ", opdate=" + opdate +
                ", opcash=" + opcash +
                '}';
    }
}
